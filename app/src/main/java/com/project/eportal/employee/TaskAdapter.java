package com.project.eportal.employee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.project.eportal.R;
import com.project.eportal.TasksData;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class TaskAdapter  extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {


    GetTasksActivity getTasksActivity;
    List<TasksData> tasksData;

    public TaskAdapter(GetTasksActivity getTasksActivity, List<TasksData> tasksData) {
        this.getTasksActivity = getTasksActivity;
        this.tasksData = tasksData;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_task_list_item, parent, false);
        TaskAdapter.TaskViewHolder holder = new TaskAdapter.TaskViewHolder(v);
        holder.setOnclickListener(new TaskAdapter.TaskViewHolder.ClickListener(){
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getTasksActivity, "Today's Task", Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

        TasksData currentData = tasksData.get(position);

        holder.txtTaskTitle.setText(currentData.getTaskTitle());
        holder.txtTaskDesc.setText(currentData.getTaskDesc());

    }

    @Override
    public int getItemCount() {
        return tasksData.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView txtTaskTitle, txtTaskDesc;
        View mView;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            this.txtTaskTitle = itemView.findViewById(R.id.txt_title);
            this.txtTaskDesc = itemView.findViewById(R.id.txt_desc);
            mView=itemView;
            
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mClickListener.onItemClick(view,getAdapterPosition());

                }
            });

        }

        public TaskAdapter.TaskViewHolder.ClickListener mClickListener;
        public interface ClickListener{
            void onItemClick(View view,int position);
        }
        public void setOnclickListener(TaskAdapter.TaskViewHolder.ClickListener clickListener){
            mClickListener= clickListener;
        }


    }
}
