package joy.org.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "HuStar";
    Button button_start, button_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");
        button_start = findViewById(R.id.button_start);
        button_stop = findViewById(R.id.button_stop);

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick - startService");
                Intent intent = new Intent(getApplicationContext(), HuService.class);
                startService(intent);
            }
        });

        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick - stopService");
                Intent intent = new Intent(getApplicationContext(), HuService.class);
                stopService(intent);
            }
        });

        Log.d(TAG, "onCreate() ends");
    }
}