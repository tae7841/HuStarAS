package org.joy.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button drawableButton = findViewById(R.id.drawable_button);
        Switch switchEnableButton = findViewById(R.id.switch_enable_button);

        drawableButton.setOnClickListener( (View v) -> {
            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show();
        });

        switchEnableButton.setOnCheckedChangeListener( (CompoundButton view, boolean b) -> {
            if (b)
                drawableButton.setEnabled(true);
            else
                drawableButton.setEnabled(false);
        } );
    }
}