package cs420.cs.edu.wm.notificationandroidapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, AlarmService.class);
        context.startService(i);
    }
}
