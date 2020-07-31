package org.joy.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RelativeLayout simpleRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the reference of RelativeLayout
        simpleRelativeLayout = (RelativeLayout) findViewById(R.id.simpleRelativeLayout);
        // set the layout params for ImageView
        RelativeLayout.LayoutParams imageViewParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        // create a new ImageView
        ImageView simpleImageView = new ImageView(this);
        simpleImageView.setId(View.generateViewId());  // set ImageView's id
        simpleImageView.setLayoutParams(imageViewParam); // set defined layout params to ImageView
        simpleImageView.setImageResource(R.drawable.home);    // set resource in ImageView
        simpleImageView.setBackgroundColor(Color.BLACK); // set black color in the background of ImageView
        imageViewParam.addRule(RelativeLayout.CENTER_HORIZONTAL); // align ImageView in the center
        simpleRelativeLayout.addView(simpleImageView); // add ImageView in RelativeLayout

        // set the layout params for Button
        RelativeLayout.LayoutParams buttonParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        Button myButton = new Button(this);  // create a new Button
        myButton.setText("Dynamic Button"); // set Text in the Button
        myButton.setLayoutParams(buttonParam); // set defined layout params to Button
        myButton.setTextColor(Color.WHITE); // set white color for the text of Button
        myButton.setBackgroundColor(Color.parseColor("#95C03C")); // set Button's background color
        buttonParam.addRule(RelativeLayout.BELOW, 1); // set Button to the below of ImageView
        simpleRelativeLayout.addView(myButton); // add Button in RelativeLayout
        // perform setOnClickListener event
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display a toast on Button click
                Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

    /*******
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    ***********/
}