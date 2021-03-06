package com.luis.dacpro.notificationbar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Luis on 06/01/2016.
 */
public class PushBroadcastReceiver extends ParsePushBroadcastReceiver{

    private final String TAG = PushBroadcastReceiver.class.getSimpleName();

    public PushBroadcastReceiver() {
        super();
    }

    @Override
    protected Notification getNotification(Context context, Intent intent) {

        JSONObject pushData = null;
        try{
            pushData = new JSONObject(intent.getExtras().getString("com.parse.Data"));
        } catch (JSONException e) {
            Log.e(TAG, "Push message json exception: " + e.getMessage());
        }

        if(pushData.has("titulo") && pushData.has("mensaje")){

            String titulo = pushData.optString("titulo");
            String mensaje = pushData.optString("mensaje");

            Intent resultIntent;
            if(pushData.has("url")){
                String url = pushData.optString("url");
                resultIntent = new Intent(Intent.ACTION_VIEW);
                resultIntent.setData(Uri.parse(url));
            }else{
                resultIntent = new Intent(context,MainActivity.class);
                resultIntent.putExtras(intent.getExtras());
            }
            PendingIntent resultPendingIntent =
                    PendingIntent.getActivity(
                            context,
                            0,
                            resultIntent,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );

            Notification notification = new android.support.v7.app.NotificationCompat.Builder(
                    context)
                    .setAutoCancel(true)
                    .setSmallIcon(android.R.drawable.ic_dialog_alert)
                    .setContentTitle(titulo)
                    .setContentText(mensaje)
                    .setContentIntent(resultPendingIntent)
                    .build();

            notification.defaults |= Notification.DEFAULT_VIBRATE;
            notification.defaults |= Notification.DEFAULT_SOUND;

            return notification;
        }else{
            return null;
        }

    }
}
