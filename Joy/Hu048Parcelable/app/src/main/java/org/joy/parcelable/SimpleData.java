package org.joy.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

// Parcel 은 SimpleData 안에 데이터를 다른 곳에 전달할 때 사용되는 객체이다.
public class SimpleData implements Parcelable {
    static public final String TAG = "HuStar";
    int number;
    String message;

    public SimpleData(int number, String message) {
        this.number = number;
        this.message = message;
        Log.d(TAG, "SimpleData: constructor creates: " + message);
    }

    // Parcel 에서 SimpleData 안에 들어가 있는 변수를 read 로 복원한다.
    public SimpleData(Parcel src){
        number = src.readInt();
        message = src.readString();
        Log.d(TAG, "SimpleData: constructor recovers: " + message);
    }

    // 역직렬화(바이트 스트림을 원래 데이터 객체로 변환)할 때 사용되어진다.
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        // 필수 메서드. parcel된 데이터를 다시 원래대로 만들어 준다.
        public SimpleData createFromParcel(Parcel src){
            Log.d(TAG, "SimpleData: CREATOR ");
            return new SimpleData(src);
        }

        // 필수 메서드. Parcel.createTypeArray()를 호출했을때 불린다.
        public SimpleData[] newArray(int size){
            return new SimpleData[size];
        }
    };

    // Parcel의 내용을 기술한다.
    // FileDescriptor 같은 특별한 객체가 들어가면 이 부분을 통해서 알려줘야한다.
    // 보통은 0을 리턴해준다.
    @Override
    public int describeContents() {
        return 0;
    }

    // SimpleData 를 Parcel 로 바꾼다. (Parcel 안에 데이터를 넣는다.)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);  //number 값을 write
        dest.writeString(message);  // message 값을 write
        Log.d(TAG, "SimpleData: writeParcel ");
    }
}
