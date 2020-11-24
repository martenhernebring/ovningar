package se.hernebring.ovningar25;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ClientWaitRandom implements Runnable{
    private int port;

    public ClientWaitRandom(int port){
        this.port = port;
    }
    public static void main(String[] args) throws InterruptedException {
        int threadNumber = ThreadLocalRandom.current().nextInt(2, 10); 
        ExecutorService service = Executors.newCachedThreadPool();
        Thread[] threads = new Thread[threadNumber];
        for(int i = 0; i < threadNumber; i++){
            threads[i] = new Thread(new ClientWaitRandom(3345+i));
            service.submit(threads[i]);
        }
        service.shutdown();
        service.awaitTermination(2, TimeUnit.MINUTES);
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("localhost", port);
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                DataOutputStream dataOut = new DataOutputStream(os)) {
            int randomOut = ThreadLocalRandom.current().nextInt(1, 10); //1 to 10 sec
            System.out.println(randomOut);
            long pre = System.currentTimeMillis();
            dataOut.writeInt(randomOut);
            dataOut.flush();
            String responce = reader.readLine();
            System.out.println("Response: " + responce);
            long after = System.currentTimeMillis();
            System.out.println(after-pre+" millisekunder tog metoden.");
        } catch (IOException ex) {
            System.err.println("Det gick fel: " + ex.getMessage());
        }
    }
}
