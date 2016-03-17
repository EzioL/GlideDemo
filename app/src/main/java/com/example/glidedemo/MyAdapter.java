package com.example.glidedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by 李浩田 on 2016/3/16.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;

    private ArrayList<Info> infos;
    public MyAdapter(Context context, ArrayList<Info> infos) {
        this.context = context;
        this.infos = infos;

    }


    @Override
    public int getCount() {
        return infos.size();
    }

    @Override
    public Object getItem(int position) {
        return infos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout ll = (LinearLayout)inflater.inflate(R.layout.myadapter_layout, null);

        ImageView titleImage = (ImageView)ll.findViewById(R.id.iv_titleImage);
        TextView title = (TextView)ll.findViewById(R.id.tv_title);
        TextView author = (TextView)ll.findViewById(R.id.tv_author);
        TextView time = (TextView)ll.findViewById(R.id.tv_time);
        TextView comments = (TextView)ll.findViewById(R.id.tv_comments);
        TextView likesCount = (TextView)ll.findViewById(R.id.tv_likesCount);
        TextView slug = (TextView)ll.findViewById(R.id.tv_slug);

        Glide.with(context).load(infos.get(position).getTitleImage()).into(titleImage);

        title.setText(infos.get(position).getTitle());
        author.setText(infos.get(position).getAuthor());
        time.setText(infos.get(position).getTime());
        //comments.setText(infos.get(position).getCommentsCount()+"");
       // likesCount.setText(infos.get(position).getLikesCount()+"");
        slug.setText(infos.get(position).getSlug());

        return ll;
    }
}
