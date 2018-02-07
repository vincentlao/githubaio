
package com.laoning.githubaio.repository.entity.commit;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;
import com.google.gson.annotations.Expose;

public class Commit {

    @PrimaryKey
    @ColumnInfo(name = "url")
    private String url;
    @ColumnInfo(name = "sha")
    private String sha;
    @ColumnInfo(name = "html_url")
    private String htmlUrl;
    @ColumnInfo(name = "comments_url")
    private String commentsUrl;
    @ColumnInfo(name = "commit")
    private CommitInfo commit;
    @ColumnInfo(name = "author")
    private Author author;
    @ColumnInfo(name = "committer")
    private Committer committer;
    @ColumnInfo(name = "parents")
    private List<Parent> parents = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public CommitInfo getCommit() {
        return commit;
    }

    public void setCommit(CommitInfo commit) {
        this.commit = commit;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Committer getCommitter() {
        return committer;
    }

    public void setCommitter(Committer committer) {
        this.committer = committer;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

}
