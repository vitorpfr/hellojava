package lowlevelapi.tcp.echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {
    private Socket socket;

    public Echoer (Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String echoString = input.readLine(); // reads request from client
                System.out.println("Received client input: " + echoString);

                if (echoString.equals("exit")) {
                    break;
                }

                // sleeps before sending response to simulate a real server processing
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                output.println(echoString); // sends response to client
            }

        } catch (IOException e) {
            System.out.println("Server exception on thread " + currentThread() + ": " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {

            }
        }
    }
}
