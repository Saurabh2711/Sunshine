package com.example.saurabhuttam.sunshine.WeatherAPI;

import org.json.JSONArray;

/**
 * Created by Saurabh Uttam on 7/28/2016.
 */
public interface OpenWeatherCallbackTwo {
    public void serviceSuccess(JSONArray dataArray);
    public void serviceFailure(Exception error);
}
