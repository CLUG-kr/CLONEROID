# π’ (3μ£Όμ°¨) μ€ν°λ μΌμ§

> #### μμ±μ : λ°μμ
>
> #### μμ± λ μ§ : 2021.10.06
>
> #### μ°Έμ¬μ : μ±μΉν, μ λ―Όμ

## β μ΄λ²μ£Ό κ³΅λΆ λ΄μ© : 3. νλ©΄ μ¬λ¬ κ° λ§λ€κΈ°

### βΆοΈ νλ‘μ νΈC. νμ€ν νλ©΄ μ ν

νλ©΄ μ¬λ¬ κ° λ§λ€κΈ°

1) νμ€ν μμ±νκΈ°, νμ€ν λͺ¨λλ³΄κΈ°λ₯Ό μν νλ©΄μ λ§λ­λλ€.

νλ©΄ λ μ΄μμ κ΅¬μ±μ μλ κ·Έλ¦Όμ μ°Έμ‘°νμΈμ.
2) μνμμΈ νλ©΄μ βμμ±νκΈ°β λ²νΌμ λλ₯΄λ©΄ νμ€ν μμ±νκΈ° νλ©΄μ λμ λ€κ° λμμ€λ κΈ°λ₯μ λ§λ­λλ€.

3) μνμμΈ νλ©΄μ βλͺ¨λλ³΄κΈ°β λ²νΌμ λλ₯΄λ©΄ νμ€ν λͺ¨λλ³΄κΈ° νλ©΄μ λμ λ€κ° λμμ€λ κΈ°λ₯μ λ§λ­λλ€.

### βΆοΈ μ½λ

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



        // μ μ₯ λ²νΌ
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ID
                editText2 = (EditText) findViewById(R.id.editTextTextPersonName2);
                String ID = editText2.getText().toString();

                // μλ ₯ν λ¦¬λ·°
                editText = (EditText) findViewById(R.id.editTextTextPersonName);
                String review = editText.getText().toString();

                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                intent.putExtra("review", review);
                intent.putExtra("ID", ID);
                startActivity(intent);

                finish();
            }
        });

        //  μ·¨μ λ²νΌ
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

## π Git (κ³΅λΆν μμ€μ½λ κ³΅μ )

| μμ±μ |           μ£Όμ            |
| :----: | :-----------------------: |
|  μ±μΉν  | https://github.com/CLUG-kr/CLONEROID/tree/main/%EC%B1%84%EC%8A%B9%ED%9B%88 |
|  λ°μμ  | https://github.com/CLUG-kr/CLONEROID/tree/main/%EB%B0%95%EC%86%8C%EC%9D%80 |
|  μ λ―Όμ  | https://github.com/CLUG-kr/CLONEROID/tree/main/%EC%A0%84%EB%AF%BC%EC%84%9D |