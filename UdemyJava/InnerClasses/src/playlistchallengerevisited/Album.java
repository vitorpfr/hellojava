package playlistchallengerevisited;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new SongList();
    }

    public boolean addSong(String songTitle, double duration) {
        return songList.addSong(songTitle, duration);
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        Song song = songList.findSong(trackNumber);

        if (song == null) {
            return false;
        }

        playlist.add(song);
        return true;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
        Song song = songList.findSong(songTitle);

        if (song == null) {
            return false;
        }

        playlist.add(song);
        return true;
    }

    // creating inner class SongList that just handles the song list inside an album (find, add, etc)
    private class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
            ;
        }

        private Song findSong(String title) {
            for (Song song : songs) {
                if (song.getTitle().equalsIgnoreCase(title)) {
                    return song;
                }
            }

            return null;
        }

        private Song findSong(int trackNumber) {
            int trackIndex = trackNumber - 1;
            int maxIndex = songs.size() - 1;

            if (trackIndex > maxIndex || trackIndex < 0) {
                return null;
            }

            return songs.get(trackIndex);
        }

        public boolean addSong(String songTitle, double duration) {
            if (findSong(songTitle) != null) {
                return false;
            }

            songs.add(new Song(songTitle, duration));
            return true;
        }
    }
}


