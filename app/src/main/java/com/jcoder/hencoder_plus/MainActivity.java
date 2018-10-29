package com.jcoder.hencoder_plus;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jcoder.hencoder_plus.plus9.FlipView;

public class MainActivity extends AppCompatActivity {

    FlipView flipView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_plus7);
//        setContentView(R.layout.activity_plus8);
        setContentView(R.layout.activity_plus9);
        flipView = findViewById(R.id.view);


        // 第一个翻折动画
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofInt(flipView,"bottomDegree",45);

        // 第二个旋转动画
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofInt(flipView,"rotateDegree",270);

        // 第二个旋转动画
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofInt(flipView,"rightDegree",-45);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator1).before(objectAnimator2); // 先执行 1 再执行 2
        animatorSet.play(objectAnimator2).before(objectAnimator3); // 先执行 1 再执行 2
        animatorSet.setStartDelay(1000);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }
}
