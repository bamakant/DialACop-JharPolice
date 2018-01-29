package com.kiusoftech.dialacop_jharpolice.fragment;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.kiusoftech.dialacop_jharpolice.R;
import com.kiusoftech.dialacop_jharpolice.activity.SinglePlaceActivity;
import com.kiusoftech.dialacop_jharpolice.rest.GooglePlaces;
import com.kiusoftech.dialacop_jharpolice.rest.Place;
import com.kiusoftech.dialacop_jharpolice.rest.PlacesList;
import com.kiusoftech.dialacop_jharpolice.service.LocationUpdatesIntentService;
import com.kiusoftech.dialacop_jharpolice.utils.AlertDialogManager;

import java.util.ArrayList;
import java.util.HashMap;

import static com.google.android.gms.internal.zzahg.runOnUiThread;

public class NearByFragment extends Fragment implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener{

    private View rootView;

    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private FusedLocationProviderClient mFusedLocationClient;

    protected static final int REQUEST_CHECK_SETTINGS = 2;

    private static final long UPDATE_INTERVAL = 10 * 1000;

    private static final long FASTEST_UPDATE_INTERVAL = UPDATE_INTERVAL / 2;

    private static final long MAX_WAIT_TIME = UPDATE_INTERVAL * 3;

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    private static final String TAG = "kant";
    private Intent serviceIntent;

    // flag for Internet connection status
    Boolean isInternetPresent = false;

    // Connection detector class
    // ConnectionDetector cd;

    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Google Places
    GooglePlaces googlePlaces;

    // Places List
    PlacesList nearPlaces;

    // GPS Location
    //GPSTracker gps;

    // Button
    Button btnShowOnMap;

    // Progress dialog
    ProgressDialog pDialog;

    // Places Listview
    ListView nearBystationsListView;

    // ListItems data
    ArrayList<HashMap<String, String>> placesListItems = new ArrayList<HashMap<String, String>>();


    // KEY Strings
    public static String KEY_REFERENCE = "reference"; // id of the place
    public static String KEY_NAME = "name"; // name of the place
    public static String KEY_VICINITY = "vicinity"; // Place area name
    private boolean isNetworkAvailable;


