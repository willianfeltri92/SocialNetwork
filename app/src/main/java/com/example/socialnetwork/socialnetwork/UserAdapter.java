package com.example.socialnetwork.socialnetwork;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    public interface OnUserClickListener {
        void onUserClick(User user);
    }

    private Context mContext;
    private ArrayList<User> mUsers;
    private OnUserClickListener listener;

    public UserAdapter(Context context, ArrayList<User> users) {
        this.mContext = context;
        this.mUsers = users;
    }

    public void setOnClickListener(OnUserClickListener onUserClickListener) {
        this.listener = onUserClickListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list_item_view, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder viewHolder, int i) {
        final User user = mUsers.get(i);
        Glide.with(mContext).load(user.getPhotoUrl()).into(viewHolder.ivPhoto);
        viewHolder.tvCity.setText(user.getCity());
        viewHolder.tvAge.setText(String.format("%d anos", user.getAge()));
        viewHolder.tvSexualOrientation.setText(user.getSexualOrientation());
        viewHolder.tvUsername.setText(user.getUsername());
        viewHolder.tvGender.setText(user.getGender());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onUserClick(user);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

}

class UserViewHolder extends RecyclerView.ViewHolder {

    TextView tvCity;
    ImageView ivPhoto;
    TextView tvUsername;
    TextView tvGender;
    TextView tvSexualOrientation;
    TextView tvAge;

    public UserViewHolder(View itemView) {
        super(itemView);

        tvCity = itemView.findViewById(R.id.tvCity);
        ivPhoto = itemView.findViewById(R.id.ivPhoto);
        tvUsername = itemView.findViewById(R.id.tvUsername);
        tvGender = itemView.findViewById(R.id.tvGender);
        tvSexualOrientation = itemView.findViewById(R.id.tvSexualOrientation);
        tvAge = itemView.findViewById(R.id.tvAge);
    }

}
