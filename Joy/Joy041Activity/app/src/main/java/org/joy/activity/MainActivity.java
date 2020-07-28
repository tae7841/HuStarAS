package org.joy.activity;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";
    public static final String EXTRA_MESSAGE = "org.joy.activity.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "MainActivity");
    }

    public void sendMessage(View view) {
        Log.d(TAG, ">sendMessage");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        intent.putExtra(EXTRA_MESSAGE, editText.getText().toString());
        startActivity(intent);
        Log.d(TAG, "<sendMessage");
    }

    public void sendMessage2(View view) {
        Log.d(TAG, ">sendMessage2");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText2 = findViewById(R.id.editText2);
        intent.putExtra(EXTRA_MESSAGE, editText2.getText().toString());
        startActivity(intent);
        Log.d(TAG, "<sendMessage2");
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm =
                    (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}