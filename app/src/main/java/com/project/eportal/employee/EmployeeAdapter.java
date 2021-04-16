package com.project.eportal.employee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.eportal.R;
import com.project.eportal.MeetingData;
import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {

    ArrayList<MeetingData> meetingData;

    public EmployeeAdapter(ArrayList<MeetingData> mmeetingData) {
        meetingData = mmeetingData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_empolyee, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        MeetingData currentdata = meetingData.get(position);

        holder.textView_title.setText(currentdata.getTitle());
        holder.textView_link.setText(currentdata.getLink());
    }

    @Override
    public int getItemCount() {
        return meetingData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView_title, textView_link;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView_title = itemView.findViewById(R.id.tv_title);
            this.textView_link = itemView.findViewById(R.id.tv_link);

        }
    }

}
