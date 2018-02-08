package com.laoning.githubaio.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.laoning.githubaio.R;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.entity.event.Payload;
import com.laoning.githubaio.ui.fragment.BaseFragment;
import butterknife.BindView;


/**
 * Created by laoni on 2018-2-6.
 */


public class EventAdapter extends BaseAdapter<EventAdapter.ViewHolder, Event> {

//    @Inject
    public EventAdapter(Context context, BaseFragment fragment) {
        super(context, fragment);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.layout_item_activity;
    }

    @Override
    protected ViewHolder getViewHolder(View itemView, int viewType) {
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Event model = data.get(position);

//        if (model.getActor().getAvatarUrl() != null) {
            Glide.with(fragment).load(model.getActor().getAvatarUrl()).into(holder.userAvatar);
//        }

        holder.userName.setText(model.getActor().getLogin());
        holder.time.setText(model.getCreatedAt());

        holder.setActionAndDesc(model);
    }

    class ViewHolder extends BaseViewHolder {

        @BindView(R.id.user_avatar)
        ImageView userAvatar;
        @BindView(R.id.user_name)
        TextView userName;
        @BindView(R.id.time) TextView time;
        @BindView(R.id.action) TextView action;
        @BindView(R.id.desc) TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }


        void setActionAndDesc(Event model) {
            if (model == null) {
                Log.d("aio", "model == null");
                return;
            }
            String fullName = model.getRepo() != null ? model.getRepo().getName() : null;

            String action = model.getPayload() != null ? model.getPayload().getAction() : "";

            String repoName = model.getRepo() != null ? model.getRepo().getName() : "";
            String actionStr = model.getActor().getDisplayLogin() + " " + action + " in " + fullName;
            this.action.setText(actionStr);
        }

        private String getFirstLine(String str){
            if(str == null || !str.contains("\n")) return str;
            return str.substring(0, str.indexOf("\n"));
        }

        private String getPullRequestReviewEventStr(String action){
            Payload.PullRequestReviewEventActionType actionType =
                    Payload.PullRequestReviewEventActionType.valueOf(action);
            switch (actionType){
                case submitted:
                    return getString(R.string.submitted_pull_request_review_at);
                case edited:
                    return getString(R.string.edited_pull_request_review_at);
                case dismissed:
                    return getString(R.string.dismissed_pull_request_review_at);
                default:
                    return getString(R.string.submitted_pull_request_review_at);
            }
        }

        private String getPullRequestReviewCommentEventStr(String action){
            Payload.PullRequestReviewCommentEventActionType actionType =
                    Payload.PullRequestReviewCommentEventActionType.valueOf(action);
            switch (actionType){
                case created:
                    return getString(R.string.created_pull_request_comment_at);
                case edited:
                    return getString(R.string.edited_pull_request_comment_at);
                case deleted:
                    return getString(R.string.deleted_pull_request_comment_at);
                default:
                    return getString(R.string.created_pull_request_comment_at);
            }
        }

        private String getMemberEventStr(String action){
            Payload.MemberEventActionType actionType = Payload.MemberEventActionType.valueOf(action);
            switch (actionType){
                case added:
                    return getString(R.string.added_member_to);
                case deleted:
                    return getString(R.string.deleted_member_at);
                case edited:
                    return getString(R.string.edited_member_at);
                default:
                    return getString(R.string.added_member_to);
            }
        }

        private String getIssueEventStr(String action){
            Payload.IssueEventActionType actionType = Payload.IssueEventActionType.valueOf(action);
            switch (actionType){
                case assigned:
                    return getString(R.string.assigned_issue_at);
                case unassigned:
                    return getString(R.string.unassigned_issue_at);
                case labeled:
                    return getString(R.string.labeled_issue_at);
                case unlabeled:
                    return getString(R.string.unlabeled_issue_at);
                case opened:
                    return getString(R.string.opened_issue_at);

                case edited:
                    return getString(R.string.edited_issue_at);
                case milestoned:
                    return getString(R.string.milestoned_issue_at);
                case demilestoned:
                    return getString(R.string.demilestoned_issue_at);
                case closed:
                    return getString(R.string.closed_issue_at);
                case reopened:
                    return getString(R.string.reopened_issue_at);

                default:
                    return getString(R.string.opened_issue_at);
            }
        }

    }

}
