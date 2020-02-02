package com.example.samplebindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    // LocalBinder를 사용하는 IBinder 변수 생성
    IBinder mBinder = new LocalBinder();

    private int number;
    private String TAG = "Service";

    public MyService() {
    }

    // LocalBinder 생성
    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    // return 값 변경
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    // onCreate 생성
    // number 0으로 초기화
    // Log 추가
    public void onCreate() {
        this.number = 0;
        Log.d(TAG, " onCreate: number = " + this.number);
    }


    // getNumber 생성
    public int getNumber() {
        return number += 1;
    }
}
