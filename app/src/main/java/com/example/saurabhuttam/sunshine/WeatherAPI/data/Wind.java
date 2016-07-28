package com.example.saurabhuttam.sunshine.WeatherAPI.data;

import org.json.JSONObject;

/**
 * Created by Saurabh Uttam on 7/25/2016.
 */
public class Wind implements JSONPopulator {
    private double speed;

    public double getSpeed() {
        return speed;
    }

    @Override
    public void pupulate(JSONObject data) {
        speed=data.optDouble("speed");
    }
}
