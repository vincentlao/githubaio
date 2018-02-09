package com.laoning.githubaio.repository.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by laoning on 01/02/2018.
 */

@Entity(tableName = "account")
public class Account {
    @NonNull
    @PrimaryKey
    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @SerializedName("password")
    @ColumnInfo(name = "password")
    private String password;

    @NonNull
    @SerializedName("authorization")
    @ColumnInfo(name = "authorization")
    private String authorization;

    @SerializedName("avatar_url")
    @ColumnInfo(name = "avatar_url")
    private String avatarUrl;


    @SerializedName("create_at")
    @ColumnInfo(name = "create_at")
    private String createAt;


    public Account() {
    }

    public void setName(String name) {
        this.name =  name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getCreateAt() {
        return createAt;
    }
}
