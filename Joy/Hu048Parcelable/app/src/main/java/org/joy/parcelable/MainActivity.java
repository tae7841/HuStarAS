package org.joy.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG= "HuStar";
    public static final String GOOD_NEWS = "org.joy.activity.GOOD_NEWS";
    public static final String JOHN_316= "org.joy.activity.JOHN_316";
    public static final String GAL_220= "org.joy.activity.GAL_220";
    public static final int REQUEST_CODE = 101;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, ">onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                // Serializable 객체 이용
                ArrayList<String> list = new ArrayList<>();
                list.add("God is good");
                list.add("All the time!");
                intent.putExtra(GOOD_NEWS, list);

                // Parcelable 객체 이용
                SimpleData data = new SimpleData(316, "God loves you!");
                intent.putExtra(JOHN_316, data);

                 BriefData nibc = new BriefData(220, "Not I, but Christ");
                intent.putExtra(GAL_220, nibc);

                Log.d(TAG, " MainActivity: Request");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        Log.d(TAG, "<onCreate");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "<onNewIntent>");
    }
}

