package com.rajdeep.blereciver.broadcastreciver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import static android.content.Context.ALARM_SERVICE;

public class CheckAndConnectToBLEDeviceReciver extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "TimerSet", Toast.LENGTH_SHORT).show();


        Intent inti = new Intent(context.getApplicationContext(), CheckAndConnectToBLEDeviceReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context.getApplicationContext(), 234324243, inti, 0);
        AlarmManager alarmManager = (AlarmManager)context. getSystemService(ALARM_SERVICE);
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis()
                        + (4000), pendingIntent);
    }
}
