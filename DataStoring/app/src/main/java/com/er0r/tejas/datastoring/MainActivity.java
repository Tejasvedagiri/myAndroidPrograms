package com.er0r.tejas.datastoring;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = this.getSharedPreferences("com.er0r.tejas.datastoring", Context.MODE_PRIVATE);
        ArrayList<String> test = new ArrayList<>();
        test.add("Tejas");
        test.add("Vedagiri");


        try {
            sp.edit().putString("Friends",ObjectSerializer.serialize(test)).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> nf = new ArrayList<>();

        try {
            nf = (ArrayList<String>) ObjectSerializer.deserialize(sp.getString("Friends",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //String username = sp.getString("UserName","");
        Log.i("UserName", String.valueOf(nf));
    }
}
