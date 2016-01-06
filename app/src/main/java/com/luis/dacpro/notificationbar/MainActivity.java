package com.luis.dacpro.notificationbar;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class MainActivity extends ActionBarActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(this, "vA1Dj9W4RdaEaFey2CDDcZgXjleD5X6ftII88SeF" , "r1CBoflOqkgUe4X7VoFiW0dJE6ElV4Rk5fDHgxsE");
        ParseInstallation.getCurrentInstallation().saveInBackground();


        }
}
