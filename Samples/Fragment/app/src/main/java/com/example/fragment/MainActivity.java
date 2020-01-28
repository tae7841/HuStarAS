package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //orientation에 따라
        // res/layout/activity_main.xml (portrait) 또는
        // res/layout-land/activity_main.xml (landscape)가 시스템에서 자동으로 선택된다.
        setContentView(R.layout.activity_main);
    }
}
