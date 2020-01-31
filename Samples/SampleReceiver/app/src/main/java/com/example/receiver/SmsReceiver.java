package com.example.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = "Hustar";
    public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, ">onReceive()");

        Bundle bundle = intent.getExtras();

        SmsMessage[] messages = parseSmsMessage(bundle);
        if (messages != null && messages.length > 0) {
            String sender = messages[0].getOriginatingAddress();
            String contents = messages[0].getMessageBody();
            Date receivedDate = new Date(messages[0].getTimestampMillis());

            Log.i(TAG, "SMS: " + sender + " " + contents + " " + receivedDate.toString());

            Intent myIntent = new Intent(context, SmsActivity.class);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP|
                    Intent.FLAG_ACTIVITY_CLEAR_TOP);
            myIntent.putExtra("sender", sender);
            myIntent.putExtra("contents", contents);
            myIntent.putExtra("receivedDate", format.format(receivedDate));
            Log.i(TAG, "calling startActivity");
            context.startActivity(myIntent);
        }
    }

    private SmsMessage[] parseSmsMessage(Bundle bundle) {

        Object[] objs = (Object[]) bundle.get("pdus");

        SmsMessage[] messages = new SmsMessage[objs.length];
        int smsCount = objs.length;
        for (int i = 0; i < smsCount; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i], format);
            } else {
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
            }
        }
        return messages;
    }
}
