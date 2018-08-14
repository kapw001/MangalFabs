package bingoyo.com.mangalfabs.customview;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;

public class TextviewSize extends AppCompatTextView {
    private static final String TAG = "TextviewSize";

    public TextviewSize(Context context) {
        super(context);

        init();
    }

    public TextviewSize(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public TextviewSize(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

//        int s = ((displayMetrics.heightPixels * 4) / 160);
        int s = ((displayMetrics.densityDpi * 3) / 100);

        s = (int) (s * displayMetrics.scaledDensity);
        int ss=displayMetrics.widthPixels/displayMetrics.densityDpi*12;
        Log.e(TAG, "init: text size " + s);
        setTextSize(ss);

    }
}
