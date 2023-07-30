package com.example.medclock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.HttpCookie;
import java.text.Annotation;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        showDialog();
    }
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Alert")
                .setMessage("Are you sure you want to ignore this Alarm?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                       /*
                       transferData();
                        */

                        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                        Intent intent = new Intent(DialogActivity.this, AlarmReceiver.class);

                        PendingIntent pendingIntent = PendingIntent.getBroadcast(DialogActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
                        if (alarmManager == null){
                            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                        }
                        alarmManager.cancel(pendingIntent);
                        Toast.makeText(DialogActivity.this, "Alarm Ignored", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        finish();
                        Intent intent1 = new Intent(DialogActivity.this, MainActivity.class);
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    /*private void transferData() {
        DatabaseReference sourceRef = FirebaseDatabase.getInstance().getReference("User Data");
        DatabaseReference destinationRef = FirebaseDatabase.getInstance().getReference("Cancelled Alarm");

        sourceRef.addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Get the data from the source path

                Annotation dataSnapshot = null;
                Object data = dataSnapshot.getValue();
                destinationRef.setValue(data)
                        .addOnCompleteListener(new OnCompleteListener<Void>(){
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(DialogActivity.this, "Data Transferred Sucessfully!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(DialogActivity.this, "Data Transferred Error!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

     */
}