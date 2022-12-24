package com.example.aramydeopenweathermap.implementation.callback;

import com.example.aramydeopenweathermap.model.threehourforecast.ThreeHourForecast;

public interface ThreeHourForecastCallback{
    void onSuccess(ThreeHourForecast threeHourForecast);
    void onFailure(Throwable throwable);
}