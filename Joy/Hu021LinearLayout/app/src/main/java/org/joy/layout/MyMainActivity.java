package org.joy.layout;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        Button button1 = new Button(this);
        button1.setText("안녕하세요");
        button1.setTextSize(24);
        button1.setLayoutParams(params);
        mainLayout.addView(button1);

        Button button2 = new Button(this);
        button2.setText("God is good all the time~");
        button2.setTextSize(24);
        button2.setAllCaps(false);
        button2.setLayoutParams(params);
        mainLayout.addView(button2);

        setContentView(mainLayout);
        Log.d("HuStar", "onCreate: MyMainActivity ends");
    }
}