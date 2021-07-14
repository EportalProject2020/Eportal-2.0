package com.project.eportal.IT;

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
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.eportal.R;
import com.project.eportal.employee.UserData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Add extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore database;
    public EditText et_password;
    public EditText et_email;
    public EditText et_name;
    public Button btn_add;
    private UserData user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        btn_add = findViewById(R.id.btn_Addnewuser);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = et_password.getText().toString();
                String mail = et_email.getText().toString();
                String name = et_name.getText().toString();


                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss:a");
                final String time =  format.format(calendar.getTime());

                mAuth = FirebaseAuth.getInstance();
                database = FirebaseFirestore.getInstance();

                String id = UUID.randomUUID().toString();
                user = new UserData(name, time);

                adduser(name, mail, password, id, time);
                authenticateuser(mail, password);

            }
        });

    }

    private void adduser(String name, String mail, String password, String id, String time) {

        Map<String, Object> users = new HashMap<>();
        users.put("ID", id);
        users.put("name", name);
        users.put("mail", mail);
        users.put("time", time);
//        users.put("password", password);

        user.setName(name);
        user.setEmail(mail);
        user.setPassword(password);
        user.setId(id);
        user.setTime(time);

        database.collection("users").document(mail).set(users)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Add.this, "User added successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Add.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void authenticateuser(String mail, String password) {

        mAuth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Add.this, "Authentication done.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Add.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

