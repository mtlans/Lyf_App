package com.example.gahallon.app2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    private Button btn1;
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent1 = getIntent();
        String text = intent1.getStringExtra(Identify.PasaMoTo);

        TextView textView1 = (TextView) findViewById(R.id.textView);
        textView1.setText(text);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }
    public void openActivity2(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
