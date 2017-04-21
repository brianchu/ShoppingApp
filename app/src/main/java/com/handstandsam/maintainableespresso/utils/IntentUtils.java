package com.handstandsam.maintainableespresso.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.handstandsam.maintainableespresso.login.LoginActivity;
import com.handstandsam.maintainableespresso.R;

public class IntentUtils {


    public static Intent getIntentForUsername(Context context, String username) {
        Intent intent = new Intent(context, LoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        intent.putExtras(bundle);
        return intent;
    }

    public static void triggerPRNotification(Context context, String username) {
        int id = (int) System.currentTimeMillis();
        PendingIntent pIntent = PendingIntent.getActivity(context, id, getIntentForUsername(context, username), PendingIntent.FLAG_ONE_SHOT);

        Notification n = new Notification.Builder(context)
                .setContentTitle("New PR from " + username)
                .setContentText("Added Debug Features to App.")
                .setSmallIcon(R.drawable.ic_github_logo)
                .setContentIntent(pIntent)
                .setAutoCancel(true).build();

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(id, n);
    }

//        public static void triggerPRNotification(Context context, String username, Intent intent) {
//        int id = (int) System.currentTimeMillis();
//        PendingIntent pIntent = PendingIntent.getContext(context, id, intent, PendingIntent.FLAG_ONE_SHOT);
//
//        Notification n = new Notification.Builder(context)
//                .setContentTitle("New PR from " + username)
//                .setContentText("Added Debug Features to App.")
//                .setSmallIcon(R.drawable.ic_github_logo)
//                .setContentIntent(pIntent)
//                .setAutoCancel(true).build();
//
//        NotificationManager notificationManager =
//                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//
//        notificationManager.notify(id, n);
//    }
}
