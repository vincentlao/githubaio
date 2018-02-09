package com.laoning.githubaio.repository.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.laoning.githubaio.repository.local.base.IntegerListConverter;

import java.util.List;

/**
 * Created by laoning on 06/02/2018.
 */

@Entity(tableName = "star_for_user", primaryKeys = {"user", "page"})
@TypeConverters(IntegerListConverter.class)
public class StarForUser {


    @NonNull
    @SerializedName("user")
    @ColumnInfo(name = "user")
    private final String user;


    @NonNull
    @SerializedName("page")
    @ColumnInfo(name = "page")
    private final int page;


    @SerializedName("ids")
    @ColumnInfo(name = "ids")
    private final List<Long> ids;

    public StarForUser(@NonNull String user, int page, List<Long> ids) {
        this.user = user;
        this.page = page;
        this.ids = ids;
    }

    public String getUser() {
        return user;
    }

    public int getPage() {
        return page;
    }

    public List<Long> getIds() {
        return ids;
    }
}
