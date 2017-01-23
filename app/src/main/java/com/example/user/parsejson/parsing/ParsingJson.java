package com.example.user.parsejson.parsing;

import com.example.user.parsejson.parsing.model.flag.CountryFlags;
import com.example.user.parsejson.parsing.model.score.FootballScore;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ParsingJson {

    public CountryFlags parseCountryFlags(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, CountryFlags.class);
    }

    public FootballScore parseFootballScore(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, FootballScore.class);
    }

    public String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
