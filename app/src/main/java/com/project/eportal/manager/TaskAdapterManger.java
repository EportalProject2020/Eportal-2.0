package com.project.eportal.manager;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.project.eportal.MeetingData;
import com.project.eportal.R;
import com.project.eportal.TasksData;

import java.util.ArrayList;

import static androidx.core.app.ActivityCompat.startActivityForResult;
import static androidx.core.content.ContextCompat.startActivity;

public class TaskAdapterManger extends RecyclerView.Adapter<TaskAdapterManger.MangerViewHolder> {

    ArrayList<TasksData> tasksData;

    StorageReference storageReference;
    DatabaseReference databaseReference;


    public TaskAdapterManger(ArrayList<TasksData> tasksData) {
        this.tasksData = tasksData;
    }

    @NonNull
    @Override
    public MangerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks_row_item_manger, parent, false);
        return new MangerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MangerViewHolder holder, int position) {

        TasksData currentData = tasksData.get(position);

        holder.edtTaskTitle.setText(currentData.getTaskTitle());


        holder.edtTaskAddFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectPDF();

            }


        });

        holder.btn_attach.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


            }
        });




    }

    private void selectPDF() {

    }

    @Override
    public int getItemCount() {
        return tasksData.size();
    }

    public class MangerViewHolder extends RecyclerView.ViewHolder {

        EditText edtTaskTitle , edtTaskAddFile;
        ImageButton btn_attach;


        public MangerViewHolder(@NonNull View itemView) {
            super(itemView);

            this.edtTaskTitle = itemView.findViewById(R.id.edt_task_title);
            this.edtTaskAddFile = itemView.findViewById(R.id.edt_request_add_file);
            this.btn_attach = itemView.findViewById(R.id.img_btn_attach);

            storageReference = FirebaseStorage.getInstance().getReference();
            databaseReference = FirebaseDatabase.getInstance().getReference("uploadPDf");
        }
    }
}
