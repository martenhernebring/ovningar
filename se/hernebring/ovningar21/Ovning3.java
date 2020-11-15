package se.hernebring.ovningar21;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Ovning3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI wikiUri = URI.create("https://en.wikipedia.org/wiki/Java_(programming_language)");
        HttpRequest request = HttpRequest.newBuilder()
            .uri(wikiUri)
            .build();
        HttpResponse<String> resp = client.send(request, BodyHandlers.ofString());
        System.out.println(resp.body());
    }

}
