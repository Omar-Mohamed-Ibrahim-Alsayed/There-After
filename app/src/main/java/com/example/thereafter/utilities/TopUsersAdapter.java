package com.example.thereafter.utilities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thereafter.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;

import java.util.List;

public class TopUsersAdapter extends RecyclerView.Adapter<TopUsersAdapter.UserViewHolder> {

    private final List<UserItem> users;
    private final FragmentManager fragmentManager;

    public TopUsersAdapter(List<UserItem> users, FragmentManager fragmentManager) {
        this.users = users;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemUserView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_top_users_item, parent, false);
        return new UserViewHolder(itemUserView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserItem current = users.get(position);
        holder.bind(current);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView badges;
        private final TextView rate;
        private final TextView posts;
        private final TextView sermons;
        //private final ImageView image;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.profilename);
            rate = itemView.findViewById(R.id.rate_text);
            badges = itemView.findViewById(R.id.profilebadge);
            posts = itemView.findViewById(R.id.posts_text);
            sermons = itemView.findViewById(R.id.sermons_text);
            //image = itemView.findViewById(R.id.UserLogo);

//            itemView.setOnClickListener(v -> {
//                User current = users.get(getAdapterPosition());
//                fragmentManager.beginTransaction()
//                        .replace(R.id.flFragment, new UserDetails())
//                        .addToBackStack(null)
//                        .commit();
//            });
        }

        public void bind(UserItem User) {
            name.setText(User.getName());
            badges.setText(String.valueOf(User.getBadges()));
            rate.setText(String.valueOf(User.getRate()));
            sermons.setText(String.valueOf(User.getSermons()));
            posts.setText(String.valueOf(User.getPosts()));
            //Glide.with(itemView.getContext()).load(User.getImage()).into(image);
        }
    }
}
