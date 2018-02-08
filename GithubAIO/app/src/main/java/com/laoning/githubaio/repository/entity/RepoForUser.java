package com.laoning.githubaio.repository.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;
import com.laoning.githubaio.repository.local.base.IntegerListConverter;

import java.util.List;

/**
 * Created by laoning on 06/02/2018.
 */

@Entity(tableName = "account")
@TypeConverters(IntegerListConverter.class)
public class RepoForUser {

    @NonNull
    @PrimaryKey
    @SerializedName("login")
    @ColumnInfo(name = "login")
    private final String login;

    @SerializedName("repo_ids")
    @ColumnInfo(name = "repo_ids")
    private final List<Integer> repoIds;

    public RepoForUser(@NonNull String login, List<Integer> repoIds) {
        this.login = login;
        this.repoIds = repoIds;
    }

    public String getLogin() {
        return login;
    }

    public List<Integer> getRepoIds() {
        return repoIds;
    }

}
