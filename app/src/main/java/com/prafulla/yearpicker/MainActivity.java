package com.prafulla.yearpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.whiteelephant.monthpicker.MonthPickerDialog;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chooseYearOnly();

    }

    int chosenYear = 2019;

    private void chooseYearOnly() {
        setContentView(R.layout.activity_main);

        final TextView year = (TextView) findViewById(R.id.year);
        findViewById(R.id.choose_year).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonthPickerDialog.Builder builder = new MonthPickerDialog.Builder(MainActivity.this, new MonthPickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(int selectedMonth, int selectedYear) {
                        year.setText(Integer.toString(selectedYear));
                        chosenYear = selectedYear;
                    }
                }, chosenYear, 0);

                builder.showYearOnly()
                        .setYearRange(1900, 2100)
                        .build()
                        .show();
            }
        });
    }



}