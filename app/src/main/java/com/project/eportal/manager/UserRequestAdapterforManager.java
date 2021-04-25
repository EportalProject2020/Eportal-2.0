package com.project.eportal.manager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.eportal.IT.ITRequestData;
import com.project.eportal.R;

import java.util.List;

public class UserRequestAdapterforManager extends RecyclerView.Adapter<UserRequestAdapterforManager.MyViewHolder> {

    UsersRequests usersRequests;
    List<ITRequestData> itRequestDataList;

    public UserRequestAdapterforManager(UsersRequests usersRequests, List<ITRequestData> itRequestDataList) {
        this.usersRequests = usersRequests;
        this.itRequestDataList = itRequestDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_userrequest_for_manager, parent, false);
        MyViewHolder holder = new MyViewHolder(v);

        holder.setOnclickListener(new MyViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
    //            Toast.makeText(usersRequests, "Redirecting to zoom", Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.textView_name.setText(itRequestDataList.get(position).getName());
        holder.textView_title.setText(itRequestDataList.get(position).getRequestTitle());
        holder.textView_description.setText(itRequestDataList.get(position).getRequestDescription());
    }

    @Override
    public int getItemCount() {
        return itRequestDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView_title;
        private final TextView textView_name;
        private final TextView textView_description;
        View mView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView_title = itemView.findViewById(R.id.tv_title);
            this.textView_name = itemView.findViewById(R.id.tv_name);
            this.textView_description = itemView.findViewById(R.id.tv_description);
            mView = itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onItemClick(v,getAdapterPosition());
                }
            });

        }

        private MyViewHolder.ClickListener mClickListener;

        public interface ClickListener {
            void onItemClick(View view, int position);
        }

        public void setOnclickListener(MyViewHolder.ClickListener clickListener) {
            mClickListener = clickListener;
        }
    }

}

