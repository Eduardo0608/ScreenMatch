package br.com.eduardo.screenmatch.models;

public class Title implements Comparable<Title> {
    private String name;
    private int releaseYear;
    private boolean includedInPlan;
    private double sumOfRatings;
    private int numberOfRatings;
    private int durationInMinutes;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
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