package com.example.saurabhuttam.sunshine.WeatherAPI.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Saurabh Uttam on 7/25/2016.
 */
public class Weather implements JSONPopulator {
    private JSONArray weatherInfo;
    private MainData mainData;
    private Sun sun;
    private Wind wind;
    private String condition;
    private int icon;

    public int getIcon() {
        return icon;
    }

    public String getCondition() {
        return condition;
    }

    public Wind getWind() {
        return wind;
    }

    public Sun getSun() {
        return sun;
    }

    public JSONArray getWeatherInfo() {
        return weatherInfo;
    }

    public MainData getMainData() {
        return mainData;
    }

    @Override
    public void pupulate(JSONObject data) {
        weatherInfo=data.optJSONArray("weather");

        try {
            JSONObject temp=weatherInfo.getJSONObject(0);
            icon=temp.optInt("id");
            condition=temp.optString("main");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mainData=new MainData();
        mainData.pupulate(data.optJSONObject("main"));

        sun=new Sun();
        sun.pupulate(data.optJSONObject("sys"));

        wind=new Wind();
        wind.pupulate(data.optJSONObject("wind"));
    }
}
