package org.joy.button;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/********* anonymous class를 사용한 이벤트 리스너 사용 방법 ********/
// 익명 클래스를 사용하는 방법은 특정 Button의 클릭 이벤트가 어디서
// 처리되는지 직관적으로 확인할 수 있고 코드 작성이 간결하기 때문에
// 가장 자주 사용되는 방법입니다. 익명 클래스를 사용하여 예제 버튼들에
//  대한 이벤트를 처리하는 코드는 다음과 같습니다.
/**
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("R");
                textView.setBackgroundColor(Color.rgb(255, 0, 0));
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("G");
                textView.setBackgroundColor(Color.rgb(0, 255, 0));
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("B");
                textView.setBackgroundColor(Color.rgb(0, 0, 255));
            }
        });
    }
}
**/

/********* II. 생성해 놓은 anonymous class를 참조를 이벤트 리스너로 사용 방법 ********/
/*** 익명 클래스 객체를 먼저 만들어 놓고 그 객체를 모든 Button의 이벤트 리스너로 사용하는
 * 것입니다. 기본적으로 익명 클래스를 사용한다는 점에서 첫 번째 방법과 유사하지만 익명
 * 클래스 객체를 매번 생성하지 않는다는 차이가 있습니다. 또한 각 Button들에 대한 이벤트
 * 처리 코드가 이벤트 리스너 객체 별로 구분되지 않고 이벤트 리스너 안의 핸들러 함수(onClick)에서
 * 구분되는 점도 다릅니다. **/
/**
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(R.id.textView);
                switch (view.getId()) {
                    case R.id.button1:
                        textView.setText("R");
                        textView.setBackgroundColor(Color.rgb(255, 0, 0));
                        break;
                    case R.id.button2:
                        textView.setText("G");
                        textView.setBackgroundColor(Color.rgb(0, 255, 0));
                        break;
                    case R.id.button3:
                        textView.setText("B");
                        textView.setBackgroundColor(Color.rgb(0, 255, 0));
                        break;
                }
            }
        };

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(onClickListener);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(onClickListener);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(onClickListener);
    }
}
***/

/********* III. 이벤트 리스너 인터페이스를 implements하는 이벤트 리스너 클래스 생성하기. ********/
// 익명 클래스를 이용하는 코드를 보면, new 키워드 다음에 Button의 이벤트 리스너 인터페이스의
// 이름이 적혀 있습니다. 이로 인해 마치 Button.OnClickListener의 객체를 만드는 것으로 잘못
// 이해되는 경우가 종종 있습니다. 하지만 이것은 Button.OnClickListener의 객체를 만드는 것이
// 아닙니다. 정확히는 Button.OnClickListener를 상속받는 새로운 클래스의 객체가 생성되는 것입니다.
// 클래스와 객체에 이름이 지정되지 않은 익명(anonymous) 상태로 말입니다.
// 세번째 방법은 Button.OnClickListener를 상속받는 새로운 클래스의 객체가 필요한데,
// 이를 익명의 class가 아니라 해당 클래스를 직접(명시적으로) 만들어, 필요한 객체를 만들어
// 사용하는 방법입니다.
/*******
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BtnOnClickListener의 객체 생성.
        BtnOnClickListener onClickListener = new BtnOnClickListener() ;

        // 각 Button의 이벤트 리스너로 onClickListener 지정.
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(onClickListener);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(onClickListener);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(onClickListener);
    }

    class BtnOnClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView textView1 = (TextView) findViewById(R.id.textView);
            switch (view.getId()) {
                case R.id.button1:
                    textView1.setText("Red") ;
                    textView1.setBackgroundColor(Color.rgb(255, 0, 0));
                    break ;
                case R.id.button2:
                    textView1.setText("Green") ;
                    textView1.setBackgroundColor(Color.rgb(0, 255, 0));
                    break ;
                case R.id.button3:
                    textView1.setText("Blue") ;
                    textView1.setBackgroundColor(Color.rgb(0, 0, 255));
                    break ;
            }
        }
    }
}
***/

/********* IV. Activity에서 이벤트 리스너 인터페이스를 implements해서 사용하기. ********/
// Button.OnClickListener를 상속받는 새로운 클래스의 객체가 필요한데, 새로운 클래스(익명이든
// 명시적이든지)를 정의할 필요가 없이, 단지 Button.onClickListener 인터페이스를 implements
// 한 클래스 객체면 가능하니까, 기존하는 Activity class를 이용해서 만들자는 것입니다.
public class MainActivity extends AppCompatActivity implements Button.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 각 Button의 이벤트 리스너로 this(MainActivity) 지정.
        // Activity 자신이 Button.OnClickListener를 implements했으며 onClick()
        // 함수를 오버라이딩 하였기에 이벤트 리스너 역할을 수행할 수 있다는 것을
        // this로 알려주는 것임.
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    // Button.OnclickListener를 implements하므로 onClick() 함수를 오버라이딩.
    @Override
    public void onClick(View view) {
        TextView textView1 = (TextView) findViewById(R.id.textView);
        switch (view.getId()) {
            case R.id.button1 :
                textView1.setText("Red") ;
                textView1.setBackgroundColor(Color.rgb(255, 0, 0));
                break ;
            case R.id.button2:
                textView1.setText("Green") ;
                textView1.setBackgroundColor(Color.rgb(0, 255, 0));
                break ;
            case R.id.button3:
                textView1.setText("Blue") ;
                textView1.setBackgroundColor(Color.rgb(0, 0, 255));
                break ;
        }
    }
}

/**** V. Layout 리소스 XML에서 Button의 onClick 속성에 이벤트 함수를 지정하는 방법.  ************/