    public NearByFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_near_by, container, false);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //Location Permission already granted
                buildGoogleApiClient();
            } else {
                //Request Location Permission
                checkLocationPermission();

            }
        } else {
            buildGoogleApiClient();
        }

        //@linking list view
        nearBystationsListView = rootView.findViewById(R.id.nearByListView);

        //@Checking internet connection is there on not
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo active = cm.getActiveNetworkInfo();
        isNetworkAvailable = active != null && active.isConnectedOrConnecting();

        // calling background Async task to load Google Places
        // After getting places from Google all the data is shown in listview

        /**
         * check here whether internet is TURNED ON or not, if Internet available then execute next line
         * else ask user to turn ON internet connection.
         */
        if (isNetworkAvailable) {
            loadStations();

        } else {

            new AlertDialog.Builder(getActivity())
                    .setTitle("Network Error")
                    .setMessage("Internet Connection Not Available.")
                    .setIcon(R.drawable.fail)
                    /*.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {

                            Intent networkIntent = new Intent(Intent.ACTION_MAIN);
                            networkIntent.setClassName("com.android.phone","com.android.phone.Settings");
                            startActivity(networkIntent);
                        }
                    })*/
                    .setNegativeButton("OK", null)
                    .show();

        }

        /**
         * ListItem click event
         * On selecting a listitem SinglePlaceActivity is launched
         * */

        nearBystationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // getting values from selected ListItem
                String reference = ((TextView) view.findViewById(R.id.reference)).getText().toString();

                // Starting new intent
                Intent in = new Intent(getActivity(),
                        SinglePlaceActivity.class);

                // Sending place refrence id to single place activity
                // place refrence id used to get "Place full details"
                in.putExtra(KEY_REFERENCE, reference);
                startActivity(in);
            }
        });


        return rootView;
    }

    private void loadStations() {
        if (LocationUpdatesIntentService.lat != 0) {
            new LoadPlaces().execute();
            Toast.makeText(getActivity(), "Police Stations arround 10 km", Toast.LENGTH_SHORT).show();
        } else {
            new AlertDialog.Builder(getActivity())
                    .setTitle("Getting Location")
                    .setMessage("Please wait...")
                    .setIcon(R.drawable.fail)
                    .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            loadStations();
                        }
                    })
                    //.setNegativeButton("OK", null)
                    .show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        //startLocationUpdates();
                        break;
                    case Activity.RESULT_CANCELED:
                        settingsrequest();//keep asking if imp or do whatever
                        Toast.makeText(getActivity(), "You can't use this app without turn ON location.", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;

        }
    }

    protected synchronized void buildGoogleApiClient() {
        if (mGoogleApiClient != null) {
            return;
        }
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setMaxWaitTime(MAX_WAIT_TIME);
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        LocationServices.getFusedLocationProviderClient(getActivity()).requestLocationUpdates(mLocationRequest, getPendingIntent());

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private PendingIntent getPendingIntent() {

        serviceIntent = new Intent(getActivity(), LocationUpdatesIntentService.class);
        return PendingIntent.getService(getActivity(), 0, serviceIntent, PendingIntent.FLAG_UPDATE_CURRENT);

    }

    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(getActivity())
                        .setTitle("Location Permission Needed.")
                        .setMessage("Please allow location access to find out near by police stations.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(getActivity(),
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .setCancelable(true)
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }

                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(getActivity(), "Require location permission to function this App.", Toast.LENGTH_LONG).show();
                    openAppSettings();
                }
                return;
            }
        }

    }

    public void settingsrequest() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(30 * 1000);
        locationRequest.setFastestInterval(5 * 1000);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
        builder.setAlwaysShow(true); //this is the key ingredient

        PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                final Status status = result.getStatus();
                final LocationSettingsStates state = result.getLocationSettingsStates();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        // All location settings are satisfied. The client can initialize location
                        // requests here.
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        // Location settings are not satisfied. But could be fixed by showing the user
                        // a dialog.
                        try {
                            // Show the dialog by calling startResolutionForResult(),
                            // and check the result in onActivityResult().
                            status.startResolutionForResult(getActivity(), REQUEST_CHECK_SETTINGS);
                        } catch (IntentSender.SendIntentException e) {
                            // Ignore the error.
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        // Location settings are not satisfied. However, we have no way to fix the
                        // settings so we won't show the dialog.
                        break;
                }
            }
        });
    }

    void openAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:" + getActivity().getPackageName()));
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        //checkLocationPermission();
        if (mGoogleApiClient != null) {
            settingsrequest();
        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }


    /**
     * Background Async Task to Load Google places
     */
    class LoadPlaces extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage(Html.fromHtml("<b>Search</b><br/><br/><i>Loading Places...</i>"));
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * getting Places JSON
         */
        protected String doInBackground(String... args) {
            // creating Places class object
            googlePlaces = new GooglePlaces();

            try {
                // Separeate your place types by PIPE symbol "|"
                // If you want all types places make it as null
                // Check list of types supported by google
                //
                String types = "police"; // Listing places only cafes, restaurants

                // Radius in meters - increase this value if you don't find any places
                double radius = 10000; // 1000 meters

                // get nearest places
                nearPlaces = googlePlaces.search(LocationUpdatesIntentService.lat,
                        LocationUpdatesIntentService.lang, radius, types);
                Log.d(TAG, "doInBackground: " + LocationUpdatesIntentService.lat + " " + LocationUpdatesIntentService.lang);


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * and show the data in UI
         * Always use runOnUiThread(new Runnable()) to update UI from background
         * thread, otherwise you will get error
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
                    // Get json response status
                    String status = nearPlaces.status;

                    // Check for all possible status

                    switch (status) {
                        case "OK":
                            // Successfully got places details
                            if (nearPlaces.results != null) {
                                // loop through each place
                                for (Place p : nearPlaces.results) {

                                    HashMap<String, String> map = new HashMap<String, String>();

                                    // Place reference won't display in listview - it will be hidden
                                    // Place reference is used to get "place full details"
                                    map.put(KEY_REFERENCE, p.reference);

                                    // Place name
                                    map.put(KEY_NAME, p.name);

                                    // adding HashMap to ArrayList
                                    placesListItems.add(map);
                                }
                                // list adapter
                                ListAdapter adapter = new SimpleAdapter(getActivity(), placesListItems,
                                        R.layout.nearby_list_item,
                                        new String[]{KEY_REFERENCE, KEY_NAME}, new int[]{
                                        R.id.reference, R.id.name});

                                // Adding data into listview
                                nearBystationsListView.setAdapter(adapter);
                            }
                            break;
                        case "ZERO_RESULTS":
                            // Zero results found
                            alert.showAlertDialog(getActivity(), "Near Places",
                                    "Sorry no places found. ",
                                    false);
                            break;
                        case "UNKNOWN_ERROR":
                            alert.showAlertDialog(getActivity(), "Places Error",
                                    "Sorry unknown error occured.",
                                    false);
                            break;
                        case "OVER_QUERY_LIMIT":
                            alert.showAlertDialog(getActivity(), "Places Error",
                                    "Sorry query limit to google places is reached",
                                    false);
                            break;
                        case "REQUEST_DENIED":
                            alert.showAlertDialog(getActivity(), "Places Error",
                                    "Sorry error occured. Request is denied",
                                    false);
                            break;
                        case "INVALID_REQUEST":
                            alert.showAlertDialog(getActivity(), "Places Error",
                                    "Sorry error occured. Invalid Request",
                                    false);
                            break;
                        default:
                            alert.showAlertDialog(getActivity(), "Places Error",
                                    "Sorry error occured.",
                                    false);
                            break;
                    }
                }
            });

        }


    }
}