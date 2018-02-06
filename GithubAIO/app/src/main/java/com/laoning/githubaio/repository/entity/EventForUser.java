package com.laoning.githubaio.repository.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.laoning.githubaio.repository.local.base.IntegerListConverter;

import java.util.List;

/**
 * Created by laoning on 06/02/2018.
 */

@Entity(tableName = "event_for_user")
@TypeConverters(IntegerListConverter.class)
public class EventForUser {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "user_and_page")
    private final String userAndPage;

    @ColumnInfo(name = "event_ids")
    private final List<Long> eventIds;

    public EventForUser(@NonNull String userAndPage, List<Long> eventIds) {
        this.userAndPage = userAndPage;
        this.eventIds = eventIds;
    }

    public String getUserAndPage() {
        return userAndPage;
    }

    public List<Long> getEventIds() {
        return eventIds;
    }

}
