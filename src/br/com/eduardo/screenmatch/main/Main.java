package br.com.eduardo.screenmatch.main;

import br.com.eduardo.screenmatch.calculations.Recomendation;
import br.com.eduardo.screenmatch.calculations.TimeCalculator;
import br.com.eduardo.screenmatch.models.Episode;
import br.com.eduardo.screenmatch.models.Film;
import br.com.eduardo.screenmatch.models.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Film myFilm = new Film("The Godfather", 1972);

        //myFilm.setName("The Godfather");
        //myFilm.setReleaseYear(1972);
        myFilm.setDurationInMinutes(175);
        myFilm.displayTechnicalInformation();

        myFilm.rate(8);
        myFilm.rate(5);
        myFilm.rate(10);
        System.out.println("Total ratings: " + myFilm.getNumberOfRatings());
        System.out.println("Average rating: " + myFilm.getAverageRating());

        Serie mySerie = new Serie("Lost", 2004);
        //mySerie.setName("Lost");
        //mySerie.setReleaseYear(2004);
        mySerie.displayTechnicalInformation();
        mySerie.setSeasons(6);
        mySerie.setEpisodesPerSeason(24);
        mySerie.setMinutesPerEpisode(50);
        System.out.println("Duration in minutes (" + mySerie.getName() + "): " + mySerie.getDurationInMinutes());

        Film otherFilm = new Film("Avatar: The Way of Water", 2023);

        //otherFilm.setName("Avatar: The Way of Water");
        //otherFilm.setReleaseYear(2023);
        otherFilm.setDurationInMinutes(192);

        TimeCalculator calc = new TimeCalculator();

        calc.includes(myFilm);
        calc.includes(otherFilm);
        calc.includes(mySerie);
        System.out.println("Total minutes after adding all titles: " + calc.getTotalTime());

        Recomendation recomendation = new Recomendation();

        recomendation.filters(myFilm);

        Episode episode = new Episode();

        episode.setNumber(1);
        episode.setSerie(mySerie);
        episode.setTotalViews(300);
        recomendation.filters(episode);

        Film otherFilm2 = new Film("Oppenheimer", 2023);

        //otherFilm2.setName("Oppenheimer");
        //otherFilm2.setReleaseYear(2023);
        otherFilm2.setDurationInMinutes(150);
        otherFilm2.rate(10);

        ArrayList<Film> filmList = new ArrayList<>();

        filmList.add(myFilm);
        filmList.add(otherFilm);
        filmList.add(otherFilm2);

        System.out.println("List size: " + filmList.size());
        System.out.println("1st film: " + filmList.get(0).getName());
        System.out.println(filmList);
    }
}