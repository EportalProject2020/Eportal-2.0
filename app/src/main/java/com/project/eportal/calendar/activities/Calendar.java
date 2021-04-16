package com.project.eportal.calendar.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import com.project.eportal.MainActivity;
import com.project.eportal.R;
import com.project.eportal.employee.EmployeeLogin;

public class Calendar extends AppCompatActivity {

    private CalendarView calendarView;
    private String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                selectedDate =Integer.toString(year)+ month + day;
            }
        });
    }



    }
