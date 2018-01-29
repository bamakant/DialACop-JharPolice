package com.kiusoftech.dialacop_jharpolice.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.kiusoftech.dialacop_jharpolice.R;

public class PoliceStationActivity extends AppCompatActivity {

    String districtName,ps;
    ListView listView;
    Intent intent;
    String[] policeStationString;
    ArrayAdapter<String> policeStationAdapter;
    ImageView imageView;
    private InterstitialAd mInterstitialAd;
    private RelativeLayout police_station_relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_station);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8605617979923403/2966828372");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        listView=(ListView) findViewById(R.id.district_listview);
        imageView = (ImageView) findViewById(R.id.topdirImage);
        police_station_relativeLayout = findViewById(R.id.police_station_no_data);

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

                    case "Choose District":
                        police_station_relativeLayout.setVisibility(View.VISIBLE);
                        break;
                    case "Bokaro":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.bokaro_district_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                          ps=(String) parent.getItemAtPosition(position);

                                // pass station name as intent to another activity

                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);

                            }
                        });
                        break;
                    case "Dhanbad":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.dhanbad_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);

                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Ranchi":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.ranchi_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Dumka":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.dumka_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);

                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Garhwa":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.garhwa_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);

                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);

                            }
                        });
                        break;
                    case "Chatra":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.chatra_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);

                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);

                            }
                        });
                        break;
                    case "Deoghar":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.deoghar_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);

                            }
                        });
                        break;
                    case "Hazaribagh":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.hazaribagh_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Jamtara":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.jamtara_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);

                            }
                        });
                        break;
                    case "Khunti":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.khunti_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);

                            }
                        });
                        break;
                    case "Giridih":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.giridih_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Godda":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.godda_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Gumla":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.gumla_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Pakur":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.pakur_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Palamu":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.palamu_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Ramgarh":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.ramgarh_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Koderma":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.koderma_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Latehar":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.latehar_police_stations0);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Lohardaga":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.lohardaga_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Simdega":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.simdega_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "East Singhbhum":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.eastsinghbhum_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "West Singhbhum":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.west_singhbhum_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Sahibganj":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.sahibganj_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
                                intent.putExtra("PoliceStationName",ps);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Saraikela":
                        police_station_relativeLayout.setVisibility(View.GONE);
                        policeStationString=getResources().getStringArray(R.array.saraikela_police_stations);
                        policeStationAdapter=new ArrayAdapter<String>(PoliceStationActivity.this,R.layout.simple_list_layout,R.id.simpleListTextView, policeStationString);
                        listView.setAdapter(policeStationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                ps=(String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(PoliceStationActivity.this,PoliceStationDetailsActivity.class);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    //for back button and option menu item click event
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.exit:
                this.finishAffinity();
                return true;
            case R.id.help:
                Intent i = new Intent(PoliceStationActivity.this,AboutActivity.class);
                startActivity(i);
                return true;
            case R.id.share:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Check out this App of Jharkhand Police, A small initiative to connect people of jharkhand state with jharkhand police.\n" +
                        "https://play.google.com/store/apps/details?id=com.kiusoftech.dialacop_jharpolice");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out this Apps!");
                startActivity(Intent.createChooser(intent, "Share"));
                return true;
            case R.id.feedback:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "kiusoftech@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding DialACop Jharkhand police Android App");
                intent.putExtra(Intent.EXTRA_TEXT, "Write your suggestion please.\n");
                startActivity(intent);
                return true;
            case R.id.rateapp:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.kiusoftech.dialacop_jharpolice")));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }else Log.d("TAG", "The Ad is not loaded.");
        super.onPause();
    }
}
