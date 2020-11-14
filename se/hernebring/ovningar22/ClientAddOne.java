package se.hernebring.ovningar22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;

public class ClientAddOne {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 3344);
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                DataInputStream dataIn = new DataInputStream(is);
                DataOutputStream dataOut = new DataOutputStream(os)) {
            int randomOut;
            randomOut = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            dataOut.writeInt(randomOut);
            dataOut.flush();
            int randomIn = dataIn.readInt();
            System.out.println("Response: " + randomIn);
        } catch (IOException ex) {
            System.err.println("Det gick fel: " + ex.getMessage());
        }
    }
}
