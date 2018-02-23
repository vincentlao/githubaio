package com.laoning.githubaio.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.laoning.githubaio.AppExecutors;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.repository.local.GithubDatabase;
import com.laoning.githubaio.repository.remote.GithubService;
import com.laoning.githubaio.repository.remote.base.ApiResponse;
import com.laoning.githubaio.repository.remote.base.NetworkBoundResource;
import com.laoning.githubaio.repository.remote.base.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by laoning on 06/02/2018.
 */

@Singleton
public class RepoRepository {

    @Inject GithubDatabase githubDatabase;
    @Inject GithubService githubService;
    @Inject AppExecutors appExecutors;

    @Inject
    public RepoRepository() {
    }

    public LiveData<Resource<List<Repository>>> loadMyRepos(int page, String type, String sort, String direction) {
        return new NetworkBoundResource<List<Repository>, List<Repository>>(appExecutors) {
            @Override
            protected List<Repository> processResponse(ApiResponse<List<Repository>> response) {
                return response.body;
            }


            protected void saveCallResult(@NonNull List<Repository> result) {

            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<Repository>>> createCall() {
                return githubService.getUserRepos(page, type, sort, direction);
            }
        }.asLiveData();
    }


    public LiveData<Resource<List<Repository>>> loadStarredRepos(String user, int page, String sort, String direction) {
        return new NetworkBoundResource<List<Repository>, List<Repository>>(appExecutors) {
            @Override
            protected List<Repository> processResponse(ApiResponse<List<Repository>> response) {
                return response.body;
            }


            protected void saveCallResult(@NonNull List<Repository> result) {

            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<Repository>>> createCall() {
                return githubService.getStarredRepos(user, page, sort, direction);
            }
        }.asLiveData();
    }
}
