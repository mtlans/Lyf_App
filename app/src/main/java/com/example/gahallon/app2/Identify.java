package com.example.gahallon.app2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.wonderkiln.camerakit.CameraKit;
import com.wonderkiln.camerakit.CameraKitError;
import com.wonderkiln.camerakit.CameraKitEvent;
import com.wonderkiln.camerakit.CameraKitEventListener;
import com.wonderkiln.camerakit.CameraKitImage;
import com.wonderkiln.camerakit.CameraKitVideo;
import com.wonderkiln.camerakit.CameraView;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import android.os.AsyncTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import java.io.IOException;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;


public class Identify extends AppCompatActivity {
    String ServerURL = "http://206.189.209.210/task_manager/v1/post";
    String ServerURL1 = "http://206.189.209.210/task_manager/v1/image";
    String tempPlant, tempLat, tempLong ;
    public static final String PasaMoTo = "com.example.gahallon.app2.PasaMoTo";
    private static final int INPUT_SIZE = 224;
    private static final int IMAGE_MEAN = 128;
    private static final float IMAGE_STD = 128.0f;
    private static final String INPUT_NAME = "input";
    private static final String OUTPUT_NAME = "final_result";
    private  String MODEL_FILE2 = "file:///android_asset/PlantNotPlant.pb";
    private  String LABEL_FILE2 = "file:///android_asset/pnp.txt";
    private String MODEL_FILE = "file:///android_asset/UpdatedBefore.pb";
    private String LABEL_FILE = "file:///android_asset/plantLabels1.txt";
    private  String finalresult, verify;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Classifier classifier, classifier2;
    private Executor executor = Executors.newSingleThreadExecutor();
    private ImageButton btnDetectObject, btnHelp;
    Global sharedData = Global.getInstance();
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private CameraView cameraView;
    private String encoded;
    private Boolean mlocationPermissionGranted = false;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify);
        cameraView = (CameraView) findViewById(R.id.cameraView);
        btnDetectObject = (ImageButton) findViewById(R.id.btnDetectObject);
        cameraView.addCameraKitListener(new CameraKitEventListener() {
            @Override
            public void onEvent(CameraKitEvent cameraKitEvent) {

            }

            @Override
            public void onError(CameraKitError cameraKitError) {

            }

            @Override
            public void onImage(CameraKitImage cameraKitImage) {

                Bitmap bitmap = cameraKitImage.getBitmap();
                bitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false);

                final List<Classifier.Recognition> result = classifier2.recognizeImage(bitmap);
                verify = result.toString();
                   boolean NextStep = verify.contains("not plant");
                if (NextStep) {
                    Toast.makeText(Identify.this, "Picture taken was not a plant.\nPlease try again.", Toast.LENGTH_SHORT).show();
                }
                else{
                    final List<Classifier.Recognition> Fresults = classifier.recognizeImage(bitmap);
                    finalresult = Fresults.toString();
                    convertLabels();
                        openWhich();

            }
            }
            @Override
            public void onVideo(CameraKitVideo cameraKitVideo) {

            }
        });

        btnDetectObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraView.captureImage();
            }
        });

        btnHelp = (ImageButton) findViewById(R.id.btnHelp);
        btnHelp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Identify.this, Tutorial.class));
            }
        });
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.onOffFlashlight);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {

                    cameraView.setFlash(CameraKit.Constants.FLASH_TORCH);
                } else {
                    cameraView.setFlash(CameraKit.Constants.FLASH_OFF);

                }
            }

        });
        initTensorFlowAndLoadModel();
    }
    public void openWhich(){

        String ipasa = finalresult;
        //Intent intent = new Intent(this, Main2Activity.class);
        if(ipasa.contains("Unclassified")){
            Intent intent1 = new Intent(this, Unidentified.class);
            startActivity(intent1);
        }
        else{
            Intent intent1 = new Intent(this, DatabasePlants.class);
            intent1.putExtra("key", ipasa);
            sharedData.setSelectedItem(ipasa);
            getDeviceLocation();
            startActivity(intent1);
        }

    }

    public void convertLabels(){
        String[] labels= {"Ampalaya", "Lagundi", "Bawang", "Niyog-niyogan", "Yerba Buena", "Pansit-pansitan","Unclassified","Three Leaf Lagundi", "Bayabas", "Akapulko", "Tsaang Gubat", "Sambong"};
        for(int i =0; i<labels.length; i++){
            if(finalresult.contains(labels[i])) {
                finalresult = labels[i];
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause() {
        cameraView.stop();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                classifier.close();
            }
        });
    }

    private void getDeviceLocation(){
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mlocationPermissionGranted = true;


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
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try {
            if (mlocationPermissionGranted) {
                Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {

                            Location currentLocation = (Location) task.getResult();
                            //moving camera
//                            moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), DEFAULT_ZOOM);
                            Double templatitude =  currentLocation.getLatitude();
                            String lat = templatitude.toString();
                            Double templongitude = currentLocation.getLongitude();
                            String longi = templongitude.toString();
//                            Toast.makeText(Identify.this, lat+longi, Toast.LENGTH_SHORT).show();

                            tempPlant = sharedData.getSelectedItem().toString();
                            tempLat = lat;
                            tempLong = longi;

                            class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
                                @Override
                                protected String doInBackground(String... params) {

                                    String plantHolder = tempPlant ;
                                    String latitudeHolder = tempLat ;
                                    String longitudeHolder = tempLong;

                                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                                    nameValuePairs.add(new BasicNameValuePair("plant", plantHolder));
                                    nameValuePairs.add(new BasicNameValuePair("latitude", latitudeHolder));
                                    nameValuePairs.add(new BasicNameValuePair("longitude", longitudeHolder));
                                    try {
                                        HttpClient httpClient = new DefaultHttpClient();

                                        HttpPost httpPost = new HttpPost(ServerURL);

                                        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                                        HttpResponse httpResponse = httpClient.execute(httpPost);

                                        HttpEntity httpEntity = httpResponse.getEntity();


                                    } catch (ClientProtocolException e) {

                                    } catch (IOException e) {

                                    }
                                    return "Data Inserted Successfully";
                                }

                                @Override
                                protected void onPostExecute(String result) {

                                    super.onPostExecute(result);

                                 //   Toast.makeText(Identify.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

                                }
                            }

                            SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

                            sendPostReqAsyncTask.execute(tempPlant, tempLat, tempLong);

                        } else {

//                            Toast.makeText(MapsSpecific.this, "Current location not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        } catch (SecurityException e) {
//            Log.d(TAG, e.getMessage());

        }

return;
    }

    private void initTensorFlowAndLoadModel() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    classifier = TensorFlowImageClassifier.create(
                            getAssets(),
                            MODEL_FILE,
                            LABEL_FILE,
                            INPUT_SIZE,
                            IMAGE_MEAN,
                            IMAGE_STD,
                            INPUT_NAME,
                            OUTPUT_NAME);
                       classifier2 = TensorFlowImageClassifier.create(
                          getAssets(),
                         MODEL_FILE2,
                         LABEL_FILE2,
                         INPUT_SIZE,
                          IMAGE_MEAN,
                          IMAGE_STD,
                          INPUT_NAME,
                         OUTPUT_NAME);
                } catch (final Exception e) {
                    throw new RuntimeException("Error initializing TensorFlow!", e);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
//        Intent intent = new Intent(Identify.this, MainActivity.class);
//        startActivity(intent);
        finish();
    }
}

//Bayabas