package bingoyo.com.mangalfabs.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.widget.TextView;

public class ShapeDraw extends android.support.v7.widget.AppCompatTextView {

    Paint paint;

    String string;

    public ShapeDraw(Context context) {
        super(context);
        init();
    }


    private void init() {

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);

        string = "Hello world text";
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
setWidth(200);
        setText(string);

        canvas.drawRect(0, getHeight() - 5, getWidth(), getHeight()+55, paint);

    }
}
