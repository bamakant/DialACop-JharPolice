package com.kiusoftech.dialacop_jharpolice;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class PoliceStationActivity extends AppCompatActivity {

    String districtName,ps;
    ListView listView;
    Intent intent;
    String[] policeStationString;
    ArrayAdapter<String> policeStationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_station);

        listView=(ListView) findViewById(R.id.district_listview);

        // Spinner for selecting district name

        final Spinner chooseDistrictSpinner = (Spinner) findViewById(R.id.choose_district_spinner);
        // an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> chooseDistrictAdapter = ArrayAdapter.createFromResource(this,
                R.array.chooseDistrict, android.R.layout.simple_spinner_item);
        // the layout to use when the list of choices appears
        chooseDistrictAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        //Need to sort adapter from here.........

        // the adapter to the spinner

        chooseDistrictSpinner.setAdapter(chooseDistrictAdapter);

        chooseDistrictSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                districtName=(String) parent.getItemAtPosition(position);

                switch (districtName){

                    case "Bokaro":
                        policeStationString=getResources().getStringArray(R.array.bokaro_district_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                          ps=(String) parent.getItemAtPosition(position);

                                // pass station name as intent to another activity

                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);

                            }
                        });
                        break;
                    case "Dhanbad":
                        policeStationString=getResources().getStringArray(R.array.dhanbad_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);

                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Ranchi":
                        policeStationString=getResources().getStringArray(R.array.ranchi_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Dumka":
                        policeStationString=getResources().getStringArray(R.array.dumka_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);

                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Garhwa":
                        policeStationString=getResources().getStringArray(R.array.garhwa_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);

                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);

                            }
                        });
                        break;
                    case "Chatra":
                        policeStationString=getResources().getStringArray(R.array.chatra_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);

                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);

                            }
                        });
                        break;
                    case "Deoghar":
                        policeStationString=getResources().getStringArray(R.array.deoghar_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);

                            }
                        });
                        break;
                    case "Hazaribagh":
                        policeStationString=getResources().getStringArray(R.array.hazaribagh_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Jamtara":
                        policeStationString=getResources().getStringArray(R.array.jamtara_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);

                            }
                        });
                        break;
                    case "Khunti":
                        policeStationString=getResources().getStringArray(R.array.khunti_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);

                            }
                        });
                        break;
                    case "Giridih":
                        policeStationString=getResources().getStringArray(R.array.giridih_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Godda":
                        policeStationString=getResources().getStringArray(R.array.godda_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Gumla":
                        policeStationString=getResources().getStringArray(R.array.gumla_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Pakur":
                        policeStationString=getResources().getStringArray(R.array.pakur_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Palamu":
                        policeStationString=getResources().getStringArray(R.array.palamu_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Ramgarh":
                        policeStationString=getResources().getStringArray(R.array.ramgarh_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Koderma":
                        policeStationString=getResources().getStringArray(R.array.koderma_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Latehar":
                        policeStationString=getResources().getStringArray(R.array.latehar_police_stations0);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Lohardaga":
                        policeStationString=getResources().getStringArray(R.array.lohardaga_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Simdega":
                        policeStationString=getResources().getStringArray(R.array.simdega_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "East Singhbhum":
                        policeStationString=getResources().getStringArray(R.array.eastsinghbhum_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "West Singhbhum":
                        policeStationString=getResources().getStringArray(R.array.west_singhbhum_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Sahibganj":
                        policeStationString=getResources().getStringArray(R.array.sahibganj_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Saraikela":
                        policeStationString=getResources().getStringArray(R.array.saraikela_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,StationContactDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
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
