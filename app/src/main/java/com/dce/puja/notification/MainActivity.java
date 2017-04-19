package com.dce.puja.notification;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view){
        //Creating Notification Builders
        NotificationCompat.Builder myNotificationBuilder = new NotificationCompat.Builder(this);

        //Setting Notification properties
        myNotificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        myNotificationBuilder.setContentTitle("Event detail");
        myNotificationBuilder.setContentText("Hello"+"How r u??"+
        "Iam fine"+"Wat about u???????"+"i amm finnnnnnnne");
        int notificationid = 3452;

        // Creates an explicit intent for an Activity in your app
        Intent myIntent = new Intent(this, Resultactivity.class);
        myIntent.putExtra("myNotificationId", notificationid);
        myIntent.putExtra("AnyValue", 12345);
        //myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent myPendingIntent = PendingIntent.getActivity(this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // start the activity when the user clicks the notification text
        myNotificationBuilder.setContentIntent(myPendingIntent);

        //Issue the Notification
        NotificationManager myManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        myManager.notify(notificationid, myNotificationBuilder.build());
    }
}


