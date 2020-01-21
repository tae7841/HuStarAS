package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmap;
    Boolean image1_displayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        scrollView = findViewById(R.id.scrollView);
        scrollView.setHorizontalScrollBarEnabled(true);
        display_image();
    }

    public void onButtonClicked(View view) {
        display_image();
    }

    private void display_image() {
        Resources res = getResources();
        if (image1_displayed) {
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);
            image1_displayed = false;
        } else {
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
            image1_displayed = true;
        }
        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmap.getIntrinsicWidth();
        imageView.getLayoutParams().height = bitmap.getIntrinsicHeight();
    }
}
