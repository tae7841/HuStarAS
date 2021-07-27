package org.joy.widget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ConstraintLayout layout;
    private Placeholder placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println(">onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        placeholder = findViewById(R.id.placeholder);

        ImageView  bike= findViewById(R.id.bike);
        bike.setOnClickListener(this);

        ImageView  bus= findViewById(R.id.bus);
        bus.setOnClickListener(this);

        ImageView  flight= findViewById(R.id.flight);
        flight.setOnClickListener(this);

        ImageView  taxi= findViewById(R.id.taxi);
        taxi.setOnClickListener(this);

        ImageView  truck= findViewById(R.id.truck);
        truck.setOnClickListener(this);
    }

    public void swapView(View view) {
        Log.d("HuStar", "swapView(): " + view.getId());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(layout);
        }
        placeholder.setContentId(view.getId());
    }

    @Override
    public void onClick(View view) {
            swapView(view);
        }
}

