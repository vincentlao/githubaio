package com.laoning.githubaio;

import android.app.Activity;
import android.app.Application;

import com.laoning.githubaio.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by laoning on 01/02/2018.
 */

public class GithubAioApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingInjector;

    @Inject
    public GithubAioApp() {

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
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }
}
