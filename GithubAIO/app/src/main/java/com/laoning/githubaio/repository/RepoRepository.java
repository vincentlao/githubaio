package com.laoning.githubaio.repository;

import android.arch.lifecycle.LiveData;

import com.laoning.githubaio.AppExecutors;
import com.laoning.githubaio.repository.entity.Account;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.local.GithubDatabase;
import com.laoning.githubaio.repository.remote.GithubService;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by laoning on 06/02/2018.
 */

public class RepoRepository {

    private GithubDatabase githubDatabase;
    private GithubService githubService;
    private final AppExecutors appExecutors;

    @Inject
    public RepoRepository(GithubDatabase githubDatabase, GithubService githubService, AppExecutors appExecutors) {
        this.githubDatabase = githubDatabase;
        this.githubService = githubService;
        this.appExecutors = appExecutors;
    }

//    public LiveData<List<Event>> loadEvent(String login) {
//        return githubDatabase.eventDao().loadById();
//    }
}
