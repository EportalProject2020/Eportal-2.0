package com.project.eportal.employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.project.eportal.R;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EmployeeMakeITRequest extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private EditText et_name,et_title,et_description;
    private UserITRequestData userITRequestData;
    private Button btn_newrequest ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_make_it_request);
        et_name = findViewById(R.id.et_name);
        et_title = findViewById(R.id.et_title);
        et_description = findViewById(R.id.et_description);
        btn_newrequest = findViewById(R.id.btn_addrequest);

        userITRequestData = new UserITRequestData();

        btn_newrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = et_title.getText().toString();
                String description = et_description.getText().toString();
                String name = et_name.getText().toString();

                database = FirebaseDatabase.getInstance();
                databaseReference = database.getReference("Manager IT Requests");

                userITRequestData.setTitle(title);
                userITRequestData.setDescreption(description);
                userITRequestData.setName(name);

                databaseReference.child(name).setValue(userITRequestData);
                Toast.makeText(EmployeeMakeITRequest.this, "Your request has been added successfully",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }



//    private void uploadData(String name, String title, String description) {
//
//        progressDialog.setTitle("Adding your request ");
//        progressDialog.show();
//        String requestId = UUID.randomUUID().toString();
//
//        Map<String, Object> ITRequestuser = new HashMap<>();
//        ITRequestuser.put("ID", requestId);
//        ITRequestuser.put("name", name);
//        ITRequestuser.put("title", title);
//        ITRequestuser.put("description", description);
//
//        db.collection("ITRequestuser").document(requestId).set(ITRequestuser)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        progressDialog.dismiss();
//                        Toast.makeText(EmployeeMakeITRequest.this, "Request has been added", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(EmployeeMakeITRequest.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//    }

}
