package se.hernebring.ovningar22;

//import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;

public class ClientCopyFile {
    public static void main(String[] args) {
        //try(BufferedReader reader = new BufferedReader())
        try (Socket socket = new Socket("localhost", 12345);
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                DataInputStream dataIn = new DataInputStream(is);
                DataOutputStream dataOut = new DataOutputStream(os)) {
            int randomOut;
            randomOut = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE-1);
            dataOut.writeInt(randomOut);
            dataOut.flush();
            int randomIn = dataIn.readInt();
            System.out.println("Response: " + randomIn);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
