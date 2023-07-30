package com.example.medclock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class TakeMedicine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_medicine);
        showDialog();
    }
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Alert")
                .setMessage("Are you sure to take the Medicine?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                        Intent intent = new Intent(TakeMedicine.this, AlarmReceiver.class);

                        PendingIntent pendingIntent = PendingIntent.getBroadcast(TakeMedicine.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
                        if (alarmManager == null){
                            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                        }
                        alarmManager.cancel(pendingIntent);
                        Toast.makeText(TakeMedicine.this, "Medicine taken sucessfuly!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        finish();
                        Intent intent1 = new Intent(TakeMedicine.this, MainActivity.class);


                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}