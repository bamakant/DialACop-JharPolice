package com.kiusoftech.dialacop_jharpolice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class EmergencyActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        //@ Anti corruption bureau click event
        linearLayout = (LinearLayout) findViewById(R.id.anticorp_linearlayout);
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:06512281530"));
                startActivity(intent);
            }
        });

        //@ Child help line click event

        linearLayout = (LinearLayout) findViewById(R.id.childhelp_linearlayout);
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:06512490295"));
                startActivity(intent);
            }
        });

        //@ cyber crime click event
        linearLayout = (LinearLayout) findViewById(R.id.cybercrime_linearlayout);
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:06512220060"));
                startActivity(intent);
            }
        });

        //@ DG control room click event
        linearLayout = (LinearLayout) findViewById(R.id.dgcontrol_linearlayout);
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:06512446607"));
                startActivity(intent);
            }
        });

        //@ organized crime acitivities click event
        linearLayout = (LinearLayout) findViewById(R.id.orgcrime_linearlayout);
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:06512490710"));
                startActivity(intent);
            }
        });

        //@ other activities click event
        linearLayout = (LinearLayout) findViewById(R.id.othercrime_linearlayout);
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:06512491293"));
                startActivity(intent);
            }
        });

        //@ terrorist activities click event
        linearLayout = (LinearLayout) findViewById(R.id.terror_linearlayout);
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:06512490295"));
                startActivity(intent);
            }
        });

        //@ women help line click event
        linearLayout = (LinearLayout) findViewById(R.id.womenhelp_linearlayout);
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:06512490295"));
                startActivity(intent);
            }
        });

    }
}
