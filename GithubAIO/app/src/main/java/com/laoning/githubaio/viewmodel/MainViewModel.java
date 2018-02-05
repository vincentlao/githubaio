package com.laoning.githubaio.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.laoning.githubaio.AppExecutors;
import com.laoning.githubaio.base.GlobalInfo;
import com.laoning.githubaio.repository.AccountRepository;
import com.laoning.githubaio.repository.entity.GithubAccount;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by laoni on 2018-2-5.
 */

public class MainViewModel extends ViewModel {
    private final AccountRepository accountRepository;
    private final GlobalInfo globalInfo;
    private final AppExecutors appExecutors;

    @Inject
    public MainViewModel(AccountRepository accountRepository, GlobalInfo globalInfo, AppExecutors appExecutors) {
        this.accountRepository = accountRepository;
        this.globalInfo = globalInfo;
        this.appExecutors = appExecutors;
    }
}
