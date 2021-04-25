package com.project.eportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.eportal.IT.ITLogin;
import com.project.eportal.employee.EmployeeLogin;
import com.project.eportal.manager.AdminLogin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void UserButton(View view) {
        Intent intent = new Intent(MainActivity.this, EmployeeLogin.class);
        startActivity(intent);
        finish();
    }

    public void AdminButton(View view) {
        Intent intent = new Intent(MainActivity.this, AdminLogin.class);
        startActivity(intent);
        finish();
    }

    public void youareIT(View view) {
        Intent intent = new Intent(MainActivity.this, ITLogin.class);
        startActivity(intent);
    }
}