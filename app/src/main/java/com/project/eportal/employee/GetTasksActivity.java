package com.project.eportal.employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.project.eportal.R;
import com.project.eportal.RetrievePDFActivity;
import com.project.eportal.TasksData;

import java.util.ArrayList;
import java.util.List;

public class GetTasksActivity extends AppCompatActivity {

    List<TasksData> tasksData = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore db;
    TaskAdapter taskAdapter;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_tasks);

        recyclerView = findViewById(R.id.rv_tasks);
        db=FirebaseFirestore.getInstance();
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        pd = new ProgressDialog(this);

        showData();

    }

    private void showData() {

        pd.setTitle("Loading Tasks...");
        pd.show();

        db.collection("todo").
                get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        pd.dismiss();
                        
                        for (DocumentSnapshot item:task.getResult()){
                            TasksData data = new TasksData(item.getString("title")
                            ,item.getString("description"));
                            tasksData.add(data);
                        }
                        taskAdapter = new TaskAdapter(GetTasksActivity.this,tasksData);
                        recyclerView.setAdapter(taskAdapter);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                pd.dismiss();
                Toast.makeText(GetTasksActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    public void retrievePDF(View view) {

        startActivity(new Intent(getApplicationContext(), RetrievePDFActivity.class));
    }
}