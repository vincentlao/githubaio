package com.laoning.githubaio.repository;

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

    @Inject
    public UserRepository(GithubDatabase githubDatabase, GithubService githubService) {
        this.githubDatabase = githubDatabase;
        this.githubService = githubService;
    }
}
