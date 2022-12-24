package com.example.aramydeopenweathermap.model.currentweather;


import com.example.aramydeopenweathermap.model.common.Clouds;
import com.example.aramydeopenweathermap.model.common.Coord;
import com.example.aramydeopenweathermap.model.common.Main;
import com.example.aramydeopenweathermap.model.common.Rain;
import com.example.aramydeopenweathermap.model.common.Snow;
import com.example.aramydeopenweathermap.model.common.Sys;
import com.example.aramydeopenweathermap.model.common.Weather;
import com.example.aramydeopenweathermap.model.common.Wind;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CurrentWeather {

    @SerializedName("coord")
    private Coord coord;

    @SerializedName("weather")
    private List<Weather> weather;

    @SerializedName("base")
    private String base;

    @SerializedName("main")
    private Main main;

    @SerializedName("visibility")
    private Long visibility;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("clouds")
    private Clouds clouds;

    @SerializedName("rain")
    private Rain rain;

    @SerializedName("snow")
    private Snow snow;

    @SerializedName("dt")
    private Long dt;

    @SerializedName("sys")
    private Sys sys;

    @SerializedName("timezone")
    private Long timezone;

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    @SerializedName("cod")
    private Integer cod;

    public Coord getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public Long getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Rain getRain() {
        return rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public Long getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public Long getTimezone() {
        return timezone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCod() {
        return cod;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", rain=" + rain +
                ", snow=" + snow +
                ", dt=" + dt +
                ", sys=" + sys +
                ", timezone=" + timezone +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}
