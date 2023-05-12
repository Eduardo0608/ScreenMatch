package br.com.eduardo.screenmatch.main;

import br.com.eduardo.screenmatch.models.Film;
import br.com.eduardo.screenmatch.models.Serie;
import br.com.eduardo.screenmatch.models.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainWithLists {
    public static void main(String[] args) {

        Film myFilm = new Film("The Godfather", 1972);

        myFilm.rate(9);

        Film otherFilm = new Film("Avatar: The Way of Water", 2023);

        otherFilm.rate(6);

        Film otherFilm2 = new Film("Oppenheimer", 2023);

        otherFilm2.rate(10);

        Serie mySerie = new Serie("Lost", 2004);

        ArrayList<Title> list = new ArrayList<>();

        list.add(myFilm);
        list.add(otherFilm);
        list.add(otherFilm2);
        list.add(mySerie);

        for (Title item : list) {
            System.out.println(item.getName());
            if (item instanceof Film film && film.getRanking() > 2) {
                System.out.println("Rating: " + film.getRanking());
            }
        }

        ArrayList<String> searchPerActor = new ArrayList<>();

        searchPerActor.add("Adam Sandler");
        searchPerActor.add("Kevin Hart");
        searchPerActor.add("Bruna Marquezine");
        System.out.println(searchPerActor);

        Collections.sort(searchPerActor);
        System.out.println("After ordination: " + searchPerActor);

        Collections.sort(list);
        System.out.println("After ordination: " + list);

        list.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println("Sorted by release date: " + list);
    }
}
