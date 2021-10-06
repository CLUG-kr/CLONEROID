package com.example.myproject3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // 저장 버튼
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ID
                editText2 = (EditText) findViewById(R.id.editTextTextPersonName2);
                String ID = editText2.getText().toString();

                // 입력한 리뷰
                editText = (EditText) findViewById(R.id.editTextTextPersonName);
                String review = editText.getText().toString();

                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                intent.putExtra("review", review);
                intent.putExtra("ID", ID);
                startActivity(intent);

                finish();
            }
        });

        //  취소 버튼
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}