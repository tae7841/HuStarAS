package org.joy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final static String PREF_KEY = "greet";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                intent.putExtra("toUpperService", editText.getText().toString());
                startActivity(intent);
            }
        });
        Log.d("Hustar", "><MainActivity:onCreate");
    }

    protected void saveState() {
        Log.d("Hustar", ">saveState");
        String msg = editText.getText().toString().trim();
        if (msg.length() > 0) {
            SharedPreferences pref = getSharedPreferences(PREF_KEY , Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit().clear();
            editor.putString(PREF_KEY, msg);
            editor.commit();
        }
        Log.d("Hustar", "<saveState msg=" + msg);
    }

    protected void restoreState() {
        Log.d("Hustar", ">restoreState");

        SharedPreferences pref = getSharedPreferences(PREF_KEY , Activity.MODE_PRIVATE);
        if (pref.contains("greet")) {
            String msg = pref.getString(PREF_KEY, "");
            editText.setText(msg);
            Log.d("Hustar", " restoreState msg:" + msg);
        }
        Log.d("Hustar", "<restoreState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreState();
        Log.d("Hustar", "<restoreState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveState();
        Log.d("Hustar", "<saveState");
    }
}