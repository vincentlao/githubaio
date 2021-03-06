package com.laoning.githubaio.repository.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.laoning.githubaio.repository.local.base.IntegerListConverter;

import java.util.List;

/**
 * Created by laoning on 06/02/2018.
 */

@Entity(tableName = "event_for_user", primaryKeys = {"user", "type", "page"})
@TypeConverters(IntegerListConverter.class)
public class EventForUser {

    public enum Type {
        ReceivedEvent,
        PerformedEvent,
    }

    @NonNull
    @SerializedName("user")
    @ColumnInfo(name = "user")
    private final String user;

    @NonNull
    @SerializedName("type")
    @ColumnInfo(name = "type")
    private final int type;


    @NonNull
    @SerializedName("page")
    @ColumnInfo(name = "page")
    private final int page;


    @SerializedName("event_ids")
    @ColumnInfo(name = "event_ids")
    private final List<Long> eventIds;

    public EventForUser(@NonNull String user,  int type, int page, List<Long> eventIds) {
        this.user = user;
        this.type = type;
        this.page = page;
        this.eventIds = eventIds;
    }

    public String getUser() {
        return user;
    }

    public int getType() {
        return  type;
    }

    public int getPage() {
        return page;
    }

    public List<Long> getEventIds() {
        return eventIds;
    }
}
