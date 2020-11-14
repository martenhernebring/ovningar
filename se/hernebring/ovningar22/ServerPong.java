package se.hernebring.ovningar22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPong {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            // the program will wait here until someone connects
            Socket connectionToClient = server.accept();
            InputStream is = connectionToClient.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            OutputStream os = connectionToClient.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
            System.out.println("Request: " + reader.readLine());
            writer.write("Pong\n");
            writer.flush();
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
