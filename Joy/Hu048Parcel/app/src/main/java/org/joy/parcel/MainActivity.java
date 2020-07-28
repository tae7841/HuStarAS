package org.joy.parcel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 101;
    public static final String KEY_SERVICE = "quote";
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                BookData book = new BookData(editText.getText().toString(), 1000);
                intent.putExtra(KEY_SERVICE, book);
                startActivityForResult(intent, REQUEST_CODE);
                // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            Toast.makeText(getApplicationContext(), "requestCode: "
                    + requestCode + ", ResultCode: " + resultCode, Toast.LENGTH_LONG).show();

            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                BookData book = bundle.getParcelable(KEY_SERVICE);
                textView2.setText("Received: " + book.getTitle() + ", " + book.getPrice());
            }
        }

    }
}