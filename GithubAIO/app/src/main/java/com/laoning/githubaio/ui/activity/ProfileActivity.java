

package com.laoning.githubaio.ui.activity;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

import com.bumptech.glide.Glide;
import com.laoning.githubaio.R;
import com.laoning.githubaio.base.BundleHelper;
import com.laoning.githubaio.base.StringUtils;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.ui.adapter.FragmentPagerModel;
import com.laoning.githubaio.ui.fragment.EventFragment;
import com.laoning.githubaio.ui.fragment.RepositoriesFragment;
import com.laoning.githubaio.viewmodel.MainViewModel;

/**
 * Created by ThirtyDegreesRay on 2017/8/23 11:39:13
 */

public class ProfileActivity extends PagerActivity {

    private String userName;
    private MainViewModel mainViewModel;

    public static void show(@NonNull Activity activity, @NonNull String loginId) {
        show(activity, loginId, null);
    }

    public static void show(@NonNull Activity activity,
                            @NonNull String loginId, @Nullable String userAvatar) {
        show(activity, null, loginId, userAvatar);
    }

    public static void show(@NonNull Activity activity, @Nullable View userAvatarView,
                            @NonNull String loginId, @Nullable String userAvatar) {
        Intent intent = createIntent(activity, loginId, userAvatar);

        if (userAvatarView != null) {
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                    .makeSceneTransitionAnimation(activity, userAvatarView, "userAvatar");
            activity.startActivity(intent, optionsCompat.toBundle());
        } else {
            activity.startActivity(intent);
        }

    }

    public static Intent createIntent(@NonNull Activity activity, @NonNull String loginId) {
        return createIntent(activity, loginId, null);
    }

    public static Intent createIntent(@NonNull Activity activity, @NonNull String loginId,
                                      @Nullable String userAvatar) {
        return new Intent(activity, ProfileActivity.class)
                .putExtras(BundleHelper.builder()
                        .put("name", loginId)
                        .put("avatar_url", userAvatar)
                        .build());
    }

    private boolean isAvatarSetted = false;

    @BindView(R.id.user_avatar_bg) ImageView userImageViewBg;
    @BindView(R.id.user_avatar) ImageView userImageView;
    @BindView(R.id.loader) ProgressBar loader;
    @BindView(R.id.joined_time) TextView joinedTime;
    @BindView(R.id.location) TextView location;


    @Nullable
    @Override
    protected int getContentView() {
        return R.layout.activity_profile;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        Bundle bundle = this.getIntent().getExtras();
        userName = bundle.getString("name");

        setTransparentStatusBar();
        setToolbarBackEnable();

        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);

        LiveData<User> userLiveData = mainViewModel.findUserByLogin(userName);
        userLiveData.observe(this, user -> {
            showProfileInfo(user);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void showProfileInfo(User user) {
        invalidateOptionsMenu();
        setUserAvatar(user);
        joinedTime.setText(getString(R.string.joined_at).concat(" ")
                .concat(user.getCreateAt()));
        location.setText(user.getLogin());

        if (pagerAdapter.getCount() == 0) {
            pagerAdapter.setPagerList(FragmentPagerModel.createProfilePagerList(this, user, getFragments()));
            tabLayout.setVisibility(View.VISIBLE);
            tabLayout.setupWithViewPager(viewPager);
            viewPager.setAdapter(pagerAdapter);
            showFirstPager();
        } else {
            notifyUserInfoUpdated(user);
        }
    }

    private void notifyUserInfoUpdated(User user){
        for(Fragment fragment : getFragments()){
//            if(fragment != null && fragment instanceof ProfileInfoFragment){
//                ((ProfileInfoFragment)fragment).updateProfileInfo(user);
//            }
        }
    }

    public void showLoading() {
        loader.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        loader.setVisibility(View.GONE);
    }

    public void finishActivity() {
        supportFinishAfterTransition();
    }

    private void setUserAvatar(User user) {
        Glide.with(this).load(user.getAvatarUrl()).into(userImageView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //TODO Don't know why loader showImage automatic when resume from other page, conflict with screen transition
//        loader.setVisibility(View.GONE);
    }

    @Override
    public int getPagerSize() {
        return 2;
    }

    @Override
    protected int getFragmentPosition(Fragment fragment) {
        if (fragment instanceof EventFragment) {
            return 0;
        } else if (fragment instanceof RepositoriesFragment) {
            return 1;
        } else {
            return -1;
        }
    }
}
