package com.project.eportal.employee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.eportal.ITRequestData;
import com.project.eportal.R;
import com.project.eportal.TasksData;

import java.util.ArrayList;

public class ItRequestAdapterEmployee extends RecyclerView.Adapter<ItRequestAdapterEmployee.EmployeeViewHolder>{
    ArrayList<ITRequestData> itRequestData;

    public ItRequestAdapterEmployee(ArrayList<ITRequestData> itRequestData) {
        this.itRequestData = itRequestData;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.it_requests_list_employee,parent,false);
        return new ItRequestAdapterEmployee.EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        ITRequestData currentdata = itRequestData.get(position);
        holder.edtRequestTitle.setText(currentdata.getRequestTitle());

        holder.btn_attach.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {



            }
        });
    }

    @Override
    public int getItemCount() {
        return itRequestData.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {

        EditText edtRequestTitle, edtRequestAddFile;

        ImageButton btn_attach;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            this.edtRequestTitle = itemView.findViewById(R.id.edt_request_title);
            this.edtRequestAddFile = itemView.findViewById(R.id.edt_request_add_file);
            this.btn_attach = itemView.findViewById(R.id.img_btn_attach);
        }
    }
}
