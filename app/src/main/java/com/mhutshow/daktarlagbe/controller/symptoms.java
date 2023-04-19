package com.mhutshow.daktarlagbe.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mhutshow.daktarlagbe.R;

public class symptoms extends AppCompatActivity {
    Button  submitbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel =  new NotificationChannel("New Notification","New Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        submitbutton = findViewById(R.id.confirmeBtn);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Message = "We have Observed your Symptoms You should Have an Appointment with Neurologist";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        symptoms.this,"New Notification"
                ).setSmallIcon(R.drawable.ic_baseline_person_24).setContentTitle("New Notification")
                        .setContentText(Message).setAutoCancel(true);
                Intent intent = new Intent(symptoms.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message",Message);
                PendingIntent pendingIntent = PendingIntent.getActivity(symptoms.this,0
                        ,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                NotificationManager notificationManager = (NotificationManager) getSystemService(
                        Context.NOTIFICATION_SERVICE );

                notificationManager.notify(0,builder.build());
            }
        });
    }


}