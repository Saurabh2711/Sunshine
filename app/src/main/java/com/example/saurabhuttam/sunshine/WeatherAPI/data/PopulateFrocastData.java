package com.example.saurabhuttam.sunshine.WeatherAPI.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Saurabh Uttam on 7/28/2016.
 */
public class PopulateFrocastData {
    private JSONObject data;
    private JSONArray array;
    public PopulateFrocastData(JSONObject data)
    {
        this.data=data;
    }
    public JSONArray getObjectArray()
    {
        JSONArray dataArray=new JSONArray();
        array=data.optJSONArray("list");
        for(int i=1;i<array.length();++i)
        {
            JSONObject obj=new JSONObject();
            try {
                JSONObject current=(JSONObject) array.get(i);
                obj.put("date",current.optLong("dt"));
                obj.put("minTemp",current.optJSONObject("temp").optDouble("min"));
                obj.put("maxTemp",current.optJSONObject("temp").optDouble("max"));
                obj.put("humidity",current.optDouble("humidity"));
                JSONObject temp=(JSONObject) current.getJSONArray("weather").get(0);
                obj.put("icon",temp.optInt("id"));
                obj.put("condition",temp.optString("main"));
                obj.put("windspeed",current.optDouble("speed"));
                dataArray.put(obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return dataArray;
    }

}
