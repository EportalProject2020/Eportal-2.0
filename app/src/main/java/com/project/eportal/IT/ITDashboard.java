package com.project.eportal.IT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.eportal.R;
import com.project.eportal.manager.ManagerItRequestActivity;

public class ITDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_dashboard);
    }

    public void usersrequests(View view) {
        Intent intent = new Intent(ITDashboard.this,UsersRequestforIT.class);
        startActivity(intent);

    }

    public void adminrequests(View view) {
        Intent intent = new Intent(ITDashboard.this, ManagerRequestForIT.class);
        startActivity(intent);
    }

    public void AddUser(View view) {
        Intent intent = new Intent(ITDashboard.this,AddUser.class);
        startActivity(intent);
    }

    public void AddManager(View view) {
    }
}