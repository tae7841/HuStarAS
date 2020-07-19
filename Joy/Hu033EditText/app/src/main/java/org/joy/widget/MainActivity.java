package org.joy.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText name, password, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);
        name.setSelectAllOnFocus(true);
        password.setSelectAllOnFocus(true);
        email.setSelectAllOnFocus(true);

        submit = (Button) findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_message();
            }
        });
    }

    public void show_message() {
        String msg = "";
        if (name.getText().toString().isEmpty()) msg += "Enter a name; ";
        if (password.getText().toString().isEmpty()) msg += "Enter a password; ";
        if (email.getText().toString().isEmpty()) msg += "Enter an email;";

        if (msg.length() != 0) {
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Name: " + name.getText().toString()
                            + " \n" + "Password: " + password.getText().toString()
                            + " \n" + "Email: " + email.getText().toString(),
                    Toast.LENGTH_LONG).show();
        }
        closeKeyboard();
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}