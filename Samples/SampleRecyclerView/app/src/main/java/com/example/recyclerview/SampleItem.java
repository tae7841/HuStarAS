package com.example.recyclerview;

public class SampleItem {
    private int imageResource;
    private String text1;
    private String text2;

    public SampleItem(int imageResource, String text1, String text2) {
        this.imageResource = imageResource;
        this.text1 = text1;
        this.text2 = text2;
    }

    public void changeText1(String text) {
        this.text1 = text;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }
}
