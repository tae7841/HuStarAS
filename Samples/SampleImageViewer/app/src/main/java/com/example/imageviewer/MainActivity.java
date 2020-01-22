package com.example.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Image> imageList = new ArrayList<Image>();
    private ImageView imageView;
    private TextView textView;
    private EditText editText;
    private int preIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View 연결

        setImageList();
    }

    //파일을 List에 추가
    public void setImageList() {
        //imageList.add(new Image(R.drawable.forest_01, "forest_01"));

        setImage(preIndex);
    }

    public void setImage(int index) {
        if (imageList.size() != 0) {
            imageView.setImageResource(imageList.get(index).getId());
            textView.setText(imageList.get(index).getFileName());
        }
    }

    //Prev Button
    public void getPrevImage(View v) {

    }

    //Next Button
    public void getNextImage(View v) {

    }

    //Search Button
    public void searchImage(View v) {

    }
}