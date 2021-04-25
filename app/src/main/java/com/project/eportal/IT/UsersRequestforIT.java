package com.project.eportal.IT;

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
import com.project.eportal.manager.UserRequestAdapterforManager;
import com.project.eportal.manager.UsersRequests;

import java.util.ArrayList;
import java.util.List;

public class UsersRequestforIT extends AppCompatActivity {

    List<ITRequestData> itRequestDataList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore db;
    UserRequestAdapterForIT adapter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_requestfor_it);


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
                        itRequestDataList.clear();
                        progressDialog.dismiss();
                        for (DocumentSnapshot documentSnapshot:task.getResult()){
                            ITRequestData data = new ITRequestData(
                                    documentSnapshot.getString("name"),
                                    documentSnapshot.getString("title"),
                                    documentSnapshot.getString("description"));
                            itRequestDataList.add(data);
                        }
                        adapter = new UserRequestAdapterForIT(UsersRequestforIT.this,itRequestDataList);
                        recyclerView.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(UsersRequestforIT.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void deleteData(int index){
        progressDialog.setTitle("Deleting request");
        progressDialog.show();
        db.collection("ITRequestuser").document(itRequestDataList.get(index).getRequestID())
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(UsersRequestforIT.this, "Deleted...", Toast.LENGTH_SHORT).show();
                        showData();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }

}