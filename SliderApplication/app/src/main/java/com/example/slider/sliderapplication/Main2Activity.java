package com.example.slider.sliderapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        LinearLayout myLayout = (LinearLayout) findViewById(R.id.linearLayout);

        for (int i = 0; i < 10; i++) {
            //Inflate the Hidden Layout Information View
            View hiddenInfo = getLayoutInflater().inflate(R.layout.slider_list_item, myLayout, false);
            myLayout.addView(hiddenInfo);

            final TextView tv = (TextView) hiddenInfo.findViewById(R.id.slider_value);
            final TextView tv2 = (TextView) hiddenInfo.findViewById(R.id.slider_value2);
            SeekBar slider = hiddenInfo.findViewById(R.id.budget_slider);
            slider.setMax(10000000);
            slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv.setText(getFormattedAmount(getAmountInDollar(i)));
                tv2.setText(getFormattedAmount(getAmountInDollar(i)));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }
    }

    public String getFormattedAmount(Double amount) {
        NumberFormat form = NumberFormat.getCurrencyInstance(Locale.getDefault());
        form.setMinimumFractionDigits(0);
        String formattedAmount = form.format(amount);
        return formattedAmount;
    }

    public Double getAmountInDollar(double amount) {
        Double formattedAmount = amount / 100;
        return Math.ceil(formattedAmount);
    }
}
