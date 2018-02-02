package com.laoning.githubaio.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.laoning.githubaio.repository.AccountRepository;
import com.laoning.githubaio.repository.entity.GithubAccount;

import javax.inject.Inject;

/**
 * Created by laoning on 01/02/2018.
 */

public class AccountViewModel extends ViewModel {
    private LiveData<GithubAccount> currentUserAccount;
    private AccountRepository accountRepository;

    @Inject
    public AccountViewModel(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        currentUserAccount = accountRepository.getFirstAccount();
    }

    public LiveData<GithubAccount> getFirstAccount() {
        return currentUserAccount;
    }
}
