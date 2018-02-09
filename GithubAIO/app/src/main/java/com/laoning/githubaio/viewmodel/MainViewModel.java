package com.laoning.githubaio.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.laoning.githubaio.AppExecutors;
import com.laoning.githubaio.base.GlobalInfo;
import com.laoning.githubaio.repository.EventRepository;
import com.laoning.githubaio.repository.UserRepository;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.remote.base.Resource;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by laoni on 2018-2-5.
 */

public class MainViewModel extends ViewModel {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final GlobalInfo globalInfo;
    private final AppExecutors appExecutors;

    @Inject
    public MainViewModel(EventRepository eventRepository, UserRepository userRepository, GlobalInfo globalInfo, AppExecutors appExecutors) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.globalInfo = globalInfo;
        this.appExecutors = appExecutors;
    }

    public LiveData<Resource<List<Event>>> loadUserReceivedEvent(String user, int page) {
        return eventRepository.loadUserReceivedEvent(user, page);
    }

    public LiveData<Resource<List<Event>>> loadUserPerformedEvent(String user, int page) {
        return eventRepository.loadUserPerformedEvent(user, page);
    }

    public LiveData<User> findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
