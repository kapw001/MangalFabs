package bingoyo.com.mangalfabs.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class DrawCircleText extends View {
    private int shapeWidth = 100;
    private int shapeHeight = 100;
    private int textXOffset = 0;
    private int textYOffset = 30;
    private Paint paintShape;
    private Paint textColor;


    public DrawCircleText(Context context) {
        super(context);
        setupPaint();
    }

    public DrawCircleText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupPaint();
    }

    public DrawCircleText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupPaint();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DrawCircleText(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setupPaint();
    }


    private void setupPaint() {
        paintShape = new Paint();
        textColor = new Paint();
        textColor.setStyle(Paint.Style.FILL_AND_STROKE);
        paintShape.setStyle(Paint.Style.FILL);
        paintShape.setColor(Color.RED);
        textColor.setTextSize(12);
        textColor.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect rect = new Rect(0, 0, shapeWidth, shapeHeight);


        canvas.drawCircle((float) shapeWidth,(float) shapeHeight,100f,paintShape);

        String s = "Hello World";

        Rect result = new Rect();
        textColor.getTextBounds(s, 0, s.length(), result);

        canvas.drawText(s, shapeWidth-result.centerX(), shapeHeight, textColor);


    }
}
