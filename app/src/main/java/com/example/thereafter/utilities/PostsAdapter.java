package com.example.thereafter.utilities;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thereafter.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.postViewHolder> {

    private final List<PostItem> posts;
    private final FragmentManager fragmentManager;

    public PostsAdapter(List<PostItem> posts, FragmentManager fragmentManager) {
        this.posts = posts;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public postViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itempostView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_posts_item, parent, false);
        return new postViewHolder(itempostView);
    }

    @Override
    public void onBindViewHolder(@NonNull postViewHolder holder, int position) {
        PostItem current = posts.get(position);
        holder.bind(current);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class postViewHolder extends RecyclerView.ViewHolder {
        private final TextView content;
        private final TextView likes;
        private final TextView comments;
        private final TextView owner;
        private final TextView badges;
        //private final ImageView image;

        public postViewHolder(@NonNull View itemView) {
            super(itemView);
            owner = itemView.findViewById(R.id.profilename);
            badges = itemView.findViewById(R.id.profilebadge);
            content = itemView.findViewById(R.id.postcontent);
            likes = itemView.findViewById(R.id.reaction_text);
            comments = itemView.findViewById(R.id.comment_text);
            //image = itemView.findViewById(R.id.postLogo);

//            itemView.setOnClickListener(v -> {
//                post current = posts.get(getAdapterPosition());
//                fragmentManager.beginTransaction()
//                        .replace(R.id.flFragment, new postDetails())
//                        .addToBackStack(null)
//                        .commit();
//            });
        }

        public void bind(PostItem post) {
            content.setText(post.getContent());
            owner.setText(post.getOwner());
            badges.setText(post.getBadges());
            likes.setText(String.valueOf(post.getLikes()));
            comments.setText(String.valueOf(post.getComments()));
            //Glide.with(itemView.getContext()).load(post.getImage()).into(image);
        }
    }
}
