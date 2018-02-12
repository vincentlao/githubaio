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

    private final MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();

    @MainThread
    public NetworkBoundResource(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
        fetchFromNetwork();
    }

    private void fetchFromNetwork() {
        LiveData<ApiResponse<ResponseType>> apiResponse = createCall();
        result.addSource(apiResponse, response -> {
            Log.d("aio", "apisource fired");
            result.removeSource(apiResponse);

            Log.d("aio", "error msg = " + response.errorMessage);

            if (response.isSuccessful()) {
                Log.d("aio", "response code = " + response.code);
                Log.d("aio", "response msg = " + response.body.toString());

                ResultType data = processResponse(response);
                saveCallResult(data);
                appExecutors.mainThread().execute(() -> {
                    setValue(Resource.success(data));
                });
            } else {
                Log.d("aio", "Retrofit request failed");

                appExecutors.mainThread().execute(() -> {
                    setValue(Resource.error(response.errorMessage, null));
                });
            }
        });
    }

    @MainThread
    private void setValue(Resource<ResultType> newValue) {
        if (!Objects.equals(result.getValue(), newValue)) {
            result.setValue(newValue);
        }
    }

    public LiveData<Resource<ResultType>> asLiveData() {
        return result;
    }

    @WorkerThread
    protected abstract  ResultType processResponse(ApiResponse<ResponseType> response);

    @WorkerThread
    protected abstract void saveCallResult(@NonNull ResultType result);

    @NonNull
    @MainThread
    protected abstract LiveData<ApiResponse<ResponseType>> createCall();
}
