package com.laoning.githubaio.repository.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by laoning on 01/02/2018.
 */

@Entity(tableName = "github_account")
public class GithubAccount {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    public GithubAccount(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
