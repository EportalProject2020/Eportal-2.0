package com.project.eportal.manager;

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
import com.project.eportal.IT.ITRequestData;
import com.project.eportal.R;

import java.util.ArrayList;
import java.util.List;

public class UsersRequests extends AppCompatActivity {

    List<ITRequestData> itRequestDataList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore db;
    UserRequestAdapterforManager adapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_requests);


        db = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        progressDialog = new ProgressDialog(this);
        showData();

    }

    private void showData() {

        progressDialog.setTitle("Loading data...");
        progressDialog.show();

        db.collection("ITRequestuser")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        progressDialog.dismiss();
                        for (DocumentSnapshot documentSnapshot : task.getResult()) {
                            ITRequestData data = new ITRequestData(

                                    documentSnapshot.getString("name"),
                                    documentSnapshot.getString("title"),
                                    documentSnapshot.getString("description"),
                                    documentSnapshot.getString("ID"));
                            itRequestDataList.add(data);
                        }
                        adapter = new UserRequestAdapterforManager(UsersRequests.this, itRequestDataList);
                        recyclerView.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(UsersRequests.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
