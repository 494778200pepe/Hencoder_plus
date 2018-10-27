package com.jcoder.hencoder_plus.plus7;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jcoder.hencoder_plus.R;
import com.jcoder.hencoder_plus.Utils;

/**
 * @author wang
 * @date 2018/10/24.
 */

public class AvatarView extends View {

    private static final float WIDTH = Utils.dp2px(50);
    private static final float EDGE_WIDTH = Utils.dp2px(2);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    Bitmap bitmap;
    RectF rectF;

    public AvatarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = getAvatar(WIDTH * 2);
        rectF = new RectF(getWidth() / 2 - WIDTH, getWidth() / 2 - WIDTH, getWidth() / 2 + WIDTH, getWidth() / 2 + WIDTH);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        // 画背景圆
        canvas.drawOval(rectF, paint);

        // 画头像
        int saveLayer = canvas.saveLayer(rectF, paint);
        canvas.drawOval(rectF.left + EDGE_WIDTH, rectF.top + EDGE_WIDTH, rectF.right - EDGE_WIDTH, rectF.bottom - EDGE_WIDTH, paint);
        paint.setXfermode(porterDuffXfermode);
        canvas.drawBitmap(bitmap, getWidth() / 2 - WIDTH, getWidth() / 2 - WIDTH, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    Bitmap getAvatar(float width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.pepe, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = (int) width;
        return BitmapFactory.decodeResource(getResources(), R.drawable.pepe, options);
    }
}
