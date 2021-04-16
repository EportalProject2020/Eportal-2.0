package com.project.eportal.manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.eportal.ITRequestData;
import com.project.eportal.R;
import com.project.eportal.TasksData;

import java.util.ArrayList;

public class ItRequestsMangerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_requests);
        RecyclerView recyclerView;
        ArrayList<ITRequestData> itRequestData = new ArrayList<>();

        itRequestData.add(new ITRequestData("Computer not working","Can not open computer"));
        itRequestData.add(new ITRequestData("System down","Can not upload or download anything from system"));
        itRequestData.add(new ITRequestData("Computer not working","Can not open computer"));
        itRequestData.add(new ITRequestData("Computer not working","Can not open computer"));
        itRequestData.add(new ITRequestData("Computer not working","Can not open computer"));
        itRequestData.add(new ITRequestData("Computer not working","Can not open computer"));
        itRequestData.add(new ITRequestData("Computer not working","Can not open computer"));
        itRequestData.add(new ITRequestData("Computer not working","Can not open computer"));


        ItRequestAdapterManger adapter = new ItRequestAdapterManger(itRequestData);
        recyclerView = findViewById(R.id.rv_request);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}