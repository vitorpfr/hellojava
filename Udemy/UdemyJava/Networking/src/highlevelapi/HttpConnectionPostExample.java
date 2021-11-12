package highlevelapi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionPostExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://somewebpage//processform.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            String parameters = "parameter1=25&parameter2=hello";
            connection.setRequestProperty("Content-Length", Integer.toString(parameters.getBytes().length));
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.setDoInput(true);

            DataOutputStream output = new DataOutputStream(connection.getOutputStream());
            output.writeBytes(parameters);
            output.flush();
            output.close();

            InputStream input = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
