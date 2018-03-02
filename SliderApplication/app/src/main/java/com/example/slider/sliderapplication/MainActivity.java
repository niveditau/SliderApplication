package com.example.slider.sliderapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        boolean useBetterAdapter = intent.getBooleanExtra(LauncherActivity.EXTRA_MESSAGE, true);

        ListView sliderList = (ListView) findViewById(R.id.slider_list);

        if (useBetterAdapter) {
            sliderList.setAdapter(new BetterSliderListAdapter(this, 0));
        } else {
            sliderList.setAdapter(new SliderListAdapter(this, 0));
        }

    }
}
