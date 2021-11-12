package lowlevelapi.tcp.echoclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class EchoClientMain {
    public static void main(String[] args) {
        // a socket is created to communicate with the server on host:localhost (or 127.0.0.1), port:5000
        try (Socket socket = new Socket("localhost", 5000)) {
            // sets a timeout of 5s, so if the server does not respond in this time, throws an exception
            socket.setSoTimeout(5000);

            // creates input and output streams (wrapped by bufferedreader and printwriter as best practices)
            BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            // do/while loop is used to guarantee that it is executed at least once
            do {
                // get string from user and send to server
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();
                stringToEcho.println(echoString);

                // read and output data that is get back from server
                if (!echoString.equals("exit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                }
            } while (!echoString.equals("exit"));

        } catch (SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
