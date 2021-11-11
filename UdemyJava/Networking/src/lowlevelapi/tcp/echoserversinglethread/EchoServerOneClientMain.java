package lowlevelapi.tcp.echoserversinglethread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerOneClientMain {
    public static void main(String[] args) {

        // port can be an int between 0 and 65535 (except reserved ones)
        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            // accept() blocks until a client connects to this server
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // after a client connects, we can use input/output streams to send/receive data
            // input: best practice is to wrap input stream with BufferedReader instance
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // output: best practice is to wrap output stream with PrintWriter instance
            // autoFlush parameter: if set to false, you have to flush after every write to actually send data back over the network
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // infinite loop to keep reading data received from client
            while (true) {
                // read data from client
                String echoString = input.readLine();

                if (echoString.equals("exit")) {
                    break;
                }

                output.println("Echo from server: " + echoString); // return a response to client
            }
        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
