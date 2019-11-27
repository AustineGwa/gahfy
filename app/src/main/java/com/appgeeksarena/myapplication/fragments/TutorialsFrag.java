package com.appgeeksarena.myapplication.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.appgeeksarena.myapplication.R;
import com.appgeeksarena.myapplication.VideoViewActivity;
import com.appgeeksarena.myapplication.adapters.VideosAdapter;
import com.appgeeksarena.myapplication.interfaces.OnVideoItemClicked;
import com.appgeeksarena.myapplication.models.Video;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TutorialsFrag extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter videosAdapter;
    private List<Video> videoList;

    public TutorialsFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutorials, container, false);
        recyclerView = view.findViewById(R.id.rv_tutorials);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        videoList = new ArrayList();

        videoList.addAll(Arrays.asList(
                new Video("Lower Back Pain", R.drawable.lbp, "link", "A video to demonstrate "),
                new Video("Knee osteoarthiritis", R.drawable.lbp, "link", "A video to demonstrate "),
                new Video("Tibia After cast Removal", R.drawable.lbp, "link", "A video to demonstrate "),
                new Video("Lower Back Pain",  R.drawable.lbp, "link", "A video to demonstrate "),
                new Video("Lower Back Pain",  R.drawable.lbp, "link", "A video to demonstrate ")
        ));

        videosAdapter = new VideosAdapter(videoList, getActivity(), new OnVideoItemClicked() {
            @Override
            public void onclick(Video video) {

                startActivity(new Intent(getActivity(), VideoViewActivity.class));

            }
        });

        recyclerView.setAdapter(videosAdapter);

        return view;

    }



}
