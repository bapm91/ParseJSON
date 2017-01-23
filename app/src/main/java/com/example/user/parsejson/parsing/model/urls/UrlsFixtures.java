package com.example.user.parsejson.parsing.model.urls;

public class UrlsFixtures {
    private Url self;
    private Url soccerseason;
    private Url homeTeame;
    private Url awayTeame;

    public UrlsFixtures(){
        self = new Url();
        soccerseason = new Url();
        homeTeame = new Url();
        awayTeame = new Url();
    }

    public Url getSelf() {
        return self;
    }

    public void setSelf(Url self) {
        this.self = self;
    }

    public Url getSoccerseason() {
        return soccerseason;
    }

    public void setSoccerseason(Url soccerseason) {
        this.soccerseason = soccerseason;
    }

    public Url getHomeTeame() {
        return homeTeame;
    }

    public void setHomeTeame(Url homeTeame) {
        this.homeTeame = homeTeame;
    }

    public Url getAwayTeame() {
        return awayTeame;
    }

    public void setAwayTeame(Url awayTeame) {
        this.awayTeame = awayTeame;
    }
}
