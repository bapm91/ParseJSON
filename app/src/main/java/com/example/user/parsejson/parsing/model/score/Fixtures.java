package com.example.user.parsejson.parsing.model.score;

import com.example.user.parsejson.parsing.model.urls.UrlsFixtures;

public class Fixtures {
    private UrlsFixtures mUrls;
    private String date;
    private String status;
    private String matchday;
    private String homeTeamName;
    private String awayTeamName;
    private FootbollResult mFootbollResult;

    public Fixtures (){
        mUrls = new UrlsFixtures();
        date = "";
        status = "";
        matchday = "";
        homeTeamName = "";
        awayTeamName = "";
        mFootbollResult = new FootbollResult();
    }

    public UrlsFixtures getUrls() {

        return mUrls;
    }

    public void setUrls(UrlsFixtures urls) {
        mUrls = urls;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMatchday() {
        return matchday;
    }

    public void setMatchday(String matchday) {
        this.matchday = matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public FootbollResult getFootbollResult() {
        return mFootbollResult;
    }

    public void setFootbollResult(FootbollResult footbollResult) {
        mFootbollResult = footbollResult;
    }
}
