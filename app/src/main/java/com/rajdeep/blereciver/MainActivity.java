package com.rajdeep.blereciver;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rajdeep.blereciver.broadcastreciver.CheckAndConnectToBLEDeviceReciver;

public class MainActivity extends AppCompatActivity {

    Button btn_connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_connect=(Button)findViewById(R.id.btn_connect);
        btn_connect.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), CheckAndConnectToBLEDeviceReciver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        getApplicationContext(), 234324243, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis()
                                + (4000), pendingIntent);
               // alarmManager.set();

                Intent serviceIntent = new Intent(getApplicationContext(), BleTestService.class);
                serviceIntent.putExtra("bluetooth_device", "80:6C:1B:84:C8:DC");
                ContextCompat.startForegroundService(MainActivity.this, serviceIntent);
            }
        });
    }
}
