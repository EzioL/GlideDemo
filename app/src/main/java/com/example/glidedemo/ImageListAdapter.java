package com.example.glidedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by 李浩田 on 2016/3/16.
 * 自定义Adapter用glide 加载
 */
public class ImageListAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] imageUrls;

    public ImageListAdapter(Context context, String[] imageUrls) {
        super(context, R.layout.listview_item_image,imageUrls);
        this.context = context;
        this.imageUrls = imageUrls;

        inflater = LayoutInflater.from(context);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.listview_item_image, parent, false);
        }

        Glide
                .with(context)
                .load(imageUrls[position])
                .into((ImageView) convertView);

        return convertView;
    }
}
