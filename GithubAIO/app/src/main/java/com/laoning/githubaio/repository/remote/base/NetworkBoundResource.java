package com.laoning.githubaio.repository.remote.base;

/**
 * Created by laoni on 2018-2-3.
 */


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;

import com.laoning.githubaio.AppExecutors;

/**
 * A generic class that can provide a resource backed by both the sqlite database and the network.
 * <p>
 * You can read more about it in the <a href="https://developer.android.com/arch">Architecture
 * Guide</a>.
 * @param <ResultType>
 * @param <ResponseType>
 */
public abstract class NetworkBoundResource<ResultType, ResponseType> {
    private final AppExecutors appExecutors;
    private final boolean ignoreDB;
    private final boolean ignoreLoading;

    private final MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();

    @MainThread
    public NetworkBoundResource(AppExecutors appExecutors, boolean ignoreDB, boolean ignoreLoading) {
        this.appExecutors = appExecutors;
        this.ignoreDB = ignoreDB;
        this.ignoreLoading = ignoreLoading;

        if (!ignoreLoading) {
            result.setValue(Resource.loading(null));
        }

        LiveData<ResultType> dbSource = loadFromDb();
        result.addSource(dbSource, data -> {
            Log.d("aio", "dbsource fired");
            result.removeSource(dbSource);
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource);
            } else {
                result.addSource(dbSource, newData -> setValue(Resource.success(newData)));
            }
        });
    }

    @MainThread
    private void setValue(Resource<ResultType> newValue) {
        if (!Objects.equals(result.getValue(), newValue)) {
            result.setValue(newValue);
        }
    }

    private void fetchFromNetwork(final LiveData<ResultType> dbSource) {
        Log.d("aio", "begin fetch from network");
        LiveData<ApiResponse<ResponseType>> apiResponse = createCall();
        // we re-attach dbSource as a new source, it will dispatch its latest value quickly
//        result.addSource(dbSource, newData -> setValue(Resource.loading(newData)));
        result.addSource(apiResponse, response -> {
            Log.d("aio", "apisource fired");
            result.removeSource(apiResponse);
//            result.removeSource(dbSource);
            //noinspection ConstantConditions
            Log.d("aio", "error msg = " + response.errorMessage);

            if (response.isSuccessful()) {
                Log.d("aio", "Retrofit request success");
                Log.d("aio", "response code = " + response.code);
                Log.d("aio", "response msg = " + response.body.toString());
                appExecutors.diskIO().execute(() -> {
                    saveCallResult(processResponse(response));
                    appExecutors.mainThread().execute(() ->
                            // we specially request a new live data,
                            // otherwise we will get immediately last cached value,
                            // which may not be updated with latest results received from network.
                            result.addSource(loadFromDb(), newData -> {
                                Log.d("aio", "dbsource fired");
                                if (newData != null) {
                                    Log.d("aio", "newData=" + newData.toString());
                                }
                                setValue(Resource.success(newData));
                            })
                    );
                });
            } else {
                Log.d("aio", "Retrofit request failed");

                onFetchFailed();
                result.addSource(dbSource,
                        newData -> setValue(Resource.error(response.errorMessage, newData)));
            }
        });
    }

    protected void onFetchFailed() {
    }

    public LiveData<Resource<ResultType>> asLiveData() {
        return result;
    }

    @WorkerThread
    protected ResponseType processResponse(ApiResponse<ResponseType> response) {
        return response.body;
    }

    @WorkerThread
    protected abstract void saveCallResult(@NonNull ResponseType item);

    @MainThread
    protected abstract boolean shouldFetch(@Nullable ResultType data);

    @NonNull
    @MainThread
    protected abstract LiveData<ResultType> loadFromDb();

    @NonNull
    @MainThread
    protected abstract LiveData<ApiResponse<ResponseType>> createCall();
}
