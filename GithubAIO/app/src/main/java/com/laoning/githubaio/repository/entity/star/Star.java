
package com.laoning.githubaio.repository.entity.star;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.laoning.githubaio.repository.entity.Owner;

@Entity(tableName = "star")
public class Star {

    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    private Integer id;


    @Embedded(prefix = "owner_")
    private Owner owner;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("full_name")
    @ColumnInfo(name = "full_name")
    private String fullName;

    @SerializedName("description")
    @ColumnInfo(name = "description")
    private String description;

    @SerializedName("private")
    @ColumnInfo(name = "private")
    private Boolean _private;

    @SerializedName("fork")
    @ColumnInfo(name = "fork")
    private Boolean fork;

    @SerializedName("url")
    @ColumnInfo(name = "url")
    private String url;

    @SerializedName("html_url")
    @ColumnInfo(name = "html_url")
    private String htmlUrl;

    @SerializedName("archive_url")
    @ColumnInfo(name = "archive_url")
    private String archiveUrl;

    @SerializedName("assignees_url")
    @ColumnInfo(name = "assignees_url")
    private String assigneesUrl;

    @SerializedName("blobs_url")
    @ColumnInfo(name = "blobs_url")
    private String blobsUrl;

    @SerializedName("branches_url")
    @ColumnInfo(name = "branches_url")
    private String branchesUrl;

    @SerializedName("clone_url")
    @ColumnInfo(name = "clone_url")
    private String cloneUrl;

    @SerializedName("collaborators_url")
    @ColumnInfo(name = "collaborators_url")
    private String collaboratorsUrl;

    @SerializedName("comments_url")
    @ColumnInfo(name = "comments_url")
    private String commentsUrl;

    @SerializedName("commits_url")
    @ColumnInfo(name = "commits_url")
    private String commitsUrl;

    @SerializedName("compare_url")
    @ColumnInfo(name = "compare_url")
    private String compareUrl;

    @SerializedName("contents_url")
    @ColumnInfo(name = "contents_url")
    private String contentsUrl;

    @SerializedName("contributors_url")
    @ColumnInfo(name = "contributors_url")
    private String contributorsUrl;

    @SerializedName("deployments_url")
    @ColumnInfo(name = "deployments_url")
    private String deploymentsUrl;

    @SerializedName("downloads_url")
    @ColumnInfo(name = "downloads_url")
    private String downloadsUrl;

    @SerializedName("events_url")
    @ColumnInfo(name = "events_url")
    private String eventsUrl;

    @SerializedName("forks_url")
    @ColumnInfo(name = "forks_url")
    private String forksUrl;

    @SerializedName("git_commits_url")
    @ColumnInfo(name = "git_commits_url")
    private String gitCommitsUrl;
    @SerializedName("git_refs_url")
    @ColumnInfo(name = "git_refs_url")
    private String gitRefsUrl;
    @SerializedName("git_tags_url")
    @ColumnInfo(name = "git_tags_url")
    private String gitTagsUrl;
    @SerializedName("git_url")
    @ColumnInfo(name = "git_url")
    private String gitUrl;
    @SerializedName("hooks_url")
    @ColumnInfo(name = "hooks_url")
    private String hooksUrl;
    @SerializedName("issue_comment_url")
    @ColumnInfo(name = "issue_comment_url")
    private String issueCommentUrl;
    @SerializedName("issue_events_url")
    @ColumnInfo(name = "issue_events_url")
    private String issueEventsUrl;
    @SerializedName("issues_url")
    @ColumnInfo(name = "issues_url")
    private String issuesUrl;
    @SerializedName("keys_url")
    @ColumnInfo(name = "keys_url")
    private String keysUrl;
    @SerializedName("labels_url")
    @ColumnInfo(name = "labels_url")
    private String labelsUrl;
    @SerializedName("languages_url")
    @ColumnInfo(name = "languages_url")
    private String languagesUrl;
    @SerializedName("merges_url")
    @ColumnInfo(name = "merges_url")
    private String mergesUrl;
    @SerializedName("milestones_url")
    @ColumnInfo(name = "milestones_url")
    private String milestonesUrl;
    @SerializedName("mirror_url")
    @ColumnInfo(name = "mirror_url")
    private String mirrorUrl;
    @SerializedName("notifications_url")
    @ColumnInfo(name = "notifications_url")
    private String notificationsUrl;
    @SerializedName("pulls_url")
    @ColumnInfo(name = "pulls_url")
    private String pullsUrl;
    @SerializedName("releases_url")
    @ColumnInfo(name = "releases_url")
    private String releasesUrl;
    @SerializedName("ssh_url")
    @ColumnInfo(name = "ssh_url")
    private String sshUrl;
    @SerializedName("stargazers_url")
    @ColumnInfo(name = "stargazers_url")
    private String stargazersUrl;
    @SerializedName("statuses_url")
    @ColumnInfo(name = "statuses_url")
    private String statusesUrl;
    @SerializedName("subscribers_url")
    @ColumnInfo(name = "subscribers_url")
    private String subscribersUrl;
    @SerializedName("subscription_url")
    @ColumnInfo(name = "subscription_url")
    private String subscriptionUrl;
    @SerializedName("svn_url")
    @ColumnInfo(name = "svn_url")
    private String svnUrl;
    @SerializedName("tags_url")
    @ColumnInfo(name = "tags_url")
    private String tagsUrl;
    @SerializedName("teams_url")
    @ColumnInfo(name = "teams_url")
    private String teamsUrl;
    @SerializedName("trees_url")
    @ColumnInfo(name = "trees_url")
    private String treesUrl;
    @SerializedName("homepage")
    @ColumnInfo(name = "homepage")
    private String homepage;
    @SerializedName("language")
    @ColumnInfo(name = "language")
    private Object language;
    @SerializedName("forks_count")
    @ColumnInfo(name = "forks_count")
    private Integer forksCount;
    @SerializedName("stargazers_count")
    @ColumnInfo(name = "stargazers_count")
    private Integer stargazersCount;
    @SerializedName("watchers_count")
    @ColumnInfo(name = "watchers_count")
    private Integer watchersCount;
    @SerializedName("size")
    @ColumnInfo(name = "size")
    private Integer size;
    @SerializedName("default_branch")
    @ColumnInfo(name = "default_branch")
    private String defaultBranch;
    @SerializedName("open_issues_count")
    @ColumnInfo(name = "open_issues_count")
    private Integer openIssuesCount;
    @SerializedName("topics")
    @ColumnInfo(name = "topics")
    private List<String> topics = null;
    @SerializedName("has_issues")
    @ColumnInfo(name = "has_issues")
    private Boolean hasIssues;
    @SerializedName("has_wiki")
    @ColumnInfo(name = "has_wiki")
    private Boolean hasWiki;
    @SerializedName("has_pages")
    @ColumnInfo(name = "has_pages")
    private Boolean hasPages;
    @SerializedName("has_downloads")
    @ColumnInfo(name = "has_downloads")
    private Boolean hasDownloads;
    @SerializedName("archived")
    @ColumnInfo(name = "archived")
    private Boolean archived;
    @SerializedName("pushed_at")
    @ColumnInfo(name = "pushed_at")
    private String pushedAt;
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    private String createdAt;
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    private String updatedAt;

