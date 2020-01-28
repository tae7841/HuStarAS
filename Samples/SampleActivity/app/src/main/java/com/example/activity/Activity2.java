package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.activity.MainActivity.TO_UPPER;

public class Activity2 extends AppCompatActivity {
    String received = "";
    String sending = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

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
            }
        });
    }
}
