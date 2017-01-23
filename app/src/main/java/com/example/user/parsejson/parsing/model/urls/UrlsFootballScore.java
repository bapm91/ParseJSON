package com.example.user.parsejson.parsing.model.urls;

public class UrlsFootballScore {
    private Url self;
    private Url soccerseason;

    public UrlsFootballScore(){
        self = new Url();
        soccerseason = new Url();
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

}
