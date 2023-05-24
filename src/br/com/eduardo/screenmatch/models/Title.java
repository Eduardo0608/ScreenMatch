package br.com.eduardo.screenmatch.models;

import br.com.eduardo.screenmatch.exception.ConversionErrorException;
import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {
    private String name;
    @SerializedName("Year")
    private int releaseYear;
    private boolean includedInPlan;
    private double sumOfRatings;
    private int numberOfRatings;
    private int durationInMinutes;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Title(TitleOmdb myTitleOmdb) {

        if (myTitleOmdb.year().length() > 4) {
            throw new ConversionErrorException("The conversion was not done because the year has more than 04 characters.");
        }

        this.name = myTitleOmdb.title();
        this.releaseYear = Integer.parseInt(myTitleOmdb.year());
        this.durationInMinutes = Integer.parseInt(myTitleOmdb.runtime().substring(0, 2));
    }

    public void displayTechnicalInformation() {
        System.out.println("Name of the title: " + name);
        System.out.println("Release year: " + releaseYear);
    }

    public void rate(double rating) {
        sumOfRatings += rating;
        numberOfRatings++;
    }

    @Override
    public String toString() {
        return "(Name: " + name + ", Release year: " + releaseYear + ", Runtime: " + durationInMinutes + ")";
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    public double getAverageRating() {
        return sumOfRatings / numberOfRatings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isIncludedInPlan() {
        return includedInPlan;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}