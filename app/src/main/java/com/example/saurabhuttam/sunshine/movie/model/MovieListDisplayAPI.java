package com.example.saurabhuttam.sunshine.movie.model;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.saurabhuttam.sunshine.WeatherAPI.OpenWeatherCallback;

import org.json.JSONObject;

/**
 * Created by Saurabh Uttam on 7/27/2016.
 */
public class MovieListDisplayAPI {
    private Context context;
    private OpenWeatherCallback callback;
    public MovieListDisplayAPI(OpenWeatherCallback callback,Context context)
    {
        this.callback=callback;
        this.context=context;
    }
    public void UpdateWeekList()
    {
        String url=String.format("");
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        StringRequest request=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(request);
    }
}
