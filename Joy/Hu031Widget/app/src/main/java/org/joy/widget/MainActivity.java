package org.joy.widget;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_greeting(view);
            }
        });
    }

    public void show_greeting(View view) {
        textView2.setText(R.string.my_greeting);
        Toast.makeText(this, R.string.my_greeting, Toast.LENGTH_LONG).show();
        Snackbar.make(view, R.string.your_greeting, Snackbar.LENGTH_LONG).show();
    }
}