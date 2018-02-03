package com.laoning.githubaio.repository.remote;

import android.arch.lifecycle.LiveData;

import com.laoning.githubaio.repository.entity.GithubUser;
import com.laoning.githubaio.repository.remote.base.ApiResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by laoning on 01/02/2018.
 */

public interface GithubService {

    @GET("user")
    LiveData<ApiResponse<GithubUser>> loginUser();

    @GET("users/{login}")
    LiveData<ApiResponse<GithubUser>> getUser(@Path("login") String login);
}
