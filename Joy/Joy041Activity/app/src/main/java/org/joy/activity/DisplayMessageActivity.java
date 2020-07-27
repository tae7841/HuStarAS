package org.joy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, ">DisplayMessageActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Log.d(TAG, " getIntent");
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Log.d(TAG, " setText");
        // your code here: Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        Log.d(TAG, "<DisplayMessageActivity");

    }

}