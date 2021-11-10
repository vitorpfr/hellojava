package music.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Obs: instead of re-writing queries every time, we could have also created a View in the DB, and queried it directly

public class Datasource {
    public static final String DB_NAME = "music.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/vitorfreitas/dev/personal/hellojava/UdemyJava/Databases/" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name"; // should have defined this TABLE_ALBUMS + ".name", would save a lot of time....
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    // since those queries are only used by one method each, maybe they should be local variables there
    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS + " (" + COLUMN_ARTIST_NAME + ")" +
            " VALUES (?)";

    public static final String INSERT_ALBUM = "INSERT INTO " + TABLE_ALBUMS + " (" + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ")" +
            " VALUES (?, ?)";

    public static final String INSERT_SONG = "INSERT INTO " + TABLE_SONGS +
            " (" + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM + ")" +
            " VALUES (?, ?, ?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " + TABLE_ARTISTS +
            " WHERE " + COLUMN_ARTIST_NAME + " = ?";

    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " + TABLE_ALBUMS +
            " WHERE " + COLUMN_ALBUM_NAME + " = ?";

    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public List<Artist> queryArtists(int sortOrder) {
//        String sql = "SELECT * FROM " + TABLE_ARTISTS; // previous version without sortOrder

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);

        switch (sortOrder) {
            case ORDER_BY_NONE:
                break;
            case ORDER_BY_DESC:
                sb.append(" ORDER BY " + COLUMN_ARTIST_NAME + " COLLATE NOCASE DESC");
                break;
            default:
                sb.append(" ORDER BY " + COLUMN_ARTIST_NAME + " COLLATE NOCASE ASC");
                break;
        }

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<Artist> artists = new ArrayList<>();
            while (results.next()) {
                Artist artist = new Artist();
                artist.setId(results.getInt(INDEX_ARTIST_ID)); // getInt accepts both column name or index, but using index is more efficient
                artist.setName(results.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }

            return artists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<Album> albumsByArtist(String artistName) {
        // ideally we would sanitize the input here to avoid injection using PreparedStatement (check next method)

        String sql = "SELECT * FROM " + TABLE_ALBUMS +
                " INNER JOIN " + TABLE_ARTISTS +
                " ON " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
                " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + " = '" + artistName + "'" +
                " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ASC";

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            List<Album> albums = new ArrayList<>();
            while (results.next()) {
                Album album = new Album();
                album.setId(results.getInt(INDEX_ALBUM_ID));
                album.setName(results.getString(INDEX_ALBUM_NAME));
                album.setArtistId(results.getInt(INDEX_ALBUM_ARTIST));
                albums.add(album);
            }

            return albums;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // this method uses PreparedStatement, which is the recommended way to sanitize input and avoid injection
    public List<String> artistAndAlbumBySong(String songName) {
        String sql = "SELECT " +
                TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
                TABLE_SONGS + "." + COLUMN_SONG_TRACK +
                " FROM " + TABLE_SONGS +
                " INNER JOIN " + TABLE_ALBUMS +
                " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID + " = " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM +
                " INNER JOIN " + TABLE_ARTISTS +
                " ON " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
//                " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = '" + songName + "'" + // old version without placeholder
                " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = ?" +
                " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ASC";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, songName); // passing the user input to the prepared statement
            ResultSet results = statement.executeQuery();

            List<String> output = new ArrayList<>();
            while (results.next()) {
                String artist = results.getString(1);
                String album = results.getString(2);
                int track = results.getInt(3);
                output.add(artist + "," + album + "," + track);
            }

            return output;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public void querySongsMetadata() {
        String sql = "SELECT * FROM " + TABLE_SONGS;

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            ResultSetMetaData meta = results.getMetaData();

            int numColumns = meta.getColumnCount();
            for (int i = 1; i < numColumns; i++) {
                System.out.format("Column %d in the songs table is named %s\n", i, meta.getColumnName(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCount(String table) {
        String sql = "SELECT COUNT(*) AS count FROM " + table;

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql)) {
//            return results.getInt(1); // better performance
            return results.getInt("count"); // more readable
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private int insertArtist(String name) throws SQLException {
        // try to query artist in the database
        PreparedStatement queryArtist = conn.prepareStatement(QUERY_ARTIST);
        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();

        // if it already exists, just return its id
        if (results.next()) {
            return results.getInt(1);
        }

        // otherwise, insert artist into the db and check how many rows were updated
        // RETURN_GENERATED_KEYS is used to return the id of the added artist
        PreparedStatement insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
        insertIntoArtists.setString(1, name);
        if (insertIntoArtists.executeUpdate() != 1) {
            throw new SQLException("Couldn't insert artist!");
        }
        // when successful, return id of new artist to user
        ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        } else {
            throw new SQLException("Couldn't get _id for artist!");
        }
    }

    private int insertAlbum(String name, int artistId) throws SQLException {
        // try to query album in the database
        PreparedStatement queryAlbum = conn.prepareStatement(QUERY_ALBUM);
        queryAlbum.setString(1, name);
        ResultSet results = queryAlbum.executeQuery();

        // if it already exists, just return its id
        if (results.next()) {
            return results.getInt(1);
        }

        // otherwise, insert album into the db and check how many rows were updated
        PreparedStatement insertIntoAlbums = conn.prepareStatement(INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
        insertIntoAlbums.setString(1, name);
        insertIntoAlbums.setInt(2, artistId);
        if (insertIntoAlbums.executeUpdate() != 1) {
            throw new SQLException("Couldn't insert album!");
        }
        // when successful, return id of new artist to user
        ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        } else {
            throw new SQLException("Couldn't get _id for album!");
        }
    }

    private void insertSongInternal(String title, String artist, String album, int track) throws SQLException {
        // either insert new artist/album or get id of existing ones
        int artistId = insertArtist(artist);
        int albumId = insertAlbum(album, artistId);

        // prepare song insertion statement
        PreparedStatement insertIntoSongs = conn.prepareStatement(INSERT_SONG);
        insertIntoSongs.setInt(1, track);
        insertIntoSongs.setString(2, title);
        insertIntoSongs.setInt(5, albumId); // if we provide an invalid index here (ex: 5), an IndexOutOfBounds exception will be thrown, catched, and the insert will be rolled back by the catch block

        // run statement - if one row is executed, commit; otherwise throw exception,
        // which will rollback the transaction in the caller method
        if (insertIntoSongs.executeUpdate() == 1) {
            conn.commit();
        } else {
            throw new SQLException("The song insertion failed");
        }
    }

    // obs1: possible issue: this method running on 2 separate threads, and one set autoCommit to true again in the middle of the other transaction
    // summary: this method relies on global state (auto-commit config), which can be changed at any time by another thread
    // maybe this should be synchronized

    // obs2: this is not checking if the song already exists (and it should)
    public void insertSong(String title, String artist, String album, int track) {
        try {
            System.out.println("Disabling auto-commit");
            conn.setAutoCommit(false);
            insertSongInternal(title, artist, album, track); // this is the line that actually does the job

        // this catches any exception, so the rollback is always performed if things go wrong
        } catch (Exception e1) {
            System.out.println("Insert song exception: " + e1.getMessage());
            try {
                System.out.println("Performing transaction rollback");
                conn.rollback();
            } catch (SQLException e2) {
                // this should not happen theoretically
                System.out.println("Exception thrown on transaction rollback: " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Re-enabling auto-commit");
                conn.setAutoCommit(true);
            } catch (SQLException e3) {
                System.out.println("Couldn't reset auto-commit: " + e3.getMessage());
            }
        }
    }
}
