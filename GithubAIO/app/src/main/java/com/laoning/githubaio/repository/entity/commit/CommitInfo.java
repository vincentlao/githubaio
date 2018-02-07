
package com.laoning.githubaio.repository.entity.commit;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommitInfo {

    @ColumnInfo(name = "url")
    private String url;
    @ColumnInfo(name = "author")
    private CommitAuthor author;
    @ColumnInfo(name = "committer")
    private CommitCommitter committer;
    @ColumnInfo(name = "message")
    private String message;
    @ColumnInfo(name = "tree")
    private Tree tree;
    @ColumnInfo(name = "comment_count")
    private Integer commentCount;
    @ColumnInfo(name = "verification")
    private Verification verification;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CommitAuthor getAuthor() {
        return author;
    }

    public void setAuthor(CommitAuthor author) {
        this.author = author;
    }

    public CommitCommitter getCommitter() {
        return committer;
    }

    public void setCommitter(CommitCommitter committer) {
        this.committer = committer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

}
