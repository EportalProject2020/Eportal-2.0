package com.project.eportal.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.eportal.R;
import com.project.eportal.RetrievePDFActivity;

public class GetTasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_tasks);



    }

    public void retrievePDF(View view) {

        startActivity(new Intent(getApplicationContext(), RetrievePDFActivity.class));


    }
}