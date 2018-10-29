package com.jcoder.hencoder_plus.plus9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jcoder.hencoder_plus.Utils;

/**
 * @author wang
 * @date 2018/10/27.
 */

public class FlipView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Camera camera = new Camera();
    private float bitmapWidth;
    int centerX, centerY;

    int bottomDegree = 0;
    int rightDegree = 0;
    int rotateDegree = 0;

    public int getRightDegree() {
        return rightDegree;
    }

    public void setRightDegree(int rightDegree) {
        this.rightDegree = rightDegree;
        invalidate();
    }

    public int getBottomDegree() {
        return bottomDegree;
    }

    public void setBottomDegree(int bottomDegree) {
        this.bottomDegree = bottomDegree;
        invalidate();
    }

    public int getRotateDegree() {
        return rotateDegree;
    }

    public void setRotateDegree(int rotateDegree) {
        this.rotateDegree = rotateDegree;
        invalidate();
    }

    public FlipView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmapWidth = Utils.dp2px(200);
        bitmap = Utils.getAvatar(getResources(), bitmapWidth);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(centerX, centerY);
        canvas.rotate(-rotateDegree);
        camera.save();
        camera.rotateX(rightDegree);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.clipRect(-bitmapWidth, -bitmapWidth, bitmapWidth, 0);
        canvas.rotate(rotateDegree);
        canvas.translate(-centerX, -centerY);
        canvas.drawBitmap(bitmap, centerX - bitmapWidth / 2, centerY - bitmapWidth / 2, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(centerX, centerY);
        canvas.rotate(-rotateDegree);
        camera.save();
        camera.rotateX(bottomDegree);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.clipRect(-bitmapWidth, 0, bitmapWidth, bitmapWidth);
        canvas.rotate(rotateDegree);
        canvas.translate(-centerX, -centerY);
        canvas.drawBitmap(bitmap, centerX - bitmapWidth / 2, centerY - bitmapWidth / 2, paint);
        canvas.restore();
    }
}
