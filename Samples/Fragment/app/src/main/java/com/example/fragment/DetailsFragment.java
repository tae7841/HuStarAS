package com.example.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

// 글내용을 화면에 보여주기 위한 Fragment입니다.
public class DetailsFragment extends Fragment {

    //새로운 DetailsFragment 인스턴스를 생성
    public static DetailsFragment newInstance(int index) {
        DetailsFragment f = new DetailsFragment();

        //글목록에서 선택된 항목에 대응되는 글내용을 보여줌
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ScrollView scroller = new ScrollView(getActivity()); //ScrollView 생성
        TextView text = new TextView(getActivity()); //TextView 생성
        int padding = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4, getActivity()
                        .getResources().getDisplayMetrics());
        text.setPadding(padding, padding, padding, padding);
        scroller.addView(text); //ScrollView에 TextView추가

        text.setText(Shakespeare.DIALOGUE[getShownIndex()]); //TextView에 선택된 글내용을 보여줌

        return scroller; //DetailsFragment의 root View인 ScrollView 리턴
    }
}