package org.joy.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.edittext);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard();
                String content = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                intent.putExtra("command", "toUpper");
                intent.putExtra("content", content);
                startService(intent);
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent) {
        Log.d("HuService", ">processIntent");
        if (intent != null) {
            String command = intent.getStringExtra("command");
            String content = intent.getStringExtra("content");

            Toast toast=Toast.makeText(this, "MainActivity:\nCommand: " +
                    command + ", " + "\ncontent: " + content, Toast.LENGTH_LONG);
            //toast.getView().setBackgroundColor(Color.parseColor("#FFFF00"));
            //toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        Log.d("HuService", "<processIntent");
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}