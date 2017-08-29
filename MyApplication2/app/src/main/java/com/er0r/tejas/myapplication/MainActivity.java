package com.er0r.tejas.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.enableLocalDatastore(this);

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("9fddc0dee7e61dd74809b12b2f9c13380bbddca6")
                .clientKey("5c69a318b7b7110b55c4328f971ca2ed359b8f96")
                .server("http://ec2-13-59-181-117.us-east-2.compute.amazonaws.com:80/parse/")
                .build()
        );

        ParseUser.enableAutomaticUser();

        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

        final ParseObject object = new ParseObject("UserDB");

        object.put("Username","test2");
        object.put("password","test2");
        object.saveInBackground();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("UserDB");

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e == null ){
                    Log.i("Test","Retrived " + objects.size());
                    if(objects.size() > 0){
                        for(ParseObject object1 : objects){
                            Log.i("Test",object1.getString("UserName"));
                        }
                    }
                }

            }
        });


    }
}
