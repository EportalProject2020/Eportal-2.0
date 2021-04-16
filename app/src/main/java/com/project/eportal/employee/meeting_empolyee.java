package com.project.eportal.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.project.eportal.manager.ManagerAdapter;
import com.project.eportal.R;
import com.project.eportal.MeetingData;

import java.util.ArrayList;

public class meeting_empolyee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_empolyee);

        ArrayList<MeetingData> meetingData = new ArrayList<>();

        // how to get edit text entered data to text view in arraylist ?

        meetingData.add(new MeetingData("Today's meeting at 5 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 8 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));
        meetingData.add(new MeetingData("Today's meeting at 7 PM","https://zoom.com/"));

        EmployeeAdapter adapter = new EmployeeAdapter(meetingData);
        RecyclerView rv = findViewById(R.id.rv_meeting);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,true);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
    }

}