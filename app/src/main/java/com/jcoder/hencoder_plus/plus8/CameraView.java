package com.jcoder.hencoder_plus.plus8;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.jcoder.hencoder_plus.Utils;

/**
 * @author wang
 * @date 2018/10/26.
 */

public class CameraView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Camera camera = new Camera();
    private float bitmapWidth;

    public CameraView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        camera.setLocation(0, 0, -6 * getResources().getDisplayMetrics().density);
    }

    {
        bitmapWidth = Utils.dp2px(150);
        bitmap = Utils.getAvatar(getResources(), bitmapWidth);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // translate
//        canvas.save();
//        canvas.translate(-100, -100);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//        canvas.restore();
//
//        canvas.save();
//        canvas.translate(200, 0);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//        canvas.restore();

        // scale  缩放的是显示宽高
//        canvas.save();
//        canvas.scale(2, 2);// 默认是(0,0)
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//        canvas.restore();
//
//        canvas.save();
//        canvas.scale(2, 2, bitmapWidth / 2, bitmapWidth /2);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//        canvas.restore();

        // rotate 顺时针旋转
//        canvas.save();
//        canvas.rotate(180, bitmapWidth / 2, bitmapWidth / 2);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//        canvas.restore();
//
//        canvas.save();
//        canvas.rotate(45, bitmapWidth / 2, bitmapWidth / 2);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//        canvas.restore();

        // skew  距离和倾斜度同时变化
//        canvas.save();
//        canvas.skew(0, 0.5f);
//        canvas.drawBitmap(bitmap, 200, 0, paint);
//        canvas.restore();
//
//        canvas.save();
//        canvas.skew(-0.5f, 0);
//        canvas.drawBitmap(bitmap, 200, 200, paint);
//        canvas.restore();

        // camera.rotate
//        canvas.save();
//        camera.save();
//        camera.rotateX(30);
//        camera.applyToCanvas(canvas);
//        camera.restore();
//        canvas.drawBitmap(bitmap,0, 0, paint);
//        canvas.restore();
//
//        canvas.save();
//        camera.save();
//        camera.rotateY(30);
//        camera.applyToCanvas(canvas);
//        camera.restore();
//        canvas.drawBitmap(bitmap, 100, 100, paint);
//        canvas.restore();

        // canvas.translate + camera.rotate
//        canvas.save();
//        canvas.translate(bitmapWidth / 2, bitmapWidth / 2);
//        camera.save();
//        camera.rotateY(30);
//        camera.applyToCanvas(canvas);
//        camera.restore();
//        canvas.translate(-bitmapWidth / 2, -bitmapWidth / 2);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//        canvas.restore();
//
//        canvas.save();
//        canvas.translate(150 + bitmapWidth / 2, 150 + bitmapWidth / 2);
//        camera.save();
//        camera.rotateY(30);
//        camera.applyToCanvas(canvas);
//        camera.restore();
//        canvas.translate(-150 - bitmapWidth / 2, -150 - bitmapWidth / 2);
//        canvas.drawBitmap(bitmap, 150, 150, paint);
//        canvas.restore();

        // canvas.clipRect + canvas.translate + camera.rotate
//        canvas.save();
//        canvas.translate(bitmapWidth / 2, bitmapWidth / 2);
//        camera.save();
//        camera.rotateX(30);
//        camera.applyToCanvas(canvas);
//        camera.restore();
//        canvas.clipRect(-bitmapWidth / 2, -bitmapWidth / 2, bitmapWidth / 2, 0);
//        canvas.translate(-bitmapWidth / 2, -bitmapWidth / 2);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//        canvas.restore();
//
//        canvas.save();
//        canvas.translate(bitmapWidth / 2, bitmapWidth / 2);
//        camera.save();
//        camera.rotateX(30);
//        camera.applyToCanvas(canvas);
//        camera.restore();
//        // clipRect  的时机，对最后图像有没有影响
//        canvas.clipRect(-bitmapWidth / 2, 0, bitmapWidth / 2, bitmapWidth / 2);
//        canvas.translate(-bitmapWidth / 2, -bitmapWidth / 2);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//        canvas.restore();


        // canvas.clipRect + canvas.translate + camera.rotate
        canvas.save();
        canvas.translate(100 + bitmapWidth / 2, 100 + bitmapWidth / 2);
        canvas.rotate(-10);
//        camera.save();
//        camera.rotateX(30);
//        camera.applyToCanvas(canvas);
//        camera.restore();
        canvas.clipRect(-bitmapWidth, -bitmapWidth, bitmapWidth, 0);
        canvas.rotate(10);
        canvas.translate(-100 - bitmapWidth / 2, -100 - bitmapWidth / 2);
        canvas.drawBitmap(bitmap, 100, 100, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(100 + bitmapWidth / 2, 100 + bitmapWidth / 2);
        canvas.rotate(-10);
        camera.save();
        camera.rotateX(45);
        camera.applyToCanvas(canvas);
        camera.restore();
        // clipRect  的时机，对最后图像有没有影响
        canvas.clipRect(-bitmapWidth, 0, bitmapWidth, bitmapWidth);
        canvas.rotate(10);
        canvas.translate(-100 - bitmapWidth / 2, -100 - bitmapWidth / 2);
        canvas.drawBitmap(bitmap, 100, 100, paint);
        canvas.restore();
    }

    // clip canvas camera
}
