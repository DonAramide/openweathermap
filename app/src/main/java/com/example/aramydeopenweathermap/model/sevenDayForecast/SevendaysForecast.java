package com.example.aramydeopenweathermap.model.sevenDayForecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SevendaysForecast {

    @SerializedName("cod")
    private String cod;

    @SerializedName("message")
    private double message;

    @SerializedName("cnt")
    private int cnt;

    @SerializedName("list")
    private List<SevenDaysForecastWeather> list;

    @SerializedName("city")
    private City city;


    public String getCod() {
        return cod;
    }

    public double getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public List<SevenDaysForecastWeather> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }


    @Override
    public String toString() {
        return "SevendaysForecast{" +
                "cod='" + cod + '\'' +
                ", message=" + message +
                ", cnt=" + cnt +
                ", list=" + list +
                ", city=" + city +
                '}';
    }
}
