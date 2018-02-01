package com.laoning.githubaio.ui.splash;

import android.arch.lifecycle.LiveData;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.laoning.githubaio.GithubAioApp;
import com.laoning.githubaio.R;
import com.laoning.githubaio.repository.entity.GithubAccount;
import com.laoning.githubaio.ui.common.BaseActivity;
import com.laoning.githubaio.ui.login.LoginActivity;
import com.laoning.githubaio.ui.main.MainActivity;
import com.laoning.githubaio.viewmodel.AccountViewModel;

/**
 * Created by laoning on 01/02/2018.
 */

public class SplashActivity extends BaseActivity {

    private AccountViewModel accountViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_splash);

        loadUser();
    }

    private void loadUser() {
        LiveData<GithubAccount> accountLiveData = accountViewModel.getFirstAccount();

        accountLiveData.observe(this, account -> {
            if (account == null) {
                showLoginActivity();
            } else {
                showMainActivity();
            }
        });
    }

    private void showLoginActivity() {
        delayFinish();
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void showMainActivity() {
        delayFinish();
        startActivity(new Intent(this, MainActivity.class));
    }
}
