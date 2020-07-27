package org.joy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";
    public static final String EXTRA_MESSAGE = "org.joy.activity.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button 1 */
    public void sendMessage(View view) {
        Log.d(TAG, ">sendMessage");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        intent.putExtra(EXTRA_MESSAGE, editText.getText().toString());
        startActivity(intent);
        Log.d(TAG, "<sendMessage");
    }

    /** Called when the user taps the Send button 2 */
    public void sendMessage2(View view) {
        Log.d(TAG, ">sendMessage");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText2);
        intent.putExtra(EXTRA_MESSAGE, editText.getText().toString());
        startActivity(intent);
        Log.d(TAG, "<sendMessage");
    }
}