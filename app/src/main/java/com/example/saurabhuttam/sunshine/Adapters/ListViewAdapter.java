package com.example.saurabhuttam.sunshine.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.bumptech.glide.Glide;
import com.example.saurabhuttam.sunshine.R;
import com.example.saurabhuttam.sunshine.WeatherAPI.IdToImageConverter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Saurabh Uttam on 7/27/2016.
 */
public class ListViewAdapter extends ArrayAdapter<JSONObject> {
    ArrayList arr;
    Context context;
    Activity activity;
    Typeface weatherFonts;

    public ListViewAdapter(Activity activity,Context context, ArrayList arr) {
        super(context,0,arr);
        this.arr=arr;
        this.activity=activity;
        this.context=context;

    }
    String convertTime(String t)
    {
        long unixSeconds = Long.parseLong(t);
        Date date = new Date(unixSeconds*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM"); // the format of your date
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); // give a timezone reference for formating (see comment at the bottom
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        weatherFonts=Typeface.createFromAsset(activity.getAssets(),"fonts/weather.ttf");
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.week_list_row,parent,false);
        TextView iconTextView=(TextView) view.findViewById(R.id.iconTextView);
        JSONObject object = (JSONObject) arr.get(position);
        iconTextView.setTypeface(weatherFonts);
        iconTextView.setText(IdToImageConverter.getConverter(activity,object.optInt("icon")));
        TextView temp=(TextView)view.findViewById(R.id.temp);
        TextView humidityIcon=(TextView)view.findViewById(R.id.humidityIcon);
        humidityIcon.setTypeface(weatherFonts);
        TextView windIcon=(TextView)view.findViewById(R.id.windIcon);
        windIcon.setTypeface(weatherFonts);
        TextView windspeed=(TextView)view.findViewById(R.id.windspeed);
        windspeed.setText(object.optDouble("windspeed")+" m/s");
        TextView humidity=(TextView) view.findViewById(R.id.humidity);
        humidity.setText(object.optDouble("humidity")+"");
        TextView condition=(TextView)view.findViewById(R.id.condition);
        condition.setText(object.optString("condition"));
        TextView date=(TextView)view.findViewById(R.id.day);
        date.setText(convertTime(object.optLong("date")+""));
        temp.setText(Math.round(object.optDouble("minTemp"))+"-"+Math.round(object.optDouble("maxTemp"))+"\u00B0C");
        return view;
    }
}
