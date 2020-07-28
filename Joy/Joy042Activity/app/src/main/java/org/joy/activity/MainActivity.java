package org.joy.activity;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";
    public static final String EXTRA_MESSAGE = "org.joy.activity.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivity");

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(view);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(view);
            }
        });
    }

    /** Called when the user taps the Send button */
    /*
    public void sendMessage(View view) {
        Log.d("HuStar", ">sendMessage");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        Log.d("HuStar", "<sendMessage");
    }
    */

    private String getMessage(View v) {
        // EditText et = new EditText(this);
        EditText et = null;
        switch(v.getId()) {
            case R.id.button:
                et = findViewById(R.id.editText);
                break;
            case R.id.button2:
                et = findViewById(R.id.editText2);
                break;
            default:
                return "";
        }
        return et.getText().toString();
    }

    public void sendMessage(View view) {
        Log.d(TAG, ">sendMessage");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, getMessage(view));
        startActivity(intent);
        Log.d(TAG, "<sendMessage");
    }
}