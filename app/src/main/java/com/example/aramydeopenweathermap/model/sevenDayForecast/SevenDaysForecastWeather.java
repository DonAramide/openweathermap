package com.example.aramydeopenweathermap.model.sevenDayForecast;

import com.example.aramydeopenweathermap.model.common.Clouds;
import com.example.aramydeopenweathermap.model.common.Main;
import com.example.aramydeopenweathermap.model.common.Rain;
import com.example.aramydeopenweathermap.model.common.Snow;
import com.example.aramydeopenweathermap.model.common.Sys;
import com.example.aramydeopenweathermap.model.common.Weather;
import com.example.aramydeopenweathermap.model.common.Wind;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SevenDaysForecastWeather {

    private Double lat;
    private Double lon;
    private String timezone;
    private Integer timezoneOffset;
    private Current current;

    private List<Daily> daily = null;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(Integer timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    @Override
    public String toString() {
        return "SevenDaysForecastWeather{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", timezone='" + timezone + '\'' +
                ", timezoneOffset=" + timezoneOffset +
                ", current=" + current +
                ", daily=" + daily +
                '}';
    }
}
