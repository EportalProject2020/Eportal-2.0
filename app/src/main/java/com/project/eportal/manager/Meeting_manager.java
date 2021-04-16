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

        ArrayList<MeetingData> meetingData = new ArrayList<>();

        meetingData.add(new MeetingData("Today's meeting at 5 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 8 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));

        ManagerAdapter adapter = new ManagerAdapter(meetingData);
        RecyclerView rv = findViewById(R.id.rv_meeting);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,true);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);

    }

    public void createMeeting(View view) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://zoom.com/")) ;
        startActivity(intent);
    }
}