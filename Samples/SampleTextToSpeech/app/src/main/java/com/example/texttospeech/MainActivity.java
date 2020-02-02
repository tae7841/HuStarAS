package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech TTS;

    private EditText editText;
    private SeekBar seekbarPitch;
    private SeekBar seekbarSpeed;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        TTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = TTS.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA ||
                            result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language is not supported");
                    }
                    else {
                        button.setEnabled(true);
                    }
                }
                else {
                    Log.e("TTS", "TTS Initialization failed");
                }
            }
        });

        editText = findViewById(R.id.editText);
        seekbarPitch = findViewById(R.id.seekBar_pitch);
        seekbarSpeed = findViewById(R.id.seekBar_speed);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }

    private void speak() {
        String text = editText.getText().toString();

        float pitch = (float) seekbarPitch.getProgress() / 50;
        if (pitch < 0.1) pitch = 0.1f;
        TTS.setPitch(pitch);

        float speed = (float) seekbarSpeed.getProgress() / 50;
        if (speed < 0.1) speed = 0.1f;
        TTS.setSpeechRate(speed);

        TTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (TTS != null) {
            TTS.stop();
            TTS.shutdown();
        }
    }
}