package com.laoning.githubaio.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.laoning.githubaio.AppExecutors;
import com.laoning.githubaio.repository.entity.GithubAccount;
import com.laoning.githubaio.repository.entity.GithubUser;
import com.laoning.githubaio.repository.local.GithubDatabase;
import com.laoning.githubaio.repository.remote.GithubService;
import com.laoning.githubaio.repository.remote.base.ApiResponse;
import com.laoning.githubaio.repository.remote.base.NetworkBoundResource;
import com.laoning.githubaio.repository.remote.base.Resource;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;

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

    public LiveData<GithubAccount> getFirstAccountLocally() {
        return githubDatabase.accountDao().getFirstAccount();
    }

    public LiveData<List<GithubAccount>> loadAccounts() {
        return githubDatabase.accountDao().loadAccounts();
    }

    public void addAccount(GithubAccount account) {
        githubDatabase.accountDao().addAccount(account);
    }

    public void deleteAccount(GithubAccount account) {
        githubDatabase.accountDao().deleteAccount(account);
    }

    public LiveData<Resource<GithubUser>> loginUser(String login, String authentication) {
        return new NetworkBoundResource<GithubUser, GithubUser>(appExecutors, true, true) {
            @Override
            protected void saveCallResult(@NonNull GithubUser item) {

                Type type=new TypeToken<GithubUser>(){}.getType();
                Log.d("aio", "user: " + new GsonBuilder().create().toJson(item, type));
                githubDatabase.userDao().addUser(item);
            }

            @Override
            protected boolean shouldFetch(@Nullable GithubUser data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<GithubUser> loadFromDb() {
                Log.d("aio", "loadFromDb, login = " + login);
                return githubDatabase.userDao().findByLogin(login);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<GithubUser>> createCall() {
                return githubService.loginUser(authentication);
            }
        }.asLiveData();
    }


    public LiveData<Resource<GithubUser>> loadUser(String login) {
        return new NetworkBoundResource<GithubUser, GithubUser>(appExecutors, false, false) {
            @Override
            protected void saveCallResult(@NonNull GithubUser item) {
                githubDatabase.userDao().addUser(item);
            }

            @Override
            protected boolean shouldFetch(@Nullable GithubUser data) {
                return data == null;
            }

            @NonNull
            @Override
            protected LiveData<GithubUser> loadFromDb() {
                return githubDatabase.userDao().findByLogin(login);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<GithubUser>> createCall() {
                return githubService.getUser(login);
            }
        }.asLiveData();
    }
}
