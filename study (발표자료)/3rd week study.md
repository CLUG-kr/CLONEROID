# 📢 (3주차) 스터디 일지

> #### 작성자 : 박소은
>
> #### 작성 날짜 : 2021.10.06
>
> #### 참여자 : 채승훈, 전민석

## ✅ 이번주 공부 내용 : 3. 화면 여러 개 만들기

### ▶️ 프로젝트C. 한줄평 화면 전환

화면 여러 개 만들기

1) 한줄평 작성하기, 한줄평 모두보기를 위한 화면을 만듭니다.

화면 레이아웃 구성은 아래 그림을 참조하세요.
2) 영화상세 화면의 ‘작성하기’ 버튼을 누르면 한줄평 작성하기 화면을 띄웠다가 돌아오는 기능을 만듭니다.

3) 영화상세 화면의 ‘모두보기’ 버튼을 누르면 한줄평 모두보기 화면을 띄웠다가 돌아오는 기능을 만듭니다.

### ▶️ 코드

MainActivity class
```
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
```

ListActivity class
```
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
```

## 👊 Git (공부한 소스코드 공유)

| 작성자 |           주소            |
| :----: | :-----------------------: |
|  채승훈  | https://github.com/CLUG-kr/CLONEROID/tree/main/%EC%B1%84%EC%8A%B9%ED%9B%88 |
|  박소은  | https://github.com/CLUG-kr/CLONEROID/tree/main/%EB%B0%95%EC%86%8C%EC%9D%80 |
|  전민석  | https://github.com/CLUG-kr/CLONEROID/tree/main/%EC%A0%84%EB%AF%BC%EC%84%9D |