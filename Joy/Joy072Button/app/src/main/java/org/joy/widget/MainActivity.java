package org.joy.widget;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

// https://abhiandroid.com/ui/dynamic-relativelayout-params-programmatically.html

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1st button
        HuButton buttonFaith = new HuButton(this);
        buttonFaith.setText("Walk by Faith");
        buttonFaith.setId(View.generateViewId());
        LayoutParams paramsFaith = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        paramsFaith.setMargins(16, 16, 16, 16);
        paramsFaith.addRule(RelativeLayout.CENTER_IN_PARENT);
        buttonFaith.setPadding(32, 32, 32, 32);
        buttonFaith.setLayoutParams(paramsFaith);

        RelativeLayout layout = findViewById(R.id.relativelayout_simple);
        layout.addView(buttonFaith);

        // 2nd button
        HuButton buttonSight = new HuButton(this);
        buttonSight.setText("Not by Sight");
        LayoutParams paramsSight = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        paramsSight.addRule(RelativeLayout.BELOW, buttonFaith.getId());
        paramsSight.addRule(RelativeLayout.CENTER_HORIZONTAL, buttonFaith.getId());
        buttonSight.setPadding(32, 32, 32, 32);
        buttonSight.setTextSize((float) 24);
        buttonSight.setLayoutParams(paramsSight);

        layout.addView(buttonSight);
    }
}