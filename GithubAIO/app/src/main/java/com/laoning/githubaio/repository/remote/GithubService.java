package com.laoning.githubaio.repository.remote;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.repository.entity.search.SearchResult;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.remote.base.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
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

    @GET("users/{user}")
    LiveData<ApiResponse<User>> loadUser(@Path("user") String user);

    @GET("/users/{user}/received_events")
    LiveData<ApiResponse<List<Event>>> loadEvent(@Path("user") String name,  @Query("page") int page);

    @NonNull
    @GET("search/users")
    LiveData<ApiResponse<SearchResult<User>>> searchUsers(@Query(value = "q", encoded = true) String query, @Query("sort") String sort, @Query("order") String order, @Query("page") int page);

    @NonNull
    @GET("search/repositories")
    LiveData<ApiResponse<SearchResult<Repository>>> searchRepos(@Query(value = "q", encoded = true) String query, @Query("sort") String sort, @Query("order") String order, @Query("page") int page);
}
