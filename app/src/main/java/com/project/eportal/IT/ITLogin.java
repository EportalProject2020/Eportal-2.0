package com.project.eportal.IT;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.eportal.MainActivity;
import com.project.eportal.R;
import com.project.eportal.employee.Dashboard;
import com.project.eportal.employee.EmployeeLogin;

public class ITLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_login);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ITLogin.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void Login(View view) {

//        FirebaseApp.initializeApp(this);
//
//        final FirebaseAuth mAuth;
//        mAuth = FirebaseAuth.getInstance();
//
//        EditText et_mail = findViewById(R.id.IT_mail);
//        EditText emp_pass = findViewById(R.id.IT_pass);
//        String email = et_mail.getText().toString();
//        String password = emp_pass.getText().toString();
        Intent intent = new Intent(ITLogin.this, ITDashboard.class);
        startActivity(intent);
    }
}