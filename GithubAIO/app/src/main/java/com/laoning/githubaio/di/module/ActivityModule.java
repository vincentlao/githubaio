package com.laoning.githubaio.di.module;

import com.laoning.githubaio.ui.activity.LoginActivity;
import com.laoning.githubaio.ui.activity.MainActivity;
import com.laoning.githubaio.ui.activity.NotificationsActivity;
import com.laoning.githubaio.ui.activity.ProfileActivity;
import com.laoning.githubaio.ui.activity.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by laoni on 2018-2-2.
 */

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract SplashActivity splashActivity();

    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract LoginActivity loginActivity();

    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract ProfileActivity profileActivity();

    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract NotificationsActivity notificationsActivity();
}
