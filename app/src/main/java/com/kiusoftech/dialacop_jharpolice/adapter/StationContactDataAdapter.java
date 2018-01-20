package com.kiusoftech.dialacop_jharpolice.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kiusoftech.dialacop_jharpolice.ModelClass.StationContactData;
import com.kiusoftech.dialacop_jharpolice.R;

import java.util.ArrayList;

/**
 * Created by bamakantkar on 21/6/17.
 */
public class StationContactDataAdapter extends ArrayAdapter<StationContactData> {

    Intent intent;

    public StationContactDataAdapter(Activity context, ArrayList<StationContactData> stationContactDatas){
        super(context,0,stationContactDatas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        StationContactData currentStationData = getItem(position);

        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.activity_station_contact_details,parent,false);
        }

        final TextView nStationContactPhone=(TextView) convertView.findViewById(R.id.station_phone_number_textview);
        final TextView nStationContactMobile= (TextView) convertView.findViewById(R.id.station_mobile_number_textview);

        final LinearLayout stationPhoneLayout = (LinearLayout) convertView.findViewById(R.id.station_phone_linearLayout);
        LinearLayout stationMobileLayout = (LinearLayout) convertView.findViewById(R.id.station_mobile_linearLayout);



        nStationContactPhone.setText(currentStationData.getmStationContactPhone());
        nStationContactMobile.setText(currentStationData.getmStationContactMobile());

        stationMobileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + nStationContactMobile.getText()));
                getContext().startActivity(intent);
            }
        });

        stationPhoneLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nStationContactPhone.getText().toString().matches("[0-9]+")){
                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + nStationContactPhone.getText()));
                    getContext().startActivity(intent);

                }else {
                    Toast.makeText(getContext(),"Number is not available",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return convertView;

    }
}
