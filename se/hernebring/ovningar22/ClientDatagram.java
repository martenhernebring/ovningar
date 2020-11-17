package se.hernebring.ovningar22;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientDatagram {
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(new File(args[0]));
            DatagramSocket socket = new DatagramSocket()){
            InetAddress recipient = InetAddress.getByName("localhost");
                while(scan.hasNextLine()){
                    String line = scan.nextLine();
                    byte[] bytes = line.getBytes();
                    var packet = new DatagramPacket(bytes, bytes.length, recipient, 57214); //49152 to 65535 ffa
                    socket.send(packet);
                }
                byte[] bytes = "stop".getBytes();
                var packet = new DatagramPacket(bytes, bytes.length, recipient, 57214); //49152 to 65535 ffa
                socket.send(packet);
        } catch (IOException ex) {
            System.err.println("Det gick fel: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
