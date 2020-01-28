package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final static String toUpper = "toUpperService";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                intent.putExtra(toUpper, editText.getText().toString());
                startActivity(intent);
            }
        });
        */
    }

    public void openActivityTwo(View view) {
        Intent intent = new Intent(getApplicationContext(), Activity2.class);
        intent.putExtra(toUpper, editText.getText().toString());
        startActivity(intent);
    }
}
