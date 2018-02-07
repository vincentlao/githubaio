package com.laoning.githubaio.di.module;

import android.content.Context;

import com.laoning.githubaio.ui.fragment.BaseFragment;
import com.laoning.githubaio.ui.fragment.EventFragment;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by laoning on 07/02/2018.
 */

@Module
public abstract class FragmentBuildersModule {

//    private BaseFragment mFragment;
//
//    public FragmentBuildersModule(BaseFragment fragment) {
//        mFragment = fragment;
//    }
//
//    @Provides
//    public BaseFragment provideFragment(){
//        return mFragment;
//    }
//
//    @Provides
//    public Context provideContext(){
//        return mFragment.getActivity();
//    }

    @ContributesAndroidInjector
    abstract EventFragment evnetFragment();
}
