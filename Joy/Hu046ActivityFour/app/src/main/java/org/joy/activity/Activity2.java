package org.joy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);

        Intent intent = getIntent();
        String received = intent.getStringExtra("toUpperService");
        textView.setText("Received: " + received);
        final String sending = received.toUpperCase();
        textView2.setText("Sending: " + sending);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("toUpperService", sending);
                setResult(RESULT_OK, intent);
                finish();
                // overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        // overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        // overridePendingTransition(R.anim.fadeout, R.anim.fadein);
    }
}