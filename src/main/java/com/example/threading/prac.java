package com.example.threading;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class prac extends HandlerThread {
  //this class creates a universal class that can be used in the various areas.
    Handler handler;
    public prac(String name) {
        super(name);
    }

    public prac(String name, int priority) {
        super(name, priority);// the lower the value of the priority the higher its priority during runtime.
    }

    @SuppressLint("HandlerLeak")
    @Override
    protected void onLooperPrepared() {
        //this is the method that is immediately before after Looper.prepare()
        //it is also immediately after the Looper.loop()
        //this makes it ideal for calling the new handler.

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg){
              // run the codes for doing the work with Message in here. This is because the Message sent to the handler
                // does not know what to do with the message.

            }
        };
    }
// this method is importand to get the handler since the onLooperprepared is a protected method which can
    //only be accessed by this class.
    public Handler getHandler(){
        return handler;
    }

}
