package com.laoning.githubaio.repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.laoning.githubaio.repository.entity.GithubAccount;
import com.laoning.githubaio.repository.local.GithubDatabase;
import com.laoning.githubaio.repository.remote.GithubService;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by laoning on 01/02/2018.
 */

public class AccountRepository {

    private GithubDatabase githubDatabase;
    private GithubService githubService;

    @Inject
    public AccountRepository(GithubDatabase githubDatabase, GithubService githubService) {
        this.githubDatabase = githubDatabase;
        this.githubService = githubService;
    }

    public LiveData<GithubAccount> getFirstAccount() {
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
}
