package com.laoning.githubaio.di.module;

import android.content.Context;

import com.laoning.githubaio.ui.fragment.BaseFragment;
import com.laoning.githubaio.ui.fragment.EventFragment;
import com.laoning.githubaio.ui.fragment.NotificationsFragment;
import com.laoning.githubaio.ui.fragment.RepositoriesFragment;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by laoning on 07/02/2018.
 */

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract EventFragment evnetFragment();

    @ContributesAndroidInjector
    abstract RepositoriesFragment repositoriesFragment();

    @ContributesAndroidInjector
    abstract NotificationsFragment notificationsFragment();
}
