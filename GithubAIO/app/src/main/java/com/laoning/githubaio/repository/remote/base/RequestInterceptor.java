package com.laoning.githubaio.repository.remote.base;

import android.support.annotation.NonNull;

import com.laoning.githubaio.base.GlobalInfo;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by laoni on 2018-2-3.
 */

public class RequestInterceptor implements Interceptor {

    @Inject
    GlobalInfo globalInfo;

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header("Authorization", "")
                .header("Accept", "applicaton/json")
                .method(original.method(), original.body());

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}