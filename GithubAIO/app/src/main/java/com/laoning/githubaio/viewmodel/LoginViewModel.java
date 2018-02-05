package com.laoning.githubaio.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.laoning.githubaio.AppExecutors;
import com.laoning.githubaio.base.GlobalInfo;
import com.laoning.githubaio.repository.AccountRepository;
import com.laoning.githubaio.repository.entity.GithubAccount;
import com.laoning.githubaio.repository.entity.GithubUser;
import com.laoning.githubaio.repository.remote.base.AbsentLiveData;
import com.laoning.githubaio.repository.remote.base.Resource;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by laoni on 2018-2-4.
 */

public class LoginViewModel extends ViewModel {
    private LiveData<GithubAccount> firstAccountLocally;
    private LiveData<List<GithubAccount>> listLiveData;

    private final AccountRepository accountRepository;
    private final GlobalInfo globalInfo;
    private final AppExecutors appExecutors;

    @Inject
    public LoginViewModel(AccountRepository accountRepository, GlobalInfo globalInfo, AppExecutors appExecutors) {
        this.accountRepository = accountRepository;
        this.globalInfo = globalInfo;
        this.appExecutors = appExecutors;
        firstAccountLocally = accountRepository.getFirstAccountLocally();
        listLiveData = accountRepository.loadAccounts();
    }

    public void saveUserAccount(GithubAccount githubAccount) {
        appExecutors.diskIO().execute(() -> {
            accountRepository.addAccount(githubAccount);
        });


    }

    public LiveData<GithubAccount> getFirstAccountLocally() {
        return firstAccountLocally;
    }

    public LiveData<List<GithubAccount>> loadAccountsLocally() {
        return listLiveData;
    }

    public LiveData<Resource<GithubUser>> loginUser() {
        return  accountRepository.loginUser(globalInfo.getCurrentUserAccount().getName(), globalInfo.getCurrentUserAccount().getAuthorization());
    }
}
