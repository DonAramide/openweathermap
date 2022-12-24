package com.example.aramydeopenweathermap.network;


import com.example.aramydeopenweathermap.model.currentweather.CurrentWeather;
import com.example.aramydeopenweathermap.model.sevenDayForecast.SevendaysForecast;
import com.example.aramydeopenweathermap.model.threehourforecast.ThreeHourForecast;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;



public interface OpenWeatherMapService {

    String CURRENT = "/data/2.5/weather";
    String FORECAST = "/data/2.5/forecast";
    String ONCALL = "/data/3.0/onecall";

    //Current Weather Endpoints start
    @GET(CURRENT)
    Call<CurrentWeather> getCurrentWeatherByCityName(@QueryMap Map<String, String> options);

    @GET(CURRENT)
    Call<CurrentWeather> getCurrentWeatherByCityID(@QueryMap Map<String, String> options);

    @GET(CURRENT)
    Call<CurrentWeather> getCurrentWeatherByGeoCoordinates(@QueryMap Map<String, String> options);

    @GET(CURRENT)
    Call<CurrentWeather> getCurrentWeatherByZipCode(@QueryMap Map<String, String> options);

    //Current Weather Endpoints end

    //Three hour forecast endpoints start
    @GET(FORECAST)
    Call<ThreeHourForecast> getThreeHourForecastByCityName(@QueryMap Map<String, String> options);

    @GET(FORECAST)
    Call<ThreeHourForecast> getThreeHourForecastByCityID(@QueryMap Map<String, String> options);

    @GET(FORECAST)
    Call<ThreeHourForecast> getThreeHourForecastByGeoCoordinates(@QueryMap Map<String, String> options);

    @GET(FORECAST)
    Call<ThreeHourForecast> getThreeHourForecastByZipCode(@QueryMap Map<String, String> options);

    @GET(FORECAST)
    Call<SevendaysForecast> getSevenDays(@QueryMap Map<String, String> options);

}
