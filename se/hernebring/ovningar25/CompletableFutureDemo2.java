package se.hernebring.ovningar25;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int websites = args.length;
        if (websites > 0) {
            var demos = new CompletableFutureDemo[websites];
            for(int i = 0; i < websites; i++){
                demos[i] = new CompletableFutureDemo(args[i]);
                CompletableFuture<String> compFuture = demos[i].getCompFuture();
                compFuture.thenAccept(string -> {
                    System.out.println(string);
                }).exceptionally(ex -> {
                    System.out.println("Exception: " + ex.getMessage());
                    return null;
                });
                // ForkJoinPool.commonPool().awaitQuiescence(2, TimeUnit.MINUTES); does not work
            }
            for(var demo : demos){
                demo.getCompFuture().get();
            }
        }
    }
}
