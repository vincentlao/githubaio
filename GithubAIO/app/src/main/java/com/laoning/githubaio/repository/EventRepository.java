package com.laoning.githubaio.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.laoning.githubaio.AppExecutors;
import com.laoning.githubaio.repository.base.LiveDataTask;
import com.laoning.githubaio.repository.entity.EventForUser;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.local.GithubDatabase;
import com.laoning.githubaio.repository.remote.GithubService;
import com.laoning.githubaio.repository.remote.base.ApiResponse;
import com.laoning.githubaio.repository.remote.base.NetworkBoundResource;
import com.laoning.githubaio.repository.remote.base.RateLimiter;
import com.laoning.githubaio.repository.remote.base.Resource;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by laoning on 06/02/2018.
 */

public class EventRepository {

    private GithubDatabase githubDatabase;
    private GithubService githubService;
    private final AppExecutors appExecutors;
    private RateLimiter<String> eventListRateLimit = new RateLimiter<>(10, TimeUnit.MINUTES);

    public EventRepository(GithubDatabase githubDatabase, GithubService githubService, AppExecutors appExecutors) {
        this.githubDatabase = githubDatabase;
        this.githubService = githubService;
        this.appExecutors = appExecutors;
    }

    public LiveData<Resource<List<Event>>> loadUserReceivedEvent(String user, int page) {
        return new NetworkBoundResource<List<Event>, List<Event>>(appExecutors, true, true) {
            @Override
            protected void saveCallResult(@NonNull List<Event> events) {
                Type type=new TypeToken<List<Event>>(){}.getType();
                Log.d("aio", "events: " + new GsonBuilder().create().toJson(events, type));

//                githubDatabase.beginTransaction();
                try{
                    List<Long> ids = new ArrayList<>();
                    for (Event event : events) {
                        ids.add(event.getId());
                    }

                    EventForUser eventForUser = new EventForUser(user, EventForUser.Type.ReceivedEvent.ordinal(), page, ids);

                    Type t = new TypeToken<EventForUser>(){}.getType();
                    Log.d("aio", "eventForUser: " + new GsonBuilder().create().toJson(eventForUser, t));


                    githubDatabase.eventDao().insert(eventForUser);
                    githubDatabase.eventDao().insertEvents(events);
                } finally {
//                    githubDatabase.endTransaction();;
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Event> data) {
                return data == null || data.isEmpty() || eventListRateLimit.shouldFetch(user + EventForUser.Type.ReceivedEvent + page);
            }

            @NonNull
            @Override
            protected LiveData<List<Event>> loadFromDb() {

                LiveDataTask<List<Event>> task = new LiveDataTask<List<Event>>() {
                    @Override
                    public void run() {
                        EventForUser eventForUser = githubDatabase.eventDao().loadEventIdsForUserSync(user, EventForUser.Type.ReceivedEvent.ordinal(), page);
                        if (eventForUser == null) {
                            result.postValue(null);
                        } else {
                            List<Long> eventIds = eventForUser.getEventIds();
                            List<Event> events = githubDatabase.eventDao().loadByIdSync(eventIds);
                            result.postValue(events);
                        }
                    }
                };


                appExecutors.networkIO().execute(task);
                return task.getLiveData();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<Event>>> createCall() {
                return githubService.loadUserReceivedEvent(user, page);
            }
        }.asLiveData();
    }


    public LiveData<Resource<List<Event>>> loadUserPerformedEvent(String user, int page) {

        return new NetworkBoundResource<List<Event>, List<Event>>(appExecutors, true, true) {
            @Override
            protected void saveCallResult(@NonNull List<Event> events) {
                Type type=new TypeToken<List<Event>>(){}.getType();
                Log.d("aio", "events: " + new GsonBuilder().create().toJson(events, type));

//                githubDatabase.beginTransaction();
                try{
                    List<Long> ids = new ArrayList<>();
                    for (Event event : events) {
                        ids.add(event.getId());
                    }

                    EventForUser eventForUser = new EventForUser(user, EventForUser.Type.PerformedEvent.ordinal(), page, ids);

                    Type t = new TypeToken<EventForUser>(){}.getType();
                    Log.d("aio", "eventForUser: " + new GsonBuilder().create().toJson(eventForUser, t));


                    githubDatabase.eventDao().insert(eventForUser);
                    githubDatabase.eventDao().insertEvents(events);
                } finally {
//                    githubDatabase.endTransaction();;
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Event> data) {
                return data == null || data.isEmpty() || eventListRateLimit.shouldFetch(user + EventForUser.Type.PerformedEvent + page);
            }

            @NonNull
            @Override
            protected LiveData<List<Event>> loadFromDb() {

                LiveDataTask<List<Event>> task = new LiveDataTask<List<Event>>() {
                    @Override
                    public void run() {
                        EventForUser eventForUser = githubDatabase.eventDao().loadEventIdsForUserSync(user, EventForUser.Type.PerformedEvent.ordinal(), page);
                        if (eventForUser == null) {
                            result.postValue(null);
                        } else {
                            List<Long> eventIds = eventForUser.getEventIds();
                            List<Event> events = githubDatabase.eventDao().loadByIdSync(eventIds);
                            result.postValue(events);
                        }
                    }
                };


                appExecutors.networkIO().execute(task);
                return task.getLiveData();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<Event>>> createCall() {
                return githubService.loadUserReceivedEvent(user, page);
            }
        }.asLiveData();
    }
}
