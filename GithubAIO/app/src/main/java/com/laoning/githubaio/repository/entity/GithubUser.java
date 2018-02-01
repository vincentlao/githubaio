package com.laoning.githubaio.repository.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.laoning.githubaio.repository.local.base.DateConverter;

import java.util.Date;

/**
 * Created by laoning on 01/02/2018.
 */

//curl  -u 273086603@qq.com:13824382402lao https://api.github.com/user
//        {
//        "login": "vincentlao",
//        "id": 1570393,
//        "avatar_url": "https://avatars3.githubusercontent.com/u/1570393?v=4",
//        "gravatar_id": "",
//        "url": "https://api.github.com/users/vincentlao",
//        "html_url": "https://github.com/vincentlao",
//        "followers_url": "https://api.github.com/users/vincentlao/followers",
//        "following_url": "https://api.github.com/users/vincentlao/following{/other_user}",
//        "gists_url": "https://api.github.com/users/vincentlao/gists{/gist_id}",
//        "starred_url": "https://api.github.com/users/vincentlao/starred{/owner}{/repo}",
//        "subscriptions_url": "https://api.github.com/users/vincentlao/subscriptions",
//        "organizations_url": "https://api.github.com/users/vincentlao/orgs",
//        "repos_url": "https://api.github.com/users/vincentlao/repos",
//        "events_url": "https://api.github.com/users/vincentlao/events{/privacy}",
//        "received_events_url": "https://api.github.com/users/vincentlao/received_events",
//        "type": "GithubUser",
//        "site_admin": false,
//        "name": null,
//        "company": null,
//        "blog": "",
//        "location": null,
//        "email": null,
//        "hireable": null,
//        "bio": null,
//        "public_repos": 589,
//        "public_gists": 2,
//        "followers": 3,
//        "following": 28,
//        "created_at": "2012-03-24T06:19:10Z",
//        "updated_at": "2018-02-01T06:30:07Z",
//        "private_gists": 0,
//        "total_private_repos": 0,
//        "owned_private_repos": 0,
//        "disk_usage": 20650,
//        "collaborators": 0,
//        "two_factor_authentication": false,
//        "plan": {
//        "name": "free",
//        "space": 976562499,
//        "collaborators": 0,
//        "private_repos": 0
//        }
//        }

@Entity(tableName = "github_user")
@TypeConverters(DateConverter.class)
public class GithubUser {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "login")
    private String login;

    @ColumnInfo(name = "avatar_url")
    private String avatarUrl;

    @ColumnInfo(name = "gravatar_id")
    private String gravatarId;

    @ColumnInfo(name = "url")
    private String url;

    @ColumnInfo(name = "html_url")
    private String htmlUrl;

    @ColumnInfo(name = "followers_url")
    private String followerUrl;

    @ColumnInfo(name = "following_url")
    private String followingUrl;

    @ColumnInfo(name = "gists_url")
    private String gistsUrl;

    @ColumnInfo(name = "starred_url")
    private String starredUrl;

    @ColumnInfo(name = "subscriptions_url")
    private String subscriptionsUrl;

    @ColumnInfo(name = "organizations_url")
    private String organizationsUrl;

    @ColumnInfo(name = "repos_url")
    private String reposUrl;

    @ColumnInfo(name = "events_url")
    private String eventsUrl;

    @ColumnInfo(name = "received_events_url")
    private String receivedEventsUrl;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "site_admin")
    private boolean siteAdmin;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "company")
    private String company;

    @ColumnInfo(name = "blog")
    private String blog;

    @ColumnInfo(name = "location")
    private String location;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "hireable")
    private String hireable;

    @ColumnInfo(name = "bio")
    private String bio;

    @ColumnInfo(name = "public_repos")
    private int publicRepos;

    @ColumnInfo(name = "public_gists")
    private int publicGists;

    @ColumnInfo(name = "followers")
    private int followers;

    @ColumnInfo(name = "following")
    private int following;

    @ColumnInfo(name = "created_at")
    private Date createAt;

    @ColumnInfo(name = "updated_at")
    private Date updateAt;

    @ColumnInfo(name = "private_gists")
    private int privateGists;

    @ColumnInfo(name = "total_private_repos")
    private int totalPrivateRepos;

    @ColumnInfo(name = "owned_private_repos")
    private int ownedPrivateRepos;

    @ColumnInfo(name = "disk_usage")
    private int diskUsage;

    @ColumnInfo(name = "collaborators")
    private int collaborators;

    @ColumnInfo(name = "two_factor_authentication")
    private boolean twoFactorAuthentication;

    @ColumnInfo(name = "plan_name")
    private String planName;

    @ColumnInfo(name = "plan_space")
    private int planSpace;

    @ColumnInfo(name = "plan_collaborators")
    private int planCollaborators;

    @ColumnInfo(name = "plan_privateRepos")
    private int planPrivateRepos;


    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getFollowerUrl() {
        return followerUrl;
    }

    public void setFollowerUrl(String followerUrl) {
        this.followerUrl = followerUrl;
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

    public boolean isSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHireable() {
        return hireable;
    }

    public void setHireable(String hireable) {
        this.hireable = hireable;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        this.publicRepos = publicRepos;
    }

    public int getPublicGists() {
        return publicGists;
    }

    public void setPublicGists(int publicGists) {
        this.publicGists = publicGists;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getPrivateGists() {
        return privateGists;
    }

    public void setPrivateGists(int privateGists) {
        this.privateGists = privateGists;
    }

    public int getTotalPrivateRepos() {
        return totalPrivateRepos;
    }

    public void setTotalPrivateRepos(int totalPrivateRepos) {
        this.totalPrivateRepos = totalPrivateRepos;
    }

    public int getOwnedPrivateRepos() {
        return ownedPrivateRepos;
    }

    public void setOwnedPrivateRepos(int ownedPrivateRepos) {
        this.ownedPrivateRepos = ownedPrivateRepos;
    }

    public int getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(int diskUsage) {
        this.diskUsage = diskUsage;
    }

    public int getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(int collaborators) {
        this.collaborators = collaborators;
    }

    public boolean isTwoFactorAuthentication() {
        return twoFactorAuthentication;
    }

    public void setTwoFactorAuthentication(boolean twoFactorAuthentication) {
        this.twoFactorAuthentication = twoFactorAuthentication;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getPlanSpace() {
        return planSpace;
    }

    public void setPlanSpace(int planSpace) {
        this.planSpace = planSpace;
    }

    public int getPlanCollaborators() {
        return planCollaborators;
    }

    public void setPlanCollaborators(int planCollaborators) {
        this.planCollaborators = planCollaborators;
    }

    public int getPlanPrivateRepos() {
        return planPrivateRepos;
    }

    public void setPlanPrivateRepos(int planPrivateRepos) {
        this.planPrivateRepos = planPrivateRepos;
    }

}
