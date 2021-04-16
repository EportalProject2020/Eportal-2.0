package com.project.eportal.manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.eportal.MeetingData;
import com.project.eportal.R;
import com.project.eportal.TasksData;

import java.util.ArrayList;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        RecyclerView recyclerView;
        ArrayList<TasksData> taskdata = new ArrayList<>();

        taskdata.add(new TasksData("Berlin's Contract","Must be done ASAP"));
        taskdata.add(new TasksData("Cairo's Contract","Must be done ASAP"));
        taskdata.add(new TasksData("New York's Contract","Must be done ASAP"));
        taskdata.add(new TasksData("Alexandria's Contract","Must be done ASAP"));
        taskdata.add(new TasksData("Johaina's Contract","Must be done ASAP"));
        taskdata.add(new TasksData("Nike's Contract","Must be done ASAP"));
        taskdata.add(new TasksData("Addidas's Contract","Must be done ASAP"));
        taskdata.add(new TasksData("Apple's Contract","Must be done ASAP"));
        taskdata.add(new TasksData("Samsung's Contract","Must be done ASAP"));

        TaskAdapterManger adapter = new TaskAdapterManger(taskdata);
         recyclerView = findViewById(R.id.rv_addTask);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}