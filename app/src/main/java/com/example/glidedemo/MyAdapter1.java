package com.example.glidedemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by 李浩田 on 2016/3/16.
 */
public class MyAdapter1 extends BaseAdapter {
    private Context context;
    String[] data = new String[]{
            "终于来了，这是现有三款 VR 设备里最便宜的",
            "带你走近「精」的世界，看看它们是如何「成精」的",
            "宋朝 GDP 占当时世界的 60%，是真的吗？",
            "推动历史的人，通常会是知识精英吗？"
    };
    public static String[] urls={
            "http://pic1.zhimg.com/6cc3a1f1ff82f8c14b7f990fb574bd90.jpg",
            "http://pic2.zhimg.com/bdb607643e20c150385e3a792fdc3ec5.jpg",
            "http://pic4.zhimg.com/6efad3e4e922239aa5c44ef66eb7bd7f.jpg",
            "http://pic4.zhimg.com/ce5bdfecba4e9109f856bee5e76a932f.jpg",
           };
    public MyAdapter1(Context context){
        this.context = context;
    }


    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout ll = (LinearLayout)inflater.inflate(R.layout.myadapter1_layout, null);
        ImageView iv = (ImageView)ll.findViewById(R.id.imageview);
        TextView tv = (TextView)ll.findViewById(R.id.textview);

        Glide.with(context).load(urls[position]).into(iv);
       /* Drawable drawble = context.getResources().getDrawable(R.drawable.icon);
        iv.setBackgroundDrawable(drawble);
        */
        tv.setText(data[position]);
        return ll;
    }
}
