package com.kiusoftech.dialacop_jharpolice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //@ Dial 100 frame click event handler

        frameLayout= (FrameLayout) findViewById(R.id.dial100_frame);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:100"));
                startActivity(intent);
            }
        });

        //@ Emergency frame touch handler

        frameLayout= (FrameLayout) findViewById(R.id.emergency_frame);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent=new Intent(MainActivity.this,EmergencyActivity.class);
                startActivity(intent);

            }
        });

        //@ Police station contact frame touch event handler

        frameLayout= (FrameLayout) findViewById(R.id.police_station_frame);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent=new Intent(MainActivity.this,PoliceStationActivity.class);
                startActivity(intent);
            }
        });

        //@ Important contact frame touch event hadler

        frameLayout= (FrameLayout) findViewById(R.id.importent_contact_frame);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent=new Intent(MainActivity.this,ImportantActivity.class);
                startActivity(intent);
            }
        });


    }
}
