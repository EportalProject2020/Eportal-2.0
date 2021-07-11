package com.project.eportal.manager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.project.eportal.Forgetpassword;
import com.project.eportal.MainActivity;
import com.project.eportal.MeetingData;
import com.project.eportal.R;
import com.project.eportal.employee.EmployeeAdapter;
import com.project.eportal.employee.meeting_employee;

import java.util.ArrayList;
import java.util.List;

public class ManagerLogin extends AppCompatActivity {
    List<ManagerData> managerData = new ArrayList<>();
    private FirebaseFirestore database;
    private FirebaseAuth mAuth;
    private Button btn_login;
    private EditText et_pass, et_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_login);

        et_mail = findViewById(R.id.manager_mail);
        et_pass = findViewById(R.id.manager_pass);
        btn_login = findViewById(R.id.btn_login);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ManagerLogin.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void Login(View view) {

        String email = et_mail.getText().toString();
        String password = et_pass.getText().toString();

        copmaredata(email,password);

        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success,
                            Intent intent = new Intent(ManagerLogin.this,
                                    ManagerDashboard.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(ManagerLogin.this,
                                    "Re-check the email and password you entered"
                                    , Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void copmaredata(final String email, String password) {

        database.collection("Managers").document(email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot item : task.getResult()) {
                            ManagerData manager = new ManagerData(
                                    item.getString("email")
                                    , item.getString("password"));
                            managerData.add(manager);
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(meeting_employee.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void forgot_pass(View view) {
        Intent intent = new Intent(ManagerLogin.this, Forgetpassword.class);
        startActivity(intent);
    }

}
