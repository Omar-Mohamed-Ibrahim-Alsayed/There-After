package com.example.thereafter.utilities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thereafter.R;
import com.example.thereafter.utilities.Sermon;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;

import java.util.List;

public class SermonsAdapter extends RecyclerView.Adapter<SermonsAdapter.SermonViewHolder> {

    private final List<Sermon> sermons;
    private final FragmentManager fragmentManager;

    public SermonsAdapter(List<Sermon> sermons, FragmentManager fragmentManager) {
        this.sermons = sermons;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public SermonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemSermonView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_sermon_item, parent, false);
        return new SermonViewHolder(itemSermonView);
    }

    @Override
    public void onBindViewHolder(@NonNull SermonViewHolder holder, int position) {
        Sermon current = sermons.get(position);
        holder.bind(current);
    }

    @Override
    public int getItemCount() {
        return sermons.size();
    }

    public class SermonViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView category;
        private final TextView content;
        private final TextView rate;
        private final TextView owner;
        private final TextView badges;
        //private final ImageView image;

        public SermonViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.sertitle);
            category = itemView.findViewById(R.id.sercategory);
            content = itemView.findViewById(R.id.sercontent);
            rate = itemView.findViewById(R.id.serrate);
            owner = itemView.findViewById(R.id.profilename);
            badges = itemView.findViewById(R.id.profilebadge);
            //image = itemView.findViewById(R.id.SermonLogo);

//            itemView.setOnClickListener(v -> {
//                Sermon current = sermons.get(getAdapterPosition());
//                fragmentManager.beginTransaction()
//                        .replace(R.id.flFragment, new DescriptionFragment(current))
//                        .addToBackStack(null)
//                        .commit();
//            });
        }

        public void bind(Sermon sermon) {
            name.setText(sermon.getName());
            category.setText(sermon.getCategory());
            content.setText(sermon.getContent());
            owner.setText(sermon.getOwner());
            badges.setText(sermon.getBadges());
            rate.setText(String.valueOf(sermon.getRate()));
            //Glide.with(itemView.getContext()).load(sermon.getImage()).into(image);
        }
    }
}
