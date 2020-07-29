package org.joy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ListFragment extends Fragment {
    public static final String TAG = "HuStar";

    public static interface ImageSelectable {
        public void onImageSelected(int position);
    }
    public ImageSelectable callback;              // interface를 구현한 객체를 저장할 것임

    @Override
    public void onAttach(Context context) {       // ImageSelectable을 구현학 객체를 찾음
        super.onAttach(context);
        if (context instanceof ImageSelectable) {  // ImageSelectable을 구현한 객체이면
            callback = (ImageSelectable) context;  // listener를 등록함.
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, ">onCreateView");
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

        Button button1 = rootView.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onImageSelected(0);
            }
        });

        Button button2 = rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onImageSelected(1);
            }
        });

        Button button3 = rootView.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onImageSelected(2);
            }
        });
        Log.d(TAG, "<onCreateView");
        return rootView;
    }
}