package playlistchallengerevisited;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // since we said it is a List, it could be either an ArrayList or a LinkedList!
        List<Album> albums = new ArrayList<>();


        Album rideTheLightning = new Album("Ride the Lightning", "Metallica");
        rideTheLightning.addSong("Fight Fire with Fire", 4.4);
        rideTheLightning.addSong("Ride the Lightning", 6.3);
        rideTheLightning.addSong("For Whom the Bell Tolls", 5.1);
        rideTheLightning.addSong("Fade to Black", 6.5);
        rideTheLightning.addSong("Trapped Under Ice", 4.0);
        rideTheLightning.addSong("Escape", 4.2);
        rideTheLightning.addSong("Creeping Death", 6.3);
        rideTheLightning.addSong("The Call of Ktulu", 8.5);
        albums.add(rideTheLightning);


        // now we're stating the playlist is just a List, not specifically a linked list
        // this way, even if we change the playlist implementation to ArrayList or Vector (which both also implements the List interface)
        // the whole code still works!
//        List<Song> playlist = new LinkedList<>();
//        List<Song> playlist = new Vector<>();
        List<Song> playlist = new ArrayList<>();


        albums.get(0).addToPlayList("Fight Fire with Fire", playlist);
        albums.get(0).addToPlayList("Master of Puppets", playlist);   // doesn't add
        albums.get(0).addToPlayList(8, playlist);                  // should add The Call of Ktulu
        albums.get(0).addToPlayList(6, playlist);                  // should add Escape
        albums.get(0).addToPlayList("Test", playlist);   // doesn't add

        System.out.println(playlist.toString());

    }
}
