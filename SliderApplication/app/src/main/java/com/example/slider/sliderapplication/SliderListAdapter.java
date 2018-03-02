package com.example.slider.sliderapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by niveditaupadhyay on 9/29/17.
 */

public class SliderListAdapter extends ArrayAdapter {
    private Context context;
    public SliderListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        convertView = inflater.inflate(R.layout.slider_list_item, null);

        SeekBar slider = convertView.findViewById(R.id.budget_slider);
        slider.setMax(10000000);

        final TextView tv = (TextView) convertView.findViewById(R.id.slider_value);
        final TextView tv2 = (TextView) convertView.findViewById(R.id.slider_value2);

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

        return convertView;
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

    public int getCount () {

        return 10;
    }
}
