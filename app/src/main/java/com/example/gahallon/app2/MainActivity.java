package com.example.gahallon.app2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton captureHome;
    private ImageButton databaseHome;
    private ImageButton mapHome;
    private ImageButton aboutHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView toolbarTitle = findViewById(R.id.toolbar_title);
////        Typeface face = Typeface.createFromAsset(getAssets(),
////                "fonts/Cocogoose.ttf");
//        toolbarTitle.setTypeface(face);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        captureHome = findViewById(R.id.captureHome);

        captureHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Identify.class);
                startActivity(intent);
            }
        });

        databaseHome = findViewById(R.id.databaseHome);

        databaseHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Database.class);
                startActivity(intent);
            }
        });

        mapHome = findViewById(R.id.mapHome);

        mapHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, Maps.class);
                startActivity(intent);
            }
        });

        aboutHome = findViewById(R.id.aboutHome);

        aboutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, About.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
