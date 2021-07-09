package com.project.eportal.manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.project.eportal.Forgetpassword;
import com.project.eportal.MainActivity;
import com.project.eportal.R;

public class ManagerLogin extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    private Button btn_login;
    private EditText et_pass,et_mail;

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

        final String email = et_mail.getText().toString();
        final String password = et_pass.getText().toString();

//        Query checkmanagerdata = FirebaseDatabase.getInstance().getReference("ManagerData")
//                .orderByChild("email").equalTo(email);
//        checkmanagerdata.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists()){
//                    String managerpassword = snapshot.child(email).child("password").getValue(String.class);
//                    if (managerpassword.equals(password)){
//
                        Intent intent = new Intent(ManagerLogin.this,ManagerDashboard.class);
                        startActivity(intent);
                        finish();
//                    }
//                    else {
//                        Toast.makeText(ManagerLogin.this, "Password does not match", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else {
//                    Toast.makeText(ManagerLogin.this, "Data not found", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//            }
//        });




//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//              //  String mail = snapshot.child("ManagerData").getValue();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

//        if (email == null || password == null) {
//            Toast.makeText(this, "Please enter a valid email and password",
//                    Toast.LENGTH_SHORT).show();
//        } else {
//            final FirebaseAuth mAuth;
//            mAuth = FirebaseAuth.getInstance();
//
//            mAuth.signInWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                // Sign in success,
//
//                                FirebaseUser user = mAuth.getCurrentUser();
//                                Intent intent = new Intent(ManagerLogin.this,
//                                        ManagerDashboard.class);
//                                startActivity(intent);
//                                finish();
//                            } else {
//                                // If sign in fails, display a message to the user.
//                                Toast.makeText(ManagerLogin.this,
//                                        "Re-check the email and password you entered"
//                                        , Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//        }
    }

    public void forgot_pass(View view) {
        Intent intent = new Intent(ManagerLogin.this, Forgetpassword.class);
        startActivity(intent);
    }

}
