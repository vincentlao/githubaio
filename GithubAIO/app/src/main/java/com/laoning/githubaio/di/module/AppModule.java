package com.laoning.githubaio.di.module;

import android.arch.persistence.room.Room;

import com.laoning.githubaio.GithubAioApp;
import com.laoning.githubaio.repository.AccountRepository;
import com.laoning.githubaio.repository.local.GithubDatabase;
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

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Singleton @Provides
    GithubService provideGithubService() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(GithubService.class);
    }

    @Provides
    @Singleton
    public GithubDatabase provideGithubDatabase(GithubAioApp app) {
        return Room.databaseBuilder(app, GithubDatabase.class,"github_aio.db").build();
    }

    @Provides
    @Singleton
    public AccountRepository provideAccountRepository(GithubDatabase githubDatabase, GithubService githubService) {
        return new AccountRepository(githubDatabase, githubService);
    }
}
