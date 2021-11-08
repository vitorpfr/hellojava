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
        List<Artist> artists = datasource.queryArtists();
        if (artists == null) {
            System.out.println("No artists!");
        } else {
            artists.forEach(System.out::println);
        }

        datasource.close();
    }
}
