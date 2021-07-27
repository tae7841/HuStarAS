package org.joy.placeholder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static android.transition.TransitionManager.beginDelayedTransition;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    private Placeholder placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        placeholder = findViewById(R.id.placeholder);
    }

    public void swapView(View view) {
        Log.d("HuStar", "swapView(): " + view.getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            beginDelayedTransition(layout);
        }

        placeholder.setContentId(view.getId());
    }
}