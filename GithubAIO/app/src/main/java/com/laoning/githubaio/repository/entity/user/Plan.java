package com.laoning.githubaio.repository.entity.user;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by laoning on 06/02/2018.
 */

//        "plan": {
//        "name": "free",
//        "space": 976562499,
//        "collaborators": 0,
//        "private_repos": 0
//        }

public class Plan {
    @SerializedName("name")
    @ColumnInfo(name = "name")
    public String name;

    @SerializedName("space")
    @ColumnInfo(name = "space")
    public int space;

    @SerializedName("collaborators")
    @ColumnInfo(name = "collaborators")
    public int collaborators;

    @SerializedName("private_repos")
    @ColumnInfo(name = "private_repos")
    public int private_repos;
}
