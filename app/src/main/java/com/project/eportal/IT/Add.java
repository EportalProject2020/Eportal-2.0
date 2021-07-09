package com.project.eportal.IT;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.eportal.R;
import com.project.eportal.employee.UserData;

public class Add extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
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
        user = new UserData();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = et_password.getText().toString();
                String mail = et_email.getText().toString();
                String name = et_name.getText().toString();

                database = FirebaseDatabase.getInstance();
                databaseReference = database.getReference("UserData");

                user.setName(name);
                user.setEmail(mail);
                user.setPassword(password);

                databaseReference.child(mail).setValue(user);
                Toast.makeText(Add.this, "User added successfully",
                        Toast.LENGTH_SHORT).show();


            }
        });


    }
}

