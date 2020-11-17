package se.hernebring.ovningar22;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

public class ServerDatagram {
    public static void main(String[] args) {
        byte[] buf = new byte[64*1024]; //datagram biggest size
        List<String> names = new ArrayList<>();
        try (DatagramSocket socket = new DatagramSocket(57214)) { //49152 to 65535 ffa
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
                String latest = "";
                do{
                    socket.receive(packet);
                    latest = new String(packet.getData(), 0, packet.getLength());
                    names.add(latest);
                } while(!latest.toLowerCase().trim().equals("stop"));
                names.remove(names.size()-1);
        } catch (IOException ex) {
            System.err.println("Det gick fel: " + ex.getMessage());
            ex.printStackTrace();
        }
        for(String name : names){
            System.out.println(name);
        }
    }

}
