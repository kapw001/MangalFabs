package bingoyo.com.mangalfabs.splashscreen;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import bingoyo.com.mangalfabs.R;
import bingoyo.com.mangalfabs.authenticate.AuthenticateActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.loading)
    ProgressBar loading;

    private int progressStatus = 0;
    private Handler handler = new Handler();
    private boolean runningThread = true;
    private static final String TAG = "SplashActivity";


    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        final Drawable drawable;
        int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < 16) {
            drawable = getResources().getDrawable(R.drawable.progess_drawable);
        } else {
            drawable = ContextCompat.getDrawable(this, R.drawable.progess_drawable);
        }
        loading.setProgressDrawable(drawable);

//        loading.getProgressDrawable().setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
        // Start the lengthy operation in a background thread
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                while (true) {
//                    try {
//                        Thread.sleep((long) Math.floor(40));
//                        if (!runningThread) {
//                            return;
//                        }
//                        progressStatus += 1;
//
//                        // Update the progress bar
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                loading.setProgress(progressStatus);
//
//
//                                if (progressStatus == 100) {
//                                    handler.removeCallbacks(this);
//                                    runningThread = false;
//                                    moveToLoginSignupScreen();
//
//                                    Thread.interrupted();
//                                }
//                            }
//                        });
//
//                    } catch (InterruptedException e) {
////                        e.printStackTrace();
//                        Log.e(TAG, "run: " + e.getMessage());
//                    }
//                }
////
////                while (true) {
////                    // Update the progress status
////                    progressStatus += 1;
////
////                    // Try to sleep the thread for 20 milliseconds
////                    try {
////                        Thread.sleep(40);
////                    } catch (InterruptedException e) {
//////                        e.printStackTrace();
////                        Log.e(TAG, "run: " + e.getMessage());
////                    }
////
////                    // Update the progress bar
////                    handler.post(new Runnable() {
////                        @Override
////                        public void run() {
////                            loading.setProgress(progressStatus);
////
////
////                            if (progressStatus == 100) {
////                                handler.removeCallbacks(this);
////                                moveToLoginSignupScreen();
////
////                                Thread.interrupted();
////                            }
////                        }
////                    });
////                }
//            }
//        }).start(); // Start the operation

    }


    @Override
    protected void onResume() {
        super.onResume();

        if (timer == null) {
            timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {

                    progressStatus += 2;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loading.setProgress(progressStatus);

                            if (progressStatus >= 100) {

                                moveToLoginSignupScreen();

                                if (timer != null) {

                                    timer.cancel();
                                }

                            }

                        }
                    });


                }
            }, 10, 50);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (timer != null) {

            timer.cancel();
        }
    }

    private void moveToLoginSignupScreen() {

        Intent intent = new Intent(this, AuthenticateActivity.class);

        startActivity(intent);

        finish();


    }
}
