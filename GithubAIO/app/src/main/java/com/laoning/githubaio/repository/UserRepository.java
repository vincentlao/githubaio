package com.laoning.githubaio.repository;

import android.arch.lifecycle.LiveData;

import com.laoning.githubaio.AppExecutors;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.local.GithubDatabase;
import com.laoning.githubaio.repository.remote.GithubService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by laoning on 01/02/2018.
 */

@Singleton
public class UserRepository {
    @Inject  GithubDatabase githubDatabase;
    @Inject  GithubService githubService;
    @Inject  AppExecutors appExecutors;

    @Inject
    public UserRepository() {
    }

    public LiveData<User> findByLogin(String login) {
        return githubDatabase.userDao().findByLogin(login);
    }
}
