package com.example.snackler.snackler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Jake on 12/13/2016.
 */

public class macroBarView extends View {

    Rect current = new Rect();
    Rect additional = new Rect();
    Rect remaining = new Rect(0,0,400,48);

    Paint curPaint;
    Paint newPaint;
    Paint remPaint;

    int overallWidth = 200;


    public macroBarView(Context context) {
        super(context);
        init();
    }

    public macroBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public macroBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init() {

        curPaint = new Paint();
        curPaint.setColor(Color.argb(255,81,149,72));
        curPaint.setAlpha(255);
        curPaint.setAntiAlias(true);
        curPaint.setStyle(Paint.Style.FILL);

        newPaint = new Paint();
        newPaint.setColor(Color.argb(255,136,196,37));
        newPaint.setAlpha(255);
        newPaint.setAntiAlias(true);
        newPaint.setStyle(Paint.Style.FILL);

        remPaint = new Paint();
        remPaint.setColor(Color.argb(255,190,242,2));
        remPaint.setAlpha(255);
        remPaint.setAntiAlias(true);
        remPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(current,curPaint);
        canvas.drawRect(remaining,remPaint);
        canvas.drawRect(additional,newPaint);

    }

    public void setWidth(float curWidth, float newWidth, float totWidth) {

        int width = 800;
        int height = 96;

        Log.i("Width:", String.valueOf(width));
        Log.i("Height:", String.valueOf(height));

        int curScaled = (int) ((curWidth/totWidth)*0.75f*width);
        int newScaled = (int) ((newWidth/totWidth)*0.75f*width);
        int remScaled = (int) (0.75f*width);

        Log.i("curScaled:", String.valueOf(curScaled));
        Log.i("newScaled:", String.valueOf(newScaled));
        Log.i("remScaled:", String.valueOf(remScaled));

        current = new Rect(0,0,curScaled,height);
        additional = new Rect(curScaled,0,curScaled+newScaled,height);
        remaining = new Rect(curScaled,0,remScaled,height);

        invalidate();
    }

}
