package com.project.eportal.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.eportal.R;
import com.project.eportal.calendar.activities.Calendar;
import com.project.eportal.employee.GetTasksActivity;

public class ManagerDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_dashboard);
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

    public void calenderEdit(View view) {
        Intent i = new Intent(ManagerDashboard.this, Calendar.class);
        startActivity(i);
    }

    public void createMeeting(View view) {
        Intent intent = new Intent(ManagerDashboard.this,Meeting_manager.class);
        startActivity(intent);
    }

    public void createTask(View view) {

        Intent intent = new Intent(ManagerDashboard.this,MakeTasksActivity.class);
        startActivity(intent);

    }


    public void addSchedule(View view) {
        Intent intent = new Intent(ManagerDashboard.this, GetTasksActivity.class);
        startActivity(intent);
    }
}