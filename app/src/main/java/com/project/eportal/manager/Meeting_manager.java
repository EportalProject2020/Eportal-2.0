package com.project.eportal.manager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.eportal.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Meeting_manager extends AppCompatActivity {

    FirebaseFirestore db;
    ProgressDialog progressDialog;
    EditText et_title, et_link;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_manager);

        progressDialog = new ProgressDialog(this);
        db = FirebaseFirestore.getInstance();
    }

    public void zoomicon(View view) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://zoom.com/"));
        startActivity(intent);
    }

    public void createMeeting(View view) {
        et_title = findViewById(R.id.et_title);
        et_link = findViewById(R.id.et_link);


        String title = et_title.getText().toString();
        String link = et_link.getText().toString();
        uploadData(title, link);
    }

    private void uploadData(String title, String link) {
        progressDialog.setTitle("Adding data to Firestore");
        progressDialog.show();

        String meetingId = UUID.randomUUID().toString();

        Map<String, Object> items = new HashMap<>();
//        items.put("id", meetingId);
        items.put("title", title);
        items.put("description", link);


        db.collection("items").document(meetingId).set(items)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        progressDialog.dismiss();
                        Toast.makeText(Meeting_manager.this, "Meeting has been created", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Meeting_manager.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


    }
}