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
import com.project.eportal.manager.ManagerData;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AddManager extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore database;
    public EditText et_password;
    public EditText et_email;
    public EditText et_name;
    public Button btn_add;
    private ManagerData manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_manager);

        btn_add = findViewById(R.id.btn_Addnewmanager);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = et_password.getText().toString();
                String mail = et_email.getText().toString();
                String name = et_name.getText().toString();

                mAuth = FirebaseAuth.getInstance();
                database = FirebaseFirestore.getInstance();

                String id = UUID.randomUUID().toString();

                manager = new ManagerData(mail, name, password, id);

                addmanager(name, mail, password, id);
                authenticatemanager(mail, password);

            }
        });
    }

    private void addmanager(String name, String mail, String password, String id) {

        Map<String, Object> Managers = new HashMap<>();
        Managers.put("ID", id);
        Managers.put("name", name);
        Managers.put("mail", mail);
//        Managers.put("password", password);

        manager.setName(name);
        manager.setEmail(mail);
        manager.setPassword(password);
        manager.setId(id);

        database.collection("Managers").document(mail).set(Managers)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(AddManager.this, "Manager added successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddManager.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void authenticatemanager(String mail, String password) {

        mAuth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(AddManager.this, "Authentication done.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(AddManager.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}



