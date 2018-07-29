package com.example.gahallon.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.bumptech.glide.Glide;

public class PlantSpecific extends AppCompatActivity {


    private ImageView ivImg;
    private String value;
    private String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_specific);

        ivImg = findViewById(R.id.ivImg);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");
            //The key argument here must match that used in the other activity
        }
        Log.d("HERE", String.valueOf(value));
        URL = "http://206.189.209.210/images/" +value+".jpg";

        GlideApp.with(this)
                .load(URL)
                .into(ivImg);
    }
}
