package com.project.eportal.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.eportal.MeetingData;
import com.project.eportal.R;
import com.project.eportal.TasksData;

import java.util.ArrayList;

public class TaskAdapterManger extends RecyclerView.Adapter<TaskAdapterManger.MangerViewHolder> {

    ArrayList<TasksData> tasksData;

    public TaskAdapterManger(ArrayList<TasksData> tasksData) {
        this.tasksData = tasksData;
    }

    @NonNull
    @Override
    public MangerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks_row_item_manger,parent,false);
        return new MangerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MangerViewHolder holder, int position) {

        TasksData currentData = tasksData.get(position);

        holder.edtTaskTitle.setText(currentData.getTaskTitle());
        holder.edtTaskDescription.setText(currentData.getTaskDesc());

    }

    @Override
    public int getItemCount() {
        return tasksData.size();
    }

    public class MangerViewHolder extends RecyclerView.ViewHolder {

        EditText edtTaskTitle , edtTaskDescription;

        public MangerViewHolder(@NonNull View itemView) {
            super(itemView);

            this.edtTaskTitle = itemView.findViewById(R.id.edt_task_title);
            this.edtTaskDescription = itemView.findViewById(R.id.edt_task_desc);
        }
    }
}
