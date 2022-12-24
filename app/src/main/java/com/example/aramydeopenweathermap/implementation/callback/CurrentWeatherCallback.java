package com.example.aramydeopenweathermap.implementation.callback;


import com.example.aramydeopenweathermap.model.currentweather.CurrentWeather;

public interface CurrentWeatherCallback{
    void onSuccess(CurrentWeather currentWeather);
    void onFailure(Throwable throwable);
}
