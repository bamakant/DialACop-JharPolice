package com.kiusoftech.dialacop_jharpolice.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.kiusoftech.dialacop_jharpolice.R;
import com.kiusoftech.dialacop_jharpolice.activity.EmergencyActivity;
import com.kiusoftech.dialacop_jharpolice.activity.ImportantActivity;
import com.kiusoftech.dialacop_jharpolice.activity.PoliceStationActivity;


public class HomeFragment extends Fragment {

    private View rootView;
    private FrameLayout frameLayout;
    private Intent intent;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        frameLayout= (FrameLayout) rootView.findViewById(R.id.dial100_frame);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:100"));
                startActivity(intent);
            }
        });

        //@ Emergency frame touch handler

        frameLayout= (FrameLayout) rootView.findViewById(R.id.emergency_frame);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent=new Intent(getActivity(),EmergencyActivity.class);
                startActivity(intent);

            }
        });

        //@ Police station contact frame touch event handler

        frameLayout= (FrameLayout) rootView.findViewById(R.id.police_station_frame);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent=new Intent(getActivity(),PoliceStationActivity.class);
                startActivity(intent);
            }
        });

        //@ FavoriteEntity contact frame touch event hadler

        frameLayout= (FrameLayout) rootView.findViewById(R.id.importent_contact_frame);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent=new Intent(getActivity(),ImportantActivity.class);
                startActivity(intent);
            }
        });



        return rootView;
    }

}
