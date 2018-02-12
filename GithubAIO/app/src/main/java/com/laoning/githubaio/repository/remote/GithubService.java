package com.laoning.githubaio.repository.remote;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.repository.entity.search.SearchResult;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.remote.base.ApiResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by laoning on 01/02/2018.
 */

public interface GithubService {

    @GET("user")
    LiveData<ApiResponse<User>> loginUser(@Header("Authorization") String authentication);

    @GET("users/{user}")
    LiveData<ApiResponse<User>> loadUser(@Path("user") String user);

    @GET("/users/{user}/events")
    LiveData<ApiResponse<List<Event>>> loadUserPerformedEvent(@Path("user") String name, @Query("page") int page);

    @GET("/users/{user}/received_events")
    LiveData<ApiResponse<List<Event>>> loadUserReceivedEvent(@Path("user") String name, @Query("page") int page);


    @NonNull @GET("user")
    LiveData<Response<User>> getPersonInfo(
            @Header("forceNetWork") boolean forceNetWork
    );

    @NonNull @GET("users/{user}")
    LiveData<Response<User>> getUser(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("user") String user
    );


    @NonNull @GET("user/following/{user}")
    LiveData<Response<ResponseBody>> checkFollowing(
            @Path("user") String user
    );

    /**
     * Check if one user follows another
     */
    @NonNull @GET("users/{user}/following/{targetUser}")
    LiveData<Response<ResponseBody>> checkFollowing(
            @Path("user") String user,
            @Path("targetUser") String targetUser
    );

    @NonNull @PUT("user/following/{user}")
    LiveData<Response<ResponseBody>> followUser(
            @Path("user") String user
    );

    @NonNull @DELETE("user/following/{user}")
    LiveData<Response<ResponseBody>> unfollowUser(
            @Path("user") String user
    );

    @NonNull @GET("users/{user}/followers")
    LiveData<Response<ArrayList<User>>> getFollowers(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("user") String user,
            @Query("page") int page
    );

    @NonNull @GET("users/{user}/following")
    LiveData<Response<ArrayList<User>>> getFollowing(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("user") String user,
            @Query("page") int page
    );

    /**
     * List events performed by a user
     */
    @NonNull @GET("users/{user}/events")
    LiveData<Response<ArrayList<Event>>> getUserEvents(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("user") String user,
            @Query("page") int page
    );

    /**
     * List github public events
     */
    @NonNull @GET("events")
    LiveData<Response<ArrayList<Event>>> getPublicEvent(
            @Header("forceNetWork") boolean forceNetWork,
            @Query("page") int page
    );

    @NonNull @GET("users/{user}/received_events")
    LiveData<Response<ArrayList<Event>>> getNewsEvent(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("user") String user,
            @Query("page") int page
    );

    @NonNull @GET("orgs/{org}/members")
    LiveData<Response<ArrayList<User>>> getOrgMembers(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("org") String org,
            @Query("page") int page
    );

    @NonNull @GET("users/{user}/orgs")
    LiveData<Response<ArrayList<User>>> getUserOrgs(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("user") String user
    );


    @NonNull
    @GET("search/users")
    LiveData<ApiResponse<SearchResult<User>>> searchUsers(@Query(value = "q", encoded = true) String query, @Query("sort") String sort, @Query("order") String order, @Query("page") int page);

    @NonNull
    @GET("search/repositories")
    LiveData<ApiResponse<SearchResult<Repository>>> searchRepos(@Query(value = "q", encoded = true) String query, @Query("sort") String sort, @Query("order") String order, @Query("page") int page);

    //    https://api.github.com/search/issues?sort=created&page=1&q=user:ThirtyDegreesRay+state:open&order=desc
//    @NonNull @GET("search/issues")
//    @Headers("Accept: application/vnd.github.html,application/vnd.github.VERSION.raw")
//    Observable<Response<SearchResult<Issue>>> searchIssues(
//            @Header("forceNetWork") boolean forceNetWork,
//            @Query(value = "q", encoded = true) String query,
//            @Query("sort") String sort,
//            @Query("order") String order,
//            @Query("page") int page
//    );

    /**
     * List repositories being starred
     */
    @NonNull @GET("users/{user}/starred")
    LiveData<ApiResponse<List<Repository>>> getStarredRepos(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("user") @NonNull String user,
            @Query("page") int page,
            @Query("sort") String sort,
            @Query("direction") String direction
    );

    @NonNull @GET("user/repos")
    LiveData<ApiResponse<List<Repository>>> getUserRepos(
            @Query("page") int page,
            @Query("type") String type,
            @Query("sort") String sort,
            @Query("direction") String direction
    );

