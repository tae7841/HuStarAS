package org.joy.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText editTextx, editTexty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextx = findViewById(R.id.editTextx);
        editTexty = findViewById(R.id.editTexty);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        View view = findViewById(R.id.constraintlayout);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                float curX = motionEvent.getX();
                float curY = motionEvent.getY();
                if (action == MotionEvent.ACTION_DOWN ||
                        action == MotionEvent.ACTION_MOVE) {
                    show_xy(curX, curY);
                } else if (action == MotionEvent.ACTION_UP) {
                    show_xy(curX, curY);
                    toastButtonClicked(view);
                }
                return true;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastButtonClicked(v);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbarButtonClicked(v);
            }
        });
    }

    public void show_xy(float curX, float curY) {
        editTextx.setText(String.valueOf(Math.round(curX)));
        editTexty.setText(String.valueOf(Math.round(curY)));
    }

    public void toastButtonClicked(View v) {
        try {
            String msg = "Toast: " + editTextx.getText().toString() + ", " + editTexty.getText().toString();
            Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);

            int x = Integer.parseInt(editTextx.getText().toString());
            int y = Integer.parseInt(editTexty.getText().toString());
            toast.setGravity(Gravity.TOP|Gravity.LEFT, x, y);
            toast.show();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void snackbarButtonClicked(View v) {
        Snackbar.make(v, "Welcome to my snackbar!", Snackbar.LENGTH_LONG).show();
    }
}