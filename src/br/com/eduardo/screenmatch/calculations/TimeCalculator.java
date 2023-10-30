package br.com.eduardo.screenmatch.calculations;

import br.com.eduardo.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime = 0;


    // Teste de documentação com conventional commit.
    public void includes(Title t) {
        System.out.println("Adding duration in minutes for " + t.getName() + "...");
        this.totalTime += t.getDurationInMinutes();
    }

    public int getTotalTime() {
        return this.totalTime;
    }
}