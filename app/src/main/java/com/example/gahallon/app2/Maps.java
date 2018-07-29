package com.example.gahallon.app2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.nfc.Tag;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Maps extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {

    private static final String TAG = "MapAct";

    private GoogleMap mMap;
    private Boolean mlocationPermissionGranted = false;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private static final float DEFAULT_ZOOM = 15;
    private String URL = "http://206.189.209.210/task_manager/v1/location/all";
    private ImageButton mGps;
    Global sharedData = Global.getInstance();
    private String selectedItem;

    private EditText mSearchText;
    private String[] plantList = {"Akapulko", "Ampalaya", "Bawang","Bayabas","Lagundi","Niyog-niyogan","Sambong","Tsaang Gubat","Pansit-Pansitan", "Yerba Buena"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mSearchText = findViewById(R.id.input_search);
        mGps = findViewById(R.id.ic_gps);
        mGps.setOnClickListener(this); // Best Solution <---

        getLocationPermissions();


    }
    @Override
    public void onClick(View v) {
        getDeviceLocation();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;

        if (mlocationPermissionGranted) {
            getDeviceLocation();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(false); //remove ung button na nag rereset back to current lcoation
         //   init();
            initSearch();
            //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        }
    }
    private void getDeviceLocation(){
       Log.d(TAG, "getting location");
       mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

       try{
           if (mlocationPermissionGranted){
               Task location = mFusedLocationProviderClient.getLastLocation();
               location.addOnCompleteListener(new OnCompleteListener() {
                   @Override
                   public void onComplete(@NonNull Task task) {
                       if (task.isSuccessful()){
                           Log.d(TAG, "location found");
                           Location currentLocation = (Location) task.getResult();
                           //moving camera
                           moveCamera(new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude()),DEFAULT_ZOOM);
//                            Double templatitude =  currentLocation.getLatitude();
//                            String lat = templatitude.toString();
                       } else {
                           Toast.makeText(Maps.this, "Current location not found", Toast.LENGTH_SHORT).show();

                       }
                   }
               });
           }

       }catch(SecurityException e){
           Log.d(TAG, e.getMessage());

       }

    }

    private void init(){

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET,
                URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i<response.length(); i++){
                    try {
                        JSONObject plantObject = response.getJSONObject(i);
                        plantLocation plantLoc = new plantLocation();
                        plantLoc.setId(plantObject.getInt("id"));
                        plantLoc.setPlantName(plantObject.getString("plant"));
                        plantLoc.setLatitude(plantObject.getDouble("latitude"));
                        plantLoc.setLongitude(plantObject.getDouble("longitude"));
                        LatLng latLng =  new LatLng(plantLoc.latitude,plantLoc.longitude);
                            mMap.addMarker(new MarkerOptions()
                                .position(latLng)
                                .title(plantLoc.plantName));



                            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                                @Override
                                public void onInfoWindowClick(Marker marker) {
                                    String selectedItem = marker.getTitle();
                                    Intent intent = new Intent(Maps.this, DatabasePlants.class);
                                    intent.putExtra("key", selectedItem);
                                    sharedData.setSelectedItem(selectedItem);
                                    startActivity(intent);



                                }
                            });


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error", error.getMessage());
            }
        });

        queue.add(arrayRequest);

    }

    private void initSearch() {
        init();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, plantList);
        //Getting the instance of AutoCompleteTextView
        final AutoCompleteTextView actv = findViewById(R.id.input_search);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView


        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = (String) adapterView.getItemAtPosition(i);

                mMap.clear();

                Intent intent = new Intent(Maps.this, MapsSpecific.class);
                intent.putExtra("key", selectedItem);
                startActivity(intent);
                Maps.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


            }
        });
    }









    private void moveCamera (LatLng latLng, float zoom){

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,zoom));
    }

    private void initMap(){
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(Maps.this);


    }


    private void getLocationPermissions() {
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mlocationPermissionGranted = true;
                initMap();

            }
            else //ask permission
            {
                ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST_CODE);
            }
        }
        else //ask permission
        {
            ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if (grantResults.length>0){
                    for (int i = 0; i< grantResults.length; i++){
                        if (grantResults[i]!=PackageManager.PERMISSION_GRANTED){
                            mlocationPermissionGranted = false;
                            return;
                        }
                    }
                    mlocationPermissionGranted = true;
                    initMap();
                }
            }

        }
    }
    public void onBackPressed() {

        // Put your own code here which you want to run on back button click.


        Intent intent = new Intent(Maps.this, MainActivity.class);

        startActivity(intent);

        Maps.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);



    }



}

