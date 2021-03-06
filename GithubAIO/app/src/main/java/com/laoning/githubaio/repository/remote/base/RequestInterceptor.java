package com.laoning.githubaio.repository.remote.base;

import android.support.annotation.NonNull;
import android.util.Log;

import com.laoning.githubaio.base.GlobalInfo;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by laoni on 2018-2-3.
 */

@Singleton
public class RequestInterceptor implements Interceptor {

    @Inject GlobalInfo globalInfo;

    @Inject
    public RequestInterceptor() {
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header("Authorization", globalInfo.getCurrentUserAccount().getAuthorization())
//                .header("Accept", "applicaton/json")
//                .header("Content-Type", "application/json;charset=UTF-8")
                .method(original.method(), original.body());

        Request request = requestBuilder.build();
        Response response = chain.proceed(request);


//        if (first) {
//            first = false;
//        } else {
//            Log.d("aio", "origin reponse body = " + response.body().string());
//        }
//

        return response;
    }
}