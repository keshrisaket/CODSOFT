package com.example.task1to_dolistapp;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.dashboard_screen);

        imageView = findViewById(R.id.your_image_view);

        Glide.with(this)
                .load("https://images.alphacoders.com/608/608245.jpg")
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);


    }
}