package com.example.thereafter.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thereafter.R;
import com.example.thereafter.items.HomeItem;

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

public class Home extends Fragment {

    private static final String TAG = "HomeFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        replaceFragment(R.id.activities, HomeItem.newInstance(getResources().getString(R.string.activities)));
        replaceFragment(R.id.sermons, HomeItem.newInstance(getResources().getString(R.string.sermons)));
        replaceFragment(R.id.posts, HomeItem.newInstance(getResources().getString(R.string.posts)));
        replaceFragment(R.id.topusers, HomeItem.newInstance(getResources().getString(R.string.topusers)));
    }

    private void replaceFragment(int containerViewId, Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(containerViewId, fragment)
                .commit();
    }
}

//
//
//public class Home extends Fragment {
//
//    private View sermons;
//    private View posts;
//    private View topusers;
//    private View Activities;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        Activities = view.findViewById(R.id.activities);
//        topusers = view.findViewById(R.id.topusers);
//        sermons = view.findViewById(R.id.sermons);
//        posts = view.findViewById(R.id.posts);
//
////        getPoster("now_playing", (ImageView) nowplaying.findViewById(R.id.fragImg));
////        getPoster("top_rated", (ImageView) topusers.findViewById(R.id.fragImg));
////        getPoster("sermons", (ImageView) sermons.findViewById(R.id.fragImg));
////        getPoster("posts", (ImageView) posts.findViewById(R.id.fragImg));
//
//        ((TextView) Activities.findViewById(R.id.fragText)).setText("Activities");
////        ((TextView) topusers.findViewById(R.id.fragText)).setText("Top Users");
////        ((TextView) sermons.findViewById(R.id.fragText)).setText("sermons");
////        ((TextView) posts.findViewById(R.id.fragText)).setText("posts");
//
////        nowplaying.setOnClickListener(v -> trans("now_playing"));
////        topusers.setOnClickListener(v -> trans("top_rated"));
////        sermons.setOnClickListener(v -> trans("sermons"));
////        posts.setOnClickListener(v -> trans("posts"));
////
////        // Profile Button
////        ImageView profile = requireView().findViewById(R.id.profile);
////        profile.setOnClickListener(v -> {
////            requireActivity().getSupportFragmentManager().beginTransaction()
////                    .replace(R.id.flFragment, new Profile())
////                    .addToBackStack(null)
////                    .commit();
////        });
////
////        // Favourites Button
////        ImageView favourites = requireView().findViewById(R.id.favourites);
////        favourites.setOnClickListener(v -> {
////            requireActivity().getSupportFragmentManager().beginTransaction()
////                    .replace(R.id.flFragment, new Fav())
////                    .addToBackStack(null)
////                    .commit();
////        });
////
////        // Home Button
////        ImageView home = requireView().findViewById(R.id.homeicon);
////        home.setOnClickListener(v -> {
////            requireActivity().getSupportFragmentManager().beginTransaction()
////                    .replace(R.id.flFragment, new HomeFragment())
////                    .addToBackStack(null)
////                    .commit();
////        });
////
////        // Logout Button
////        ImageView logout = requireView().findViewById(R.id.logout);
////        logout.setOnClickListener(v -> {
////            requireActivity().getSupportFragmentManager().beginTransaction()
////                    .replace(R.id.flFragment, new Profile())
////                    .addToBackStack(null)
////                    .commit();
////        });
//    }
//
////    private void trans(String cat) {
////        requireActivity().getSupportFragmentManager().beginTransaction()
////                .replace(R.id.flFragment, new RecyclerFrag(cat))
////                .addToBackStack(null)
////                .commit();
////    }
//
////    private void getPoster(String cat, ImageView current) {
////        MoviesNetworking moviesNetworking = new MoviesNetworking(cat);
////        MoviesCallBack moviesCallBack = new MoviesCallBack() {
////            @Override
////            public void onMoviesReady(List<Movie> movs) {
////                int tmp = new Random(System.currentTimeMillis()).nextInt(10);
////                String movies = movs != null ? movs.get(tmp).getImage() : null;
////                if (movies != null) {
////                    Picasso.get().load(movies).into(current);
////                }
////            }
////
////            @Override
////            public void onMovieReady(Movie movs) {
////                // No implementation needed
////            }
////        };
////        moviesNetworking.updateList(moviesCallBack);
////    }
//}
