package com.laoning.githubaio.repository.entity.user;

import android.arch.persistence.room.ColumnInfo;

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
    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "space")
    public int space;

    @ColumnInfo(name = "collaborators")
    public int collaborators;

    @ColumnInfo(name = "private_repos")
    public int private_repos;
}
