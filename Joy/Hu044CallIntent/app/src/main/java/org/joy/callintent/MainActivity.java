package org.joy.callintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.joy.callintent.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(data));
                startActivity(intent);
            }
        });
        */
        button.setOnClickListener(view -> {
                String phone = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                startActivity(intent);
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                ComponentName name = new ComponentName("org.joy.callintent", "org.joy.callintent.JoyActivity");
                intent.setComponent(name);
                startActivity(intent);
            }
        });

        /*******
        button2.setOnClickListener(view -> startActivity(new Intent().setComponent(
                new ComponentName("org.joy.intent", "org.joy.intent.JoyActivity"))) );
         ************/

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener( v -> {
            Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse("geo:36.10356, 129.38836") );
            startActivity(intent);
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
            startActivity(intent);
        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
            startActivity(intent);
        });
    }
}