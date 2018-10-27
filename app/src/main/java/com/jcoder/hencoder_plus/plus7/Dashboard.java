package com.jcoder.hencoder_plus.plus7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jcoder.hencoder_plus.Utils;

/**
 * @author wang
 * @date 2018/10/24.
 */

public class Dashboard extends View {

    private static final int ANGEL = 120;
    private static float radius;
    private static float length;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    PathDashPathEffect pathDashPathEffect;
    Path arc = new Path();
    Path dash = new Path();
    int mark = 5;

    public Dashboard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.dp2px(2));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        radius = getWidth() * 2 / 4;
        length = getWidth() * 1 / 4;

        // 画弧
        arc.addArc(getWidth() / 2 - radius, getHeight() / 2 - radius, getWidth() / 2 + radius, getHeight() / 2 + radius, 90 + ANGEL / 2, 360 - ANGEL);
        canvas.drawPath(arc, paint);

        // 画刻度
        PathMeasure pathMeasure = new PathMeasure(arc, false);
        dash.addRect(0, 0, 5, 10, Path.Direction.CW);
        pathDashPathEffect = new PathDashPathEffect(dash, (pathMeasure.getLength() - 5) / 20, 0, PathDashPathEffect.Style.ROTATE);
        paint.setPathEffect(pathDashPathEffect);
        canvas.drawPath(arc, paint);
        paint.setPathEffect(null);

        // 画指针
        canvas.drawLine(getWidth() / 2, getHeight() / 2, (float) Math.cos(Math.toRadians(getAngelFromMark(mark))) * length + getWidth() / 2, (float) Math.sin(Math.toRadians(getAngelFromMark(mark))) * length + getHeight() / 2, paint);

//        Rect rect = new Rect();
//        paint.getTextBounds("abab", 0, "abab".length(), rect);
//        Log.d("pepe", "rect.left = " + rect.left);
//        Log.d("pepe", "rect.right = " + rect.right);
//        Log.d("pepe", "rect.top = " + rect.top);
//        Log.d("pepe", "rect.bottom = " + rect.bottom);
//        Log.d("pepe", "rect.center = " + (rect.top + rect.bottom) / 2);
//
//
//        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
//        Log.d("pepe", "fontMetrics.top = " + fontMetrics.top);
//        Log.d("pepe", "fontMetrics.bottom = " + fontMetrics.bottom);
//        Log.d("pepe", "fontMetrics.ascent = " + fontMetrics.ascent);
//        Log.d("pepe", "fontMetrics.descent = " + fontMetrics.descent);
//        Log.d("pepe", "fontMetrics.center = " + (fontMetrics.ascent + fontMetrics.descent) / 2);

    }

    private int getAngelFromMark(int mark) {
        return (int) (90 + (float) ANGEL / 2 + (360 - (float) ANGEL) / 20 * mark);
    }
}
