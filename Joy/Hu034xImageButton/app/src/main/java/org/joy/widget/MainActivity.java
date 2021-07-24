package org.joy.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton clear, submit, passwordView;
    EditText name, password, email;
    Boolean show = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clear = findViewById(R.id.imageButtonClear);
        submit = findViewById(R.id.imageButtonSubmit);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        passwordView = findViewById(R.id.passwordView);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear_message();
                closeKeyboard();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_message();
                closeKeyboard();
            }
        });

        passwordView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (show == false) {
                    password.setTransformationMethod(null);
                    show = true;
                }
                else {
                    password.setTransformationMethod(
                            new PasswordTransformationMethod()
                    );
                    show = false;
                }
            }
        });

//        passwordView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    password.setTransformationMethod(null);
//                    return true;
//                }
//                else {
//                    password.setTransformationMethod(
//                            new PasswordTransformationMethod()
//                    );
//                }
//                return false;
//            }
//        });
    }

    public void clear_message() {
        name.setText("");
        password.setText("");
        email.setText("");
    }

    public void show_message() {
        String msg = "";
        if (name.getText().toString().isEmpty()) msg += "Enter a name; ";
        if (password.getText().toString().isEmpty()) msg += "Enter a password; ";
        if (email.getText().toString().isEmpty()) msg += "Enter a email; ";

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