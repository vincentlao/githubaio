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

public class AccountViewModel extends ViewModel {

    private LiveData<GithubAccount> firstAccountLocally;
    private LiveData<List<GithubAccount>> listLiveData;

    private final AccountRepository accountRepository;
    private final GlobalInfo globalInfo;

    @Inject
    public AccountViewModel(AccountRepository accountRepository, GlobalInfo globalInfo) {
        this.accountRepository = accountRepository;
        this.globalInfo = globalInfo;
        firstAccountLocally = accountRepository.getFirstAccountLocally();
        listLiveData = accountRepository.loadAccounts();
    }

    public void saveUserAccount(GithubAccount githubAccount) {
        accountRepository.addAccount(githubAccount);
    }

    public LiveData<GithubAccount> getFirstAccountLocally() {
        return firstAccountLocally;
    }

    public LiveData<List<GithubAccount>> loadAccounts() {
        return listLiveData;
    }

    public LiveData<GithubUser> loginUser() {
        LiveData<Resource<GithubUser>> apiResponse =  accountRepository.loginUser(globalInfo.getCurrentUserAccount().getName());

        LiveData<GithubUser> user = Transformations.switchMap(apiResponse, data -> {
            if (data == null) {
                return AbsentLiveData.<GithubUser>create();
            } else {
                MutableLiveData<GithubUser> u = new MutableLiveData<>();
                u.postValue(data.data);
                return u;
            }
        });

        return  user;
    }
}
