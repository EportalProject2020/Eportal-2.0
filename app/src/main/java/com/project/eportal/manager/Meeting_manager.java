package com.project.eportal.manager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.eportal.MeetingData;
import com.project.eportal.R;

public class Meeting_manager extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseReference;
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
        meetingData = new MeetingData();
        btn_create = findViewById(R.id.btn_createmeeting);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = et_title.getText().toString();
                String link = et_link.getText().toString();

                database = FirebaseDatabase.getInstance();
                databaseReference = database.getReference("MeetingData");

                meetingData.setTitle(title);
                meetingData.setLink(link);

                databaseReference.child(title).setValue(meetingData);
                Toast.makeText(Meeting_manager.this, "Meeting added successfully",
                        Toast.LENGTH_SHORT).show();


            }
        });

    }

    public void zoomicon(View view) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://zoom.com/"));
        startActivity(intent);
    }


}

