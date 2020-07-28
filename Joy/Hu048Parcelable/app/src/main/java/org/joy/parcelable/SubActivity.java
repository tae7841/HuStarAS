package org.joy.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import static org.joy.parcelable.MainActivity.GAL_220;
import static org.joy.parcelable.MainActivity.GOOD_NEWS;
import static org.joy.parcelable.MainActivity.JOHN_316;
import static org.joy.parcelable.MainActivity.TAG;

public class SubActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, ">SubActivity: onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String snackbar_msg = "";

        Intent intent = getIntent();
        if(intent != null){
            Log.d(TAG, "SubActivity: got intent");
            // Parcelable 객체는 Serializable 보다 좀 더 메모리 용량을 적게 차지한다.
            // SimpleData 와 같이 직접 정의하는 객체들은 Parcelable 인터페이스를 구현한 후 부가데이터로 추가한다.
            SimpleData data = intent.getParcelableExtra(JOHN_316);
            if(data != null){
                snackbar_msg = data.number + ", " + data.message;
                Snackbar.make(button.getRootView(), snackbar_msg, Snackbar.LENGTH_INDEFINITE).show();
                Log.d(TAG, "SubActivity " + snackbar_msg);
            }

            // ArrayList 와 같은 객체들은 이미 Serializable 인터페이스를 구현하고 있어 그대로 부가데이터로 추가할 수 있다.
            ArrayList<String> list = (ArrayList<String>) intent.getSerializableExtra(GOOD_NEWS);
            if(list != null){
                String msg = "";
                for (String x: list) {
                    msg += x + " ";
                }
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                Log.d(TAG, "SubActivity - ArrayList: " + msg);
            }

            BriefData nibc = (BriefData) intent.getSerializableExtra(GAL_220);
            if(nibc != null){
                snackbar_msg += "   " + nibc.number + ", " + nibc.message;
                Snackbar.make(button.getRootView(), snackbar_msg, Snackbar.LENGTH_INDEFINITE).show();
                Log.d(TAG, "SubActivity " + snackbar_msg);
            }
        }
        Log.d(TAG, "<SubActivity: onCreate");
    }
}