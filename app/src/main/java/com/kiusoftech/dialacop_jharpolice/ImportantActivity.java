package com.kiusoftech.dialacop_jharpolice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class ImportantActivity extends AppCompatActivity {

    ListView listView;
    String location,designation;
    Intent intent;
    Spinner locationSpinner;
    String[] locationString;
    ArrayAdapter<String> locationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important);

        listView = (ListView) findViewById(R.id.location_listview);
        locationSpinner = (Spinner) findViewById(R.id.choose_location_spinner);

        //@ loading string array on spinner as array adapter
        ArrayAdapter<CharSequence> chooseLocationAdapter = ArrayAdapter.createFromResource(this,R.array.choose_location, android.R.layout.simple_spinner_item);
        chooseLocationAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        locationSpinner.setAdapter(chooseLocationAdapter);

        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                location = parent.getItemAtPosition(position).toString();


                switch (location){

                    case "Anti Corruption Bureau (A.C.B.)":
                        locationString=getResources().getStringArray(R.array.acb_designations);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Bokaro Range":
                        locationString=getResources().getStringArray(R.array.bokaro_range);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Chhotanagpur Range":
                        locationString=getResources().getStringArray(R.array.chhotanagpur_range);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "CID":
                        locationString=getResources().getStringArray(R.array.cid);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Dumka Range":
                        locationString=getResources().getStringArray(R.array.dumka_range);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Hazaribagh Range":
                        locationString=getResources().getStringArray(R.array.hazaribagh_range);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Home Department":
                        locationString=getResources().getStringArray(R.array.home_department);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Home Guard":
                        locationString=getResources().getStringArray(R.array.home_guard);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "JAP":
                        locationString=getResources().getStringArray(R.array.jap);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Jharkhand Jaguar":
                        locationString=getResources().getStringArray(R.array.jharkhand_jaguar);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Jharkhand Police Housing Corporation":
                        locationString=getResources().getStringArray(R.array.jphc);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Kolhan Range":
                        locationString=getResources().getStringArray(R.array.kolhan_ange);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Palamu Range":
                        locationString=getResources().getStringArray(R.array.palamu_range);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Police Headquarter":
                        locationString=getResources().getStringArray(R.array.police_headquater);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Railways":
                        locationString=getResources().getStringArray(R.array.railways);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "SCRB":
                        locationString=getResources().getStringArray(R.array.scrb);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Special Branch":
                        locationString=getResources().getStringArray(R.array.special_branch);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Training":
                        locationString=getResources().getStringArray(R.array.training);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Wireless":
                        locationString=getResources().getStringArray(R.array.wireless);
                        locationAdapter=new ArrayAdapter<String>(ImportantActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this,LocationDetailsActivity.class);
                                intent.putExtra("designation",designation);
                                startActivity(intent);
                            }
                        });
                        break;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
