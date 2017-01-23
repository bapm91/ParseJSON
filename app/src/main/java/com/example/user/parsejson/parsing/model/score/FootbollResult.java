package com.example.user.parsejson.parsing.model.score;

public class FootbollResult {
    private String goalsHomeTeam;
    private String goalsAwayTeam;
    private HalfTime resultHalfTime;

    public String getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(String goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public String getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(String goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public HalfTime getResultHalfTime() {
        return resultHalfTime;
    }

    public void setResultHalfTime(HalfTime resultHalfTime) {
        this.resultHalfTime = resultHalfTime;
    }
}
