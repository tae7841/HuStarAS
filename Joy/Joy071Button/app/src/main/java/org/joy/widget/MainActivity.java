package org.joy.widget;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
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
        LayoutParams paramsFaith = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        paramsFaith.setMargins(16, 16, 16, 16);
        buttonFaith.setPadding(32, 32, 32, 32);
        buttonFaith.setLayoutParams(paramsFaith);

        LinearLayout layout = findViewById(R.id.linearlayout_simple);
        layout.setGravity(Gravity.CENTER);
        layout.addView(buttonFaith);

        // 2nd button
        HuButton buttonSight = new HuButton(this);
        buttonSight.setText("Not by Sight");

        LayoutParams paramsSight = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        buttonSight.setLayoutParams(paramsSight);
        buttonSight.setPadding(32, 32, 32, 32);

        layout.addView(buttonSight);
    }
}