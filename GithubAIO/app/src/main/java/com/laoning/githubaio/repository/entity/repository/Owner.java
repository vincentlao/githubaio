
package com.laoning.githubaio.repository.entity.repository;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("login")
    @ColumnInfo(name = "login")
    private String login;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private Integer id;

    @SerializedName("avatar_url")
    @ColumnInfo(name = "avatar_url")
    private String avatarUrl;

    @SerializedName("gravatar_id")
    @ColumnInfo(name = "gravatar_id")
    private String gravatarId;

    @SerializedName("url")
    @ColumnInfo(name = "url")
    private String url;

    @SerializedName("html_url")
    @ColumnInfo(name = "html_url")
    private String htmlUrl;

    @SerializedName("followers_url")
    @ColumnInfo(name = "followers_url")
    private String followersUrl;

    @SerializedName("following_url")
    @ColumnInfo(name = "following_url")
    private String followingUrl;

    @SerializedName("gists_url")
    @ColumnInfo(name = "gists_url")
    private String gistsUrl;

    @SerializedName("starred_url")
    @ColumnInfo(name = "starred_url")
    private String starredUrl;

    @SerializedName("subscriptions_url")
    @ColumnInfo(name = "subscriptions_url")
    private String subscriptionsUrl;

    @SerializedName("organizations_url")
    @ColumnInfo(name = "organizations_url")
    private String organizationsUrl;

    @SerializedName("repos_url")
    @ColumnInfo(name = "repos_url")
    private String reposUrl;

    @SerializedName("events_url")
    @ColumnInfo(name = "events_url")
    private String eventsUrl;

    @SerializedName("received_events_url")
    @ColumnInfo(name = "received_events_url")
    private String receivedEventsUrl;

    @SerializedName("type")
    @ColumnInfo(name = "type")
    private String type;

    @SerializedName("site_admin")
    @ColumnInfo(name = "site_admin")
    private Boolean siteAdmin;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

}
