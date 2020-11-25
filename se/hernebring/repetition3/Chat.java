package se.hernebring.repetition3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Chat extends JFrame implements ActionListener {
    private static final long serialVersionUID = -8079089426558666254L;
    private String namn;
    private InetAddress iadr;
    private int port;
    private JTextField skriv;
    private MulticastSocket so;
    private JButton sluta;

    public Chat(String användarnamn, String gruppAdr, int portNr) {
        namn = användarnamn;
        JTextArea txt = new JTextArea();
        JScrollPane sp = new JScrollPane(txt);
        skriv = new JTextField();
        sluta = new JButton("Koppla ner");
        port = portNr;
        try {
            iadr = InetAddress.getByName(gruppAdr);
        } catch (UnknownHostException ex) {
            printAndExit(ex);
        }
        try{
            so = new MulticastSocket(port);
            so.joinGroup(iadr);
            new Mottagare(so, txt);
            sändMedd("UPPKOPPLAD");
            setTitle("Chat " + namn);
            txt.setEditable(false);
            add(sluta, BorderLayout.NORTH);
            add(sp, BorderLayout.CENTER);
            add(skriv, BorderLayout.SOUTH);
            sluta.addActionListener(this);
            skriv.addActionListener(this);
            setSize(400, 250);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } catch(IOException ex){
            printAndExit(ex);
        } finally{
            so.close();
        }
    }

    private void sändMedd(String string) {
        byte[] data = (namn + ": " + string).getBytes();
        var packet = new DatagramPacket(data, data.length, iadr, port);
        try{
            so.send(packet);
        } catch (IOException ex){
            //do nothing
        }
    }

    private void printAndExit(Exception ex) {
        System.err.println(ex.getMessage());
        ex.printStackTrace();
        System.exit(-1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == skriv){
            sändMedd(skriv.getText());
            skriv.setText("");
        } else if(e.getSource() == sluta){
            sändMedd("NEDKOPPLAD");
            try{
                so.leaveGroup(iadr);
            } catch(IOException ex){
                //do nothing
            }
            so.close();
            dispose();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        String namn = "Anonym";
        if(args.length > 0){
            namn = args[0];
        }
        new Chat(namn, "234.235.236.237", 9876);
    }
    
}
