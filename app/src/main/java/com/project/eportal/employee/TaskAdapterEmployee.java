package com.project.eportal.employee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.eportal.R;
import com.project.eportal.TasksData;
import com.project.eportal.manager.TaskAdapterManger;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TaskAdapterEmployee extends RecyclerView.Adapter<TaskAdapterEmployee.EmployeeViewHolder>{


    ArrayList<TasksData> tasksData;

    public TaskAdapterEmployee(ArrayList<TasksData> tasksData) {
        this.tasksData = tasksData;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks_row_item_employee,parent,false);
        return new TaskAdapterEmployee.EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        TasksData currentData = tasksData.get(position);

        holder.txtTaskTitle.setText(currentData.getTaskTitle());
        holder.txtTaskDescription.setText(currentData.getTaskDesc());
    }

    @Override
    public int getItemCount() {
        return tasksData.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView txtTaskTitle, txtTaskDescription;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            this.txtTaskTitle = itemView.findViewById(R.id.txt_task_title);
            this.txtTaskDescription = itemView.findViewById(R.id.txt_task_description);

        }
    }
}
