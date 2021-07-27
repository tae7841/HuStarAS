package org.joy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoyActivity.class);
                startActivity(intent);
            }
        });
        */
        button.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), JoyActivity.class)));
        println("onCreate() called");
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    @Override
    protected void onStart() {
        super.onStart();
        println("onStart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        println("onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        println("onDestroy() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        println("onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        println("onResume() called");
    }

    public void println(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        Log.d(TAG, msg);
    }
}