package com.example.task1to_dolistapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import java.util.Calendar;

public class AnalogClockView extends View {

    private Paint paint;
    private int width, height, centerX, centerY, radius;
    private Handler handler;
    private Runnable runnable;

    public AnalogClockView(Context context) {
        super(context);
        init();
    }

    public AnalogClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AnalogClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(runnable);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        centerX = width / 2;
        centerY = height / 2;
        radius = Math.min(centerX, centerY) - 10; // Padding for the border
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Calendar calendar = Calendar.getInstance();
        drawClock(canvas, calendar);
    }

    private void drawClock(Canvas canvas, Calendar calendar) {
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        // Draw clock border
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        canvas.drawCircle(centerX, centerY, radius, paint);

        // Draw clock numbers
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(20);
        int[] hours = {3, 6, 9, 12};
        for (int hourNumber : hours) {
            String number = String.valueOf(hourNumber);
            float angle = (float) Math.toRadians((hourNumber - 3) * 30);
            float x = (float) (centerX + Math.cos(angle) * (radius - 30));
            float y = (float) (centerY + Math.sin(angle) * (radius - 30) + 10);
            canvas.drawText(number, x, y, paint);
        }

        // Draw hour hand
        float hourAngle = (hour + minute / 60f) * 360 / 12;
        paint.setStrokeWidth(6);
        paint.setColor(Color.BLACK);
        canvas.drawLine(centerX, centerY,
                (float) (centerX + Math.cos(Math.toRadians(hourAngle - 90)) * radius / 2),
                (float) (centerY + Math.sin(Math.toRadians(hourAngle - 90)) * radius / 2), paint);

        // Draw minute hand
        float minuteAngle = (minute + second / 60f) * 360 / 60;
        paint.setStrokeWidth(4);
        paint.setColor(Color.DKGRAY);
        canvas.drawLine(centerX, centerY,
                (float) (centerX + Math.cos(Math.toRadians(minuteAngle - 90)) * radius * 0.75),
                (float) (centerY + Math.sin(Math.toRadians(minuteAngle - 90)) * radius * 0.75), paint);

        // Draw second hand
        float secondAngle = second * 360 / 60;
        paint.setStrokeWidth(2);
        paint.setColor(Color.RED);
        canvas.drawLine(centerX, centerY,
                (float) (centerX + Math.cos(Math.toRadians(secondAngle - 90)) * radius * 0.85),
                (float) (centerY + Math.sin(Math.toRadians(secondAngle - 90)) * radius * 0.85), paint);

        // Draw center circle
        paint.setColor(Color.BLACK);
        canvas.drawCircle(centerX, centerY, 5, paint);
    }
}
