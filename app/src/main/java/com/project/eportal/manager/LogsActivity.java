package com.project.eportal.manager;

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
import com.project.eportal.TasksData;
import com.project.eportal.employee.GetTasksActivity;
import com.project.eportal.employee.TaskAdapter;
import com.project.eportal.employee.UserData;

import java.util.ArrayList;
import java.util.List;

public class LogsActivity extends AppCompatActivity {

    List<UserData> userData = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore db;
    LogsAdapter logsAdapter;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        recyclerView = findViewById(R.id.rv_logs);
        db = FirebaseFirestore.getInstance();
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        pd = new ProgressDialog(this);

        showData();


    }

    private void showData() {

        pd.setTitle("Loading Logs...");
        pd.show();

        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        pd.dismiss();
                        for (DocumentSnapshot item:task.getResult()){

                            Toast.makeText(LogsActivity.this, item.getString("name")+"", Toast.LENGTH_SHORT).show();
                            UserData data = new UserData(
                                    item.getString("name")
                                    ,item.getString("time"));
                            userData.add(data);
                        }
                       logsAdapter = new LogsAdapter(LogsActivity.this, userData);
                        recyclerView.setAdapter(logsAdapter);

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                pd.dismiss();
                Toast.makeText(LogsActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}