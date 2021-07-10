package com.project.eportal.manager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
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
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.eportal.MeetingData;
import com.project.eportal.R;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Meeting_manager extends AppCompatActivity {

    FirebaseFirestore database;
    ProgressDialog progressDialog;
    EditText et_title, et_link;
    Button btn_create;
    MeetingData meetingData;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_manager);

        progressDialog = new ProgressDialog(this);
        et_title = findViewById(R.id.et_title);
        et_link = findViewById(R.id.et_link);
        btn_create = findViewById(R.id.btn_createmeeting);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = et_title.getText().toString();
                String link = et_link.getText().toString();

                database = FirebaseFirestore.getInstance();

                String requestId = UUID.randomUUID().toString();

                meetingData = new MeetingData(title,link,requestId);

                Map<String, Object> items = new HashMap<>();
                items.put("ID", requestId);
                items.put("link", link);
                items.put("title", title);

                meetingData.setTitle(title);
                meetingData.setLink(link);
                meetingData.setMeeting_id(requestId);

                database.collection("items").document(title).set(items)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(Meeting_manager.this, "Meeting added successfully",
                                        Toast.LENGTH_SHORT).show();                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Meeting_manager.this, e.getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });



            }
        });

    }

    public void zoomicon(View view) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://zoom.com/"));
        startActivity(intent);
    }


}

