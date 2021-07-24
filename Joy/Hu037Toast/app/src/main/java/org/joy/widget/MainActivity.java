package org.joy.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
////////////////////////// method 2 /////////////////////////
public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    EditText editTextx, editTexty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextx = findViewById(R.id.editTextx);
        editTexty = findViewById(R.id.editTexty);

        Button button = findViewById(R.id.button);
        // Button button2 = findViewById(R.id.button2);

        View view = findViewById(R.id.constraintlayout);

        /*
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                int curX = (int) motionEvent.getX();
                int curY = (int) motionEvent.getY();
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
         */

        //////////// method 1 /////////////////
        /**
        MyClass obj = new MyClass();
        view.setOnTouchListener(obj);
         */

        //////////// method 2 /////////////////
        view.setOnTouchListener(this);
        //////////////////////////////////////////

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_toastsnackbar(v);
            }
        });
    }

    public void show_xy(int curX, int curY) {
        Log.d("HuStar", "show_xy x:" + curX);
        editTextx.setText("" + curX);
        editTexty.setText("" + curY);
    }

    public void show_toastsnackbar(View v) {
        String msg = editTextx.getText().toString() + ", " + editTexty.getText().toString();
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        Snackbar.make(v, msg, Snackbar.LENGTH_LONG).show();
    }

    /////////////////////// method 1 ////////////////////////////////
    /*
    private class MyClass implements View.OnTouchListener{
        public boolean onTouch(View view,MotionEvent motionEvent){
            int action=motionEvent.getAction();
                int curX = (int) motionEvent.getX();
                int curY = (int) motionEvent.getY();
            if(action==MotionEvent.ACTION_DOWN|| action==MotionEvent.ACTION_MOVE){
                show_xy(curX,curY);
            }else if(action==MotionEvent.ACTION_UP){
                show_xy(curX,curY);
                show_toastsnackbar(view);
            }
            return true;
        }
    }
    */

    ///////////////////// method 2 //////////////////////////////////
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent){
        int action=motionEvent.getAction();
        int curX = (int) motionEvent.getX();
        int curY = (int) motionEvent.getY();
        if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE)  {
            show_xy(curX,curY);
            return true;
        }else if(action==MotionEvent.ACTION_UP){
            show_xy(curX,curY);
            show_toastsnackbar(view);
        }
        return false;
    }
    //////////////////////////////////////////////////////////
}

