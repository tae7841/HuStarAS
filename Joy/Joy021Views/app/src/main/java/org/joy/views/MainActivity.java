package org.joy.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("HuStar", ">onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moveImage(v);
            }
        });

        Log.d("HuStar", "<onCreate");
    }

    public void moveImage(View v) {
        Log.d("HuStar", ">onButtonClicked");
        imageView1.setImageResource(R.drawable.image01);
        imageView1.invalidate();
        Log.d("HuStar", "<onButtonClicked");
    }
}