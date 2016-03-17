package com.example.glidedemo;

import java.io.Serializable;

/**
 * Created by 李浩田 on 2016/3/16.
 */
public class Info implements Serializable {
    private String title;
    private String titleImage;
    private String slug;
    private String author;
    private String time;
    private int commentsCount;
    private int likesCount;

    public Info(String title, String titleImage,
                String slug, String author, String time,
                int commentsCount, int likesCount) {
        this.title = title;
        this.titleImage = titleImage;
        this.slug = slug;
        this.author = author;
        this.time = time;
        this.commentsCount = commentsCount;
        this.likesCount = likesCount;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public String getSlug() {
        return slug;
    }

    public String getAuthor() {
        return author;
    }

    public String getTime() {
        return time;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public int getLikesCount() {
        return likesCount;
    }
}
