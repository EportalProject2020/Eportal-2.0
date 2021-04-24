package com.project.eportal.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.eportal.R;
import com.project.eportal.calendar.activities.Calendar;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setTitle("Leave?")
                .setMessage("Do you really want to leave?")
                .setCancelable(false)
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }



    public void joinMeeting(View view) {
        Intent intent = new Intent(Dashboard.this, meeting_employee.class);
        startActivity(intent);
    }

    public void goToSchedule(View view) {
        Intent intent = new Intent(Dashboard.this,MakeItRequestActivity.class);
        startActivity(intent);
    }

    public void gotToTasks(View view) {
        Intent intent = new Intent(Dashboard.this, GetTasksActivity.class);
        startActivity(intent);
    }

    public void gotToCalender(View view) {
        Intent intent = new Intent(Dashboard.this,Calendar.class);
        startActivity(intent);
    }
}