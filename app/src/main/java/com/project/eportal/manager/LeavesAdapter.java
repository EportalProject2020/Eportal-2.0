package com.project.eportal.manager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.eportal.R;
import com.project.eportal.calendar.activities.CalendarData;
import com.project.eportal.calendar.activities.MangersCalendarActivity;

import java.util.List;

public class LeavesAdapter extends RecyclerView.Adapter<LeavesAdapter.LeavesViewHolder> {

     MangersCalendarActivity mangersCalendarActivity;
    List<CalendarData> calendarData;

    public LeavesAdapter(MangersCalendarActivity mangersCalendarActivity, List<CalendarData> calendarData) {
        this.mangersCalendarActivity = mangersCalendarActivity;
        this.calendarData = calendarData;
    }





    @NonNull
    @Override
    public LeavesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaves_list_item, parent, false);
          LeavesAdapter.LeavesViewHolder holder = new LeavesAdapter.LeavesViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeavesViewHolder holder, int position) {

        CalendarData currentData = calendarData.get(position);

        holder.txtEmployeeLeaveName.setText(currentData.getEmployeeName());
        holder.txtLeaveStart.setText(currentData.getFromDate());
        holder.txtLeaveEnd.setText(currentData.getToDate());

    }

    @Override
    public int getItemCount() {
        return calendarData.size();
    }

    public class LeavesViewHolder extends RecyclerView.ViewHolder {

        TextView txtEmployeeLeaveName, txtLeaveStart, txtLeaveEnd;
        View mView;

        public LeavesViewHolder(@NonNull View itemView) {
            super(itemView);

            txtEmployeeLeaveName  = itemView.findViewById(R.id.txt_employee_leave_name);
            txtLeaveStart = itemView.findViewById(R.id.txt_leave_start);
            txtLeaveEnd = itemView.findViewById(R.id.txt_leave_end);
            mView = itemView;
        }
    }
}
