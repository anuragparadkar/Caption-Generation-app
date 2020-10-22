package com.example.cg3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Activity4 extends AppCompatActivity {
    ImageButton imagebutton1 = (ImageButton) findViewById(R.id.imagebuttongal);
    ImageButton imageButton2 = (ImageButton) findViewById(R.id.imagebuttoncam);
    public Button button5;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        imagebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Activity4.this, Activity5.class);
                startActivity(intent3);

            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(Activity4.this, Activity6.class);
                startActivity(intent4);
             }
         });
}
}