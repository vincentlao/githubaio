package com.laoning.githubaio.repository.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.laoning.githubaio.repository.local.dao.GithubAccountDao;
import com.laoning.githubaio.repository.local.dao.GithubUserDao;
import com.laoning.githubaio.repository.entity.GithubAccount;
import com.laoning.githubaio.repository.entity.GithubUser;

/**
 * Created by laoning on 01/02/2018.
 */

@Database(entities = {GithubAccount.class, GithubUser.class}, version = 1, exportSchema = false)
public abstract class GithubDatabase extends RoomDatabase {

    public abstract GithubUserDao userDao();
    public abstract GithubAccountDao accountDao();
}
