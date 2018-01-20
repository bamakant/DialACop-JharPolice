package com.kiusoftech.dialacop_jharpolice.activity;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.kiusoftech.dialacop_jharpolice.R;
import com.kiusoftech.dialacop_jharpolice.fragment.FavoriteFragment;
import com.kiusoftech.dialacop_jharpolice.fragment.HomeFragment;
import com.kiusoftech.dialacop_jharpolice.fragment.NearByFragment;

public class HomeActivity extends AppCompatActivity {

private Intent intent;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeFragment(0);
                    return true;
                case R.id.navigation_nearby:
                    changeFragment(1);
                    return true;
                case R.id.navigation_favorite:
                    changeFragment(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        changeFragment(0);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private void changeFragment(int position) {

        Fragment newFragment = null;

        if (position == 0) {
            newFragment = new HomeFragment();
        } else if (position % 2 != 0) {
            newFragment = new NearByFragment();
        } else {
            newFragment = new FavoriteFragment();
        }

        getFragmentManager().beginTransaction().replace(
                R.id.fragmentContainer, newFragment)
                .commit();
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
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Check out this App of Jharkhand Police, A small initiative to connect people of jharkhand state with jharkhand police.\n" +
                    "https://play.google.com/store/apps/details?id=com.kiusoftech.dialacop_jharpolice");
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out this Apps!");
            startActivity(Intent.createChooser(intent, "Share App"));
            return true;
        }
        else if(id==R.id.help){
            Intent i = new Intent(getApplicationContext(),HelpActivity.class);
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
