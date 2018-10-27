package com.jcoder.hencoder_plus.plus7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jcoder.hencoder_plus.Utils;

/**
 * @author wang
 * @date 2018/10/24.
 */

public class PieChart extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private static final float radius = Utils.dp2px(70);
    private static final float length = Utils.dp2px(10);

    int[] angles = {60, 100, 120, 80};
    int[] colors = {Color.parseColor("#2979FF"), Color.parseColor("#C2185B"), Color.parseColor("#009688"), Color.parseColor("#FF8F00")};
    RectF rectF = new RectF();

    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rectF.left = getWidth() / 2 - radius;
        rectF.top = getHeight() / 2 - radius;
        rectF.right = getWidth() / 2 + radius;
        rectF.bottom = getHeight() / 2 + radius;

        Log.d("pepe", "rectF.left = " + rectF.left);
        Log.d("pepe", "rectF.top = " + rectF.top);
        Log.d("pepe", "rectF.right = " + rectF.right);
        Log.d("pepe", "rectF.bottom = " + rectF.bottom);

        int currAngel = 0;
        for (int i = 0; i < angles.length; i++) {
            paint.setColor(colors[i]);
            canvas.save();
            if (i == 2) {
                canvas.translate((float) Math.cos(Math.toRadians(currAngel + angles[i] / 2)) * length, (float) Math.sin(Math.toRadians(currAngel + angles[i] / 2)) * length);
            }
            canvas.drawArc(rectF, currAngel, angles[i], true, paint);
            canvas.restore();
            currAngel += angles[i];
        }
    }
}
