
package com.laoning.githubaio.repository.entity.repository;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.laoning.githubaio.repository.local.base.DateConverter;

@Entity(tableName = "repository")
@TypeConverters(DateConverter.class)
public class Repository {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "full_name")
    private String fullName;
    @Embedded(prefix = "owner_")
    private Owner owner;
    @ColumnInfo(name = "private")
    private boolean _private;
    @ColumnInfo(name = "html_url")
    private String htmlUrl;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "fork")
    private boolean fork;
    @ColumnInfo(name = "url")
    private String url;
    @ColumnInfo(name = "forks_url")
    private String forksUrl;
    @ColumnInfo(name = "keys_url")
    private String keysUrl;
    @ColumnInfo(name = "collaborators_url")
    private String collaboratorsUrl;
    @ColumnInfo(name = "teams_url")
    private String teamsUrl;
    @ColumnInfo(name = "hooks_url")
    private String hooksUrl;
    @ColumnInfo(name = "issue_events_url")
    private String issueEventsUrl;
    @ColumnInfo(name = "events_url")
    private String eventsUrl;
    @ColumnInfo(name = "assignees_url")
    private String assigneesUrl;
    @ColumnInfo(name = "branches_url")
    private String branchesUrl;
    @ColumnInfo(name = "tags_url")
    private String tagsUrl;
    @ColumnInfo(name = "blobs_url")
    private String blobsUrl;
    @ColumnInfo(name = "git_tags_url")
    private String gitTagsUrl;
    @ColumnInfo(name = "git_refs_url")
    private String gitRefsUrl;
    @ColumnInfo(name = "trees_url")
    private String treesUrl;
    @ColumnInfo(name = "statuses_url")
    private String statusesUrl;
    @ColumnInfo(name = "languages_url")
    private String languagesUrl;
    @ColumnInfo(name = "stargazers_url")
    private String stargazersUrl;
    @ColumnInfo(name = "contributors_url")
    private String contributorsUrl;
    @ColumnInfo(name = "subscribers_url")
    private String subscribersUrl;
    @ColumnInfo(name = "subscription_url")
    private String subscriptionUrl;
    @ColumnInfo(name = "commits_url")
    private String commitsUrl;
    @ColumnInfo(name = "git_commits_url")
    private String gitCommitsUrl;
    @ColumnInfo(name = "comments_url")
    private String commentsUrl;
    @ColumnInfo(name = "issue_comment_url")
    private String issueCommentUrl;
    @ColumnInfo(name = "contents_url")
    private String contentsUrl;
    @ColumnInfo(name = "compare_url")
    private String compareUrl;
    @ColumnInfo(name = "merges_url")
    private String mergesUrl;
    @ColumnInfo(name = "archive_url")
    private String archiveUrl;
    @ColumnInfo(name = "downloads_url")
    private String downloadsUrl;
    @ColumnInfo(name = "issues_url")
    private String issuesUrl;
    @ColumnInfo(name = "pulls_url")
    private String pullsUrl;
    @ColumnInfo(name = "milestones_url")
    private String milestonesUrl;
    @ColumnInfo(name = "notifications_url")
    private String notificationsUrl;
    @ColumnInfo(name = "labels_url")
    private String labelsUrl;
    @ColumnInfo(name = "releases_url")
    private String releasesUrl;
    @ColumnInfo(name = "deployments_url")
    private String deploymentsUrl;
    @ColumnInfo(name = "created_at")
    private String createdAt;
    @ColumnInfo(name = "updated_at")
    private String updatedAt;
    @ColumnInfo(name = "pushed_at")
    private String pushedAt;
    @ColumnInfo(name = "git_url")
    private String gitUrl;
    @ColumnInfo(name = "ssh_url")
    private String sshUrl;
    @ColumnInfo(name = "clone_url")
    private String cloneUrl;
    @ColumnInfo(name = "svn_url")
    private String svnUrl;
    @ColumnInfo(name = "homepage")
    private String homepage;
    @ColumnInfo(name = "size")
    private Integer size;
    @ColumnInfo(name = "stargazers_count")
    private Integer stargazersCount;
    @ColumnInfo(name = "watchers_count")
    private Integer watchersCount;
    @ColumnInfo(name = "language")
    private String language;
    @ColumnInfo(name = "has_issues")
    private boolean hasIssues;
    @ColumnInfo(name = "has_projects")
    private boolean hasProjects;
    @ColumnInfo(name = "has_downloads")
    private boolean hasDownloads;
    @ColumnInfo(name = "has_wiki")
    private boolean hasWiki;
    @ColumnInfo(name = "has_pages")
    private boolean hasPages;
    @ColumnInfo(name = "forks_count")
    private Integer forksCount;
    @ColumnInfo(name = "mirror_url")
    private String mirrorUrl;
    @ColumnInfo(name = "archived")
    private boolean archived;
    @ColumnInfo(name = "open_issues_count")
    private Integer openIssuesCount;
    @Embedded(prefix = "license_")
    private License license;
    @ColumnInfo(name = "forks")
    private Integer forks;
    @ColumnInfo(name = "open_issues")
    private Integer openIssues;
    @ColumnInfo(name = "watchers")
    private Integer watchers;
    @ColumnInfo(name = "default_branch")
    private String defaultBranch;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean getPrivate() {
        return _private;
    }

    public void setPrivate(boolean _private) {
        this._private = _private;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getForksUrl() {
        return forksUrl;
    }

    public void setForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
    }

    public String getKeysUrl() {
        return keysUrl;
    }

    public void setKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
    }

    public String getCollaboratorsUrl() {
        return collaboratorsUrl;
    }

    public void setCollaboratorsUrl(String collaboratorsUrl) {
        this.collaboratorsUrl = collaboratorsUrl;
    }

    public String getTeamsUrl() {
        return teamsUrl;
    }

    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
    }

    public String getHooksUrl() {
        return hooksUrl;
    }

    public void setHooksUrl(String hooksUrl) {
        this.hooksUrl = hooksUrl;
    }

    public String getIssueEventsUrl() {
        return issueEventsUrl;
    }

    public void setIssueEventsUrl(String issueEventsUrl) {
        this.issueEventsUrl = issueEventsUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getAssigneesUrl() {
        return assigneesUrl;
    }

    public void setAssigneesUrl(String assigneesUrl) {
        this.assigneesUrl = assigneesUrl;
    }

    public String getBranchesUrl() {
        return branchesUrl;
    }

    public void setBranchesUrl(String branchesUrl) {
        this.branchesUrl = branchesUrl;
    }

    public String getTagsUrl() {
        return tagsUrl;
    }

    public void setTagsUrl(String tagsUrl) {
        this.tagsUrl = tagsUrl;
    }

    public String getBlobsUrl() {
        return blobsUrl;
    }

    public void setBlobsUrl(String blobsUrl) {
        this.blobsUrl = blobsUrl;
    }

    public String getGitTagsUrl() {
        return gitTagsUrl;
    }

    public void setGitTagsUrl(String gitTagsUrl) {
        this.gitTagsUrl = gitTagsUrl;
    }

    public String getGitRefsUrl() {
        return gitRefsUrl;
    }

    public void setGitRefsUrl(String gitRefsUrl) {
        this.gitRefsUrl = gitRefsUrl;
    }

    public String getTreesUrl() {
        return treesUrl;
    }

    public void setTreesUrl(String treesUrl) {
        this.treesUrl = treesUrl;
    }

    public String getStatusesUrl() {
        return statusesUrl;
    }

    public void setStatusesUrl(String statusesUrl) {
        this.statusesUrl = statusesUrl;
    }

    public String getLanguagesUrl() {
        return languagesUrl;
    }

    public void setLanguagesUrl(String languagesUrl) {
        this.languagesUrl = languagesUrl;
    }

    public String getStargazersUrl() {
        return stargazersUrl;
    }

    public void setStargazersUrl(String stargazersUrl) {
        this.stargazersUrl = stargazersUrl;
    }

    public String getContributorsUrl() {
        return contributorsUrl;
    }

    public void setContributorsUrl(String contributorsUrl) {
        this.contributorsUrl = contributorsUrl;
    }

    public String getSubscribersUrl() {
        return subscribersUrl;
    }

    public void setSubscribersUrl(String subscribersUrl) {
        this.subscribersUrl = subscribersUrl;
    }

    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    public void setSubscriptionUrl(String subscriptionUrl) {
        this.subscriptionUrl = subscriptionUrl;
    }

    public String getCommitsUrl() {
        return commitsUrl;
    }

    public void setCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
    }

    public String getGitCommitsUrl() {
        return gitCommitsUrl;
    }

    public void setGitCommitsUrl(String gitCommitsUrl) {
        this.gitCommitsUrl = gitCommitsUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public String getIssueCommentUrl() {
        return issueCommentUrl;
    }

    public void setIssueCommentUrl(String issueCommentUrl) {
        this.issueCommentUrl = issueCommentUrl;
    }

    public String getContentsUrl() {
        return contentsUrl;
    }

    public void setContentsUrl(String contentsUrl) {
        this.contentsUrl = contentsUrl;
    }

    public String getCompareUrl() {
        return compareUrl;
    }

    public void setCompareUrl(String compareUrl) {
        this.compareUrl = compareUrl;
    }

    public String getMergesUrl() {
        return mergesUrl;
    }

    public void setMergesUrl(String mergesUrl) {
        this.mergesUrl = mergesUrl;
    }

    public String getArchiveUrl() {
        return archiveUrl;
    }

    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    public String getDownloadsUrl() {
        return downloadsUrl;
    }

    public void setDownloadsUrl(String downloadsUrl) {
        this.downloadsUrl = downloadsUrl;
    }

    public String getIssuesUrl() {
        return issuesUrl;
    }

    public void setIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
    }

    public String getPullsUrl() {
        return pullsUrl;
    }

    public void setPullsUrl(String pullsUrl) {
        this.pullsUrl = pullsUrl;
    }

    public String getMilestonesUrl() {
        return milestonesUrl;
    }

    public void setMilestonesUrl(String milestonesUrl) {
        this.milestonesUrl = milestonesUrl;
    }

    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    public void setNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
    }

    public String getLabelsUrl() {
        return labelsUrl;
    }

    public void setLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public void setReleasesUrl(String releasesUrl) {
        this.releasesUrl = releasesUrl;
    }

    public String getDeploymentsUrl() {
        return deploymentsUrl;
    }

    public void setDeploymentsUrl(String deploymentsUrl) {
        this.deploymentsUrl = deploymentsUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getSshUrl() {
        return sshUrl;
    }

    public void setSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(Integer stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public Integer getWatchersCount() {
        return watchersCount;
    }

    public void setWatchersCount(Integer watchersCount) {
        this.watchersCount = watchersCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean getHasIssues() {
        return hasIssues;
    }

    public void setHasIssues(boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public boolean getHasProjects() {
        return hasProjects;
    }

    public void setHasProjects(boolean hasProjects) {
        this.hasProjects = hasProjects;
    }

    public boolean getHasDownloads() {
        return hasDownloads;
    }

    public void setHasDownloads(boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }

    public boolean getHasWiki() {
        return hasWiki;
    }

    public void setHasWiki(boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public boolean getHasPages() {
        return hasPages;
    }

    public void setHasPages(boolean hasPages) {
        this.hasPages = hasPages;
    }

    public Integer getForksCount() {
        return forksCount;
    }

    public void setForksCount(Integer forksCount) {
        this.forksCount = forksCount;
    }

    public String getMirrorUrl() {
        return mirrorUrl;
    }

    public void setMirrorUrl(String mirrorUrl) {
        this.mirrorUrl = mirrorUrl;
    }

    public boolean getArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Integer getOpenIssuesCount() {
        return openIssuesCount;
    }

    public void setOpenIssuesCount(Integer openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public Integer getForks() {
        return forks;
    }

    public void setForks(Integer forks) {
        this.forks = forks;
    }

    public Integer getOpenIssues() {
        return openIssues;
    }

    public void setOpenIssues(Integer openIssues) {
        this.openIssues = openIssues;
    }

    public Integer getWatchers() {
        return watchers;
    }

    public void setWatchers(Integer watchers) {
        this.watchers = watchers;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

}
