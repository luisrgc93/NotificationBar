package com.luis.dacpro.notificationbar;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends ActionBarActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getIntent().getExtras()!=null && getIntent().hasExtra("com.parse.Data")){
            JSONObject pushData = null;
            try{
                pushData = new JSONObject(getIntent().getExtras().getString("com.parse.Data"));
                String url = pushData.optString("url");
                Log.i(TAG,url);
            } catch (JSONException e) {}
        }
        setContentView(R.layout.activity_main);
        }
}
