package bingoyo.com.mangalfabs.dashboard.swipetodismiss;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.transition.TransitionInflater;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.commit451.elasticdragdismisslayout.ElasticDragDismissFrameLayout;
import com.commit451.elasticdragdismisslayout.ElasticDragDismissLinearLayout;
import com.commit451.elasticdragdismisslayout.ElasticDragDismissListener;
import com.commit451.elasticdragdismisslayout.ElasticDragDismissRelativeLayout;

import bingoyo.com.mangalfabs.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SwipeToActivity extends AppCompatActivity {

    //    @BindView(R.id.baseRoot)
//    RelativeLayout baseLayout;
    @BindView(R.id.draggable_frame)
    ElasticDragDismissRelativeLayout mDraggableFrame;


    private int previousFingerPosition = 0;
    private int baseLayoutPosition = 0;
    private int defaultViewHeight;

    private boolean isClosing = false;
    private boolean isScrollingUp = false;
    private boolean isScrollingDown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_to);
        ButterKnife.bind(this);

//        baseLayout.setOnTouchListener(this);


//        setSupportActionBar(toolbar);

        mDraggableFrame.addListener(new ElasticDragDismissListener() {
            @Override
            public void onDrag(float elasticOffset, float elasticOffsetPixels, float rawOffset, float rawOffsetPixels) {
            }

            @Override
            public void onDragDismissed() {
//                if (mDraggableFrame.getTranslationY() > 0 && Build.VERSION.SDK_INT >= 21) {
////                    getWindow().setReturnTransition(
////                            TransitionInflater.from(SwipeToActivity.this)
////                                    .inflateTransition(R.transition.about_return_downward));
//                }
                if (Build.VERSION.SDK_INT >= 21) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
        });

//        if (Build.VERSION.SDK_INT >= 21) {
//            mDraggableFrame.addListener(new SystemChromeFader(this));
//        }
    }

//
//    @Override
//    public boolean onTouch(View view, MotionEvent event) {
//
//        // Get finger position on screen
//        final int Y = (int) event.getRawY();
//
//        // Switch on motion event type
//        switch (event.getAction() & MotionEvent.ACTION_MASK) {
//
//            case MotionEvent.ACTION_DOWN:
//                // save default base layout height
//                defaultViewHeight = baseLayout.getHeight();
//
//                // Init finger and view position
//                previousFingerPosition = Y;
//                baseLayoutPosition = (int) baseLayout.getY();
//                break;
//
//            case MotionEvent.ACTION_UP:
//                // If user was doing a scroll up
//                if (isScrollingUp) {
//                    // Reset baselayout position
//                    baseLayout.setY(0);
//                    // We are not in scrolling up mode anymore
//                    isScrollingUp = false;
//                }
//
//                // If user was doing a scroll down
//                if (isScrollingDown) {
//                    // Reset baselayout position
//                    baseLayout.setY(0);
//                    // Reset base layout size
//                    baseLayout.getLayoutParams().height = defaultViewHeight;
//                    baseLayout.requestLayout();
//                    // We are not in scrolling down mode anymore
//                    isScrollingDown = false;
//                }
//                break;
//            case MotionEvent.ACTION_MOVE:
//                if (!isClosing) {
//                    int currentYPosition = (int) baseLayout.getY();
//
//                    // If we scroll up
//                    if (previousFingerPosition > Y) {
//                        // First time android rise an event for "up" move
//                        if (!isScrollingUp) {
//                            isScrollingUp = true;
//                        }
//
//                        // Has user scroll down before -> view is smaller than it's default size -> resize it instead of change it position
//                        if (baseLayout.getHeight() < defaultViewHeight) {
//                            baseLayout.getLayoutParams().height = baseLayout.getHeight() - (Y - previousFingerPosition);
//                            baseLayout.requestLayout();
//                        } else {
//                            // Has user scroll enough to "auto close" popup ?
//                            if ((baseLayoutPosition - currentYPosition) > defaultViewHeight / 4) {
//                                closeUpAndDismissDialog(currentYPosition);
//                                return true;
//                            }
//
//                            //
//                        }
//                        baseLayout.setY(baseLayout.getY() + (Y - previousFingerPosition));
//
//                    }
//                    // If we scroll down
//                    else {
//
//                        // First time android rise an event for "down" move
//                        if (!isScrollingDown) {
//                            isScrollingDown = true;
//                        }
//
//                        // Has user scroll enough to "auto close" popup ?
//                        if (Math.abs(baseLayoutPosition - currentYPosition) > defaultViewHeight / 2) {
//                            closeDownAndDismissDialog(currentYPosition);
//                            return true;
//                        }
//
//                        // Change base layout size and position (must change position because view anchor is top left corner)
//                        baseLayout.setY(baseLayout.getY() + (Y - previousFingerPosition));
//                        baseLayout.getLayoutParams().height = baseLayout.getHeight() - (Y - previousFingerPosition);
//                        baseLayout.requestLayout();
//                    }
//
//                    // Update position
//                    previousFingerPosition = Y;
//                }
//                break;
//        }
//        return true;
//    }
//
//
//    public void closeUpAndDismissDialog(int currentPosition) {
//        isClosing = true;
//        ObjectAnimator positionAnimator = ObjectAnimator.ofFloat(baseLayout, "y", currentPosition, -baseLayout.getHeight());
//        positionAnimator.setDuration(300);
//        positionAnimator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//                finish();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//
//            }
//        });
//        positionAnimator.start();
//    }
//
//    public void closeDownAndDismissDialog(int currentPosition) {
//        isClosing = true;
//        Display display = getWindowManager().getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        int screenHeight = size.y;
//        ObjectAnimator positionAnimator = ObjectAnimator.ofFloat(baseLayout, "y", currentPosition, screenHeight + baseLayout.getHeight());
//        positionAnimator.setDuration(300);
//        positionAnimator.addListener(new Animator.AnimatorListener() {
//
//            @Override
//            public void onAnimationStart(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//                finish();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//
//            }
//
//        });
//        positionAnimator.start();
//    }
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//
//    }
}
