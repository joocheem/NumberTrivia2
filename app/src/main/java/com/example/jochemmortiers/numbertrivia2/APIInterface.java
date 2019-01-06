package com.example.jochemmortiers.numbertrivia2;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface APIInterface {

    String BASE_URL = "http://numbersapi.com/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("/random/trivia?json")

    Call<Nummer> getRandomNumber();


}
