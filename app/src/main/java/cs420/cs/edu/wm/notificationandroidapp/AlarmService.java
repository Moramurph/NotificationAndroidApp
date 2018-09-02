package cs420.cs.edu.wm.notificationandroidapp;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;

public class AlarmService extends IntentService {

    private NotificationManager notificationManager;
    private String sID;
    private int iID;

    public AlarmService() {
        super("AlarmService");
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        createNotification();
    }

    public void createNotificationView(View view) {
        sID = "TESTING";
        iID = 001;



        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(this, sID);
        mbuilder.setSmallIcon(R.drawable.ic_launcher_background);
        mbuilder.setContentTitle("Hello World");
        mbuilder.setDefaults(NotificationCompat.DEFAULT_ALL);

        createNotificationChannel();
        notificationManager.notify(iID, mbuilder.build());

    }

    public void createNotification() {
        sID = "TESTING";
        iID = 001;



        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(this, sID);
        mbuilder.setSmallIcon(R.drawable.ic_launcher_background);
        mbuilder.setContentTitle("Hello World");
        mbuilder.setDefaults(NotificationCompat.DEFAULT_ALL);
        mbuilder.setPriority(NotificationManagerCompat.IMPORTANCE_MAX);

        createNotificationChannel();
        notificationManager.notify(iID, mbuilder.build());

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(sID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
