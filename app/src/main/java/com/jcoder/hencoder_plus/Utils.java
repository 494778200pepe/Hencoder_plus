package com.jcoder.hencoder_plus;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * @author wang
 * @date 2018/10/24.
 */

public class Utils {

    public static float dp2px(float dp){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp, Resources.getSystem().getDisplayMetrics());
    }
}