    @Embedded(prefix = "permissions_")
    private Permissions permissions;

    @SerializedName("allow_rebase_merge")
    @ColumnInfo(name = "allow_rebase_merge")
    private Boolean allowRebaseMerge;
    @SerializedName("allow_squash_merge")
    @ColumnInfo(name = "allow_squash_merge")
    private Boolean allowSquashMerge;
    @SerializedName("allow_merge_commit")
    @ColumnInfo(name = "allow_merge_commit")
    private Boolean allowMergeCommit;
    @SerializedName("subscribers_count")
    @ColumnInfo(name = "subscribers_count")
    private Integer subscribersCount;
    @SerializedName("network_count")
    @ColumnInfo(name = "network_count")
    private Integer networkCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPrivate() {
        return _private;
    }

    public void setPrivate(Boolean _private) {
        this._private = _private;
    }

    public Boolean getFork() {
        return fork;
    }

    public void setFork(Boolean fork) {
        this.fork = fork;
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

    public String getArchiveUrl() {
        return archiveUrl;
    }

    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    public String getAssigneesUrl() {
        return assigneesUrl;
    }

    public void setAssigneesUrl(String assigneesUrl) {
        this.assigneesUrl = assigneesUrl;
    }

    public String getBlobsUrl() {
        return blobsUrl;
    }

    public void setBlobsUrl(String blobsUrl) {
        this.blobsUrl = blobsUrl;
    }

    public String getBranchesUrl() {
        return branchesUrl;
    }

    public void setBranchesUrl(String branchesUrl) {
        this.branchesUrl = branchesUrl;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public String getCollaboratorsUrl() {
        return collaboratorsUrl;
    }

    public void setCollaboratorsUrl(String collaboratorsUrl) {
        this.collaboratorsUrl = collaboratorsUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public String getCommitsUrl() {
        return commitsUrl;
    }

    public void setCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
    }

    public String getCompareUrl() {
        return compareUrl;
    }

    public void setCompareUrl(String compareUrl) {
        this.compareUrl = compareUrl;
    }

    public String getContentsUrl() {
        return contentsUrl;
    }

    public void setContentsUrl(String contentsUrl) {
        this.contentsUrl = contentsUrl;
    }

    public String getContributorsUrl() {
        return contributorsUrl;
    }

    public void setContributorsUrl(String contributorsUrl) {
        this.contributorsUrl = contributorsUrl;
    }

    public String getDeploymentsUrl() {
        return deploymentsUrl;
    }

    public void setDeploymentsUrl(String deploymentsUrl) {
        this.deploymentsUrl = deploymentsUrl;
    }

    public String getDownloadsUrl() {
        return downloadsUrl;
    }

    public void setDownloadsUrl(String downloadsUrl) {
        this.downloadsUrl = downloadsUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getForksUrl() {
        return forksUrl;
    }

    public void setForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
    }

    public String getGitCommitsUrl() {
        return gitCommitsUrl;
    }

    public void setGitCommitsUrl(String gitCommitsUrl) {
        this.gitCommitsUrl = gitCommitsUrl;
    }

    public String getGitRefsUrl() {
        return gitRefsUrl;
    }

    public void setGitRefsUrl(String gitRefsUrl) {
        this.gitRefsUrl = gitRefsUrl;
    }

    public String getGitTagsUrl() {
        return gitTagsUrl;
    }

    public void setGitTagsUrl(String gitTagsUrl) {
        this.gitTagsUrl = gitTagsUrl;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getHooksUrl() {
        return hooksUrl;
    }

    public void setHooksUrl(String hooksUrl) {
        this.hooksUrl = hooksUrl;
    }

    public String getIssueCommentUrl() {
        return issueCommentUrl;
    }

    public void setIssueCommentUrl(String issueCommentUrl) {
        this.issueCommentUrl = issueCommentUrl;
    }

    public String getIssueEventsUrl() {
        return issueEventsUrl;
    }

    public void setIssueEventsUrl(String issueEventsUrl) {
        this.issueEventsUrl = issueEventsUrl;
    }

    public String getIssuesUrl() {
        return issuesUrl;
    }

    public void setIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
    }

    public String getKeysUrl() {
        return keysUrl;
    }

    public void setKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
    }

    public String getLabelsUrl() {
        return labelsUrl;
    }

    public void setLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    public String getLanguagesUrl() {
        return languagesUrl;
    }

    public void setLanguagesUrl(String languagesUrl) {
        this.languagesUrl = languagesUrl;
    }

    public String getMergesUrl() {
        return mergesUrl;
    }

    public void setMergesUrl(String mergesUrl) {
        this.mergesUrl = mergesUrl;
    }

    public String getMilestonesUrl() {
        return milestonesUrl;
    }

    public void setMilestonesUrl(String milestonesUrl) {
        this.milestonesUrl = milestonesUrl;
    }

    public String getMirrorUrl() {
        return mirrorUrl;
    }

    public void setMirrorUrl(String mirrorUrl) {
        this.mirrorUrl = mirrorUrl;
    }

    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    public void setNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
    }

