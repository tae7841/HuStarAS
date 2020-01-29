package com.example.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.r0adkll.slidr.Slidr;

public class MainActivity extends AppCompatActivity {
    final static String TO_UPPER = "toUpperService";
    final static int REQUEST_CODE = 101;
    final static String HUSTAR = "Hustar";
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(HUSTAR, ">onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                intent.putExtra(TO_UPPER, editText.getText().toString());
                // startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);
                // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        Log.d(HUSTAR, "<onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(HUSTAR, ">onStart<");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(HUSTAR, ">onDestory<");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(HUSTAR, ">onResume<");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(HUSTAR, ">onResume<");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            Toast.makeText(getApplicationContext(),
                    "RequestCode:" + requestCode + "resultCode: " + resultCode,
                    Toast.LENGTH_LONG).show();

            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra(TO_UPPER);
                textView.setText("Received: " + item);
            }
        }
    }
}
