package com.laoning.githubaio.ui.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.laoning.githubaio.R;
import com.laoning.githubaio.base.GlobalInfo;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by laoning on 01/02/2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    GlobalInfo globalInfo;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
