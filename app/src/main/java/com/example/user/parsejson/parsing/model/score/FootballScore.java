package com.example.user.parsejson.parsing.model.score;

import com.example.user.parsejson.parsing.model.urls.UrlsFootballScore;

public class FootballScore {
    private UrlsFootballScore _links;
    private String count;
    private Fixtures[] fixtures;

    public FootballScore(int size){
        _links = new UrlsFootballScore();
        count = "";
        fixtures = new Fixtures[size];
    }

    public UrlsFootballScore get_links() {
        return _links;
    }

    public void set_links(UrlsFootballScore _links) {
        this._links = _links;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Fixtures[] getFixtures() {
        return fixtures;
    }

    public void setFixtures(Fixtures[] fixtures){
        this.fixtures = fixtures;
    }
}
