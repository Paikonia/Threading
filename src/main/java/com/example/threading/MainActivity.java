package com.example.threading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Theory theory = new Theory();
    TextView text = findViewById(R.id.message);
    //HandlerThread han = new HandlerThread("Sample handler thread");//This is one way of creating this object but it isnot advisable.
    //private Handler hand; this creates handler which is initiated in the oncreate
    prac pr = new prac("debuggingname", -12);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theory.start();//calling this here to stat this thread all the time the main activity starts.
        //this can also be dont on a method click. this is seen below.
        /*findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theory.start();
            }
        });
          */
        //han.start();
        // hand = new Handler(han.getLooper()); // this is to enable us to manupilate the HandlerThread.
            pr.start();
    }

    public void Startthread(View view) {

      //theory.start() could also be called here

    }

    public void StopThread(View view) {

        theory.lopp.quitSafely();// calling this here just incase the user wanted to end the thread.

    }

    public void fixtask(View view){
        /*Message msg = Message.obtain();
        msg.what = 1223;
        theory.handle.sendMessage(msg);
        */

        /*
        //This is a demo of the handler.post() method
     theory.handle.post(new Runnable() {
         @Override
         public void run() {
             for (int i = 0; i < 10; i++) {
                 text.setText("Run: " + i);
             }
         }
     });
*/

        //the above code can also be rewritten with a new handler for this class(MainActivity)
        Handler hanler = new Handler(theory.lopp);// this binds the main method to the created threads Looper.
        hanler.post(new Runnable() {
            @Override
            public void run() {
           //the codes to be run.
            }
        });

        //hand.post(new runTask());// this eliminates memory leakage.

        // to do work with the prac class, the following is called
       pr.getHandler().post(new runTask());// this is how work is done.
        Message msg = Message.obtain(pr.getHandler()); // this associates the message with the handler.
        msg.what = 1;//this needs an integer
        msg.obj = "this take in objects including Strings";
        //using the above, we use the codes that follow.
        msg.sendToTarget();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        theory.lopp.quit();//calling this here to make sure that the thread is destroyed when the mainactivity is destroyed. This makes sure that we dont have any chance of memory leak.
        pr.quitSafely();
         //han.quit();

    }

    private class runTask implements Runnable{
        public void run(){
            //write the codes for the task you want to run in the background.


        }

          }

}
