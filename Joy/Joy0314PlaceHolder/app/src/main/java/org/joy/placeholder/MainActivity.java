package org.joy.placeholder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    private Placeholder placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println(">onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        placeholder = findViewById(R.id.placeholder);

        ////////////////////// method 4 ///////////////////////////
        ImageView bus = findViewById(R.id.bus);
        bus.setOnClickListener( (view) -> {
            swapView(view);
        });

        ImageView bike = findViewById(R.id.bike);
        bike.setOnClickListener( (view) -> {swapView(view);});

        ImageView flight = findViewById(R.id.flight);
        flight.setOnClickListener( (view) -> {swapView(view);});

        ImageView taxi = findViewById(R.id.taxi);
        taxi.setOnClickListener( (view) -> {swapView(view);});

        ImageView truck = findViewById(R.id.truck);
        truck.setOnClickListener( (view) -> {swapView(view);});
    }

    public void swapView(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(layout);
        }
        placeholder.setContentId(v.getId());
    }
}