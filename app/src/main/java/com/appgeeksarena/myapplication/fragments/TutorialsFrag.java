package com.appgeeksarena.myapplication.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appgeeksarena.myapplication.R;
import com.appgeeksarena.myapplication.VideoViewActivity;
import com.appgeeksarena.myapplication.adapters.ContentAdapter;
import com.appgeeksarena.myapplication.interfaces.OnVideoItemClicked;
import com.appgeeksarena.myapplication.models.Content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TutorialsFrag extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter videosAdapter;
    private List<Content> contentList;

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

        contentList = new ArrayList();

        contentList.addAll(Arrays.asList(
                new Content("Lower Back Pain", "link", "A video to demonstrate "),
                new Content("Knee osteoarthiritis", "link", "A video to demonstrate "),
                new Content("Tibia After cast Removal",  "link", "A video to demonstrate "),
                new Content("Lower Back Pain", "link", "A video to demonstrate "),
                new Content("Lower Back Pain",  "link", "A video to demonstrate ")
        ));

        videosAdapter = new ContentAdapter(contentList, getActivity(), new OnVideoItemClicked() {
            @Override
            public void onclick(Content content) {

                startActivity(new Intent(getActivity(), VideoViewActivity.class));

            }
        });

        recyclerView.setAdapter(videosAdapter);

        return view;

    }



}
