package com.laoning.githubaio.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.laoning.githubaio.base.GlobalInfo;
import com.laoning.githubaio.repository.AccountRepository;
import com.laoning.githubaio.repository.entity.Account;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.remote.base.Resource;

import javax.inject.Inject;

/**
 * Created by laoning on 01/02/2018.
 */

public class SplashViewModel extends ViewModel {

    private LiveData<Account> firstAccountLocally;

    @Inject AccountRepository accountRepository;
    @Inject GlobalInfo globalInfo;

    @Inject
    public SplashViewModel() {

    }

    public LiveData<Account> getFirstAccountLocally() {
        if (firstAccountLocally == null) {
            firstAccountLocally = accountRepository.getFirstAccountLocally();
        }
        return firstAccountLocally;
    }

    public LiveData<Resource<User>> loginUser() {
        return  accountRepository.loginUser(globalInfo.getCurrentUserAccount().getName(), globalInfo.getCurrentUserAccount().getAuthorization());
    }
}
