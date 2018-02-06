package com.laoning.githubaio.base;

import com.laoning.githubaio.repository.entity.Account;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by laoni on 2018-2-3.
 */

@Singleton
public class GlobalInfo {

    private Account currentUserAccount = new Account();

    @Inject
    public GlobalInfo() {

    }

    public Account getCurrentUserAccount() {
        return currentUserAccount;
    }
}
