package se.hernebring.ovningar22;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerCopyFile {
    private final static Logger logger = LoggerFactory.getLogger(ServerCopyFile.class);
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            logger.atInfo().log("Connecting to port 12345");
            String filePath = waitForConnection(server);
            makeCopy(filePath, server);
        } catch (IOException ex){
            System.err.println("Problem vid skrivande till fil.");
            ex.printStackTrace();
        }
    }

    private static void makeCopy(String filePath, ServerSocket server) throws IOException {
        try (Socket connectionToClient = server.accept();
                InputStream is = connectionToClient.getInputStream();
                BufferedInputStream dataIn = new BufferedInputStream(is);
                BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(Path.of("resources/"+filePath)))) {
                
                    byte[] bytes = new byte[64*1024];
                    int count;
                    while ((count = dataIn.read(bytes)) > 0) {
                        bos.write(bytes, 0, count);
                    }
            }
    }

    private static String waitForConnection(ServerSocket server) throws IOException {
        String filePath = "";
        try(Socket connectionToClient = server.accept();
            InputStream is = connectionToClient.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            OutputStream os = connectionToClient.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))){
                logger.atInfo().log("Connecting to client on port 12345.");
                filePath = reader.readLine();
                System.out.println(filePath);
                writer.write("ok\n");
                writer.flush();
            }
        return filePath;
    }

}
