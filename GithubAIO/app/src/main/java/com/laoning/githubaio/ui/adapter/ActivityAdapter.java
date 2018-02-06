package com.laoning.githubaio.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.laoning.githubaio.R;
import com.laoning.githubaio.base.StringUtils;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.ui.fragment.BaseFragment;

import java.util.regex.Matcher;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by laoni on 2018-2-6.
 */


public class ActivityAdapter extends BaseAdapter<ActivityAdapter.ViewHolder, Event> {

    @Inject
    public ActivityAdapter(Context context, BaseFragment fragment) {
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
//        GlideApp.with(fragment)
//                .load(model.getActor().getAvatarUrl())
//                .onlyRetrieveFromCache(!PrefUtils.isLoadImageEnable())
//                .into(holder.userAvatar);
        holder.userName.setText(model.getActor().getLogin());
        holder.time.setText(StringUtils.getNewsTimeStr(context, model.getCreatedAt()));

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


        //TODO to be better event action and desc
        void setActionAndDesc(Event model) {

        }

        private String getFirstLine(String str){
            if(str == null || !str.contains("\n")) return str;
            return str.substring(0, str.indexOf("\n"));
        }

        private String getPullRequestReviewEventStr(String action){
            return action;
        }

        private String getPullRequestReviewCommentEventStr(String action){
            return action;
        }

        private String getMemberEventStr(String action){
            return action;
        }

        private String getIssueEventStr(String action){
            return action;
        }

    }

}
