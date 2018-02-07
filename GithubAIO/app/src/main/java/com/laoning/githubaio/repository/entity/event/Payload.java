
package com.laoning.githubaio.repository.entity.event;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload {

    public enum RefType{
        repository, branch, tag
    }

    public enum IssueEventActionType{
        assigned, unassigned, labeled, unlabeled, opened,
        edited, milestoned, demilestoned, closed, reopened
    }

    public enum MemberEventActionType{
        added, deleted, edited
    }

    public enum OrgBlockEventActionType{
        blocked, unblocked
    }

    public enum PullRequestReviewCommentEventActionType{
        created, edited, deleted
    }

    public enum PullRequestReviewEventActionType{
        submitted, edited, dismissed
    }

    @ColumnInfo(name = "action")
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
