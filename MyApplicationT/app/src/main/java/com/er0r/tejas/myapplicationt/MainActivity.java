package com.er0r.tejas.myapplicationt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("9fddc0dee7e61dd74809b12b2f9c13380bbddca6")
                .clientKey("5c69a318b7b7110b55c4328f971ca2ed359b8f96")
                .server("http://ec2-13-59-181-117.us-east-2.compute.amazonaws.com:80/parse/")
                .build()
        );


        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
        ParseUser u = new ParseUser();

    }
}
