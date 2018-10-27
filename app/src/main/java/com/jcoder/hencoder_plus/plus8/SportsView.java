package com.jcoder.hencoder_plus.plus8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jcoder.hencoder_plus.Utils;

/**
 * @author wang
 * @date 2018/10/26.
 */

public class SportsView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public SportsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.dp2px(10));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.GRAY);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 0.8f * getWidth() / 2, paint);
        paint.setColor(Color.parseColor("#FF4081"));
        canvas.drawArc(0.1f * getWidth(), 0.1f * getWidth(), 0.9f * getWidth(), 0.9f * getHeight(), -90, 270, false, paint);


        paint.setTextSize(Utils.dp2px(25));
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        String text = "aaaa";
        float offset;
        // 方式一，完全包裹
        Rect rect = new Rect();
        paint.getTextBounds(text,0,text.length(),rect);
        offset = (rect.top + rect.bottom)/2;
        canvas.drawText(text, getWidth() / 2, getHeight() / 2 - offset, paint);

        paint.setColor(Color.parseColor("#3F51B5"));
        // 方式二，防止文字变化抖动
        Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
        paint.getFontMetrics(fontMetrics);
        offset = (fontMetrics.ascent + fontMetrics.descent)/2;
        canvas.drawText(text, getWidth() / 2, getHeight() / 2 - offset, paint);
    }

}
