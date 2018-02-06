package com.laoning.githubaio.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.laoning.githubaio.AppExecutors;
import com.laoning.githubaio.GithubAioApp;
import com.laoning.githubaio.base.GlobalInfo;
import com.laoning.githubaio.repository.AccountRepository;
import com.laoning.githubaio.repository.EventRepository;
import com.laoning.githubaio.repository.local.GithubDatabase;
import com.laoning.githubaio.repository.remote.GithubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.laoning.githubaio.repository.remote.base.LiveDataCallAdapterFactory;
import com.laoning.githubaio.repository.remote.base.RequestInterceptor;

import java.util.concurrent.TimeUnit;

/**
 * Created by laoni on 2018-2-1.
 */

@Module(includes = ViewModelModule.class)
public class AppModule {

    private static final int TIMEOUT_IN_SEC = 15;

    @Provides
    @Singleton
    GlobalInfo provideGlobalInfo() {
        return new GlobalInfo();
    }

    @Provides
    @Singleton
    RequestInterceptor provideRequestInterceptor(GlobalInfo globalInfo) {
        return new RequestInterceptor(globalInfo);
    }

    @Provides
    @Singleton
    public AppExecutors provideAppExecutors() {
        return new AppExecutors();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(RequestInterceptor requestInterceptor) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.readTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.addInterceptor(requestInterceptor);
        return okHttpClient.build();
    }

    @Singleton
    @Provides
    GithubService provideGithubService(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .client(okHttpClient)
                .build()
                .create(GithubService.class);
    }

    @Provides
    @Singleton
    public GithubDatabase provideGithubDatabase(Application app) {
        return Room.databaseBuilder(app, GithubDatabase.class,"github_aio.db").build();
//        return Room.inMemoryDatabaseBuilder(app, GithubDatabase.class).build();
    }

    @Provides
    @Singleton
    public AccountRepository provideAccountRepository(GithubDatabase githubDatabase, GithubService githubService, AppExecutors appExecutors) {
        return new AccountRepository(githubDatabase, githubService, appExecutors);
    }

    @Provides
    @Singleton
    public EventRepository provideEventRepository(GithubDatabase githubDatabase, GithubService githubService, AppExecutors appExecutors) {
        return new EventRepository(githubDatabase, githubService, appExecutors);
    }
}
