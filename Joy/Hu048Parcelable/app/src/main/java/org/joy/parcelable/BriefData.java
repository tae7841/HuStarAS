package org.joy.parcelable;

import android.util.Log;

import java.io.Serializable;

// Parcel 은 SimpleData 안에 데이터를 다른 곳에 전달할 때 사용되는 객체이다.
public class BriefData implements Serializable {
    static public final String TAG = "HuStar";
    int number;
    String message;

    public BriefData(int number, String message) {
        this.number = number;
        this.message = message;
        Log.d(TAG, "SimpleData: constructor creates: " + message);
    }
}
