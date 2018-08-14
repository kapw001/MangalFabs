package bingoyo.com.mangalfabs.dashboard.sizescreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import bingoyo.com.mangalfabs.R;

public class SizeScreenActivity extends AppCompatActivity {

    private static final String TAG = "SizeScreenActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size_screen);


        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        int dmW = displayMetrics.widthPixels;
        int dmH = displayMetrics.widthPixels;

        int dpi = displayMetrics.densityDpi;
        float density = displayMetrics.density;
        float Scaleddensity = displayMetrics.scaledDensity;

        Log.e(TAG, "onCreate: w h " + dmW + "   " + dmH + "  size " + ((displayMetrics.densityDpi * 6) / 100));

        Log.e(TAG, "onCreate: dpt den  scaled den " + dpi + "    " + density + "   " + Scaleddensity);


        int ss=dmW;

        Log.e(TAG, "onCreate: another "+ss );

    }
}
