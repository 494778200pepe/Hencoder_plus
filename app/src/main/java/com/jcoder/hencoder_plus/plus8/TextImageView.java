package com.jcoder.hencoder_plus.plus8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jcoder.hencoder_plus.Utils;

/**
 * @author wang
 * @date 2018/10/26.
 */

public class TextImageView extends View {

    private static final String text = "如何保证客户端所持有的公钥就是某合法服务器声明的公钥？\n" +
            "如果不能保证这一点，那么客户端发送的信息就有可能存在被窃听的危险，因为用此公钥加密的数据可以被其对应的私钥拥有者获取，而该私钥并不在客户端所认为的服务器上。 因此可采用一个权威机构进行证书的颁发，所谓证书就是包含了服务器声明的公钥以及组织名称等信息，这里我们只考虑最关键的公钥信息。该权威机构会对申请证书的组织进行审核，确保其身份合法，然后将服务器公钥信息发布给客户端，客户端可利用该公钥与对应的服务器进行通信。整个过程可归纳为以下几步： 1、服务器生成一对密钥，私钥自己留着，公钥交给数字证书认证机构（CA） 2、CA进行审核，并用CA自己的私钥对服务器提供的公钥进行签名（参照上文RSA签名） 3、客户端从CA获取证书（即服务器端公钥），用CA的公钥对签名的证书进行验证，比对一致，说明该服务器公钥确实是CA颁发的（得此结论有一个前提就是：客户端的CA公钥确实是CA的公钥，即该CA的公钥与CA对证书进行签名的私钥确实是一对。参照上文RSA签名中所论述的情况），而CA又作为权威机构保证该公钥的确是服务器端提供的，从而可以确认该证书中的公钥确实是合法服务器端提供的.";
    TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    StaticLayout staticLayout;

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    float marginTop = 0.27f;
    float marginLeft = 0;
    float[] width = new float[1];

    public TextImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        textPaint.setTextSize(Utils.dp2px(12));
        paint.setTextSize(Utils.dp2px(12));
    }

    {

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // 文字间距所乘以的比率
        // 文件间距偏移
        // 纵向，是否要加额外的高度
        staticLayout = new StaticLayout(text, textPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        staticLayout.draw(canvas);

        canvas.drawBitmap(Utils.getAvatar(getResources(), Utils.dp2px(100)), marginLeft * getWidth(), marginTop * getHeight(), paint);
        int index = 0;
        int lineNumber;
        float y = paint.getFontSpacing();
        float x;
        while (index < text.length()) {
            if (y > marginTop * getHeight() && y < marginTop * getHeight() + Utils.dp2px(100) + paint.getFontSpacing()) {
                x = Utils.dp2px(100);
            } else {
                x = 0;
            }
            lineNumber = paint.breakText(text, index, text.length(), true, getWidth() - x, width);//获取第一行的宽度
            canvas.drawText(text, index, index + lineNumber, x, y, paint);
            index += lineNumber;
            y += paint.getFontSpacing();
        }
    }

}
