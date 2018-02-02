package com.laoning.githubaio.di.component;

import android.app.Application;

import com.laoning.githubaio.GithubAioApp;
import com.laoning.githubaio.di.module.ActivityModule;
import com.laoning.githubaio.di.module.AppModule;
import com.laoning.githubaio.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by laoni on 2018-2-1.
 */

@Singleton
@Component(modules = {AppModule.class, AndroidInjectionModule.class, ActivityModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
    void inject(GithubAioApp githubApp);
}