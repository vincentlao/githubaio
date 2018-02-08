
package com.laoning.githubaio.repository.entity.repository;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class License {

    @SerializedName("key")
    @ColumnInfo(name = "key")
    private String key;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("spdx_id")
    @ColumnInfo(name = "spdx_id")
    private String spdxId;

    @SerializedName("url")
    @ColumnInfo(name = "url")
    private String url;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpdxId() {
        return spdxId;
    }

    public void setSpdxId(String spdxId) {
        this.spdxId = spdxId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
