package com.kiusoftech.dialacop_jharpolice.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kiusoftech.dialacop_jharpolice.R;
import com.kiusoftech.dialacop_jharpolice.rest.GooglePlaces;
import com.kiusoftech.dialacop_jharpolice.rest.PlaceDetails;
import com.kiusoftech.dialacop_jharpolice.service.LocationUpdatesIntentService;
import com.kiusoftech.dialacop_jharpolice.utils.AlertDialogManager;

public class SinglePlaceActivity extends AppCompatActivity implements OnMapReadyCallback {

    // flag for Internet connection status
    //Boolean isInternetPresent = false;

    // Connection detector class
    // ConnectionDetector cd;

    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Google Places
    GooglePlaces googlePlaces;

    // Place Details
    PlaceDetails placeDetails;

    // Progress dialog
    ProgressDialog pDialog;

    // KEY Strings
    public static String KEY_REFERENCE = "reference"; // id of the place
    private static final String TAG = "kant";

    private SupportMapFragment singlePlaceMapFragment;
    private GoogleMap mGoogleMap;
    private LatLng currentLatLng;
    private Marker mCurrLocationMarker;
    private LatLng stationLatLng;
    private Marker stationMarker;
    private Intent intent;
    private Intent dialIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_place);

        Intent i = getIntent();

        singlePlaceMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.single_place_map_fragment);

        singlePlaceMapFragment.getMapAsync(this);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Place referece id
        String reference = i.getStringExtra(KEY_REFERENCE);

        // Calling a Async Background thread
        new LoadSinglePlaceDetails().execute(reference);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mGoogleMap = googleMap;

        //Place current location marker
        currentLatLng = new LatLng(LocationUpdatesIntentService.lat, LocationUpdatesIntentService.lang);
        MarkerOptions currentMarkerOptions = new MarkerOptions();
        currentMarkerOptions.position(currentLatLng);
        currentMarkerOptions.title("Current Position");
        currentMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        mCurrLocationMarker = mGoogleMap.addMarker(currentMarkerOptions);


    }

    /**
     * Background Async Task to Load Google places
     */
    class LoadSinglePlaceDetails extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(SinglePlaceActivity.this);
            pDialog.setMessage("Loading details ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * getting Profile JSON
         */
        protected String doInBackground(String... args) {
            String reference = args[0];

            // creating Places class object
            googlePlaces = new GooglePlaces();

            // Check if used is connected to Internet
            try {
                placeDetails = googlePlaces.getPlaceDetails(reference);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all products
            pDialog.dismiss();
            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed Places into LISTVIEW
                     * */
                    if (placeDetails != null) {
                        String status = placeDetails.status;

                        // check place deatils status
                        // Check for all possible status
                        switch (status) {
                            case "OK":
                                if (placeDetails.result != null) {
                                    String name = placeDetails.result.name;
                                    String address = placeDetails.result.formatted_address;
                                    String phone = placeDetails.result.formatted_phone_number;
                                    String latitude = Double.toString(placeDetails.result.geometry.location.lat);
                                    String longitude = Double.toString(placeDetails.result.geometry.location.lng);

                                    Log.d(TAG, name + address + phone + latitude + longitude);

                                    // Displaying all the details in the view
                                    // single_place.xml
                                    TextView lbl_name = (TextView) findViewById(R.id.name);
                                    TextView lbl_address = (TextView) findViewById(R.id.address);
                                    final TextView lbl_phone = (TextView) findViewById(R.id.phone);
                                    TextView lbl_location = (TextView) findViewById(R.id.location);

                                    // Check for null data from google
                                    // Sometimes place details might missing
                                    name = name == null ? "Not present" : name; // if name is null display as "Not present"
                                    address = address == null ? "Not present" : address;
                                    phone = phone == null ? "Not present" : phone;
                                    latitude = latitude == null ? "Not present" : latitude;
                                    longitude = longitude == null ? "Not present" : longitude;

                                    lbl_name.setText(name);
                                    lbl_address.setText(address);
                                    lbl_phone.setText(phone);
                                    lbl_phone.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if (lbl_phone.getText().toString().trim().contains("Not present")) {
                                                Toast.makeText(SinglePlaceActivity.this, "Can't make a call.", Toast.LENGTH_SHORT).show();
                                            } else {
                                                dialIntent = new Intent(Intent.ACTION_DIAL);
                                                dialIntent.setData(Uri.parse("tel:" + lbl_phone.getText().toString()));
                                                startActivity(dialIntent);
                                            }
                                        }
                                    });
                                    lbl_location.setText(Html.fromHtml("<b>Latitude:</b> " + latitude + ", <b>Longitude:</b> " + longitude));


                                    //Marker on police station

                                    stationLatLng = new LatLng(placeDetails.result.geometry.location.lat, placeDetails.result.geometry.location.lng);
                                    MarkerOptions stationMarkerOptions = new MarkerOptions();
                                    stationMarkerOptions.position(stationLatLng);
                                    stationMarkerOptions.title(placeDetails.result.name);
                                    stationMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                                    stationMarker = mGoogleMap.addMarker(stationMarkerOptions);

                                    //move map camera
                                    //mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stationLatLng, 16));

                                    LatLngBounds.Builder builder = new LatLngBounds.Builder();

//the include method will calculate the min and max bound.
                                    builder.include(mCurrLocationMarker.getPosition());
                                    builder.include(stationMarker.getPosition());
                                    LatLngBounds bounds = builder.build();

                                    //singlePlaceMapFragment.
                                    FrameLayout fr = findViewById(R.id.single_place_frame_layout);
                                    int width = fr.getWidth();//getResources().getDisplayMetrics().widthPixels;
                                    int height = fr.getHeight();//getResources().getDisplayMetrics().heightPixels;
                                    int padding = (int) (width * 0.10); // offset from edges of the map 10% of screen

                                    CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);

                                    mGoogleMap.animateCamera(cu);


                                }
                                break;
                            case "ZERO_RESULTS":
                                alert.showAlertDialog(SinglePlaceActivity.this, "Near Places",
                                        "Sorry no place found.",
                                        false);
                                break;
                            case "UNKNOWN_ERROR":
                                alert.showAlertDialog(SinglePlaceActivity.this, "Places Error",
                                        "Sorry unknown error occured.",
                                        false);
                                break;
                            case "OVER_QUERY_LIMIT":
                                alert.showAlertDialog(SinglePlaceActivity.this, "Places Error",
                                        "Sorry query limit to google places is reached",
                                        false);
                                break;
                            case "REQUEST_DENIED":
                                alert.showAlertDialog(SinglePlaceActivity.this, "Places Error",
                                        "Sorry error occured. Request is denied",
                                        false);
                                break;
                            case "INVALID_REQUEST":
                                alert.showAlertDialog(SinglePlaceActivity.this, "Places Error",
                                        "Sorry error occured. Invalid Request",
                                        false);
                                break;
                            default:
                                alert.showAlertDialog(SinglePlaceActivity.this, "Places Error",
                                        "Sorry error occured.",
                                        false);
                                break;
                        }
                    } else {
                        alert.showAlertDialog(SinglePlaceActivity.this, "Places Error",
                                "Sorry error occured.",
                                false);
                    }


                }
            });

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

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
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
                return true;
            case R.id.share:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Check out this App of Jharkhand Police, A small initiative to connect people of jharkhand state with jharkhand police.\n" +
                        "https://play.google.com/store/apps/details?id=com.kiusoftech.dialacop_jharpolice");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out this Apps!");
                startActivity(Intent.createChooser(intent, "Share App"));
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
