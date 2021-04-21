package com.project.eportal.employee;

import android.app.ListActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.eportal.R;
import com.project.eportal.MeetingData;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {

    meeting_employee meetingEmployee;
    List<MeetingData> meetingData;

    public EmployeeAdapter(meeting_employee meetingEmployee, List<MeetingData> meetingData) {
        this.meetingEmployee = meetingEmployee;
        this.meetingData = meetingData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_empolyee, parent, false);
        MyViewHolder holder = new MyViewHolder(v);

        holder.setOnclickListener(new MyViewHolder.ClickListener(){
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(meetingEmployee, "Redirecting to zoom", Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        MeetingData currentdata = meetingData.get(position);

        holder.textView_title.setText(meetingData.get(position).getTitle());
        holder.textView_link.setText(currentdata.getLink());
    }

    @Override
    public int getItemCount() {
        return meetingData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView_title;
        private final TextView textView_link;
        View mView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView_title = itemView.findViewById(R.id.tv_title);
            this.textView_link = itemView.findViewById(R.id.tv_link);
            mView = itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onItemClick(v,getAdapterPosition());
                }
            });

        }
        private MyViewHolder.ClickListener mClickListener;
        public interface ClickListener{
            void onItemClick(View view,int position);
        }
        public void setOnclickListener(MyViewHolder.ClickListener clickListener){
            mClickListener= clickListener;
        }
    }

}
