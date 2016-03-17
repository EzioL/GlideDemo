package com.example.glidedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private ListView lsitview;
    private  ArrayList<Info> list = new ArrayList<Info>();
    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lsitview  = (ListView) findViewById(R.id.listView);
        mQueue = Volley.newRequestQueue(this);

        getData();

        MyAdapter1 adapter1=new MyAdapter1(this);
        MyAdapter adapter=new MyAdapter(this,list);
        lsitview.setAdapter(adapter);
       // lsitview.setAdapter(adapter1);




    }
    public ArrayList<Info> getdata(){
        ArrayList<Info> infos=new ArrayList<Info>();
        for(int i=0;i<10;i++){
            Info info = new Info("疯狂动物城》只是一部技术牛逼的电影吗？",
                    "https://pic2.zhimg.com/0635b914ae5e4a11f3fcb03e7145b689_b.jpg",
                    "20627196",
                    "木易",
                    "2016年3月16日20:10:35",
                    1,
                    95);

            infos.add(info);
        }


        return infos;

    }


    public void getData(){
        list.clear();

        String urlArray="http://zhuanlan.zhihu.com/api/columns/happymuyi/posts";

       /* getJSONArray data=new getJSONArray();

        infos=data.getInfos();*/
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(urlArray,
                new Response.Listener<JSONArray>(){
            public void onResponse(JSONArray response) {

                try {

                    for(int i=0;i<response.length();i++){

                        JSONObject job=response.getJSONObject(i);
                        String title=job.getString("title");
                        String titleImage=job.getString("titleImage");
                        String slug=job.getString("slug");
                        String time=job.getString("publishedTime").substring(0,9);
                        String author=job.getJSONObject("author").getString("name");
                        int commentsCount=job.getInt("commentsCount");
                        int likesCount=job.getInt("likesCount");
                        Log.e("文章标题",title);
                        Log.e("图片url",titleImage);
                        Log.e("文章id",slug);
                        Log.e("作者",author);
                        Log.e("评论数",commentsCount+"");
                        Log.e("点赞数",likesCount+"");

                        Info info = new Info(title, titleImage, slug,  author,
                                time, commentsCount,  likesCount);

                        list.add(info);


                    }


                }catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.v( "list.size = " , list.size()+"");
            }

        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                    }
                });
        mQueue.add(jsonArrayRequest);

    }


    public class getJSONArray implements Response.Listener<JSONArray> , Serializable {

        ArrayList<Info> infos;
        public ArrayList<Info> getInfos() {
            return infos;
        }


        @Override
        public void onResponse(JSONArray response) {

            try {

                for(int i=0;i<response.length();i++){

                    JSONObject job=response.getJSONObject(i);
                    String title=job.getString("title");
                    String titleImage=job.getString("titleImage");
                    String slug=job.getString("slug");
                    String time=job.getString("publishedTime");
                    String author=job.getJSONObject("author").getString("name");
                    int commentsCount=job.getInt("commentsCount");
                    int likesCount=job.getInt("likesCount");
                    Log.e("文章标题",title);
                    Log.e("图片url",titleImage);
                    Log.e("文章id",slug);
                    Log.e("作者",author);
                    Log.e("评论数",commentsCount+"");
                    Log.e("点赞数",likesCount+"");

                    Info info = new Info(title, titleImage, slug,  author,
                            time, commentsCount,  likesCount);

                    infos.add(info);


                }
                Log.e("getJSONArray",infos.size()+"");

            }catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }





}
