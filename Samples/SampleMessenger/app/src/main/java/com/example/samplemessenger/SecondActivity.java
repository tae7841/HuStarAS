package com.example.samplemessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private TextView text01;
    private TextView text02;
    private TextView text03;
    private TextView text04;
    private TextView text05;
    private TextView text06;
    private TextView text07;
    private TextView text08;
    private EditText sendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text01 = (TextView) findViewById(R.id.textView1);
        text02 = (TextView) findViewById(R.id.textView2);
        text03 = (TextView) findViewById(R.id.textView3);
        text04 = (TextView) findViewById(R.id.textView4);
        text05 = (TextView) findViewById(R.id.textView5);
        text06 = (TextView) findViewById(R.id.textView6);
        text07 = (TextView) findViewById(R.id.textView7);
        text08 = (TextView) findViewById(R.id.textView8);
        sendMessage = (EditText) findViewById(R.id.send_message);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("message");
        text01.setText(msg);
    }
/*
    public void setMessage() {
        if (message != null) {
            if (message.size() >= 1) {
                text01.setText(message.get(0));
            }
            if (message.size() >= 2) {
                text02.setText(message.get(1));
            }
            if (message.size() >= 3) {
                text03.setText(message.get(2));
            }
            if (message.size() >= 4) {
                text04.setText(message.get(3));
            }
            if (message.size() >= 5) {
                text05.setText(message.get(4));
            }
            if (message.size() >= 6) {
                text06.setText(message.get(5));
            }
            if (message.size() >= 7) {
                text07.setText(message.get(6));
            }
            if (message.size() >= 8) {
                text08.setText(message.get(7));
            }
        }
    }
*/
    public void sendMessage(View v) {

    }
}
