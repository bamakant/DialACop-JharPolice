package com.kiusoftech.dialacop_jharpolice.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.kiusoftech.dialacop_jharpolice.R;

public class MainActivity extends AppCompatActivity  {

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

        //@ FavoriteEntity contact frame touch event hadler

        frameLayout= (FrameLayout) findViewById(R.id.importent_contact_frame);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent=new Intent(MainActivity.this,ImportantActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            this.finishAffinity();
            return true;
        }
        else if (id == R.id.request){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "kiusoftech@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding DialACop Jharkhand police Android App");
            intent.putExtra(Intent.EXTRA_TEXT, "Write your details and required contact person name or designation and location.\n");
            startActivity(intent);
        }
        else if(id==R.id.share){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Check out this App of Jharkhand Police, A small initiative to connect people of jharkhand state with jharkhand police.\n" +
                    "https://play.google.com/store/apps/details?id=com.kiusoftech.dialacop_jharpolice");
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out this Apps!");
            startActivity(Intent.createChooser(intent, "Share App"));
            return true;
        }
        else if(id==R.id.help){
            Intent i = new Intent(MainActivity.this,AboutActivity.class);
            startActivity(i);
        }
        else if(id==R.id.feedback){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "kiusoftech@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding DialACop Jharkhand police Android App");
            intent.putExtra(Intent.EXTRA_TEXT, "Write your suggestion please.\n");
            startActivity(intent);
        }
        else if(id==R.id.rateapp){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.kiusoftech.dialacop_jharpolice")));
        }
        return super.onOptionsItemSelected(item);
    }
}
