package com.laoning.githubaio.repository.entity.notification;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.laoning.githubaio.repository.entity.repository.Repository;


/**
 * Created by laoni on 2018-2-20.
 */

@Entity(tableName = "notification")
public class Notification {

    @PrimaryKey
    private String id;

    @Embedded(prefix = "repository_")
    private Repository repository;

    @Embedded(prefix = "subject_")
    private Subject subject;

    private String reason;

    private boolean unread;

    private String updated_at;

    private String last_read_at;

    private String url;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setRepository(Repository repository){
        this.repository = repository;
    }
    public Repository getRepository(){
        return this.repository;
    }
    public void setSubject(Subject subject){
        this.subject = subject;
    }
    public Subject getSubject(){
        return this.subject;
    }
    public void setReason(String reason){
        this.reason = reason;
    }
    public String getReason(){
        return this.reason;
    }
    public void setUnread(boolean unread){
        this.unread = unread;
    }
    public boolean getUnread(){
        return this.unread;
    }
    public void setUpdated_at(String updated_at){
        this.updated_at = updated_at;
    }
    public String getUpdated_at(){
        return this.updated_at;
    }
    public void setLast_read_at(String last_read_at){
        this.last_read_at = last_read_at;
    }
    public String getLast_read_at(){
        return this.last_read_at;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
}
