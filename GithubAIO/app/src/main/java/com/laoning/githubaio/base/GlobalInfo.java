package com.laoning.githubaio.base;

import com.laoning.githubaio.repository.entity.GithubAccount;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by laoni on 2018-2-3.
 */

public class GlobalInfo {

    private GithubAccount currentUserAccount = new GithubAccount();

    @Inject
    public GlobalInfo() {

    }

    public GithubAccount getCurrentUserAccount() {
        return currentUserAccount;
    }
}
