package com.alu.test.okletusgo.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.alu.test.okletusgo.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Alu on 2017/5/12.
 * 版本：V1.0
 */

public class CountView extends View {
    private Paint mPaint;
    private int millisecond;
    private int hour;
    private int minute;
    private int second;
    private Rect mBounds;
    private Context context;
    private boolean isRunning = false;
    private Timer timer;
    private StringBuffer stringBuffer;
    private MyTask myTask;

    public CountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        mBounds = new Rect();
        mPaint = new Paint();
        stringBuffer = new StringBuffer();
        stringBuffer.append("00:00:00:00");
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (isRunning) {
                    timer.cancel();
                    timer.purge();
                    timer = null;
                    myTask = null;
                    System.gc();
                } else {
                    timer = new Timer();
                    myTask = new MyTask();
                    timer.schedule(myTask, 0, 10);
                }
                isRunning = !isRunning;
                break;
        }
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(60);
        String text = stringBuffer.toString();
        mPaint.getTextBounds(text, 0, text.length(), mBounds);
        float textWidth = mBounds.width();
        float textHeight = mBounds.height();
        canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2 + textHeight / 2, mPaint);
    }

    private class MyTask extends TimerTask {

        @Override
        public void run() {
            stringBuffer.delete(0, stringBuffer.length());
            millisecond++;
            if (millisecond > 99) {
                millisecond = 0;
                second++;
            }
            if (second > 59) {
                second = 0;
                minute++;
            }

            if (minute > 59) {
                minute = 0;
                hour++;
            }
            if (hour < 10)
                stringBuffer.append(0).append(hour);
            else
                stringBuffer.append(hour);
            stringBuffer.append(":");
            if (minute < 10)
                stringBuffer.append(0).append(minute);
            else
                stringBuffer.append(minute);
            stringBuffer.append(":");
            if (second < 10)
                stringBuffer.append(0).append(second);
            else
                stringBuffer.append(second);
            stringBuffer.append(":");
            if (millisecond < 10)
                stringBuffer.append(0).append(millisecond);
            else
                stringBuffer.append(millisecond);
            handler.sendEmptyMessage(0);
        }

    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                invalidate();
            }
        }
    };
}