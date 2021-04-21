package com.project.eportal.manager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.eportal.MeetingData;
import com.project.eportal.R;

import java.util.ArrayList;

public class Meeting_manager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_manager);

    }

    public void zoomicon(View view) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://zoom.com/")) ;
        startActivity(intent);
    }

    public void createMeeting(View view) {

    }
}