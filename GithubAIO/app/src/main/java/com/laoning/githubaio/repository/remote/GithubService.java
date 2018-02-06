package com.laoning.githubaio.repository.remote;

import android.arch.lifecycle.LiveData;

import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.remote.base.ApiResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by laoning on 01/02/2018.
 */

public interface GithubService {

    @GET("user")
    LiveData<ApiResponse<User>> loginUser(@Header("Authorization") String authentication);

    @GET("users/{login}")
    LiveData<ApiResponse<User>> loadUser(@Path("login") String login);

    @GET("/users/{user}/received_events")
    LiveData<ApiResponse<List<Event>>> loadEvent(@Path("user") String name,  @Query("page") int page);
}
