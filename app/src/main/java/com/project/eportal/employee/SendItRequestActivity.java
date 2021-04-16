package com.project.eportal.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.eportal.ITRequestData;
import com.project.eportal.R;
import com.project.eportal.manager.ItRequestAdapterManger;

import java.util.ArrayList;

public class SendItRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_it_request);
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


        ItRequestAdapterEmployee adapter = new ItRequestAdapterEmployee(itRequestData);
        recyclerView = findViewById(R.id.rv_send_request);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}