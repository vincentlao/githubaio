package com.laoning.githubaio.repository.base;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import com.laoning.githubaio.repository.entity.EventForUser;
import com.laoning.githubaio.repository.entity.event.Event;

import java.util.List;

/**
 * Created by laoning on 06/02/2018.
 */

public abstract class LiveDataTask<T> implements Runnable {
    protected final MediatorLiveData<T> result = new MediatorLiveData<>();


    public LiveData<T> getLiveData() {
        return result;
    }
}
