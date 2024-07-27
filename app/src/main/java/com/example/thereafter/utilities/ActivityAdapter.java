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

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.activityViewHolder> {

    private final List<ActivityItem> acts;
    private final FragmentManager fragmentManager;

    public ActivityAdapter(List<ActivityItem> acts, FragmentManager fragmentManager) {
        this.acts = acts;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public activityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itempostView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_activities_item, parent, false);
        return new activityViewHolder(itempostView);
    }

    @Override
    public void onBindViewHolder(@NonNull activityViewHolder holder, int position) {
        ActivityItem current = acts.get(position);
        holder.bind(current);
    }

    @Override
    public int getItemCount() {
        return acts.size();
    }

    public class activityViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView description;
        private final TextView date;

        //private final ImageView image;

        public activityViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.activity_name);
            description = itemView.findViewById(R.id.activity_description);
            date = itemView.findViewById(R.id.activity_info);
            //image = itemView.findViewById(R.id.activitypic);

//            itemView.setOnClickListener(v -> {
//                post current = acts.get(getAdapterPosition());
//                fragmentManager.beginTransaction()
//                        .replace(R.id.flFragment, new postDetails())
//                        .addToBackStack(null)
//                        .commit();
//            });
        }

        public void bind(ActivityItem post) {
            name.setText(post.getName());
            description.setText(post.getDescription());
            date.setText(String.valueOf(post.getDate()));
            //Glide.with(itemView.getContext()).load(post.getImage()).into(image);
        }
    }
}
