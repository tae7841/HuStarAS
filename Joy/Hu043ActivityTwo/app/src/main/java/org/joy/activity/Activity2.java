package org.joy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static org.joy.activity.MainActivity.UPPER_SERVICE;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);

        Intent intent = getIntent();
        String received = intent.getStringExtra(UPPER_SERVICE);
        textView.setText("Received: " + received);

        String prepared = received.toUpperCase();
        textView2.setText("Prepared: " + prepared);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(UPPER_SERVICE, prepared);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        /*******
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        */
    }
}