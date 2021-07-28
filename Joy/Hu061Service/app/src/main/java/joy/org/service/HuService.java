package joy.org.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class HuService extends Service {
    private static final String TAG = "HuService";
    MediaPlayer mediaPlayer;

    public HuService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate() Service starts...");
        mediaPlayer = MediaPlayer.create(this, R.raw.music_sample);
        mediaPlayer.setLooping(true);  // replay on
        Log.d(TAG, "onCreate() called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() - Music starts");
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy() - Service ends");
        mediaPlayer.stop();
        super.onDestroy();
    }
}