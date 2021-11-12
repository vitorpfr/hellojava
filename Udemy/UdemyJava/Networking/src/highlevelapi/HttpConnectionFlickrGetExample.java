package highlevelapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// example of getting data from a API via an HTTP connection
public class HttpConnectionFlickrGetExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cats");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response code = " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
