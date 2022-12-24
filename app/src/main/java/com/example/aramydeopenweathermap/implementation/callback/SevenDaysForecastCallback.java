package com.example.aramydeopenweathermap.implementation.callback;

import com.example.aramydeopenweathermap.model.sevenDayForecast.SevendaysForecast;

public interface SevenDaysForecastCallback {
    void onSuccess(SevendaysForecast sevendaysForecast);
    void onFailure(Throwable throwable);
}