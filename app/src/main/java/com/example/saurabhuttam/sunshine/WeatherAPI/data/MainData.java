package com.example.saurabhuttam.sunshine.WeatherAPI.data;

import org.json.JSONObject;

/**
 * Created by Saurabh Uttam on 7/25/2016.
 */
public class MainData implements JSONPopulator {
    private double temp;
    private int humidity;
    private double temp_min;
    private double temp_max;

    public int getHumidity() {
        return humidity;
    }

    public double getTemp() {
        return temp;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    @Override
    public void pupulate(JSONObject data) {
        temp=data.optDouble("temp");
        humidity=data.optInt("humidity");
        temp_min=data.optDouble("temp_min");
        temp_max=data.optDouble("temp_max");
    }
}
