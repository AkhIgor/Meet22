package com.example.meet22;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView coordinatesView;
    MyCustomView rectangle;

    float X, Y;
    float dX, dY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatesView = (TextView) findViewById(R.id.textView);
        rectangle = (MyCustomView) findViewById(R.id.rectangle);

        rectangle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    int color = Color.rgb(new Random().nextInt(256),
                            new Random().nextInt(256),
                            new Random().nextInt(256));

                    rectangle.paint.setColor(color);
                    dX = v.getX() - event.getRawX();
                    dY = v.getY() - event.getRawY();
                }
                if(event.getAction() == MotionEvent.ACTION_MOVE)
                {
                    X = event.getRawX() + dX;
                    Y = event.getRawY() + dY;

                    v.setX(X);
                    v.setY(Y);

                    String coordinates = "X = " + rectangle.getX() + ", Y = " + rectangle.getY();
                    coordinatesView.setText(coordinates);
                }

                rectangle.performClick();
                rectangle.invalidate();
                return true;
            }
        });
    }
}
