package com.example.task1to_dolistapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class splash_activity extends AppCompatActivity {

   /* ImageView imageView;*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.splash_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ihome=new Intent(splash_activity.this,Welcome_screen.class);
                startActivity(ihome);
                finish();

            }
        },3000);









       /* imageView = findViewById(R.id.your_image_view);

        Glide.with(this)
                .load("https://images.alphacoders.com/608/608245.jpg")
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);*/


    }
}