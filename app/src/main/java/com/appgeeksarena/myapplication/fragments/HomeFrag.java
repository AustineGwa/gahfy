package com.appgeeksarena.myapplication.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appgeeksarena.myapplication.R;
import com.appgeeksarena.myapplication.VideoViewActivity;
import com.appgeeksarena.myapplication.adapters.ServicesAdapter;
import com.appgeeksarena.myapplication.adapters.VideosAdapter;
import com.appgeeksarena.myapplication.interfaces.OnVideoItemClicked;
import com.appgeeksarena.myapplication.models.Video;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFrag extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter servicesAdapter;
    private List<Video> videoList;


    public HomeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.rv_services);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity() , 2));
        recyclerView.setHasFixedSize(true);

        servicesAdapter = new ServicesAdapter(videoList, getActivity(), new OnVideoItemClicked() {
            @Override
            public void onclick(Video video) {

                startActivity(new Intent(getActivity(), VideoViewActivity.class));

            }
        });

        recyclerView.setAdapter(servicesAdapter);

        return view;
    }

}
