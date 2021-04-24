package com.project.eportal.employee;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.project.eportal.MeetingData;
import com.project.eportal.R;

import java.util.ArrayList;
import java.util.List;

public class meeting_employee extends AppCompatActivity {

    List<MeetingData> meetingData = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore db;
    EmployeeAdapter adapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_empolyee);

        db=FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.rv_meeting);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        progressDialog= new ProgressDialog(this);
        showData();

    }

    private void showData() {

        progressDialog.setTitle("Loading Data...");
        progressDialog.show();

        db.collection("items")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        progressDialog.dismiss();
                        for (DocumentSnapshot item:task.getResult()){
                            MeetingData data = new MeetingData(
                                    item.getString("title")
                                    ,item.getString("description"));
                            meetingData.add(data);
                        }
                        adapter = new EmployeeAdapter(meeting_employee.this,meetingData);
                        recyclerView.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(meeting_employee.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

}