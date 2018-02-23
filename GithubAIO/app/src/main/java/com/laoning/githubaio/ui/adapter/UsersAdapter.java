package com.laoning.githubaio.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.laoning.githubaio.R;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.ui.fragment.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by laoni on 2018-2-20.
 */


public class UsersAdapter extends BaseAdapter<UsersAdapter.ViewHolder, User> {

    private boolean cardEnable = true;

    @Inject
    public UsersAdapter(Context context, BaseFragment fragment){
        super(context, fragment);
    }

    public void setCardEnable(boolean cardEnable) {
        this.cardEnable = cardEnable;
    }

    @Override
    protected int getLayoutId(int viewType) {
        return cardEnable ? R.layout.layout_item_user : R.layout.layout_item_user_no_card;
    }

    @Override
    protected ViewHolder getViewHolder(View itemView, int viewType) {
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Glide.with(fragment).load(data.get(position).getAvatarUrl()).into(holder.avatar);
        holder.name.setText(data.get(position).getLogin());
    }

    class ViewHolder extends BaseViewHolder {
        @BindView(R.id.avatar)
        ImageView avatar;
        @BindView(R.id.name)
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
