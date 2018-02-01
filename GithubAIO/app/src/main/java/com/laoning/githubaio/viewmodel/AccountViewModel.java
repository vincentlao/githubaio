package com.laoning.githubaio.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.laoning.githubaio.repository.entity.GithubAccount;

/**
 * Created by laoning on 01/02/2018.
 */

public class AccountViewModel extends ViewModel {
    private LiveData<GithubAccount> currentUserAccount;

    public LiveData<GithubAccount> getFirstAccount() {
        return currentUserAccount;
    }
}
