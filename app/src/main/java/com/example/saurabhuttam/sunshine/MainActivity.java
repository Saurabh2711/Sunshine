package com.example.saurabhuttam.sunshine;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhuttam.sunshine.Adapters.ViewPagerAdapter;
import com.example.saurabhuttam.sunshine.WeatherAPI.OpenWeatherCallback;
import com.example.saurabhuttam.sunshine.WeatherAPI.OpenWeatherCallbackTwo;
import com.example.saurabhuttam.sunshine.WeatherAPI.WeatherServiceVolley;
import com.example.saurabhuttam.sunshine.WeatherAPI.data.Weather;
import com.example.saurabhuttam.sunshine.fragments.OneFragment;
import com.example.saurabhuttam.sunshine.fragments.ThreeFragment;
import com.example.saurabhuttam.sunshine.fragments.TwoFragment;


public class MainActivity extends AppCompatActivity{
    private Toolbar app_bar;
    private ViewPager viewPager;
    private TabLayout tabs;
    OneFragment oneFragment;
    TwoFragment twoFragment;
    ThreeFragment threeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create Appbar
        app_bar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(app_bar);

        // Create Fragments
        oneFragment=new OneFragment();
        twoFragment=new TwoFragment();
        threeFragment=new ThreeFragment();
        viewPager=(ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabs=(TabLayout)findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    //Appbar Handling
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
        // /return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //
        switch (item.getItemId()) {
            case R.id.refresh:
                refresh();
                return true;
            case R.id.setting:
                startActivity(new Intent(this, SubActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onStart() {
        refresh();
        super.onStart();
    }

    private void refresh() {
        updateWeatherData("Delhi,India","C",oneFragment,twoFragment);
    }

    private void updateWeatherData(String location, String unit, OpenWeatherCallback fragment, OpenWeatherCallbackTwo fragment2)
    {
        WeatherServiceVolley serviceVolley=new WeatherServiceVolley(fragment,fragment2,this);
        serviceVolley.refreshWeather(location,"metric","4c4516ec88dc2dea8ca8b5ee3352802d");
    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(oneFragment,"Today");
        adapter.addFragment(twoFragment,"This week");
        adapter.addFragment(threeFragment,"Graph");
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
    }
}