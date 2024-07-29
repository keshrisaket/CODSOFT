package com.example.task2quoteofthedayapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.splash_screen);

      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent inext=new Intent(MainActivity.this, Dashboard.class);
              startActivity(inext);
              finish();
          }
      },2500);

    }
}