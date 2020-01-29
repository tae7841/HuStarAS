package com.example.samplelifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText greetings;
    final static String PREF_KEY = "greet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // greetings = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        println("onCreate 호출됨");
    }

    @Override
    protected void onStart() {
        super.onStart();
        println("OnStart 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        println("onStop 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        println("onDestroy 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();
        println("onPause 호출됨");
        // saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        println("onResume 호출됨");
        // restoreState();
    }

    public void println(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        Log.d("Hustar", msg);
    }

    protected void restoreState() {
        Log.d("Hustar", ">restoreState");

        SharedPreferences pref = getSharedPreferences(PREF_KEY , Activity.MODE_PRIVATE);
        if (pref.contains("greet")) {
            String msg = pref.getString(PREF_KEY, "");
            greetings.setText(msg);
            Log.d("Hustar", " restoreState msg:" + msg);
        }
        Log.d("Hustar", "<restoreState");
    }

    protected void saveState() {
        Log.d("Hustar", ">saveState");
        String msg = greetings.getText().toString().trim();
        if (msg.length() > 0) {
            SharedPreferences pref = getSharedPreferences(PREF_KEY , Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit().clear();
            editor.putString(PREF_KEY, msg);
            editor.commit();
        }
        Log.d("Hustar", "<saveState msg=" + msg);
    }

    protected void clearState() {
        Log.d("Hustar", ">clearState");
        SharedPreferences pref = getSharedPreferences(PREF_KEY , Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit().clear();
        editor.commit();
        Log.d("Hustar", "<clearState");
    }

}
