package com.project.eportal.manager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.eportal.MeetingData;
import com.project.eportal.R;
import com.project.eportal.TasksData;

import java.util.ArrayList;

public class ManagerAdapter extends RecyclerView.Adapter<ManagerAdapter.MyViewHolder> {

    ArrayList<MeetingData> meetingData;

    public ManagerAdapter(ArrayList<MeetingData> meetingData) {
        this.meetingData = meetingData;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_manager, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        MeetingData currentdata = meetingData.get(position);

        holder.edittext_title.setText(currentdata.getTitle());
        holder.editText_link.setText(currentdata.getLink());
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_item, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.menu_update:
                                Toast.makeText(view.getContext(), "Meeting data has been updated", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_delete:
                                Toast.makeText(view.getContext(), "Meeting has been deleted", Toast.LENGTH_SHORT).show();
                                deleteItem(position);
                                break;
                        }
                        return true;
                    }
                });

            }
        });
    }

    @Override
    public int getItemCount() {
        return meetingData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private EditText edittext_title, editText_link;
        private ImageButton imageButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.edittext_title = itemView.findViewById(R.id.et_title);
            this.editText_link = itemView.findViewById(R.id.et_link);
            this.imageButton = itemView.findViewById(R.id.imageButton);
        }
    }

    private void deleteItem(final int position) {
        meetingData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, meetingData.size());

    }


}
