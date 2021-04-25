package com.project.eportal.IT;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.eportal.MeetingData;
import com.project.eportal.R;

import java.util.ArrayList;
import java.util.List;

public class UserRequestAdapterForIT extends RecyclerView.Adapter<UserRequestAdapterForIT.MyViewHolder> {

    List<ITRequestData> itRequestDataList;
    UsersRequestforIT usersRequestforIT;


    public UserRequestAdapterForIT(UsersRequestforIT usersRequestforIT, List<ITRequestData> itRequestDataList) {
        this.itRequestDataList = itRequestDataList;
        this.usersRequestforIT = usersRequestforIT;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_userrequest_for_it, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.textView_name.setText(itRequestDataList.get(position).getName());
        holder.textView_title.setText(itRequestDataList.get(position).getRequestTitle());
        holder.textView_description.setText(itRequestDataList.get(position).getRequestDescription());
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                usersRequestforIT.deleteData(position);
//                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
//                popupMenu.getMenuInflater().inflate(R.menu.menu_item, popupMenu.getMenu());
//                popupMenu.show();
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        switch (menuItem.getItemId()) {
//                            case R.id.menu_delete:
//                                Toast.makeText(view.getContext(), "Meeting has been deleted", Toast.LENGTH_SHORT).show();
//                                deleteItem(position);
//                                break;
//                        }
//                        return true;
//                    }
//                });

            }
        });
    }

    @Override
    public int getItemCount() {
        return itRequestDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView_title;
        private final TextView textView_description;
        private final TextView textView_name;
        private final ImageButton imageButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView_name = itemView.findViewById(R.id.tv_name);
            this.textView_title = itemView.findViewById(R.id.tv_title);
            this.textView_description = itemView.findViewById(R.id.tv_description);
            this.imageButton = itemView.findViewById(R.id.imageButton);
        }
    }

//    private void deleteItem(final int position) {
//        meetingData.remove(position);
//        notifyItemRemoved(position);
//        notifyItemRangeChanged(position, meetingData.size());
//
//    }


}
