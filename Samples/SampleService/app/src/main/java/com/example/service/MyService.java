package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import static com.example.service.MainActivity.TAG;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() 호출됨");

        if (intent == null) return Service.START_STICKY;
        processCommand(intent);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void processCommand(Intent intent) {
        String command = intent.getStringExtra("Command");
        String content = intent.getStringExtra("Content");
        Log.d(TAG, "Command: " + command + ", Content: " + content);
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                Log.d(TAG, "waiting " + i + " seconds.");
            } catch (Exception e) {
                Log.d(TAG, "Thread exception");
            }
        }
        Log.d(TAG, "Waiting is over");

        Intent newIntent = new Intent(getApplicationContext(), MainActivity.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TOP);
        newIntent.putExtra("Command", command);
        newIntent.putExtra("Content", capitalizeName(content));
        startActivity(newIntent);
    }

    public String capitalizeName(String name) {
        String[] s = name.trim().split("\\s+");
        name = "";
        for (String i : s){
            if(i.equals("")) return name;
            name += i.substring(0, 1).toUpperCase() + i.substring(1) + " ";
        }
        return name.trim();
    }

    private String processName(String name) {
        name = name.trim();
        String[] words = name.split(" ");
        StringBuilder sb = new StringBuilder();
        if (words[0].length() > 0) {
            sb.append(Character.toUpperCase(words[0].charAt(0)) +
                    words[0].subSequence(1, words[0].length()).toString().toLowerCase());
            for (int i = 1; i < words.length; i++) {
                sb.append(" ");
                sb.append(Character.toUpperCase(words[i].charAt(0)) +
                        words[i].subSequence(1, words[i].length()).toString().toLowerCase());
            }
        }
        return sb.toString();
    }
}