    public String getPullsUrl() {
        return pullsUrl;
    }

    public void setPullsUrl(String pullsUrl) {
        this.pullsUrl = pullsUrl;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public void setReleasesUrl(String releasesUrl) {
        this.releasesUrl = releasesUrl;
    }

    public String getSshUrl() {
        return sshUrl;
    }

    public void setSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
    }

    public String getStargazersUrl() {
        return stargazersUrl;
    }

    public void setStargazersUrl(String stargazersUrl) {
        this.stargazersUrl = stargazersUrl;
    }

    public String getStatusesUrl() {
        return statusesUrl;
    }

    public void setStatusesUrl(String statusesUrl) {
        this.statusesUrl = statusesUrl;
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

    public String getSvnUrl() {
        return svnUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public String getTagsUrl() {
        return tagsUrl;
    }

    public void setTagsUrl(String tagsUrl) {
        this.tagsUrl = tagsUrl;
    }

    public String getTeamsUrl() {
        return teamsUrl;
    }

    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
    }

    public String getTreesUrl() {
        return treesUrl;
    }

    public void setTreesUrl(String treesUrl) {
        this.treesUrl = treesUrl;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Object getLanguage() {
        return language;
    }

    public void setLanguage(Object language) {
        this.language = language;
    }

    public Integer getForksCount() {
        return forksCount;
    }

    public void setForksCount(Integer forksCount) {
        this.forksCount = forksCount;
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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public Integer getOpenIssuesCount() {
        return openIssuesCount;
    }

    public void setOpenIssuesCount(Integer openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public Boolean getHasIssues() {
        return hasIssues;
    }

    public void setHasIssues(Boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public Boolean getHasWiki() {
        return hasWiki;
    }

    public void setHasWiki(Boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public Boolean getHasPages() {
        return hasPages;
    }

    public void setHasPages(Boolean hasPages) {
        this.hasPages = hasPages;
    }

    public Boolean getHasDownloads() {
        return hasDownloads;
    }

    public void setHasDownloads(Boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
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

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    public Boolean getAllowRebaseMerge() {
        return allowRebaseMerge;
    }

    public void setAllowRebaseMerge(Boolean allowRebaseMerge) {
        this.allowRebaseMerge = allowRebaseMerge;
    }

    public Boolean getAllowSquashMerge() {
        return allowSquashMerge;
    }

    public void setAllowSquashMerge(Boolean allowSquashMerge) {
        this.allowSquashMerge = allowSquashMerge;
    }

    public Boolean getAllowMergeCommit() {
        return allowMergeCommit;
    }

    public void setAllowMergeCommit(Boolean allowMergeCommit) {
        this.allowMergeCommit = allowMergeCommit;
    }

    public Integer getSubscribersCount() {
        return subscribersCount;
    }

    public void setSubscribersCount(Integer subscribersCount) {
        this.subscribersCount = subscribersCount;
    }

    public Integer getNetworkCount() {
        return networkCount;
    }

    public void setNetworkCount(Integer networkCount) {
        this.networkCount = networkCount;
    }

}
