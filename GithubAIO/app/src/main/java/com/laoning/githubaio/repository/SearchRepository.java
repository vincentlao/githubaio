package com.laoning.githubaio.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.laoning.githubaio.AppExecutors;
import com.laoning.githubaio.repository.entity.event.Repo;
import com.laoning.githubaio.repository.entity.notification.Notification;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.repository.entity.search.SearchResult;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.local.GithubDatabase;
import com.laoning.githubaio.repository.remote.GithubService;
import com.laoning.githubaio.repository.remote.base.ApiResponse;
import com.laoning.githubaio.repository.remote.base.NetworkBoundResource;
import com.laoning.githubaio.repository.remote.base.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.http.Query;

/**
 * Created by laoning on 06/02/2018.
 */

@Singleton
public class SearchRepository {

    @Inject GithubDatabase githubDatabase;
    @Inject GithubService githubService;
    @Inject AppExecutors appExecutors;

    private List<Repository> repos;
    private List<User> users;

    @Inject
    public SearchRepository() {
    }

    public LiveData<Resource<List<Repository>>> searchRepos(String query, String sort, String order, int page) {
        return new NetworkBoundResource<List<Repository>, SearchResult<Repository>>(appExecutors) {
            @Override
            protected List<Repository> processResponse(ApiResponse<SearchResult<Repository>> response) {
                if (repos == null || page == 1) {
                    repos = response.body.getItems();
                } else {
                    repos.addAll(response.body.getItems());
                }

                return repos;
            }


            protected void saveCallResult(@NonNull List<Repository> result) {

            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<SearchResult<Repository>>> createCall() {
                return githubService.searchRepos(query, sort, order, page);
            }
        }.asLiveData();
    }


    public LiveData<Resource<List<User>>> searchUsers(String query, String sort, String order, int page) {
        return new NetworkBoundResource<List<User>, SearchResult<User>>(appExecutors) {
            @Override
            protected List<User> processResponse(ApiResponse<SearchResult<User>> response) {
                if (users == null || page == 1) {
                    users = response.body.getItems();
                } else {
                    users.addAll(response.body.getItems());
                }

                return users;
            }


            protected void saveCallResult(@NonNull List<User> result) {

            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<SearchResult<User>>> createCall() {
                return githubService.searchUsers(query, sort, order, page);
            }
        }.asLiveData();
    }
}
