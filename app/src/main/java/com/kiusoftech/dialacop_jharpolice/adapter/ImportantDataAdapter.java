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

import com.kiusoftech.dialacop_jharpolice.Pojo.ImportantData;
import com.kiusoftech.dialacop_jharpolice.R;

import java.util.ArrayList;

/**
 * Created by bamakantkar on 23/6/17.
 */
public class ImportantDataAdapter extends ArrayAdapter<ImportantData> {

    Intent intent;

    public ImportantDataAdapter(Activity context, ArrayList<ImportantData> importantData){
        super(context,0, importantData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImportantData currentImportantData = getItem(position);

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_location_details,parent,false);
        }

        TextView nPersonName = (TextView) convertView.findViewById(R.id.personName_TextView);
        final TextView nMobileNo = (TextView) convertView.findViewById(R.id.location_mobile_textview);
        final TextView nOfficeNo = (TextView) convertView.findViewById(R.id.location_officeno_textview);
        final TextView nResidenceNo = (TextView) convertView.findViewById(R.id.location_residenceno_textview);
        final TextView nFaxNo = (TextView) convertView.findViewById(R.id.location_faxno_textview);
        final TextView nEmail = (TextView) convertView.findViewById(R.id.location_email_textview);

        LinearLayout mobilenolinearLayout = (LinearLayout) convertView.findViewById(R.id.location_mobileno_linearLayout);
        LinearLayout officenolinearLayout = (LinearLayout) convertView.findViewById(R.id.location_officeno_linearLayout);
        LinearLayout residencenolinearLayout = (LinearLayout) convertView.findViewById(R.id.location_residenceno_linearLayout);
        LinearLayout faxnolinearLayout = (LinearLayout) convertView.findViewById(R.id.location_faxno_linearLayout);
        LinearLayout emaillinearLayout = (LinearLayout) convertView.findViewById(R.id.location_email_linearLayout);


        nPersonName.setText(currentImportantData.getmPersonName());
        nMobileNo.setText(currentImportantData.getmMobileNo());
        nOfficeNo.setText(currentImportantData.getmOfficeNo());
        nResidenceNo.setText(currentImportantData.getmResidenceNo());
        nFaxNo.setText(currentImportantData.getmFaxNo());
        nEmail.setText(currentImportantData.getmEmail());

        mobilenolinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nMobileNo.getText().toString().matches("[0-9]+")){
                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + nMobileNo.getText()));
                    getContext().startActivity(intent);

                }else {
                    Toast.makeText(getContext(),"Mobile Number is not available",Toast.LENGTH_SHORT).show();
                }
            }
        });

        officenolinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nOfficeNo.getText().toString().matches("[0-9]+")){
                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + nOfficeNo.getText()));
                    getContext().startActivity(intent);

                }else {
                    Toast.makeText(getContext(),"Office Number is not available",Toast.LENGTH_SHORT).show();
                }
            }
        });

        residencenolinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nResidenceNo.getText().toString().matches("[0-9]+")){
                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + nResidenceNo.getText()));
                    getContext().startActivity(intent);

                }else {
                    Toast.makeText(getContext(),"Residence Number is not available",Toast.LENGTH_SHORT).show();
                }
            }
        });

        faxnolinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nFaxNo.getText().toString().matches("[0-9]+")){
                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + nFaxNo.getText()));
                    getContext().startActivity(intent);

                }else {
                    Toast.makeText(getContext()," Fax number is not available",Toast.LENGTH_SHORT).show();
                }
            }
        });

        emaillinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nEmail.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+")){
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + nEmail.getText()));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Your Subject here please");
                    intent.putExtra(Intent.EXTRA_TEXT, "Start writing from here.");
                    getContext().startActivity(intent);

                }else {
                    Toast.makeText(getContext(),"Email ID is not available",Toast.LENGTH_SHORT).show();
                }
            }
        });


        return convertView;
    }
}
