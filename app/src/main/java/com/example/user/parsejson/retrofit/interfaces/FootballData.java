package com.example.user.parsejson.retrofit.interfaces;

import com.example.user.parsejson.retrofit.models.football_season.FootballSeasonModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FootballData {
    @GET("v1/soccerseasons/424/fixtures")
    Call<FootballSeasonModel> getData();
}
