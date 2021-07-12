package com.project.eportal.employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.eportal.AdminActivity;
import com.project.eportal.Forgetpassword;
import com.project.eportal.IT.ITDashboard;
import com.project.eportal.MainActivity;
import com.project.eportal.R;
import com.project.eportal.manager.ManagerDashboard;
import com.project.eportal.manager.ManagerLogin;

public class EmployeeLogin extends AppCompatActivity {
    private FirebaseFirestore database;
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
        FirebaseFirestore database;
        FirebaseAuth mAuth;

        EditText et_mail = findViewById(R.id.emp_mail);
        EditText emp_pass = findViewById(R.id.emp_pass);

        String email = et_mail.getText().toString();
        String password = emp_pass.getText().toString();
        if(!email.toString().equals("")&&!password.equals("")) {
            int y = copmaredata(email, password);

            if (y != 0) {
                if (y == 1) {
                    Intent intent = new Intent(EmployeeLogin.this,
                            AdminActivity.class);
                    startActivity(intent);

                } else if (y == 2) {
                    Intent intent = new Intent(EmployeeLogin.this,
                            Dashboard.class);
                    startActivity(intent);

                } else if (y == 3) {
                    Intent intent = new Intent(EmployeeLogin.this,
                            ITDashboard.class);
                    startActivity(intent);

                } else if (y == 4) {
                    Intent intent = new Intent(EmployeeLogin.this,
                            ManagerDashboard.class);
                    startActivity(intent);

                }
            }
        }
        else
            Toast.makeText(this, "Please! Enter Email and Password", Toast.LENGTH_SHORT).show();
    }
    int x=0;
    private int copmaredata(final String email, String password) {
        if(x==0)
        {
            database.getInstance()
                    .collection("Admin").document(email)
                    .get()
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(EmployeeLogin.this, "no", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()) {
                                x = 1;
                            }else
                                x=0;
                        }
                    });
        }
        if(x==0)
        {
            database.getInstance()
                    .collection("users").document(email)
                    .get()
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(EmployeeLogin.this, "no", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()) {
                                x = 2;
                            }else
x=0;                        }
                    });
        }
        if(x==0)
        {
            database.getInstance()
                    .collection("IT").document(email)
                    .get()
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(EmployeeLogin.this, "no", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()) {
                                x = 3;
                            }else
x=0;                        }
                    });
        }
     if(x==0)
     {
         database.getInstance()
                 .collection("Managers").document(email)
                 .get()
                 .addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception e) {
                         Toast.makeText(EmployeeLogin.this, "no", Toast.LENGTH_SHORT).show();

                     }
                 })
                 .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                     @Override
                     public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                         if(task.isSuccessful()) {
                             x = 4;
                         }else
x=0;                     }
                 });
     }
       return x;
    }
    public void forgot_pass(View view) {
        Intent intent = new Intent(EmployeeLogin.this, Forgetpassword.class);
        startActivity(intent);
    }

}