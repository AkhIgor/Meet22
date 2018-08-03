package com.example.meet22;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Игорь on 30.07.2018.
 */
public class MyCustomView extends View {

    Paint paint;
    Rect rectangle;

    int X,Y;

    public MyCustomView(Context context) {
        super(context);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.RED);
        rectangle = new Rect();

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs,R.styleable.MyCustomView);
        int width = typedArray.getInt(R.styleable.MyCustomView_width, 75);
        int length = typedArray.getInt(R.styleable.MyCustomView_length, 40);
        X = typedArray.getInt(R.styleable.MyCustomView_coordinateX, 0);
        Y = typedArray.getInt(R.styleable.MyCustomView_coordinateY, 0);

        typedArray.recycle();
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rectangle.set(0, 0, 550, 350);
        canvas.drawRect(rectangle, paint);
    }

    public float MyGetX() {
        return rectangle.left;
    }

    public float MyGetY() {
        return rectangle.top;
    }
}
