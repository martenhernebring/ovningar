package se.hernebring.ovningar25;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CachedExe {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.submit(() -> {
                for (int j = 0; j < 50; j++) {
                    System.out.print("j" + (j + 1) + " ");
                }
            });
        }
        service.shutdown();
        service.awaitTermination(2, TimeUnit.MINUTES);
    }
}
