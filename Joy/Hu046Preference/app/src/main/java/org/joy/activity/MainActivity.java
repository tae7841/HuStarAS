package org.joy.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String UPPER_SERVICE = "org.joy.activity.UPPER_SERVICE";
    public static final int REQUEST_CODE_MENU = 101;
    TextView textView2;
    static final String TAG = "HuStar";
    static final String PREF_KEY = "greet";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        textView2 = findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                intent.putExtra(UPPER_SERVICE, editText.getText().toString());
                // startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE_MENU);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        Log.d(TAG, "onCreate() called");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MENU) {
            Toast.makeText(getApplicationContext(), "requestCode: " + requestCode +
                    ", resultCode" + resultCode, Toast.LENGTH_LONG).show();
            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra(UPPER_SERVICE);
                textView2.setText("Received: " + item);
            }
        }
    }

    protected void saveState() {
        Log.d(TAG, "saveState()");
        String msg = editText.getText().toString().trim();
        if (msg.length() > 0) {
            SharedPreferences pref = getSharedPreferences(PREF_KEY , Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit().clear();
            editor.putString(PREF_KEY, msg);
            editor.commit();
            Log.d(TAG, " saved msg: " + msg);
        }
        Log.d(TAG, "saveState() ends");
    }

    protected void restoreState() {
        Log.d(TAG, "restoreState()");
        SharedPreferences pref = getSharedPreferences(PREF_KEY , Activity.MODE_PRIVATE);
        if (pref.contains(PREF_KEY)) {
            String msg = pref.getString(PREF_KEY, "");
            editText.setText(msg);
            Log.d(TAG, " restored msg: " + msg);
        }
        Log.d(TAG, "restoreState() ends");
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreState();
        Log.d(TAG, "onResume() ends");
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveState();
        Log.d(TAG, "onPause() ends");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() ends");
    }
}