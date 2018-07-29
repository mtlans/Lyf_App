package com.example.gahallon.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;
public class Tutorial extends AppCompatActivity {
private ImageButton btnCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
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


}

