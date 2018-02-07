package com.laoning.githubaio;

import android.app.Activity;
import android.app.Application;

import com.laoning.githubaio.di.component.DaggerAppComponent;
import com.laoning.githubaio.di.module.AppInjector;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by laoning on 01/02/2018.
 */

@Singleton
public class GithubAioApp extends Application implements HasActivityInjector {

    private static  GithubAioApp app;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingInjector;

    @Inject
    public GithubAioApp() {
        app = this;
    }

    public static GithubAioApp getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initializeComponent();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingInjector;
    }


    private void initializeComponent() {
        AppInjector.init(this);
    }
}
