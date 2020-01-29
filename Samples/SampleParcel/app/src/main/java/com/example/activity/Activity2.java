package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

import static com.example.activity.MainActivity.TO_UPPER;

public class Activity2 extends AppCompatActivity {
    String received = "";
    String sending = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);


        Slidr.attach(this);


        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        Button button = findViewById(R.id.button);

        Intent intent = getIntent();
        received = intent.getStringExtra(TO_UPPER);
        textView.setText("Received: " + received);

        sending = received.toUpperCase();
        textView2.setText("Sending: " + sending);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(TO_UPPER, sending);
                setResult(RESULT_OK, intent);
                finish();
                // overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    /*
    @Override
    public void finish() {
        Log.d("Hustar", ">finish override");
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        Log.d("Hustar", "<finished override");
    }
    */
}
