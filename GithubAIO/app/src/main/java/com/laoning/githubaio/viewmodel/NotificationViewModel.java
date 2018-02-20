package com.laoning.githubaio.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.laoning.githubaio.repository.EventRepository;
import com.laoning.githubaio.repository.NotificationRepository;
import com.laoning.githubaio.repository.RepoRepository;
import com.laoning.githubaio.repository.UserRepository;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.entity.notification.Notification;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.remote.base.Resource;
import com.laoning.githubaio.ui.adapter.base.DoubleTypesModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by laoni on 2018-2-5.
 */

public class NotificationViewModel extends ViewModel {
    @Inject
    NotificationRepository notificationRepository;

    @Inject
    public NotificationViewModel() {
    }

    public LiveData<Resource<List<Notification>>> loadMyNotifications(boolean all, boolean participating) {
        return notificationRepository.loadMyNotifications(all, participating);
    }

}
