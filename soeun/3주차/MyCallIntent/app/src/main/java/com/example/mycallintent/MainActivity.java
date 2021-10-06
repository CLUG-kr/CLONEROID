package com.example.mycallintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextTextPersonName);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String receiver = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + receiver));
                startActivity(intent);  // 이 객체가 시스템쪽으로 전달된다

                Intent intent2 = new Intent();
                // menuActivity를 안 만들어서 오류가 나긴 하지만 이런 식으로도 할 수 있다,,
                ComponentName name = new ComponentName("org.techtown.callintent", "org.techtown.callintent.MenuActivity");
                intent2.setComponent(name);
                startActivity(intent2);
            }
        });
    }
}