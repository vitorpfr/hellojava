package playlistchallengerevisited;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }

        return null;
    }

    public boolean addSong(String songTitle, double duration) {
        if (findSong(songTitle) != null) {
            return false;
        }

        songs.add(new Song(songTitle, duration));
        return true;
    }

    // here I can say the playlist is of the interface 'List' and it still works
    public boolean addToPlayList(int trackNumber, List<Song> playlist) {
        int trackIndex = trackNumber - 1;
        int maxIndex = songs.size() - 1;

        if (trackIndex > maxIndex || trackIndex < 0) {
            return false;
        }

        playlist.add(songs.get(trackIndex));
        return true;
    }

    public boolean addToPlayList(String songTitle, List<Song> playlist) {
        Song song = findSong(songTitle);

        if (song == null) {
            return false;
        }

        playlist.add(song);
        return true;
    }
}
