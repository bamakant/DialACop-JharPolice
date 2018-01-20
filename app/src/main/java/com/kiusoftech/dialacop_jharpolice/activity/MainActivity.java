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
    private InterstitialAd mInterstitialAd1,mInterstitialAd2;
    private RewardedVideoAd mAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //@ Ads section

        mInterstitialAd1 = new InterstitialAd(this);
        mInterstitialAd1.setAdUnitId("ca-app-pub-8605617979923403/4722763177");
        mInterstitialAd1.loadAd(new AdRequest.Builder().build());

        mInterstitialAd2 = new InterstitialAd(this);
        mInterstitialAd2.setAdUnitId(getResources().getString(R.string.homeAdsUnit));
        mInterstitialAd2.loadAd(new AdRequest.Builder().build());

        // Use an activity context to get the rewarded video instance.
        mAd = MobileAds.getRewardedVideoAdInstance(this);
        mAd.loadAd("ca-app-pub-8605617979923403/7477753173", new AdRequest.Builder().build());

        mAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {

            }

            @Override
            public void onRewardedVideoAdOpened() {

            }

            @Override
            public void onRewardedVideoStarted() {

            }

            @Override
            public void onRewardedVideoAdClosed() {

            }

            @Override
            public void onRewarded(RewardItem rewardItem) {

            }

            @Override
            public void onRewardedVideoAdLeftApplication() {

            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {

            }
        });

        mInterstitialAd1.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i("Ads", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.i("Ads", "onAdFailedToLoad");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
                Log.i("Ads", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i("Ads", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                Log.i("Ads", "onAdClosed");
            }
        });

        //@ Ads section end

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
            Intent i = new Intent(MainActivity.this,HelpActivity.class);
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

    @Override
    protected void onStop() {
        if(mInterstitialAd1.isLoaded()){
            mInterstitialAd1.show();
        }else Log.d("TAG", "The Ad is not loaded.");
        super.onStop();
    }

    @Override
    public void onResume() {
        if(mInterstitialAd2.isLoaded()){
            mInterstitialAd2.show();
        }else Log.d("TAG", "The Ad is not loaded.");
        super.onResume();
    }

    @Override
    public void onPause() {
        mAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        if (mAd.isLoaded()) {
            mAd.show();
        }
        super.onDestroy();
    }
}
