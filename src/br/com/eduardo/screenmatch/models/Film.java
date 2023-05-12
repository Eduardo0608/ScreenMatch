package br.com.eduardo.screenmatch.models;

import br.com.eduardo.screenmatch.calculations.Ranking;

public class Film extends Title implements Ranking {
    private String director;

    public Film(String name, int releaseYear) {
        super(name, releaseYear);
    }

    @Override
    public int getRanking() {
        return (int) getAverageRating() / 2;
    }

    @Override
    public String toString() {
        return "Film: " + this.getName() + " (" + this.getReleaseYear() + ")";
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}