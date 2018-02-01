package com.laoning.githubaio.di.module;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.laoning.githubaio.GithubAioApp;
import com.laoning.githubaio.repository.AccountRepository;
import com.laoning.githubaio.repository.remote.GithubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.laoning.githubaio.repository.remote.base.LiveDataCallAdapterFactory;

/**
 * Created by laoni on 2018-2-1.
 */

@Module
public class AppModule {

    private GithubAioApp application;

    public AppModule(GithubAioApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public GithubAioApp provideApplication() {
        return application;
    }

    @Singleton @Provides
    GithubService provideGithubService() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(GithubService.class);
    }


    @NonNull
    @Provides
    @Singleton
    public AccountRepository provideAccountRepository() {
        return null;
    }
}
