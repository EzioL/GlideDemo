package com.example.glidedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener{
    ImageView  iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //继承自ActionBar的Activity之隐藏标题栏
        getSupportActionBar().hide();
        //最上面的电池电量及信号栏
        getWindow().setFlags(WindowManager.LayoutParams.TYPE_STATUS_BAR,
                WindowManager.LayoutParams.TYPE_STATUS_BAR);

        setContentView(R.layout.activity_main);


        iv= (ImageView) findViewById(R.id.imageView);

        Glide.with(this)
                .load("https://pic2.zhimg.com//102781f8a7a5a997db57b0e426953e74.jpg")
                .dontAnimate()//去掉默认动画 ，否则会和启动动画冲突。
                .into(iv);
        Animation animation = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f); // 将图片放大1.2倍，从中心开始缩放
        animation.setDuration(5000); // 动画持续时间
        animation.setFillAfter(true); // 动画结束后停留在结束的位置
        animation.setAnimationListener(MainActivity.this); // 添加动画监听
        iv.startAnimation(animation); // 启动动画



        /*Animation animation= AnimationUtils.loadAnimation(this, R.anim.enlarge);
        animation.setFillAfter(true);
        iv.startAnimation(animation);
*/


        /*Glide.with(this)
                .load("https://pic2.zhimg.com//102781f8a7a5a997db57b0e426953e74.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(iv);*/
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        //动画结束时跳转至首页
        startActivity(new Intent(this, Main2Activity.class));
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
