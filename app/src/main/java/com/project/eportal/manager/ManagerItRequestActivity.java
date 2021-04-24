package com.project.eportal.manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.eportal.R;
import com.project.eportal.employee.MakeItRequestActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ManagerItRequestActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    FirebaseFirestore db ;
    EditText et_name,et_title,et_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_it_request);

        progressDialog = new ProgressDialog(this);
        db = FirebaseFirestore.getInstance();
    }

    public void Users_requests(View view) {
        Intent intent = new Intent(ManagerItRequestActivity.this, UsersRequests.class);
    }

    public void addrequest(View view) {

        et_name = findViewById(R.id.et_name);
        et_title = findViewById(R.id.et_title);
        et_description = findViewById(R.id.et_description);

        String title = et_title.getText().toString();
        String description = et_description.getText().toString();
        String name = et_name.getText().toString();
        uploadData(name,title, description);
    }

    private void uploadData(String name, String title, String description) {
        progressDialog.setTitle("Adding your request ");
        progressDialog.show();
        String requestId = UUID.randomUUID().toString();

        Map<String, Object> ITRequestmanager = new HashMap<>();
        ITRequestmanager.put("name", name);
        ITRequestmanager.put("title", title);
        ITRequestmanager.put("description", description);


        db.collection("ITRequestManager").document(requestId).set(ITRequestmanager)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        Toast.makeText(ManagerItRequestActivity.this, "Request has been added", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ManagerItRequestActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}