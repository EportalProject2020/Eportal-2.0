package com.project.eportal.manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.eportal.R;
import com.project.eportal.employee.EmployeeMakeITRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ManagerMakeItRequest extends AppCompatActivity {
    private FirebaseFirestore database;
    private EditText et_name,et_title,et_description;
    private ManagerRequestsData managerRequestsData;
    private Button btn_newrequest ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_it_request);
        et_name = findViewById(R.id.et_name);
        et_title = findViewById(R.id.et_title);
        et_description = findViewById(R.id.et_description);
        btn_newrequest = findViewById(R.id.btn_addrequest);



        btn_newrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = et_title.getText().toString();
                String description = et_description.getText().toString();
                String name = et_name.getText().toString();

                database = FirebaseFirestore.getInstance();

                String requestId = UUID.randomUUID().toString();

                managerRequestsData = new ManagerRequestsData(title,description,name,requestId);

                Map<String, Object> ITRequestManager = new HashMap<>();
                ITRequestManager.put("ID", requestId);
                ITRequestManager.put("name", name);
                ITRequestManager.put("title", title);
                ITRequestManager.put("description", description);

                managerRequestsData.setTitle(title);
                managerRequestsData.setDescreption(description);
                managerRequestsData.setName(name);
                managerRequestsData.setRequestID(requestId);

                database.collection("ITRequestManager").document(name).set(ITRequestManager)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(ManagerMakeItRequest.this, "Request has been added", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ManagerMakeItRequest.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                Toast.makeText(ManagerMakeItRequest.this, "Your request has been added successfully",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void Users_requests(View view) {
        Intent intent = new Intent(ManagerMakeItRequest.this, UsersRequests.class);
        startActivity(intent);
    }
}