package com.laoning.githubaio.repository.remote.base;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by laoni on 2018-2-1.
 */

public class LiveDataCallAdapter<R> implements CallAdapter<R, LiveData<ApiResponse<R>>> {
    private final Type responseType;
    public LiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public LiveData<ApiResponse<R>> adapt(Call<R> call) {
        Log.d("aio", "adapt");
        return new LiveData<ApiResponse<R>>() {
            AtomicBoolean started = new AtomicBoolean(false);
            @Override
            protected void onActive() {
                Log.d("aio", "onActive");
                super.onActive();
                if (started.compareAndSet(false, true)) {
                    Log.d("aio", "enqueue");
                    call.enqueue(new Callback<R>() {
                        @Override
                        public void onResponse(Call<R> call, Response<R> response) {
                            Log.d("aio", "onResponse" );
                            postValue(new ApiResponse<>(response));
                        }

                        @Override
                        public void onFailure(Call<R> call, Throwable throwable) {
                            Log.d("aio", "onFailure");
                            postValue(new ApiResponse<R>(throwable));
                        }
                    });
                } else {
                    Log.d("aio", "not enqueue");
                }
            }
        };
    }
}
