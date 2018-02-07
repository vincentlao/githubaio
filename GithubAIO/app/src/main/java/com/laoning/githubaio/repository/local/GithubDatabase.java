package com.laoning.githubaio.repository.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.laoning.githubaio.repository.entity.EventForUser;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.repository.local.dao.AccountDao;
import com.laoning.githubaio.repository.local.dao.EventDao;
import com.laoning.githubaio.repository.local.dao.RepositoryDao;
import com.laoning.githubaio.repository.local.dao.UserDao;
import com.laoning.githubaio.repository.entity.Account;
import com.laoning.githubaio.repository.entity.user.User;

/**
 * Created by laoning on 01/02/2018.
 */

@Database(entities = {Account.class, User.class, Event.class, EventForUser.class, Repository.class}, version = 1, exportSchema = false)
public abstract class GithubDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract AccountDao accountDao();
    public abstract EventDao eventDao();
    public abstract RepositoryDao repositoryDao();
}
