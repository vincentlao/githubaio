
package com.laoning.githubaio.repository.entity.event;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Actor {

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private Integer id;

    @SerializedName("login")
    @ColumnInfo(name = "login")
    private String login;

    @SerializedName("display_login")
    @ColumnInfo(name = "display_login")
    private String displayLogin;

    @SerializedName("gravatar_id")
    @ColumnInfo(name = "gravatar_id")
    private String gravatarId;

    @SerializedName("url")
    @ColumnInfo(name = "url")
    private String url;

    @SerializedName("avatar_url")
    @ColumnInfo(name = "avatar_url")
    private String avatarUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDisplayLogin() {
        return displayLogin;
    }

    public void setDisplayLogin(String displayLogin) {
        this.displayLogin = displayLogin;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
