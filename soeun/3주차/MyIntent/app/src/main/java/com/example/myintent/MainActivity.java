package com.example.myintent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 클릭했을 때 menu activity 띄우기
                // Intent: menu activity
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, 101); //deprecated되었다고 한다!!!
                //registerForActivityResult(intent, 101);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {   //응답을 받아주는 메소드
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101) {
            // 메뉴 화면에서 넘긴 101
            String name = data.getStringExtra("name");    //"name"이라는 키 값
            Toast.makeText(getApplicationContext(), "응답으로 전달된 name: " + name, Toast.LENGTH_LONG).show();
        }

    }
}