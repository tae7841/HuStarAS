package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final int timer = 10;
    private volatile boolean stopThread;
    EditText editText;
    Button button_start;
    Button button_stop;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, ">onCreate: ");

        editText= findViewById(R.id.editText);
        button_start = findViewById(R.id.button_start);
        button_start.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Log.d(TAG, "onClick: start");
                  button_start.setEnabled(false);
                  button_stop.setEnabled(true);
                  stopThread = false;
                  int timer_in_text = Integer.parseInt(editText.getText().toString());
                  if (timer_in_text == 0)
                      timer_in_text = timer;

                  SampleThread thread = new SampleThread(timer_in_text);
                  thread.start();
              }
        });
        
        button_stop = findViewById(R.id.button_stop);
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopThread = true;
                Log.d(TAG, "onClick: stop");
                if (Integer.parseInt(editText.getText().toString()) == 0)
                    editText.setText("" + timer);
                button_stop.setEnabled(false);
                button_start.setEnabled(true);
            }
        });

        button_stop.setEnabled(false);
        Log.d(TAG, "<onCreate: ");
    }

    class SampleThread extends Thread {
        int seconds;

        public SampleThread(int timer) {
            this.seconds = timer;
        }

        @Override
        public void run() {
            Log.d(TAG, "SampleThread run: starts");
            while (seconds != 0) {
                if (stopThread) return;

                try {
                    Thread.sleep(1000);
                } catch(Exception e) {}
                
                seconds -= 1;
                Log.d(TAG, "run: " + seconds);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        editText.setText("" + seconds);
                    }
                });
            }
        }
    }
}
