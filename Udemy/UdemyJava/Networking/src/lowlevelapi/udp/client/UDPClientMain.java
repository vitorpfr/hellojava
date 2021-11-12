package lowlevelapi.udp.client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClientMain {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost(); // getByName() if running server in a different machine
            DatagramSocket datagramSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {
                System.out.println("Enter a string to be echoed: ");
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                datagramSocket.send(packet);

                // this would be the code waiting for a response, however, when using udp normally you don't want a response in a real-world application
//                byte[] buffer2 = new byte[50];
//                packet = new DatagramPacket(buffer2, buffer2.length);
//                datagramSocket.receive(packet);
//                System.out.println("Text received is: " + new String(buffer2, 0, packet.getLength()));
            } while (!echoString.equals("exit"));

        } catch (SocketTimeoutException e) {
            System.out.println("SocketTimeoutException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
