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
    EditText name, password, email;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editText1);
        password = findViewById(R.id.editText2);
        email = findViewById(R.id.editText3);

        name.setSelectAllOnFocus(true);
        password.setSelectAllOnFocus(true);
        email.setSelectAllOnFocus(true);

        submit = findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
                show_message();
            }
        });
    }

    public void show_message() {
        String msg = "";

        if (name.getText().toString().isEmpty()) msg += "Enter a name: \n";
        if (password.getText().toString().isEmpty()) msg += "Enter a password: \n";
        if (email.getText().toString().isEmpty()) msg += "Enter an email: ";

        if (msg.length() != 0) {
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Name: " + name.getText().toString() +
                    "\nPassword: " + password.getText().toString() +
                    "\nemail: " + email.getText().toString(), Toast.LENGTH_LONG).show();
        }
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm =
                    (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}