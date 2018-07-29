package com.example.gahallon.app2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Unidentified extends AppCompatActivity {
    private ImageButton btnCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unidentified);
        btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIdentify();
            }
        });

}
    public void openIdentify(){

        Intent intent = new Intent(this, Identify.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
//        Intent intent = new Intent(Identify.this, MainActivity.class);
//        startActivity(intent);
        finish();
    }

}
