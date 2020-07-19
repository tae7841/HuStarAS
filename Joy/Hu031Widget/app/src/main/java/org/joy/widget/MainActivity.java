package org.joy.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    TextView textView, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                show_greeting(v);
            }
        });
        textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                show_my_greeting(v);
            }
        });
    }

    public void show_greeting(View v) {
        Toast.makeText(getApplicationContext(), R.string.greeting, Toast.LENGTH_LONG).show();
    }
    public void show_my_greeting(View v) {
        Snackbar.make(v, R.string.my_greeting, Snackbar.LENGTH_LONG).show();
    }
}