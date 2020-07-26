package org.joy.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button reddotButton = findViewById(R.id.reddot_button);
        Switch switchEnableButton = findViewById(R.id.switch_enable_button);

        /**
        reddotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });

        switchEnableButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                switchClicked(b);
            }
        });
         */

        // v can be omitted since it is unused
        reddotButton.setOnClickListener( (view) -> {
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
        });

        // view can be omitted since it is unused
        switchEnableButton.setOnCheckedChangeListener( (view, b)  -> {
            if (b)
                reddotButton.setEnabled(true);
            else
                reddotButton.setEnabled(false);
        });
    }

    /*
    public void switchClicked(boolean b) {
        if (b)
            reddotButton.setEnabled(true);
        else
            reddotButton.setEnabled(false);
    }
    */
}