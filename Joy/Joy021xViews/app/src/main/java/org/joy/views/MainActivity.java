package org.joy.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{
    ImageView imageView1;
    ImageView imageView2;
    boolean image_at_top = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("HuStar", ">onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moveImage(v);
            }
        });

        // moveImage(imageView1);
        Log.d("HuStar", "<onCreate");
    }

    public void moveImage(View v) {
        Log.d("HuStar", ">onButtonClicked");
        if (image_at_top) {
            imageView1.setImageResource(0);
            imageView2.setImageResource(R.drawable.image01);
            image_at_top = false;
        }
        else {
            imageView2.setImageResource(0);
            imageView1.setImageResource(R.drawable.image01);
            image_at_top = true;
        }

        imageView1.invalidate();
        imageView2.invalidate();
        Log.d("HuStar", "<onButtonClicked");
    }
}