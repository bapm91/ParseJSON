package com.example.user.parsejson;
import android.app.Application;

import com.example.user.parsejson.retrofit.interfaces.FootballData;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static FootballData sFootballData;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.football-data.org/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        sFootballData = retrofit.create(FootballData.class); //Создаем объект, при помощи которого будем выполнять запросы
    }

    public static FootballData getApi() {
        return sFootballData;
    }
}