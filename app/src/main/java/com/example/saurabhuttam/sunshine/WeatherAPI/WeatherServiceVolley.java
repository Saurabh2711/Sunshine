package com.example.saurabhuttam.sunshine.WeatherAPI;

import android.app.DownloadManager;
import android.content.Context;
import android.service.voice.VoiceInteractionSession;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.saurabhuttam.sunshine.WeatherAPI.data.PopulateFrocastData;
import com.example.saurabhuttam.sunshine.WeatherAPI.data.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Saurabh Uttam on 7/26/2016.
 */
public class WeatherServiceVolley {
    private OpenWeatherCallback callback_one;
    private OpenWeatherCallbackTwo callback_two;
    private Context context;
    public WeatherServiceVolley(OpenWeatherCallback callback,OpenWeatherCallbackTwo callback2, Context context)
    {
        this.context=context;
        this.callback_one=callback;
        this.callback_two=callback2;
    }
    public void refreshWeather(String location,String unit,String key)
    {
        String url1=String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&units=%s&APPID=%s",location,unit,key);
        String url2=String.format("http://api.openweathermap.org/data/2.5/forecast/daily?q=%s&units=%s&cnt=7&APPID=%s",location,unit,key);
        RequestQueue queue= Volley.newRequestQueue(context);
        StringRequest requestToday=new StringRequest(Request.Method.GET, url1
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Weather weather=new Weather();
                try {
                    weather.pupulate(new JSONObject(response));
                    callback_one.serviceSuccess(weather);
                } catch (JSONException e) {
                    callback_one.serviceFailure(e);
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Exception e=new Exception(error+"");
                        callback_one.serviceFailure(e);

                    }
                }
        );
        StringRequest requestForecast=new StringRequest(Request.Method.GET, url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            PopulateFrocastData populateFrocastData=new PopulateFrocastData(new JSONObject(response));
                            JSONArray array=populateFrocastData.getObjectArray();
                            callback_two.serviceSuccess(array);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        queue.add(requestToday);
        queue.add(requestForecast);

    }
}
