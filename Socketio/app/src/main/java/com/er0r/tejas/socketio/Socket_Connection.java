package com.er0r.tejas.socketio;

import android.app.Application;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

/**
 * Created by Tejas on 07-08-2017.
 */

public class Socket_Connection extends Application {
    private Socket mSocket;
    Socket_Connection(){
        {
            try {
                mSocket = IO.socket("http://192.168.1.14:3000/");
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Socket getSocket() {
        return mSocket;
    }
}
