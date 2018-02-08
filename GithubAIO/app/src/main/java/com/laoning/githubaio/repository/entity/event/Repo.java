
package com.laoning.githubaio.repository.entity.event;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repo {

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private Integer id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("url")
    @ColumnInfo(name = "url")
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
