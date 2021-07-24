package org.joy.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    CheckBox checkBox;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("HuStar", "onCreate()");
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        checkBox = findViewById(R.id.checkBox);
        textView2 = findViewById(R.id.textView2);

        //// to make genesis preselected ///////////////////
        RadioButton genesis = (RadioButton) findViewById(R.id.radioButton);
        genesis.setChecked(true);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                show_message();
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_message();
            }
        });

        show_message();
        Log.d("HuStar", "onCreate() ends");
    }

    public void show_message() {
        //// this will work if and only if one radio button is preselected
        Log.d("HuStar", "show_message()");
        int radioId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(radioId);

        String msg = "Your choice: " + radioButton.getText().toString();
        if (checkBox.isChecked())
            msg += " " + checkBox.getText().toString();
        else
            msg += " One Hour";
        textView2.setText(msg);
        Log.d("HuStar", "show_message() ends:" + msg);
    }
}