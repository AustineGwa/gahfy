package com.appgeeksarena.myapplication.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.appgeeksarena.myapplication.R;
import com.appgeeksarena.myapplication.adapters.ServicesAdapter;
import com.appgeeksarena.myapplication.interfaces.OnServiceClicked;
import com.appgeeksarena.myapplication.models.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFrag extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter servicesAdapter;
    private List<Service> serviceList;


    public HomeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_home, container, false);

    serviceList = new ArrayList<>();
    serviceList.addAll(Arrays.asList(
            new Service(R.drawable.ic_chat_black_24dp,"Chat"),
            new Service(R.drawable.ic_person_pin_black_24dp,"My Profile"),
            new Service(R.drawable.ic_call_black_24dp,"Emergency"),
            new Service(R.drawable.ic_local_hospital_black_24dp,"My Doctor")));

        recyclerView = view.findViewById(R.id.rv_services);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity() , 2));
        recyclerView.setHasFixedSize(true);

        servicesAdapter = new ServicesAdapter(serviceList, getActivity(), new OnServiceClicked() {
            @Override
            public void onClick(Service service) {
                Toast.makeText(getActivity(), service.getTitle() , Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(servicesAdapter);

        return view;
    }

}
