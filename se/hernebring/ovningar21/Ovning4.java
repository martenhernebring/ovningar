package se.hernebring.ovningar21;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ovning4 {
    private static HttpClient client;
    private static HttpRequest request;

    public static void main(String[] args) throws IOException, InterruptedException {
        connectDadJokes("text/plain", "Yrgo OOP Class (https://yrgo.se)");
        Map<String, Integer> jokeReviews = new HashMap<>();
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.println("Give grade 1-10. 0 to quit");
                String joke = getJoke();
                System.out.println(joke);
                int grade = scan.nextInt();
                scan.nextLine();
                if (grade == 0) {
                    break;
                }
                jokeReviews.put(joke, grade);
            }
            String highestRated = getHigestRated(jokeReviews);
            System.out.println("Best joke: " + highestRated);

        } catch (IOException | InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String getHigestRated(Map<String, Integer> jokeReviews) {
        // To store the result 
        Map.Entry<String, Integer> entryWithMaxValue = null; 
        // Iterate in the map to find the required entry 
        for (Map.Entry<String, Integer> currentEntry : jokeReviews.entrySet()) { 
  
            if ( 
                // If this is the first entry, set result as this 
                entryWithMaxValue == null
  
                // If this entry's value is more than the max value 
                // Set this entry as the max 
                || currentEntry.getValue() 
                           .compareTo(entryWithMaxValue.getValue()) 
                       > 0) { 
  
                entryWithMaxValue = currentEntry; 
            } 
        } 
  
        // Return the entry with highest value 
        return entryWithMaxValue.getKey(); 
    }

    private static String getJoke() throws IOException, InterruptedException {
        HttpResponse<String> resp = client.send(request, BodyHandlers.ofString());
        String joke;
            if (resp.statusCode() == 200) {
                joke = resp.body();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(resp.statusCode());
                sb.append(resp.headers());
                sb.append(resp.body());
                joke = sb.toString();
            }
        return joke;
    }

    private static void connectDadJokes(String accept, String userAgent) {
        client = HttpClient.newHttpClient();
        URI dadUri = URI.create("https://icanhazdadjoke.com");
        request = HttpRequest.newBuilder()
            .uri(dadUri)
            .header("Accept", accept)
            .header("User-Agent", userAgent)
            .build();
    }
}