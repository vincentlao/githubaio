package com.laoning.githubaio.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.laoning.githubaio.AppExecutors;
import com.laoning.githubaio.base.GlobalInfo;
import com.laoning.githubaio.repository.AccountRepository;
import com.laoning.githubaio.repository.entity.Account;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.remote.base.Resource;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by laoni on 2018-2-4.
 */

public class LoginViewModel extends ViewModel {
    private LiveData<Account> firstAccountLocally;
    private LiveData<List<Account>> listLiveData;

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

    public void saveUserAccount(Account githubAccount) {
        accountRepository.addAccount(githubAccount);
    }

    public LiveData<Account> getFirstAccountLocally() {
        return firstAccountLocally;
    }

    public LiveData<List<Account>> loadAccountsLocally() {
        return listLiveData;
    }

    public LiveData<Resource<User>> loginUser() {
        return  accountRepository.loginUser(globalInfo.getCurrentUserAccount().getName(), globalInfo.getCurrentUserAccount().getAuthorization());
    }
}
