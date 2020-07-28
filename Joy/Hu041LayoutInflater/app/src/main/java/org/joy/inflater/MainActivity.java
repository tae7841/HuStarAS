package org.joy.inflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pressmeButton = findViewById(R.id.pressme_button);
        pressmeButton.setOnClickListener( (v) -> {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        });
    }
}