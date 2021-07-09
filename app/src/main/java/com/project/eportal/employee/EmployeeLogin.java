package com.project.eportal.employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.eportal.Forgetpassword;
import com.project.eportal.MainActivity;
import com.project.eportal.R;

public class EmployeeLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EmployeeLogin.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void Login(View view) {
        FirebaseApp.initializeApp(this);
        FirebaseDatabase database;
        DatabaseReference mDatabase;
        FirebaseAuth mAuth;



        EditText et_mail = findViewById(R.id.emp_mail);
        EditText emp_pass = findViewById(R.id.emp_pass);
        String email = et_mail.getText().toString();
        String password = emp_pass.getText().toString();
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("USER");
        mAuth = FirebaseAuth.getInstance();
        Intent intent = new Intent(EmployeeLogin.this,Dashboard.class);
        startActivity(intent);

    }

    public void forgot_pass(View view) {
        Intent intent = new Intent(EmployeeLogin.this, Forgetpassword.class);
        startActivity(intent);
    }

}