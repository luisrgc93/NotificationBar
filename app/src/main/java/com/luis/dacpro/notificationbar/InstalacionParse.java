package com.luis.dacpro.notificationbar;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by Luis on 06/01/2016.
 */
public class InstalacionParse extends Application{

    public void onCreate(){
        super.onCreate();
                                    //Id de la Aplicacion                       Id del Cliente (Mi cuenta en parse)
        Parse.initialize(this, "CQw4JhCzjM6FaU1cqBp2R8dRYkJbIlWesYxjpX2u" , "Na1dtYvKDWgRrs9z7V76zdIUNsiyt1VDRNDi67hq");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
