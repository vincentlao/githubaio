package com.laoning.githubaio.ui.activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.laoning.githubaio.R;
import com.laoning.githubaio.base.GlobalInfo;
import com.laoning.githubaio.base.StringUtils;
import com.laoning.githubaio.repository.base.LiveDataTask;
import com.laoning.githubaio.repository.entity.Account;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.remote.base.Resource;
import com.laoning.githubaio.ui.fragment.EventFragment;
import com.laoning.githubaio.viewmodel.MainViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.nav_view) @Nullable
    protected NavigationView navView;

    @BindView(R.id.drawer_layout) @Nullable
    protected DrawerLayout drawerLayout;

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment showFragment = EventFragment.create();

        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_content, showFragment, showFragment.getTag()).commit();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("News");
        }

        navView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        updateDrawerContent(R.menu.activity_main_drawer);

        ImageView avatar = navView.getHeaderView(0).findViewById(R.id.avatar);
        TextView name = navView.getHeaderView(0).findViewById(R.id.name);
        TextView createDate = navView.getHeaderView(0).findViewById(R.id.create_date);

        Account loginAccount = globalInfo.getCurrentUserAccount();
        LiveData<User> userLiveData = mainViewModel.findUserByLogin(loginAccount.getName());

        userLiveData.observe(this, user -> {
            Glide.with(this).load(user.getAvatarUrl()).into(avatar);

            name.setText(StringUtils.isBlank(user.getName()) ? user.getLogin() : user.getName());
            String joinTime = getString(R.string.joined_at).concat(" ").concat(user.getCreateAt());
            createDate.setText(StringUtils.isBlank(user.getBio()) ? joinTime : user.getBio());
        });
    }

    private void updateDrawerContent(int menuId) {
        if (drawerLayout != null && navView != null) {
            navView.getMenu().clear();
            navView.inflateMenu(menuId);
            if (drawerLayout.indexOfChild(navView) == -1) {
                drawerLayout.addView(navView);
            }
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
