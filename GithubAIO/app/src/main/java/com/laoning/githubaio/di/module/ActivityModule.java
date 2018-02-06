package com.laoning.githubaio.di.module;

import com.laoning.githubaio.ui.activity.LoginActivity;
import com.laoning.githubaio.ui.activity.MainActivity;
import com.laoning.githubaio.ui.activity.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by laoni on 2018-2-2.
 */

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract SplashActivity splashActivity();

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract LoginActivity loginActivity();
}
