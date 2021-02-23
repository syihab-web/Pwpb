package com.example.announce;

import java.util.Date;

public class Post {
    private String title;
    private String desc;
    private String datetime;

    public Post(){

    }
    public Post(String title) {
        this.title = title;
        this.desc = desc;
        this.datetime = datetime;
    }

    public Post(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public Post(String title, String desc, String datetime) {
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
