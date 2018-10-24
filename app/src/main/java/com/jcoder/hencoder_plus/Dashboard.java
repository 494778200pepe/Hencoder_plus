package com.jcoder.hencoder_plus;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

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

        arc.addArc(getWidth() / 2 - radius, getHeight() / 2 - radius, getWidth() / 2 + radius, getHeight() / 2 + radius, 90 + ANGEL / 2, 360 - ANGEL);
        PathMeasure pathMeasure = new PathMeasure(arc, false);

        dash.addRect(0, 0, 5, 10, Path.Direction.CW);
        pathDashPathEffect = new PathDashPathEffect(dash, (pathMeasure.getLength() - 5) / 20, 0, PathDashPathEffect.Style.ROTATE);

        canvas.drawPath(arc,paint);
        paint.setPathEffect(pathDashPathEffect);
        canvas.drawPath(arc,paint);
        canvas.drawLine(getWidth() / 2, getHeight() / 2, (float) Math.cos(Math.toRadians(getAngelFromMark(mark))) * length + getWidth() / 2, (float) Math.sin(Math.toRadians(getAngelFromMark(mark))) * length + getHeight() / 2, paint);

    }

    private int getAngelFromMark(int mark) {
        return (int) (90 + (float) ANGEL / 2 + (360 - (float) ANGEL) / 20 * mark);
    }
}
