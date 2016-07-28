package com.example.saurabhuttam.sunshine.fragments;

/**
 * Created by Saurabh Uttam on 7/24/2016.
 */
import android.content.Context;
import android.graphics.Typeface;
import android.nfc.tech.NfcBarcode;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhuttam.sunshine.R;
import com.example.saurabhuttam.sunshine.WeatherAPI.IdToImageConverter;
import com.example.saurabhuttam.sunshine.WeatherAPI.OpenWeatherCallback;
import com.example.saurabhuttam.sunshine.WeatherAPI.WeatherServiceVolley;
import com.example.saurabhuttam.sunshine.WeatherAPI.data.Weather;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class OneFragment extends Fragment implements OpenWeatherCallback{
    private TextView temp,city,humidity,windSpeed,sunrise,sunset,minTemp,maxTemp,humidityIcon,windSpeedIcon,sunriseIcon,sunSetIcon,conditionIcon,condition;

    String location;
    Typeface weatherFonts;
    View rootView;
    public OneFragment() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weatherFonts=Typeface.createFromAsset(getActivity().getAssets(),"fonts/weather.ttf");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.fragment_one, container, false);
        temp= (TextView) rootView.findViewById(R.id.tempTV);
        temp.setTypeface(weatherFonts);
        city=(TextView) rootView.findViewById(R.id.cityTV);
        humidity=(TextView) rootView.findViewById(R.id.humidityTV);
        windSpeed=(TextView) rootView.findViewById(R.id.windSpeedTV);
        sunrise=(TextView) rootView.findViewById(R.id.sunriseTV);
        sunset=(TextView) rootView.findViewById(R.id.sunsetTV);
        minTemp=(TextView) rootView.findViewById(R.id.minTempTV);
        maxTemp=(TextView) rootView.findViewById(R.id.maxTempTV);
        conditionIcon=(TextView) rootView.findViewById(R.id.conditionIV);
        conditionIcon.setTypeface(weatherFonts);
        humidityIcon=(TextView) rootView.findViewById(R.id.humidityIV);
        humidityIcon.setTypeface(weatherFonts);
        windSpeedIcon=(TextView) rootView.findViewById(R.id.windSpeedIV);
        windSpeedIcon.setTypeface(weatherFonts);
        sunriseIcon=(TextView) rootView.findViewById(R.id.sunriseIV);
        sunriseIcon.setTypeface(weatherFonts);
        sunSetIcon=(TextView) rootView.findViewById(R.id.sunsetIV);
        sunSetIcon.setTypeface(weatherFonts);
        condition=(TextView)rootView.findViewById(R.id.condtion);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    String convertTime(String t)
    {
        long unixSeconds = Long.parseLong(t);
        Date date = new Date(unixSeconds*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mma"); // the format of your date
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); // give a timezone reference for formating (see comment at the bottom
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    @Override
    public void serviceSuccess(Weather weather) {
        try {
            temp.setText(Math.round(weather.getMainData().getTemp()) + "");
            humidity.setText(weather.getMainData().getHumidity() + "%");
            windSpeed.setText(weather.getWind().getSpeed() + " m/s");
            sunrise.setText(convertTime(weather.getSun().getSunrise()));
            sunset.setText(convertTime(weather.getSun().getSunset()));
            maxTemp.setText(Math.round(weather.getMainData().getTemp_max()) + "\u00B0C");
            minTemp.setText(Math.round(weather.getMainData().getTemp_min()) + "\u00B0C");
            condition.setText(weather.getCondition());
            city.setText(location);

            int icon = weather.getIcon();

            conditionIcon.setText(IdToImageConverter.getConverter(getActivity(), icon));
        }catch (Exception e)
        {
            Toast.makeText(getActivity(),""+e,Toast.LENGTH_LONG).show();
        }
        // conditionIcon.setTypeface(weatherFonts);
    }

    @Override
    public void serviceFailure(Exception exception) {
        Toast.makeText(getActivity(),""+exception,Toast.LENGTH_LONG).show();
    }
}
