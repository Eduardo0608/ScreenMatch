package br.com.eduardo.screenmatch.calculations;

public class Recomendation {
    public void filters(Ranking ranking) {
        if (ranking.getRanking() >= 4) {
            System.out.println("It is among the favorites of the moment.");
        } else if (ranking.getRanking() >= 2) {
            System.out.println("Very well rated.");
        } else {
            System.out.println("Put it on your list to watch later.");
        }
    }
}
