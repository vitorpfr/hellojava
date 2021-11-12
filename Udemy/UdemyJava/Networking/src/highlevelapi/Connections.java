package highlevelapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Connections {
    public static void main(String[] args) {
        try {
            // read content from an URL (high-level api does the part of creating socket, etc, under the hood)

            // 1st way: getting InputStream from the URL directly
            // reader reminder: InputStreamReader reads input character by character, BufferedReader buffers the read in memory and returns chunks (more efficient)
            URL url = new URL("http://example.org");
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));

            // printing page content
            String line = "";
            while (line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }

            inputStream.close();

            System.out.println("------------------------");
            // 2nd way: using URLConnection class
            // this way, you can do configuration before calling the .connect() method
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            // the rest is equal (BufferedReader etc), using urlConnection.getInputStream() to get stream

            // to retrieve the http header files, you can use this method above
            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            System.out.println("key = value");
            headerFields.forEach((x, y) -> System.out.println(x + " = " + y));

            // you can also get a specific field
            System.out.println(urlConnection.getHeaderField("Content-Type"));

            // theres a 3rd better way for http: HttpURLConnection, which is a subclass of URLConnection specialized in http
            // example: making a http GET request to example.org
            System.out.println("------------------------------------------");
            url = new URL("http://example.org/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome"); // random options
            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode(); // this step implicitly performs the connection (getInputStream too)
            System.out.println("Response code = " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading webpage: " + connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }

            inputReader.close();

            // since urls are also uris, we can convert back and check the uri data
//            URI uri = url.toURI();
//            System.out.println("--- Checking metadata: ---");
//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
