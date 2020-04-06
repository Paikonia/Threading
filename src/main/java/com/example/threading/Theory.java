package com.example.threading;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;

public class Theory extends Thread {
    //This example allows room for memory leaks which reduces performance. This is just to study the theory.
    Looper lopp ; // this is important to enable the thread be exposed so that it can be stopped.
    public Handler handle; /* = new Handler(); does not work because and error of cannot create handler in a
    a method that has not called looper.prepare is thrown
    */

    @Override
    public void run() { // the next three line of code must be in there order.
        Looper.prepare();

        lopp = Looper.myLooper();

        handle = new Handler();


        Looper.loop();// this creates an infinite for loop.
        Message message = Message.obtain();
        String end = "The thread has ended";



    }
}
