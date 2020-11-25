package se.hernebring.repetition3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

import javax.swing.JTextArea;

public class Mottagare implements Runnable{
    Thread aktivitet = new Thread(this);
    MulticastSocket so;
    JTextArea txt;

    public Mottagare(MulticastSocket sock, JTextArea txtAr){
        so = sock;
        txt = txtAr;
        aktivitet.start();
    }

    @Override
    public void run() {
        byte[] data = new byte[1024];
        while(true){
            try{
                DatagramPacket packet = new DatagramPacket(data, data.length);
                so.receive(packet);
                String medd = new String(data, 0, packet.getLength());
                txt.append(medd + "\n");
            } catch(IOException ex){
                break;
            }
        }
    }
    
}
