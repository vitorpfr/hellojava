package music;

import music.model.*;
import music.model.Datasource;

import java.util.List;

public class MusicMain {
    public static void main(String[] args) {
        Datasource datasource = new Datasource();

        datasource.open();

        // IMPORTANT: the main file doesn't make any assumptions about how the data is stored, it just receives a list
        // this means that the database interface implementation is decoupled from the application usage
        // this way, we can use any database behind the scenes if we want

        System.out.println("----- Print all artists ------");
        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_ASC);
        if (artists == null) {
            System.out.println("No artists!");
        } else {
            artists.forEach(System.out::println);
        }

        System.out.println("----- Print all albums by an artist ------");
        datasource.albumsByArtist("aaaa").forEach(System.out::println); // no results - no output
        datasource.albumsByArtist("Iron Maiden").forEach(System.out::println); // results
        datasource.albumsByArtist("Pink Floyd").forEach(System.out::println); // results

        System.out.println("----- Print all times a song was recorded ------");
        datasource.artistAndAlbumBySong("aaaa").forEach(System.out::println); // no result
        datasource.artistAndAlbumBySong("Wish You Were Here").forEach(System.out::println); // results
        datasource.artistAndAlbumBySong("Heartless").forEach(System.out::println);

        System.out.println("----- Get table metadata from songs table ------");
        datasource.querySongsMetadata();

        System.out.println("----- Print count of songs ------");
        System.out.println(datasource.getCount(Datasource.TABLE_SONGS));

        System.out.println("----- Insert song ------");
//        datasource.insertSong("Touch of Grey", "Grateful Dead", "In the Dark", 1);
        datasource.insertSong("Unforgiven III", "Metallica", "Death Magnetic", 6);

        // close data source
        datasource.close();
    }
}
