package lowlevelapi.udp.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServerMain {
    public static void main(String[] args) {
        try {

            // this is a one-way communication: data is just received by server initially
            DatagramSocket socket = new DatagramSocket(5000);
            while (true) {
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet); // blocks until data is received
                System.out.println("Text received is: " + new String(buffer, 0, packet.getLength()));

                // if the server wants, it can send something back to the client this way - usually not necessary in a real-world app
                // it needs to get address and port from the packet to send a new packet, because there's no permanent two-way connection
//                String returnString = "echo: " + new String(buffer, 0, packet.getLength());
//                byte[] buffer2 = returnString.getBytes();
//                InetAddress address = packet.getAddress();
//                int port = packet.getPort();
//                packet = new DatagramPacket(buffer2, buffer2.length, address, port);
//                socket.send(packet);

            }
        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
