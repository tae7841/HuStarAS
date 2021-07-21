package org.joy.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Called when the user taps the Send button 1
    public void sendMessage(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }

    // Called when the user taps the Send button 2
    public void sendMessage2(View view) {
        EditText editText = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }
}