package bingoyo.com.mangalfabs.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import bingoyo.com.mangalfabs.R;

public class DrawableButtonColor extends AppCompatButton {


    public DrawableButtonColor(Context context) {
        super(context);

        init(context, null);
    }

    public DrawableButtonColor(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DrawableButtonColor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.DrawableButtonColor, 0, 0);
        int valueColor = a.getColor(R.styleable.DrawableButtonColor_drawableColor,
                getResources().getColor(android.R.color.holo_blue_light));
//
//        String shape = a.getString(R.styleable.DrawableButtonColor_shape);
//
//        int w = a.getInt(R.styleable.DrawableButtonColor_w, 10);
//        int h = a.getInt(R.styleable.DrawableButtonColor_h, 10);
//        int r = a.getInt(R.styleable.DrawableButtonColor_radius, 10);

        a.recycle();


        GradientDrawable bgShape = (GradientDrawable) getBackground();
        bgShape.setColor(valueColor);
//
//        if (shape.toLowerCase().equalsIgnoreCase("rectangle")) {
//
//            bgShape.setShape(GradientDrawable.RECTANGLE);
//
//        } else if (shape.toLowerCase().equalsIgnoreCase("oval")) {
//
//            bgShape.setShape(GradientDrawable.OVAL);
//
//            bgShape.setSize(w, h);
//
//        }
//
//        bgShape.setCornerRadii(new float[]{r});
//

    }
}
