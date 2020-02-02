package com.example.samplebindservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Hustar";

    private MyService myService;
    private boolean isService = false;
    private TextView textView;

    // ServiceConnection 변수 생성
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.LocalBinder mb = (MyService.LocalBinder) service;
            myService = mb.getService();
            isService = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isService = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        Log.d(TAG, "MainActivity: onCreate");
    }

    // bindService
    public void startService(View view) {
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, conn, this.BIND_AUTO_CREATE);
        isService = true;
    }

    // unbindService
    public void stopService(View view) {
        isService = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isService) {
            unbindService(conn);
            isService = false;
        }
    }

    // getNumber
    public void getData(View view) {
        if (isService) {
            textView.setText(myService.getNumber() + "");
        }
        else {
            textView.setText("연결된 서비스 없음");
        }
    }

    // SecondActivity 실행
    public void goSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
