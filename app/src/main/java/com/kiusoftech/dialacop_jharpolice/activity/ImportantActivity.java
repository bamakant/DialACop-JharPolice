package com.kiusoftech.dialacop_jharpolice.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
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

public class ImportantActivity extends AppCompatActivity {

    private ListView listView;
    private String location;
    private String designation;
    private Intent intent;
    private Spinner locationSpinner;
    private String[] locationString;
    private ArrayAdapter<String> locationAdapter;
    private ImageView imageView;
    private RelativeLayout importantRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.location_listview);
        locationSpinner = (Spinner) findViewById(R.id.choose_location_spinner);
        imageView = (ImageView) findViewById(R.id.topdirImage);
        importantRelativeLayout = findViewById(R.id.important_activity_no_data);

        //@ loading string array on spinner as array adapter
        ArrayAdapter<CharSequence> chooseLocationAdapter = ArrayAdapter.createFromResource(this, R.array.choose_location, android.R.layout.simple_spinner_item);
        chooseLocationAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        locationSpinner.setAdapter(chooseLocationAdapter);

        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                location = parent.getItemAtPosition(position).toString();

                switch (location) {

                    case "Choose Department":
                        importantRelativeLayout.setVisibility(View.VISIBLE);
                        break;
                    case "Anti Corruption Bureau (A.C.B.)":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.acb_designations);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Bokaro Range":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.bokaro_range);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Chhotanagpur Range":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.chhotanagpur_range);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "CID":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.cid);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Dumka Range":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.dumka_range);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Hazaribagh Range":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.hazaribagh_range);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Home Department":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.home_department);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Home Guard":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.home_guard);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "JAP":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.jap);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Jharkhand Jaguar":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.jharkhand_jaguar);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Jharkhand Police Housing Corporation":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.jphc);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Kolhan Range":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.kolhan_ange);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Palamu Range":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.palamu_range);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Police Headquarter":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.police_headquater);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Railways":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.railways);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "SCRB":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.scrb);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Special Branch":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.special_branch);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Training":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.training);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
                                startActivity(intent);
                            }
                        });
                        break;
                    case "Wireless":
                        importantRelativeLayout.setVisibility(View.GONE);
                        locationString = getResources().getStringArray(R.array.wireless);
                        locationAdapter = new ArrayAdapter<String>(ImportantActivity.this, R.layout.simple_list_layout, R.id.simpleListTextView, locationString);
                        listView.setAdapter(locationAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // on click handler for individual police stations
                                designation = (String) parent.getItemAtPosition(position);
                                // pass station name as intent to another activity
                                intent = new Intent(ImportantActivity.this, ImportantDetailsActivity.class);
                                intent.putExtra("designation", designation);
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
        getMenuInflater().inflate(R.menu.menu_with_search, menu);
        MenuItem searchMenuItem = menu.findItem(R.id.menu_search);
        if (searchMenuItem == null) {
            return true;
        }
        SearchView searchView = (SearchView) searchMenuItem.getActionView();
        if (searchView != null) {
            searchView.setQueryHint("Search ");
            searchView.setMaxWidth(2129960); // https://stackoverflow.com/questions/18063103/searchview-in-optionsmenu-not-full-width
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    ImportantActivity.this.onQueryTextChange(s);
                    return false;
                }
            });
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void onQueryTextChange(String s) {
        try {
            locationAdapter.getFilter().filter(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            case R.id.request:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "kiusoftech@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding DialACop Jharkhand police Android App");
                intent.putExtra(Intent.EXTRA_TEXT, "Write your details and required contact person name or designation and location.\n");
                startActivity(intent);
                return true;
            case R.id.help:
                Intent i = new Intent(ImportantActivity.this, AboutActivity.class);
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
}
