package com.laoning.githubaio.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.laoning.githubaio.base.GlobalInfo;
import com.laoning.githubaio.repository.AccountRepository;
import com.laoning.githubaio.repository.entity.GithubAccount;
import com.laoning.githubaio.repository.entity.GithubUser;
import com.laoning.githubaio.repository.remote.base.AbsentLiveData;
import com.laoning.githubaio.repository.remote.base.ApiResponse;
import com.laoning.githubaio.repository.remote.base.Resource;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by laoning on 01/02/2018.
 */

public class SplashViewModel extends ViewModel {

    private LiveData<GithubAccount> firstAccountLocally;
    private final AccountRepository accountRepository;

    @Inject
    public SplashViewModel(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        firstAccountLocally = accountRepository.getFirstAccountLocally();
    }

    public LiveData<GithubAccount> getFirstAccountLocally() {
        return firstAccountLocally;
    }
}
