package se.hernebring.ovningar22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAddOne {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(3344)) {
            // the program will wait here until someone connects
            try (Socket connectionToClient = server.accept();
                InputStream is = connectionToClient.getInputStream();
                DataInputStream dataIn = new DataInputStream(is);
                OutputStream os = connectionToClient.getOutputStream();
                DataOutputStream dataOut = new DataOutputStream(os)) {

                int random = dataIn.readInt();
                dataOut.writeInt(random + 1);
                dataOut.flush();

                System.out.println("Request: " + random);
            }
        } catch (IOException ex) {
            System.err.println("Det gick fel: " + ex.getMessage());
        }
    }

}
