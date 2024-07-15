package com.example.thereafter.fragments;

import android.graphics.Movie;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thereafter.HomeViewModel;
import com.example.thereafter.R;

//public class Home extends Fragment {
//
//    private HomeViewModel mViewModel;
//
//    public static Home newInstance() {
//        return new Home();
//    }
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_home, container, false);
//    }
//
//
//}


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//import com.example.movieapp.Movie;
//import com.example.movieapp.R;
//import com.example.movieapp.networking.MoviesCallBack;
//import com.example.movieapp.networking.MoviesNetworking;
//import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

public class Home extends Fragment {

    private View sermons;
    private View posts;
    private View topusers;
    private View activities;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activities = view.findViewById(R.id.activities);
        topusers = view.findViewById(R.id.topusers);
        sermons = view.findViewById(R.id.sermons);
        posts = view.findViewById(R.id.posts);

//        getPoster("now_playing", (ImageView) nowplaying.findViewById(R.id.fragImg));
//        getPoster("top_rated", (ImageView) topusers.findViewById(R.id.fragImg));
//        getPoster("sermons", (ImageView) sermons.findViewById(R.id.fragImg));
//        getPoster("posts", (ImageView) posts.findViewById(R.id.fragImg));

        ((TextView) activities.findViewById(R.id.fragText)).setText("Now Playing");
        ((TextView) topusers.findViewById(R.id.fragText)).setText("Top Rated");
        ((TextView) sermons.findViewById(R.id.fragText)).setText("sermons");
        ((TextView) posts.findViewById(R.id.fragText)).setText("posts");

//        nowplaying.setOnClickListener(v -> trans("now_playing"));
//        topusers.setOnClickListener(v -> trans("top_rated"));
//        sermons.setOnClickListener(v -> trans("sermons"));
//        posts.setOnClickListener(v -> trans("posts"));
//
//        // Profile Button
//        ImageView profile = requireView().findViewById(R.id.profile);
//        profile.setOnClickListener(v -> {
//            requireActivity().getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.flFragment, new Profile())
//                    .addToBackStack(null)
//                    .commit();
//        });
//
//        // Favourites Button
//        ImageView favourites = requireView().findViewById(R.id.favourites);
//        favourites.setOnClickListener(v -> {
//            requireActivity().getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.flFragment, new Fav())
//                    .addToBackStack(null)
//                    .commit();
//        });
//
//        // Home Button
//        ImageView home = requireView().findViewById(R.id.homeicon);
//        home.setOnClickListener(v -> {
//            requireActivity().getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.flFragment, new HomeFragment())
//                    .addToBackStack(null)
//                    .commit();
//        });
//
//        // Logout Button
//        ImageView logout = requireView().findViewById(R.id.logout);
//        logout.setOnClickListener(v -> {
//            requireActivity().getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.flFragment, new Profile())
//                    .addToBackStack(null)
//                    .commit();
//        });
    }

//    private void trans(String cat) {
//        requireActivity().getSupportFragmentManager().beginTransaction()
//                .replace(R.id.flFragment, new RecyclerFrag(cat))
//                .addToBackStack(null)
//                .commit();
//    }

//    private void getPoster(String cat, ImageView current) {
//        MoviesNetworking moviesNetworking = new MoviesNetworking(cat);
//        MoviesCallBack moviesCallBack = new MoviesCallBack() {
//            @Override
//            public void onMoviesReady(List<Movie> movs) {
//                int tmp = new Random(System.currentTimeMillis()).nextInt(10);
//                String movies = movs != null ? movs.get(tmp).getImage() : null;
//                if (movies != null) {
//                    Picasso.get().load(movies).into(current);
//                }
//            }
//
//            @Override
//            public void onMovieReady(Movie movs) {
//                // No implementation needed
//            }
//        };
//        moviesNetworking.updateList(moviesCallBack);
//    }
}
