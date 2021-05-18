package com.project.eportal.IT;

import android.app.ProgressDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.eportal.R;

import java.util.List;

public class ManagerRequestAdapterForIT extends RecyclerView.Adapter<ManagerRequestAdapterForIT.ViewHolder> {

    List<ITRequestData> itRequestDataList;
    ManagerRequestForIT managerRequestForIT;


    public ManagerRequestAdapterForIT(ManagerRequestForIT managerRequestForIT, List<ITRequestData> itRequestDataList) {
        this.itRequestDataList = itRequestDataList;
        this.managerRequestForIT = managerRequestForIT;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_userrequest_for_it, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ManagerRequestAdapterForIT.ViewHolder holder, final int position) {

        holder.textView_name.setText(itRequestDataList.get(position).getName());
        holder.textView_title.setText(itRequestDataList.get(position).getRequestTitle());
        holder.textView_description.setText(itRequestDataList.get(position).getRequestDescription());
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                managerRequestForIT.deleteData(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itRequestDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView_title;
        private final TextView textView_name;
        private final TextView textView_description;
        private final ImageButton imageButton;
        View mView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView_title = itemView.findViewById(R.id.tv_title);
            this.textView_name = itemView.findViewById(R.id.tv_name);
            this.textView_description = itemView.findViewById(R.id.tv_description);
            this.imageButton = itemView.findViewById(R.id.imageButton);

        }

    }
}
