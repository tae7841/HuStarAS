package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.activity.R;

import static com.example.activity.MainActivity.toUpper;

public class Activity2 extends AppCompatActivity {
    String received = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        Intent intent = getIntent();
        received = intent.getStringExtra(toUpper);
        textView.setText("Received: " + received);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
