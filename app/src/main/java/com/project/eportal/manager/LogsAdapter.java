package com.project.eportal.manager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.eportal.R;
import com.project.eportal.employee.TaskAdapter;
import com.project.eportal.employee.UserData;

import java.util.List;

public class LogsAdapter extends RecyclerView.Adapter<LogsAdapter.LogsViewHolder> {

    LogsActivity logsActivity;
    List<UserData>userData;

    public LogsAdapter(LogsActivity logsActivity, List<UserData> userData) {
        this.logsActivity = logsActivity;
        this.userData = userData;
    }

    @NonNull
    @Override
    public LogsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.logs_employee_list_item, parent, false);
        LogsAdapter.LogsViewHolder holder = new LogsAdapter.LogsViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LogsViewHolder holder, int position) {

        UserData currentData = userData.get(position);
        holder.txtName.setText(currentData.getName());
        holder.txtTime.setText(currentData.getTime());

    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public class LogsViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtTime;
        View mView;

        public LogsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_empployee_name);
            txtTime = itemView.findViewById(R.id.txt_login_time);
            mView=itemView;

        }
    }
}
