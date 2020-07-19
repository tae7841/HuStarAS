package org.joy.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v) {
        Toast.makeText(this, "God is good, all the time!", Toast.LENGTH_LONG).show();
    }

    public void onNaverClicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }

    public void onCallingClicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1000-1000"));
        startActivity(intent);
    }
}