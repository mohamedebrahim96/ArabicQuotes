package com.quotes.app.arabicquotes;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar;
import com.quotes.app.arabicquotes.Model.Data;

import java.util.List;

import static android.R.id.progress;

/**
 * Created by Home on 2017-07-24.
 */

public class SplashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 5000;
    RoundCornerProgressBar progress1;
    //Volley v;
    List<Data> posts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progress1 = (RoundCornerProgressBar) findViewById(R.id.progress_1);
        progress1.setProgress(0);
        progress1.setMax(100);


        new AsyncTask<String, Integer, String>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                // code will executed before task start (main thread)

            }

            @Override
            protected String doInBackground(String... params) {
                // task will done in background

                for (int i = 0; i < 100; i++) {
                    try {
                        // sleep 100 millisecond every loop so progress will not finished fast with out see it
                        Thread.sleep(100);
                        publishProgress(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }



                return null;

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                // code executed after task finish hide progress and change text
                progress1.animate().alpha(0).setDuration(2000).start();


            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                // progress come as array maybe there is mote than one value or progress update so i put [0]
                progress1.setProgress(values[0]);
            }


        }.execute();













        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}