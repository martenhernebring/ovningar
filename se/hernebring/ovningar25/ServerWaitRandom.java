package se.hernebring.ovningar25;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServerWaitRandom implements Runnable{
    private int port;

    ServerWaitRandom(int port){
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        int threadNumber = 10; 
        ExecutorService service = Executors.newFixedThreadPool(threadNumber);
        Thread[] threads = new Thread[threadNumber];
        for(int i = 0; i < threadNumber; i++){
            threads[i] = new Thread(new ServerWaitRandom(3345 + i));
            service.submit(threads[i]);
        }
        service.shutdown();
        service.awaitTermination(2, TimeUnit.MINUTES);
    }

    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(port)) {
            // the program will wait here until someone connects
            try (Socket connectionToClient = server.accept();
                InputStream is = connectionToClient.getInputStream();
                DataInputStream dataIn = new DataInputStream(is);
                OutputStream os = connectionToClient.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))) {

                int timeOut = dataIn.readInt();
                try{
                    Thread.sleep(1000*timeOut);
                } catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
                writer.write("Pong\n");
                writer.flush();

                System.out.println("Time out: " + timeOut);
            }
        } catch (IOException ex) {
            System.err.println("Det gick fel: " + ex.getMessage());
        }
    }

}
