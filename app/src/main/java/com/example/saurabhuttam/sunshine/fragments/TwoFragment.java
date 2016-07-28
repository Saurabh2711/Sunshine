package com.example.saurabhuttam.sunshine.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.saurabhuttam.sunshine.Adapters.ListViewAdapter;
import com.example.saurabhuttam.sunshine.R;
import com.example.saurabhuttam.sunshine.WeatherAPI.OpenWeatherCallback;
import com.example.saurabhuttam.sunshine.WeatherAPI.OpenWeatherCallbackTwo;
import com.example.saurabhuttam.sunshine.WeatherAPI.data.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh Uttam on 7/25/2016.
 */
public class TwoFragment extends Fragment implements OpenWeatherCallbackTwo{
    View rootView;
    ListView listView;
    TextView tempTextView;
    Typeface weatherFonts;
    public TwoFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_two,container,false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public void serviceSuccess(JSONArray dataArray) {
        ArrayList arr=new ArrayList();
        for(int i=0;i<dataArray.length();++i)
        {
            try {
                arr.add(dataArray.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        ListViewAdapter adapter=new ListViewAdapter(getActivity(),getActivity(),arr);
        listView=(ListView) rootView.findViewById(R.id.weekList);
        listView.setAdapter(adapter);
    }

    @Override
    public void serviceFailure(Exception error) {

    }
}
