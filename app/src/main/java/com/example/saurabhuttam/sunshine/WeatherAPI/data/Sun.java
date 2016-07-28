package com.example.saurabhuttam.sunshine.WeatherAPI.data;

import org.json.JSONObject;

/**
 * Created by Saurabh Uttam on 7/25/2016.
 */
public class Sun implements JSONPopulator {
    private String sunrise;
    private String sunset;

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    @Override
    public void pupulate(JSONObject data) {
        sunrise=data.optString("sunrise");
        sunset=data.optString("sunset");
    }
}
