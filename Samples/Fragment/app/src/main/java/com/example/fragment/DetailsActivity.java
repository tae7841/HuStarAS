package com.example.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

//기기방향이 Portrait일 때 사용자가 글목록에서 선택시 DetailsFragment를 보여주기 위한것이다.
public class DetailsActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //화면이 landscape일 때 MainActivity에서 한꺼번에 두개의 프래그먼트를 보여주므로
            //이 액티비티가 필요없다. 따라서 종료시킨다.
            finish();
            return;
        }

        if (savedInstanceState == null) {//새로 생성하는 거라면

            //DetailsFragment를 생성한다.
            DetailsFragment details = new DetailsFragment();

            //현재 글목록에서 선택된 항목의 인덱스를 가져와 설정한다.
            //DetailsActivity 시작시 인덱스가 intent로 전달됨
            details.setArguments(getIntent().getExtras());

            //현재 Activity에 DetailsFragment 추가
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content, details).commit();
        }
    }
}
