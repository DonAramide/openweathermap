package com.example.aramydeopenweathermap.model.sevenDayForecast;

import com.example.aramydeopenweathermap.model.common.Coord;
import com.google.gson.annotations.SerializedName;


public class City {

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("coord")
    private Coord coord;

    @SerializedName("country")
    private String country;

    @SerializedName("timezone")
    private Long timezone;

    @SerializedName("population")
    private Long population;

    @SerializedName("sunrise")
    private Long sunrise;

    @SerializedName("sunset")
    private Long sunset;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public Long getTimezone() {
        return timezone;
    }

    public Long getPopulation() {
        return population;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                ", country='" + country + '\'' +
                ", timezone=" + timezone +
                ", population=" + population +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
}
