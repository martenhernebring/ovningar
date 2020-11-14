package se.hernebring.ovningar21;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Ovning2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI dadUri = URI.create("https://icanhazdadjoke.com");
        HttpRequest request = HttpRequest.newBuilder()
                            .uri(dadUri)
                            .header("Accept", "text/plain")
                            .header("User-Agent", "Yrgo OOP Class (https://yrgo.se)")
                            .build();
        for(int i = 0; i < 5; i++){
            HttpResponse<String> resp = client.send(request, BodyHandlers.ofString());
            if (resp.statusCode() == 200) {
                System.out.println(resp.body());
            }
        }
    }
}