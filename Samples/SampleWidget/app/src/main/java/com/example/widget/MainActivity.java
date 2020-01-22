package com.example.widget;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RadioButton radioButton;
    RadioGroup radioGroup;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.greeting, Toast.LENGTH_LONG).show();
                Snackbar.make(v, R.string.my_confession, Snackbar.LENGTH_LONG).show();
            }
        });
        */

        radioButton = findViewById(R.id.radioButton);  // for initialization
        radioButton.setChecked(true);                  // initial condition

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                display_message();
            }
        });

        checkBox = (CheckBox) findViewById(R.id.checkBox) ; // for initialization
        checkBox.setChecked(true) ;                         // initial condition

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display_message();
            }
        });

        display_message();
    }

    private void display_message() {
        String checkBoxMsg = "";

        if (checkBox.isChecked()) {
            Log.d("Hustar", "checkbox is Checked");
            checkBoxMsg = checkBox.getText().toString();
        }
        Log.d("Hustar", "checkbox text: " + checkBoxMsg);

        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);

        String msg = radioButton.getText() + "  " + checkBoxMsg;
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}