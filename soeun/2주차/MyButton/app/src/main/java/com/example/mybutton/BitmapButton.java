package com.example.mybutton;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class BitmapButton extends AppCompatButton {

    public BitmapButton(@NonNull Context context) {
        super(context);

        init(context);
    }

    public BitmapButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        setBackgroundResource(R.drawable.ic_launcher_foreground);

        float textSize = getResources().getDimension(R.dimen.text_size);
        setTextSize(100);
        setTextColor(Color.BLUE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        switch(action) {
            case MotionEvent.ACTION_DOWN:
                setBackgroundResource(R.drawable.ic_launcher_background);
                break;
            case MotionEvent.ACTION_UP:
                setBackgroundResource(R.drawable.ic_launcher_foreground);
                break;
        }

        invalidate();
        return true;
    }

}
