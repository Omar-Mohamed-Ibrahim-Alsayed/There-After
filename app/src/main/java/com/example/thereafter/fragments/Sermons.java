package com.example.thereafter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thereafter.R;
import com.example.thereafter.utilities.Sermon;
import com.example.thereafter.utilities.SermonsAdapter;

import java.util.ArrayList;
import java.util.List;

public class Sermons extends Fragment {

    private RecyclerView recyclerView;
    private String cat;
    private FragmentManager fragmentManager;
    private ImageButton addPost;

    public static Sermons newInstance() {
        return new Sermons();
    }

    public static List<Sermon> getSampleSermons() {
        List<Sermon> sermons = new ArrayList<>();

        sermons.add(new Sermon("خطبة 1", 1, "صورة1.jpg", "فئة أ", "احترام بعضنا البعض هو أساس تعزيز مجتمع متناغم ومنتج. يتضمن الاعتراف بقيمة الاختلافات والتشابهات التي نشاركها، سواء في الآراء أو المعتقدات أو الخلفيات الثقافية.احترام بعضنا البعض هو أساس تعزيز مجتمع متناغم ومنتج. يتضمن الاعتراف بقيمة الاختلافات والتشابهات التي نشاركها، سواء في الآراء أو المعتقدات أو الخلفيات الثقافية.احترام بعضنا البعض هو أساس تعزيز مجتمع متناغم ومنتج. يتضمن الاعتراف بقيمة الاختلافات والتشابهات التي نشاركها، سواء في الآراء أو المعتقدات أو الخلفيات الثقافية.احترام بعضنا البعض هو أساس تعزيز مجتمع متناغم ومنتج. يتضمن الاعتراف بقيمة الاختلافات والتشابهات التي نشاركها، سواء في الآراء أو المعتقدات أو الخلفيات الثقافية.احترام بعضنا البعض هو أساس تعزيز مجتمع متناغم ومنتج. يتضمن الاعتراف بقيمة الاختلافات والتشابهات التي نشاركها، سواء في الآراء أو المعتقدات أو الخلفيات الثقافية.احترام بعضنا البعض هو أساس تعزيز مجتمع متناغم ومنتج. يتضمن الاعتراف بقيمة الاختلافات والتشابهات التي نشاركها، سواء في الآراء أو المعتقدات أو الخلفيات الثقافية.احترام بعضنا البعض هو أساس تعزيز مجتمع متناغم ومنتج. يتضمن الاعتراف بقيمة الاختلافات والتشابهات التي نشاركها، سواء في الآراء أو المعتقدات أو الخلفيات الثقافية.", 4.5, "مالك 1", "شارة 1"));
        sermons.add(new Sermon("خطبة 2", 2, "صورة2.jpg", "فئة ب", "محتوى الخطبة 2", 4.0, "مالك 2", "شارة 2"));
        sermons.add(new Sermon("خطبة 3", 3, "صورة3.jpg", "فئة ج", "محتوى الخطبة 3", 3.5, "مالك 3", "شارة 3"));
        sermons.add(new Sermon("خطبة 4", 4, "صورة4.jpg", "فئة أ", "محتوى الخطبة 4", 4.7, "مالك 4", "شارة 4"));
        sermons.add(new Sermon("خطبة 5", 5, "صورة5.jpg", "فئة ب", "محتوى الخطبة 5", 4.2, "مالك 5", "شارة 5"));
        sermons.add(new Sermon("خطبة 6", 6, "صورة6.jpg", "فئة ج", "محتوى الخطبة 6", 3.8, "مالك 6", "شارة 6"));
        sermons.add(new Sermon("خطبة 7", 7, "صورة7.jpg", "فئة أ", "محتوى الخطبة 7", 4.6, "مالك 7", "شارة 7"));
        sermons.add(new Sermon("خطبة 8", 8, "صورة8.jpg", "فئة ب", "محتوى الخطبة 8", 4.3, "مالك 8", "شارة 8"));
        sermons.add(new Sermon("خطبة 9", 9, "صورة9.jpg", "فئة ج", "محتوى الخطبة 9", 3.9, "مالك 9", "شارة 9"));
        sermons.add(new Sermon("خطبة 10", 10, "صورة10.jpg", "فئة أ", "محتوى الخطبة 10", 4.8, "مالك 10", "شارة 10"));
        sermons.add(new Sermon("خطبة 11", 11, "صورة11.jpg", "فئة ب", "محتوى الخطبة 11", 4.1, "مالك 11", "شارة 11"));
        sermons.add(new Sermon("خطبة 12", 12, "صورة12.jpg", "فئة ج", "محتوى الخطبة 12", 4.0, "مالك 12", "شارة 12"));
        sermons.add(new Sermon("خطبة 13", 13, "صورة13.jpg", "فئة أ", "محتوى الخطبة 13", 4.4, "مالك 13", "شارة 13"));
        sermons.add(new Sermon("خطبة 14", 14, "صورة14.jpg", "فئة ب", "محتوى الخطبة 14", 4.5, "مالك 14", "شارة 14"));
        sermons.add(new Sermon("خطبة 15", 15, "صورة15.jpg", "فئة ج", "محتوى الخطبة 15", 3.7, "مالك 15", "شارة 15"));
        sermons.add(new Sermon("خطبة 16", 16, "صورة16.jpg", "فئة أ", "محتوى الخطبة 16", 4.6, "مالك 16", "شارة 16"));
        sermons.add(new Sermon("خطبة 17", 17, "صورة17.jpg", "فئة ب", "محتوى الخطبة 17", 4.2, "مالك 17", "شارة 17"));
        sermons.add(new Sermon("خطبة 18", 18, "صورة18.jpg", "فئة ج", "محتوى الخطبة 18", 3.9, "مالك 18", "شارة 18"));
        sermons.add(new Sermon("خطبة 19", 19, "صورة19.jpg", "فئة أ", "محتوى الخطبة 19", 4.7, "مالك 19", "شارة 19"));
        sermons.add(new Sermon("خطبة 20", 20, "صورة20.jpg", "فئة ب", "محتوى الخطبة 20", 4.3, "مالك 20", "شارة 20"));

        return sermons;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sermons, container, false);
        fragmentManager = getParentFragmentManager();

        addPost = view.findViewById(R.id.add_sermon);
        addPost.setOnClickListener(v -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.flFragment, new AddSermon())
                    .addToBackStack(null)
                    .commit();
        });

        recyclerView = view.findViewById(R.id.rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Sermon> sermons = getSampleSermons();
        SermonsAdapter adapter = new SermonsAdapter(sermons, getParentFragmentManager());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
