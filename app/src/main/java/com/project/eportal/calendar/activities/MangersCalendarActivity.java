package com.project.eportal.calendar.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.project.eportal.R;
import com.project.eportal.employee.GetTasksActivity;
import com.project.eportal.employee.TaskAdapter;
import com.project.eportal.manager.LeavesAdapter;

import java.util.ArrayList;
import java.util.List;

public class MangersCalendarActivity extends AppCompatActivity {

    List<CalendarData> calendarData = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore db;
    LeavesAdapter leavesAdapter;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangers_calendar);

        recyclerView = findViewById(R.id.rv_leaves);
        db=FirebaseFirestore.getInstance();
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        pd = new ProgressDialog(this);

        showData();

    }

    private void showData() {

        pd.setTitle("Loading Leaves...");
        pd.show();

        db.collection("leaveRequest").
                get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                pd.dismiss();
                for(DocumentSnapshot item:task.getResult()){

                    CalendarData data = new CalendarData(item.getString("employeeName")
                    ,item.getString("fromDate"),
                            item.getString("toDate"));
                    calendarData.add(data);
                    leavesAdapter = new LeavesAdapter(MangersCalendarActivity.this, calendarData);
                    recyclerView.setAdapter(leavesAdapter);

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                pd.dismiss();
                Toast.makeText(MangersCalendarActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}