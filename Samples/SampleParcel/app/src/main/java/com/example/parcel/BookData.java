package com.example.parcel;

import android.os.Parcel;
import android.os.Parcelable;

public class BookData implements Parcelable {
    private String title;
    private int price;

    public BookData(String title, int price) {
        this.title = title;
        this.price = price;
    }

    protected BookData(Parcel in) {
        title = in.readString();
        price = in.readInt();
    }

    public static final Creator<BookData> CREATOR = new Creator<BookData>() {
        @Override
        public BookData createFromParcel(Parcel in) {
            return new BookData(in);
        }

        @Override
        public BookData[] newArray(int size) {
            return new BookData[size];
        }
    };

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(price);
    }
}

