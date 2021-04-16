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
import com.project.eportal.MainActivity;
import com.project.eportal.R;
import com.project.eportal.manager.AdminLogin;
import com.project.eportal.manager.ManagerDashboard;

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

        final FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        EditText et_mail = findViewById(R.id.emp_mail);
        EditText emp_pass = findViewById(R.id.emp_pass);
        String email = et_mail.getText().toString();
        String password = emp_pass.getText().toString();

        if (email == null || password == null) {
            Toast.makeText(this, "Please enter a valid email and password", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(EmployeeLogin.this, Dashboard.class);
                                startActivity(intent);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(EmployeeLogin.this, "Re-check the email and password you entered", Toast.LENGTH_SHORT).show();


                            }
                        }
                    });
        }
    }

    public void forgot_pass(View view) {
//        FirebaseAuth auth = FirebaseAuth.getInstance();
//
//        auth.sendPasswordResetEmail(email)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                                Intent intent = new Intent(AdminLogin.this, forgot_password.class);
//        startActivity(intent);
//                        }
//                    }
//                });
    }

}