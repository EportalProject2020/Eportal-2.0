package com.project.eportal.manager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.eportal.ITRequestData;
import com.project.eportal.R;
import com.project.eportal.employee.ItRequestAdapterEmployee;

import java.util.ArrayList;

public class ItRequestAdapterManger extends RecyclerView.Adapter<ItRequestAdapterManger.MangerViewHolder> {
    ArrayList<ITRequestData> itRequestData;

    public ItRequestAdapterManger(ArrayList<ITRequestData> itRequestData) {
        this.itRequestData = itRequestData;
    }

    @NonNull
    @Override
    public MangerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.it_requests_list_manger,parent,false);
        return new ItRequestAdapterManger.MangerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MangerViewHolder holder, int position) {

        ITRequestData currentData = itRequestData.get(position);
        holder.txtRequestTitle.setText(currentData.getRequestTitle());
        holder.txtRequestDescription.setText(currentData.getRequestDescription());

    }

    @Override
    public int getItemCount() {
        return itRequestData.size();
    }

    public class MangerViewHolder extends RecyclerView.ViewHolder {


        TextView txtRequestTitle, txtRequestDescription;
        public MangerViewHolder(@NonNull View itemView) {
            super(itemView);

            this.txtRequestTitle = itemView.findViewById(R.id.txt_request_title);
            this.txtRequestDescription = itemView.findViewById(R.id.txt_request_desc);

        }
    }
}
