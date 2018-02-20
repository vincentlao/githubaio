package com.laoning.githubaio.repository.entity.notification;

/**
 * Created by laoni on 2018-2-20.
 */

public class Subject {

    public enum Type{
        Issue, PullRequest, Commit
    }

    private String title;

    private String url;

    private String latest_comment_url;

    private String type;

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
    public void setLatest_comment_url(String latest_comment_url){
        this.latest_comment_url = latest_comment_url;
    }
    public String getLatest_comment_url(){
        return this.latest_comment_url;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
