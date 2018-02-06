package com.laoning.githubaio.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.laoning.githubaio.AppExecutors;
import com.laoning.githubaio.repository.entity.Account;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.local.GithubDatabase;
import com.laoning.githubaio.repository.remote.GithubService;
import com.laoning.githubaio.repository.remote.base.ApiResponse;
import com.laoning.githubaio.repository.remote.base.NetworkBoundResource;
import com.laoning.githubaio.repository.remote.base.Resource;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by laoning on 01/02/2018.
 */
public class AccountRepository {

    private final GithubDatabase githubDatabase;
    private final GithubService githubService;
    private final AppExecutors appExecutors;

    @Inject
    public AccountRepository(GithubDatabase githubDatabase, GithubService githubService, AppExecutors appExecutors) {
        this.githubDatabase = githubDatabase;
        this.githubService = githubService;
        this.appExecutors = appExecutors;
    }

    public LiveData<Account> getFirstAccountLocally() {
        return githubDatabase.accountDao().getFirstAccount();
    }

    public LiveData<List<Account>> loadAccounts() {
        return githubDatabase.accountDao().loadAccounts();
    }

    public void addAccount(Account account) {
        appExecutors.diskIO().execute(() -> {
            githubDatabase.accountDao().addAccount(account);
        });
    }

    public void deleteAccount(Account account) {
        githubDatabase.accountDao().deleteAccount(account);
    }

    public LiveData<Resource<User>> loginUser(String login, String authentication) {
        return new NetworkBoundResource<User, User>(appExecutors, true, true) {
            @Override
            protected void saveCallResult(@NonNull User item) {

                Type type=new TypeToken<User>(){}.getType();
                Log.d("aio", "user: " + new GsonBuilder().create().toJson(item, type));
                githubDatabase.userDao().addUser(item);
            }

            @Override
            protected boolean shouldFetch(@Nullable User data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<User> loadFromDb() {
                Log.d("aio", "loadFromDb, login = " + login);
                return githubDatabase.userDao().findByLogin(login);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<User>> createCall() {
                return githubService.loginUser(authentication);
            }
        }.asLiveData();
    }


    public LiveData<Resource<User>> loadUser(String login) {
        return new NetworkBoundResource<User, User>(appExecutors, false, false) {
            @Override
            protected void saveCallResult(@NonNull User item) {
                githubDatabase.userDao().addUser(item);
            }

            @Override
            protected boolean shouldFetch(@Nullable User data) {
                return data == null;
            }

            @NonNull
            @Override
            protected LiveData<User> loadFromDb() {
                return githubDatabase.userDao().findByLogin(login);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<User>> createCall() {
                return githubService.loadUser(login);
            }
        }.asLiveData();
    }
}
