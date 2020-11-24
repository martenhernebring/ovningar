package se.hernebring.ovningar25;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    private CompletableFuture<String> compFuture;

    public CompletableFutureDemo(String string) {
        compFuture = getWebpage(string);
	}

	CompletableFuture<String> getWebpage(String url) {
        return CompletableFuture.supplyAsync(() -> {
            HttpClient client = HttpClient.newHttpClient();
            URI uri = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            try {
                HttpResponse<String> resp = client.send(request, BodyHandlers.ofString());
                return resp.body();
            } catch (IOException e) {
                System.out.println("Problems opening website");
                e.printStackTrace();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "error";
        });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var demo = new CompletableFutureDemo("https://www.wikipedia.org");
        var compFuture = demo.getCompFuture();
        compFuture.thenAccept(string -> {
            System.out.println(string);
        })
        .exceptionally(ex -> {
            System.out.println("Exception: " + ex.getMessage());
            return null;
            });
        compFuture.get();
        ForkJoinPool.commonPool().awaitQuiescence(2, TimeUnit.MINUTES);
    }

    public CompletableFuture<String> getCompFuture() {
        return compFuture;
    }

}
