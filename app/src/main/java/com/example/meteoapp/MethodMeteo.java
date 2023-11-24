package com.example.meteoapp;

import android.speech.ModelDownloadListener;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MethodMeteo {

    @GET("data/2.5/forecast")
    Call<ModelMeteo> getAllData(@Query("q") String cityName,@Query("units") String units, @Query("appid") String apiKey);
    Call<ModelMeteo> getAllData(@Query("lat") double lat, @Query("lon") double lon,@Query("units") String units, @Query("appid") String apiKey);
}
