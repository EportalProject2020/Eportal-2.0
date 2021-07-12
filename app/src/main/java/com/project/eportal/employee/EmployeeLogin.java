package com.project.eportal.employee;

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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.project.eportal.AdminActivity;
import com.project.eportal.Forgetpassword;
import com.project.eportal.IT.ITDashboard;
import com.project.eportal.R;
import com.project.eportal.manager.ManagerDashboard;

public class EmployeeLogin extends AppCompatActivity {
    private FirebaseFirestore database;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);
    }


    public void Login(View view) {
        FirebaseApp.initializeApp(this);
        FirebaseFirestore database;
        FirebaseAuth mAuth;

        EditText et_mail = findViewById(R.id.emp_mail);
        EditText emp_pass = findViewById(R.id.emp_pass);

        String email = et_mail.getText().toString();
        String password = emp_pass.getText().toString();
        if (!email.equals("") && !password.equals("")) {

            authenticateuser(email, password);



        } else
            Toast.makeText(this, "Please! Enter Email and Password", Toast.LENGTH_SHORT).show();
    }

    int x = 0;
    int y = 0;

    private int copmaredata(final String email, final String password) {

        DocumentReference docRef = database.getInstance().collection("Admin").document(email);
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot snap, FirebaseFirestoreException fe) {
                if (snap.exists()) {
                    if (snap.get("mail").toString().equals(email) && snap.get("password").toString().equals(password)) {

                        Intent intent = new Intent(EmployeeLogin.this,
                                AdminActivity.class);
                        startActivity(intent);

                    }
                }
            }

        });
        DocumentReference docRef1 = database.getInstance().collection("users").document(email);
        docRef1.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot snap, FirebaseFirestoreException fe) {
                if (snap.exists()) {
                    if (snap.get("mail").toString().equals(email) && snap.get("password").toString().equals(password)) {
                        {
                            Intent intent = new Intent(EmployeeLogin.this,
                                    Dashboard.class);
                            startActivity(intent);
                        }
                    }
                }
            }

        });
        DocumentReference docRef2 = database.getInstance().collection("IT").document(email);
        docRef2.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot snap, FirebaseFirestoreException fe) {
                if (snap.exists()) {
                    if (snap.get("mail").toString().equals(email) && snap.get("password").toString().equals(password)) {

                        Intent intent = new Intent(EmployeeLogin.this,
                                ITDashboard.class);
                        startActivity(intent);
                    }
                    //update
                }
            }

        });
        DocumentReference docRef4 = database.getInstance().collection("Managers").document(email);
        docRef4.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot snap, FirebaseFirestoreException fe) {
                if (snap.exists()) {
                    if (snap.get("mail").toString().equals(email) && snap.get("password").toString().equals(password)) {

                        Intent intent = new Intent(EmployeeLogin.this,
                                ManagerDashboard.class);
                        startActivity(intent);

                    }
                    //update
                }
            }

        });

        return x;
    }

    private int authenticateuser(final String email, final String password) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        y=1;
                        if (task.isSuccessful()) {
                            // Sign in success,
                            copmaredata(email, password);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(EmployeeLogin.this,
                                    "Re-check the email and password you entered"
                                    , Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return y;
    }


    public void forgot_pass(View view) {
        Intent intent = new Intent(EmployeeLogin.this, Forgetpassword.class);
        startActivity(intent);
    }

}