package com.example.myframelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ImageView;
    ImageView ImageView2;
    int Index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView = (ImageView) findViewById(R.id.imageView);
        ImageView2 = (ImageView) findViewById(R.id.imageView3);
    }

    public void onButton1Clicked(View v) {
        Index += 1;
        if(Index >1){
            index=0;
        }

        if(Index == 0){
            ImageView.setVisibility(View.VISIBLE);
            ImageView.setVisibility(View.INVISIBLE);
        }
        else if(Index == 0){
            ImageView.setVisibility(View.INVISIBLE);
            ImageView.setVisibility(View.VISIBLE);
        }
    }
}