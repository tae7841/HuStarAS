package org.joy.activity;

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

    /** Called when the user taps the Send button 1 */
    public void sendMessage(View view) {
        Log.d(TAG, ">sendMessage");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);

        EditText et = null;
        switch(view.getId()) {
            case R.id.button:
                et = findViewById(R.id.editText);
                break;
            case R.id.button2:
                et = findViewById(R.id.editText2);
                break;
            default:
                break;
        }

        intent.putExtra(EXTRA_MESSAGE, et.getText().toString());
        startActivity(intent);
        Log.d(TAG, "<sendMessage");
    }
}