package org.joy.receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SmsActivity extends AppCompatActivity {
    private static final String TAG = "HuStar";
    EditText editText_msg;
    TextView textView_num, textView_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        editText_msg = findViewById(R.id.editText_msg);
        textView_num = findViewById(R.id.textView_num);
        textView_time = findViewById(R.id.textView_time);

        Button button_ok = findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  finish();  }
        });

        processIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent()");
        processIntent(intent);
    }

    private void processIntent(Intent intent) {
        Log.d(TAG, "processIntent()");
        if (intent == null) return;

        String sender = intent.getStringExtra("sender");
        String receivedDate = intent.getStringExtra("receivedDate");
        String contents = intent.getStringExtra("contents");

        textView_num.setText(textView_num.getText().toString() + " " + sender);
        textView_time.setText(textView_time.getText().toString() + " " + receivedDate);
        editText_msg.setText(editText_msg.getText().toString() + " " + contents);

        Log.d(TAG, "processIntent() ends");
    }
}