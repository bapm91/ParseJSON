package com.example.user.parsejson.parsing.model.urls;

public class Urls {
    Url[] mUrl;

    public Urls(int number) {
        mUrl = new Url[number];
    }

    public Url[] getUrl() {
        return mUrl;
    }

    public void setUrl(Url[] url) {
        mUrl = url;
    }
}