    /**
     * List user repositories
     */
    @NonNull @GET("users/{user}/repos")
    LiveData<ApiResponse<List<Repository>>> getUserPublicRepos(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("user") @NonNull String user,
            @Query("page") int page,
            @Query("type") String type,
            @Query("sort") String sort,
            @Query("direction") String direction
    );

    /**
     * Check if you are starring a repository
     */
    @NonNull @GET("user/starred/{owner}/{repo}")
    LiveData<Response<ResponseBody>> checkRepoStarred(
            @Path("owner") String owner,
            @Path("repo") String repo
    );

    /**
     * Star a repository
     */
    @NonNull @PUT("user/starred/{owner}/{repo}")
    LiveData<Response<ResponseBody>> starRepo(
            @Path("owner") String owner,
            @Path("repo") String repo
    );

    /**
     * Unstar a repository
     */
    @NonNull @DELETE("user/starred/{owner}/{repo}")
    LiveData<Response<ResponseBody>> unstarRepo(
            @Path("owner") String owner,
            @Path("repo") String repo
    );

    @NonNull @GET("user/subscriptions/{owner}/{repo}")
    LiveData<Response<ResponseBody>> checkRepoWatched(
            @Path("owner") String owner,
            @Path("repo") String repo
    );

    @NonNull @PUT("user/subscriptions/{owner}/{repo}")
    LiveData<Response<ResponseBody>> watchRepo(
            @Path("owner") String owner,
            @Path("repo") String repo
    );

    @NonNull @DELETE("user/subscriptions/{owner}/{repo}")
    LiveData<Response<ResponseBody>> unwatchRepo(
            @Path("owner") String owner,
            @Path("repo") String repo
    );

    @NonNull @GET @Headers("Accept: application/vnd.github.html")
    LiveData<Response<ResponseBody>> getFileAsHtmlStream(
            @Header("forceNetWork") boolean forceNetWork,
            @Url String url
    );

    @NonNull @GET @Headers("Accept: application/vnd.github.VERSION.raw")
    LiveData<Response<ResponseBody>> getFileAsStream(
            @Header("forceNetWork") boolean forceNetWork,
            @Url String url
    );

//    @NonNull @GET("repos/{owner}/{repo}/contents/{path}")
//    Observable<Response<List<FileModel>>> getRepoFiles(
//            @Path("owner") String owner,
//            @Path("repo") String repo,
//            @Path(value = "path", encoded = true) String path,
//            @Query("ref") String branch
//    );

//    @NonNull @GET("repos/{owner}/{repo}/branches")
//    Observable<Response<List<Branch>>> getBranches(
//            @Path("owner") String owner,
//            @Path("repo") String repo
//    );
//
//    @NonNull @GET("repos/{owner}/{repo}/tags")
//    Observable<Response<List<Branch>>> getTags(
//            @Path("owner") String owner,
//            @Path("repo") String repo
//    );

    @NonNull @GET("repos/{owner}/{repo}/stargazers")
    LiveData<Response<List<User>>> getStargazers(
            @Header("forceNetWork") boolean forceNetWork,
            @Path(value = "owner") String owner,
            @Path(value = "repo") String repo,
            @Query("page") int page
    );

    @NonNull @GET("repos/{owner}/{repo}/subscribers")
    LiveData<Response<List<User>>> getWatchers(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Query("page") int page
    );

    @NonNull @GET("repos/{owner}/{repo}")
    LiveData<Response<Repository>> getRepoInfo(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("owner") String owner,
            @Path("repo") String repo
    );

    @NonNull @POST("repos/{owner}/{repo}/forks")
    LiveData<Response<Repository>> createFork(
            @Path("owner") String owner,
            @Path("repo") String repo
    );

    @NonNull @GET("repos/{owner}/{repo}/forks")
    LiveData<Response<List<Repository>>> getForks(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Query("page") int page
    );

    /**
     * List public events for a network of repositories
     */
    @NonNull @GET("networks/{owner}/{repo}/events")
    LiveData<Response<List<Event>>> getRepoEvent(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Query("page") int page
    );
//
//    @NonNull @GET("repos/{owner}/{repo}/releases")
//    @Headers("Accept: application/vnd.github.html")
//    Observable<Response<List<Release>>> getReleases(
//            @Header("forceNetWork") boolean forceNetWork,
//            @Path("owner") String owner,
//            @Path("repo") String repo,
//            @Query("page") int page
//    );
//
//    @NonNull @GET("repos/{owner}/{repo}/releases/tags/{tag}")
//    @Headers("Accept: application/vnd.github.html")
//    Observable<Response<Release>> getReleaseByTagName(
//            @Header("forceNetWork") boolean forceNetWork,
//            @Path("owner") String owner,
//            @Path("repo") String repo,
//            @Path("tag") String tag
//    );


}
