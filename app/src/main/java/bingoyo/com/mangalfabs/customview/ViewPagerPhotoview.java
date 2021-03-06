package bingoyo.com.mangalfabs.customview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.github.chrisbanes.photoview.PhotoView;

public class ViewPagerPhotoview extends ViewPager {

    public ViewPagerPhotoview(@NonNull Context context) {
        super(context);
    }

    public ViewPagerPhotoview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        try {
//            return super.onInterceptTouchEvent(ev);
//        } catch (IllegalArgumentException e) {
//            //uncomment if you really want to see these errors
//            //e.printStackTrace();
//            return false;
//        }
//    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            return super.onTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }


//    @Override
//    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
//        if (v instanceof ViewPagerPhotoview) {
//            return ((ViewPagerPhotoview) v).canScrollHorizontallyFroyo(-dx);
//        } else {
//            return super.canScroll(v, checkV, dx, x, y);
//        }
//    }
//
//    public boolean canScrollHorizontallyFroyo(int direction) {
//        return canScrollHorizontally(direction);
//    }
}
