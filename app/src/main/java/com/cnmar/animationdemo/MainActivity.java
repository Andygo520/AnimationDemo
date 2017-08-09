package com.cnmar.animationdemo;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            使用AnimationUtils加载res/anim/下面的一个补间动画资源文件
//                Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha_animation);
                /*
                * 使用JAVA代码创建动画
                *  AlphaAnimation animation = new AlphaAnimation(0, 1);
                   animation.setDuration(3000);
                *
                * */
//                btn.startAnimation(animation);
//           使用属性动画改变按钮的背景色,在3秒内实现颜色从蓝色渐变为绿色，动画会无限播放并且会有反转效果
                ObjectAnimator colorAnim=ObjectAnimator.ofInt(btn,"backgroundColor", Color.BLUE,Color.GREEN);
                colorAnim.setDuration(3000);
                colorAnim.setEvaluator(new ArgbEvaluator());
                colorAnim.setRepeatCount(ValueAnimator.INFINITE);
                colorAnim.setRepeatMode(ValueAnimator.REVERSE);
                colorAnim.start();
            }
        });
    }
}
