package com.example.myproject3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

    }

    @Override
    protected void onStart() {
        super.onStart();

        textView2 = (TextView) findViewById(R.id.textView4);
        textView = (TextView) findViewById(R.id.textView5);

        Intent intent = getIntent();
        if (intent != null) {
            String reviewText = intent.getStringExtra("review");
            String IDText = intent.getStringExtra("ID");
            textView.setText(reviewText);
            textView2.setText(IDText);
        }
    }
}