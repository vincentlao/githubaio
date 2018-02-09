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

public class UserRepository {
    private GithubDatabase githubDatabase;
    private GithubService githubService;
    private AppExecutors appExecutors;

    @Inject
    public UserRepository(GithubDatabase githubDatabase, GithubService githubService, AppExecutors appExecutors) {
        this.githubDatabase = githubDatabase;
        this.githubService = githubService;
        this.appExecutors = appExecutors;
    }

    public LiveData<User> findByLogin(String login) {
        return githubDatabase.userDao().findByLogin(login);
    }
}
