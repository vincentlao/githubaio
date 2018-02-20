package com.laoning.githubaio.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.laoning.githubaio.AppExecutors;
import com.laoning.githubaio.repository.entity.notification.Notification;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.repository.local.GithubDatabase;
import com.laoning.githubaio.repository.remote.GithubService;
import com.laoning.githubaio.repository.remote.base.ApiResponse;
import com.laoning.githubaio.repository.remote.base.NetworkBoundResource;
import com.laoning.githubaio.repository.remote.base.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by laoning on 06/02/2018.
 */

@Singleton
public class NotificationRepository {

    @Inject GithubDatabase githubDatabase;
    @Inject GithubService githubService;
    @Inject AppExecutors appExecutors;

    @Inject
    public NotificationRepository() {
    }

    public LiveData<Resource<List<Notification>>> loadMyNotifications( boolean all, boolean participating) {
        return new NetworkBoundResource<List<Notification>, List<Notification>>(appExecutors) {
            @Override
            protected List<Notification> processResponse(ApiResponse<List<Notification>> response) {

                return response.body;
            }


            protected void saveCallResult(@NonNull List<Notification> result) {

            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<Notification>>> createCall() {
                return githubService.getMyNotifications(all, participating);
            }
        }.asLiveData();
    }

}
