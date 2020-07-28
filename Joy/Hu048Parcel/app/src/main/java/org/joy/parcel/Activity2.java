package org.joy.parcel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static org.joy.parcel.MainActivity.KEY_SERVICE;

public class Activity2 extends AppCompatActivity {
    BookData book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);

        Bundle bundle = getIntent().getExtras();
        book = bundle.getParcelable(KEY_SERVICE);
        textView.setText("Received: " + book.getTitle() + ", " + book.getPrice());

        book.setPrice((int)Math.round(book.getPrice() * 0.5));  // 50% discount price를 book 객체에 저장합니다.
        textView2.setText("Sending: " + book.getTitle() + ", " + book.getPrice());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(KEY_SERVICE, book);
                setResult(RESULT_OK, intent);
                finish();
                // overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        // overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        // overridePendingTransition(R.anim.fadeout, R.anim.fadein);
    }
}