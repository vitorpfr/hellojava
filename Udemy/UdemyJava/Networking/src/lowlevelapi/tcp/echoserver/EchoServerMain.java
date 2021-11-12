package lowlevelapi.tcp.echoserver;

import java.io.IOException;
import java.net.ServerSocket;

// this is a server using the TCP protocol
// it uses multiple threads to answer mulitple incoming client requests
public class EchoServerMain {
    public static void main(String[] args) {

        // this code will start a new thread (instance of Echoer class) for each incoming client connection
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                // serverSocket.accept() will be waiting for connections, blocking the new thread start
                // whenever a connection arrives, it unblocks, starts a new thread, and loops back to accept() again
                new Echoer(serverSocket.accept()).start();

                // more verbose option, but accomplishes the same thing
//                Socket socket = serverSocket.accept();
//                Echoer echoer = new Echoer(socket);
//                echoer.start();
            }
        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
