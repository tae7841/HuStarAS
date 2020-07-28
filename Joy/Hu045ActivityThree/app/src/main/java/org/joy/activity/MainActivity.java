package org.joy.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";
    public static final String UPPER_SERVICE = "org.joy.activity.UPPER_SERVICE";
    public static final int REQUEST_CODE_MENU = 101;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                intent.putExtra(UPPER_SERVICE, editText.getText().toString());
                // startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MENU) {
            Toast.makeText(getApplicationContext(), "requestCode: " + requestCode +
                    ", resultCode" + resultCode, Toast.LENGTH_LONG).show();
            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra("toUpperService");
                textView2.setText("Received: " + item);
            }
        }
    }
}