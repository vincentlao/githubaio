package com.laoning.githubaio.ui.activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.laoning.githubaio.R;
import com.laoning.githubaio.base.GlobalInfo;
import com.laoning.githubaio.repository.entity.Account;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.remote.base.Resource;
import com.laoning.githubaio.viewmodel.SplashViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by laoning on 01/02/2018.
 */

public class SplashActivity extends BaseActivity {

    private SplashViewModel splashViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    GlobalInfo globalInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        splashViewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel.class);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_splash);

        loadUser();
    }

    private void loadUser() {
        LiveData<Account> accountLiveData = splashViewModel.getFirstAccountLocally();

        accountLiveData.observe(this, account -> {
            if (account == null) {
                showLoginActivity();
            } else {
                String name = account.getName();
                String password = account.getPassword();
                String credentials = name + ":" + password;
                String authorization = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

                globalInfo.getCurrentUserAccount().setName(name);
                globalInfo.getCurrentUserAccount().setPassword(password);
                globalInfo.getCurrentUserAccount().setAuthorization(authorization);

                //too login
                LiveData<Resource<User>> user = splashViewModel.loginUser();
                user.observe(this, githubUser -> {
                    Log.d("aio", "user.observe callback");
                    if (githubUser == null || githubUser.data == null) {
                        Log.d("aio", "githubUser == null");
                        showLoginActivity();
                    } else {
                        Log.d("aio", "login success, login = " + githubUser.data.getLogin());
                        startActivity(new Intent(this, MainActivity.class));
                        finish();;
                    }
                });
                showMainActivity();
            }
        });
    }

    private void showLoginActivity() {
        final SplashActivity splashActivity = this;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splashActivity, LoginActivity.class));
                splashActivity.finish();
            }
        }, 1000);
    }

    private void showMainActivity() {
        final SplashActivity splashActivity = this;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splashActivity, MainActivity.class));
                splashActivity.finish();
            }
        }, 1000);
    }
}
