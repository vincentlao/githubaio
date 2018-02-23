package com.laoning.githubaio.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

import com.laoning.githubaio.R;
import com.laoning.githubaio.ui.adapter.FragmentPagerModel;
import com.laoning.githubaio.ui.adapter.FragmentViewPagerAdapter;
import com.laoning.githubaio.ui.fragment.NotificationsFragment;

/**
 * Created by laoni on 2018-2-20.
 */


public class NotificationsActivity extends PagerActivity {

    public static void show(@NonNull Activity activity){
        Intent intent = new Intent(activity, NotificationsActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        setToolbarScrollAble(true);
        setToolbarBackEnable();
        setToolbarTitle(getString(R.string.notifications));

        pagerAdapter.setPagerList(FragmentPagerModel.createNotificationsPagerList(this, getFragments()));
        tabLayout.setVisibility(View.VISIBLE);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(pagerAdapter);
        showFirstPager();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_view_pager;
    }

    @Override
    public int getPagerSize() {
        return 3;
    }

    @Override
    protected int getFragmentPosition(Fragment fragment) {
        if(fragment instanceof NotificationsFragment){
            NotificationsFragment.NotificationsType type
                    = (NotificationsFragment.NotificationsType) fragment.getArguments().get("type");
            if(NotificationsFragment.NotificationsType.Unread.equals(type)){
                return 0;
            } else if(NotificationsFragment.NotificationsType.Participating.equals(type)){
                return 1;
            } else if(NotificationsFragment.NotificationsType.All.equals(type)){
                return 2;
            } else
                return -1;
        } else
            return -1;
    }

}

