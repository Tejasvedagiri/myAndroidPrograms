package com.er0r.tejas.loginserver;

import android.util.Log;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by Tejas on 02-08-2017.
 */

public class Person {
    String Name;
    String Pass;
    Boolean veri = false;
    ParseUser user;

    Person(String n,String p,MainActivity activity){
        Name=n;
        Pass=p;
        Parse.initialize(new Parse.Configuration.Builder(activity.getApplicationContext())
                .applicationId("9fddc0dee7e61dd74809b12b2f9c13380bbddca6")
                .clientKey("5c69a318b7b7110b55c4328f971ca2ed359b8f96")
                .server("http://ec2-13-59-181-117.us-east-2.compute.amazonaws.com:80/parse/")
                .build()
        );

        //ParseUser.enableAutomaticUser();

        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
        user = new ParseUser();
        user.logInInBackground(Name, Pass, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(user != null){
                    Log.i("Test","Suessful");
                    veri = true;
                }

            }
        });
    }
    boolean test(){
        return veri;
    }
}
