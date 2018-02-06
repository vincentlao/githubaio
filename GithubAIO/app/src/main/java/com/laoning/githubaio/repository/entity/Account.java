package com.laoning.githubaio.repository.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by laoning on 01/02/2018.
 */

@Entity(tableName = "account")
public class Account {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    @NonNull
    @ColumnInfo(name = "authorization")
    private String authorization;

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
}
