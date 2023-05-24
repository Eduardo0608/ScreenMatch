package br.com.eduardo.screenmatch.main;

import br.com.eduardo.screenmatch.exception.ConversionErrorException;
import br.com.eduardo.screenmatch.models.Title;
import br.com.eduardo.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        String search = "";

        List<Title> titles = new ArrayList<>();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!search.equalsIgnoreCase("Exit")) {

            System.out.println("Enter a movie to search: ");
            search = sc.nextLine();

            if (search.equalsIgnoreCase("Exit")) {
                break;
            }

            String address = "https://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=87ca90a7";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
                System.out.println(myTitleOmdb);

                Title myTitle = new Title(myTitleOmdb);

                System.out.println("My title already converted.");
                System.out.println(myTitle);

                titles.add(myTitle);

            } catch (NumberFormatException e) {
                System.out.println("A error has occurred -> " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid argument on search, check the address again.");
            } catch (ConversionErrorException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titles);

        FileWriter fw = new FileWriter("Movies.json");

        fw.write(gson.toJson(titles));

        fw.close();

        System.out.println("Terminated.");
    }
}
