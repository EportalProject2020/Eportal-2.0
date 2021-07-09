package com.project.eportal.IT;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
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
import com.project.eportal.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ManagerRequestForIT extends AppCompatActivity {
    List<ITRequestData> itRequestDataList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore db;
    ManagerRequestAdapterForIT adapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_request_for_it);


        db = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        progressDialog = new ProgressDialog(this);
        showData();
      //  deleteData();
    }

    public void showData() {
        progressDialog.setTitle("Loading data...");
        progressDialog.show();

        db.collection("ITRequestManager")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        itRequestDataList.clear();
                        progressDialog.dismiss();
                        for (DocumentSnapshot documentSnapshot : Objects.requireNonNull(task.getResult())) {
                            ITRequestData data = new ITRequestData(
                                    documentSnapshot.getString("name"),
                                    documentSnapshot.getString("title"),
                                    documentSnapshot.getString("description"),
                                    documentSnapshot.getString("ID"));
                            itRequestDataList.add(data);
                        }
                        adapter = new ManagerRequestAdapterForIT(ManagerRequestForIT.this, itRequestDataList);
                        recyclerView.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(ManagerRequestForIT.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void deleteData(String position) {
        progressDialog.setTitle("Deleting...");
        progressDialog.dismiss();
        Toast.makeText(ManagerRequestForIT.this, position, Toast.LENGTH_SHORT).show();
        db.collection("ITRequestManager").document("f2cbe77a-d217-4127-a2b8-40a9626f5b6b ")
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                         Toast.makeText(ManagerRequestForIT.this, "Deleted...", Toast.LENGTH_SHORT).show();
                        showData();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ManagerRequestForIT.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
   }

}
