package se.hernebring.ovningar22;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientCopyFile {
    final static String host = "localhost";
    final static int port = 12345;
    private final static Logger logger = LoggerFactory.getLogger(ClientCopyFile.class);

    public static void main(String[] args) {
        String filePath = getPath(args);
        try (FileInputStream fis = new FileInputStream(filePath)) {
            logger.atInfo().log("Opened file " + filePath);
            String answer = establishConnection(filePath);
            if (answer.trim().toLowerCase().equals("ok")) {
                sendFile(fis);
                System.out.println("Bara bra");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Filen finns inte.");
            ex.printStackTrace();
            errorUsage();
        } catch (IOException ex) {
            System.err.println("Problem med inläsning av filen");
            ex.printStackTrace();
        }
    }

    private static void sendFile(FileInputStream fis) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(fis);
                Socket socket = new Socket(host, port);
                OutputStream os = socket.getOutputStream();
                BufferedOutputStream bos = new BufferedOutputStream(os)) {
            int count;
            byte[] buffer = new byte[64 * 1024];
            while ((count = bis.read(buffer)) > 0) {
                bos.write(buffer, 0, count);
            }
        }
    }

    private static String establishConnection(String filePath) {
        String answer = null;
        try (Socket socket = new Socket(host, port);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))) {

                logger.atInfo().log("Connecting to port 12345 as localhost");
                writer.write(filePath +"\n");
                writer.flush();
                answer = reader.readLine();
                System.out.println("Response: " + answer);
        } catch (IOException ex) {
            System.err.println("Error establishing connection.");
            ex.printStackTrace();
        }
        return answer;
    }

    private static String getPath(String[] args) {
        if (args == null || args.length == 0) {
            errorUsage();
            return "";
        } else {
            return args[0];
        }
    }

    private static void errorUsage() {
        System.err.println("Usage ClientCopyFile [file-path]");
        System.exit(-1);
    }
}
