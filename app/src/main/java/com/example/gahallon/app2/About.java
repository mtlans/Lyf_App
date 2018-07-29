package com.example.gahallon.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {

    private TextView about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        about = findViewById(R.id.about);
        about.setText("Lyf is an application prototype of an image recognition system that allows its users to identify plants by directing the phone’s camera to the found plant. Once identified, the application will then pinpoint the location of the user and indicate it in its map that determines which plant is available in what location. Along with this, the system will provide the user of the specified plant’s medicinal benefits and other miscellaneous information regarding the plant that may help the user. The plants that will be identified will revolve around the 10 medicinal plants that has been approved by the Department of Health.");
    }
}
