package com.example.receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SmsActivity extends AppCompatActivity {
    private static final String TAG = "Hustar";
    EditText editText;
    EditText editText2;
    EditText editText3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, ">onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        Log.d(TAG, " onCreate");
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        processIntent(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d(TAG, ">onNewIntent");
        super.onNewIntent(intent);
        processIntent(intent);
    }

    private void processIntent(Intent intent) {
        if (intent == null) return;
        String sender = intent.getStringExtra("sender");
        String contents = intent.getStringExtra("contents");
        String receivedDate = intent.getStringExtra("receivedDate");

        editText.setText(sender);
        editText2.setText(contents);
        editText3.setText(receivedDate);
    }
}
