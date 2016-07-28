package com.example.saurabhuttam.sunshine.WeatherAPI;

import com.example.saurabhuttam.sunshine.WeatherAPI.data.Weather;

/**
 * Created by Saurabh Uttam on 7/25/2016.
 */
public interface OpenWeatherCallback {
    public void serviceSuccess(Weather weather);
    public void serviceFailure(Exception exception);
}
