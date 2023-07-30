package com.example.medclock;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReceiver extends BroadcastReceiver {

    private PendingIntent pendingIntent1;
    private PendingIntent pendingIntent2;

    @SuppressLint("MissingPermission")
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent nextActivity = new Intent(context, MedicineSchedule.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        Intent intent1 = new Intent(context, TakeMedicine.class);
        Intent intent2 = new Intent(context, DialogActivity.class);

        PendingIntent pendingIntent1 = PendingIntent.getActivity(context, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent pendingIntent2 = PendingIntent.getActivity(context, 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, nextActivity, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "MedClock")
                .setSmallIcon(R.drawable.baseline_notifications_24)
                .setContentTitle("Good Day!")
                .setContentText("It's time for your Medicine")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setContentIntent(pendingIntent1)
                .setContentIntent(pendingIntent2);

        builder.addAction(R.drawable.ic_launcher_foreground, "Take", pendingIntent1);
        builder.addAction(R.drawable.ic_launcher_foreground, "Ignore", pendingIntent2);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(123, builder.build());
    }
}
