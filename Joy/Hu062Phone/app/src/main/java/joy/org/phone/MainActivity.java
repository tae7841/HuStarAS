package joy.org.phone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton callingButton = findViewById(R.id.button_calling);
        callingButton.setOnClickListener(view -> dial_number(view));
        //callingButton.setOnClickListener(view -> call_number(view));

        ImageButton imageButton = findViewById(R.id.button_message);
        imageButton.setOnClickListener(view -> send_message(view));

        checkForSmsPermission();
        Log.d(TAG, "<onCreate");
    }

    public void dial_number(View view) {
        Log.d(TAG, "dial_dumber()");
        EditText editText = findViewById(R.id.editText_dialing);
        // Use format with "tel:" and phone number to create phoneNumber.
        String number = editText.getText().toString();
        // Create the intent and set the data for the intent as the phone number.
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
        startActivity(intent);
        Log.d(TAG, "dial_number() ends:" + number);
    }

    //////////// it is not working? //////////
    /*
    public void call_number(View view) {
        Log.d(TAG, "call_number()");
        EditText editText = findViewById(R.id.editText_dialing);
        // Use format with "tel:" and phone number to create phoneNumber.
        String number = editText.getText().toString();
        // Create the intent and set the data for the intent as the phone number.
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        startActivity(intent);
        Log.d(TAG, "call_number() ends:" + number);
    }
    */

    public void send_message(View view) {
        Log.d(TAG, ">send_message: ");
        EditText editText = (EditText) findViewById(R.id.editText_dialing);
        // Use format with "smsto:" and phone number to create smsNumber.
        String smsto_number = "smsto:" + editText.getText().toString();

        // Find the sms_message view and get the text of the sms message.
        EditText editText_message = (EditText) findViewById(R.id.editText_message);
        String  message= editText_message.getText().toString();

        // Create the intent and set the data for the intent as the phone number.
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse(smsto_number));
        // Add the message (sms) with the key ("sms_body").
        smsIntent.putExtra("sms_body", message);
        startActivity(smsIntent);
        Log.d(TAG, "<sendSmsMessage: " + message);
    }

    private void checkForSmsPermission() {
        Log.d(TAG, ">checkForSmsPermission ");

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Permission denied");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
        } else {
            // Permission already granted.
            Log.d(TAG, "Permission already granted");
        }
        Log.d(TAG, "<checkForSmsPermission ");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        // Check if permission is granted or not for the request.
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (permissions[0].equalsIgnoreCase(Manifest.permission.SEND_SMS)
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "Permission granted");
                } else {
                    Log.d(TAG, "Permission denied");
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show();
                }
            }
            default:
                Log.d(TAG, "Pass - not my request");
                break;
        }
    }
}