package org.joy.parcel;

import android.os.Parcel;
import android.os.Parcelable;

public class BookData implements Parcelable {
    private String title;
    private int price;

    public BookData(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public BookData(Parcel src) {
        title = src.readString();
        price = src.readInt();
    }

    public void setTitle(String title) {  this.title = title;  }

    public void setPrice(int price) {  this.price = price;  }

    public String getTitle() {  return title;  }

    public int getPrice() {  return price;  }

    public static final Creator<BookData> CREATOR = new Creator<BookData>() {
        public BookData createFromParcel(Parcel src) {
            return new BookData(src);
        }

        public BookData[] newArray(int size) {
            return new BookData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeInt(price);
    }
}
