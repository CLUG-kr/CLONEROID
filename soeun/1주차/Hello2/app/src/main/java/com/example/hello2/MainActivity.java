package com.example.hello2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // 설명창 띄우기: ctrl+q
    // 파라미터 보기: ctrl+p

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v) {
        Toast.makeText(getApplicationContext(), "버튼이 눌렸어요.", Toast.LENGTH_LONG).show();
        // Toast message: 잠시 떴다가 사라지는 메세지
    }

    public void onButton2Clicked(View v) {
        // 웹 띄우기
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }


}