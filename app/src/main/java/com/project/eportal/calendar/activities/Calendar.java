package com.project.eportal.calendar.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;

import com.project.eportal.MainActivity;
import com.project.eportal.R;
import com.project.eportal.employee.EmployeeLogin;


// test test backk or not
public class Calendar extends AppCompatActivity {

    private CalendarView calendarView;
    private String selectedDate;
    private DatePickerDialog datePickerDialog;
    private DatePickerDialog datePickerDialog2;

    private Button btn_date , btn_date2;
//it's backk to its old shape

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

        inintDatePicker();
        inintDatePicker2();
        btn_date = findViewById(R.id.btn_date_picker);
        btn_date2 = findViewById(R.id.btn_date_picker2);
        btn_date2.setText(getTodayDate());
        btn_date.setText(getTodayDate());
    }

    private String getTodayDate() {

        java.util.Calendar calendar = java.util.Calendar.getInstance();

        int year = calendar.get(java.util.Calendar.YEAR);
        int month = calendar.get(java.util.Calendar.MONTH);
        month = month + 1 ;
        int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        return makeDateString( day, month , year);

    }
        // for *FROM* date
    private void inintDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month+1;
                  String date = makeDateString(day,month,year);
                  btn_date.setText(date);
        }
        };

        java.util.Calendar calendar = java.util.Calendar.getInstance();

        int year = calendar.get(java.util.Calendar.YEAR);
        int month = calendar.get(java.util.Calendar.MONTH);
        int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year , month , day );

        //for *TO* Date

    } private void inintDatePicker2() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year1, int month1, int day1)
            {
                month1 = month1 +1;
                  String date2 = makeDateString(day1,month1,year1);

                  btn_date2.setText(date2);
            }
        };

        java.util.Calendar calendar = java.util.Calendar.getInstance();

        int year1 = calendar.get(java.util.Calendar.YEAR);
        int month1 = calendar.get(java.util.Calendar.MONTH);
        int day1 = calendar.get(java.util.Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog2 = new DatePickerDialog(this, style, dateSetListener, year1 , month1 , day1 );


    }

    private String makeDateString(int day, int month, int year) {

            return getMonthFormate(month) +  " "  + day +  " "  + year;
    }

    private String getMonthFormate(int month) {

     if(month == 1)
         return "Jan";
        if(month == 2)
            return "Feb";
        if(month == 3)
            return "Mar";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";
// initial Month
        return"JAN";
    }
    public void openDataPicker(View view) {
        datePickerDialog.show();


    }

    public void openDataPicker1(View view) {
        datePickerDialog2.show();

    }
}
