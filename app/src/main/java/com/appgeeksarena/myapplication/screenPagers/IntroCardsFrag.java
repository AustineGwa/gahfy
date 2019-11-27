package com.appgeeksarena.myapplication.screenPagers;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroCardsFrag extends Fragment {

   private  View currentView;

    public IntroCardsFrag() {
        // Required empty public constructor
    }

    public IntroCardsFrag(View view){

        this.currentView = view;
    }

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return this.currentView;
    }

}
