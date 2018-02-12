package com.laoning.githubaio.ui.activity;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.laoning.githubaio.R;
import com.laoning.githubaio.base.StringUtils;
import com.laoning.githubaio.repository.entity.Account;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.ui.fragment.EventFragment;
import com.laoning.githubaio.ui.fragment.RepositoriesFragment;
import com.laoning.githubaio.viewmodel.MainViewModel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Unbinder unbinder;

    @BindView(R.id.toolbar) @Nullable
    protected Toolbar toolbar;

    @BindView(R.id.nav_view) @Nullable
    protected NavigationView navView;

    @BindView(R.id.drawer_layout) @Nullable
    protected DrawerLayout drawerLayout;

    private MainViewModel mainViewModel;

    private int selectedPage = R.id.nav_news;

    private final Map<Integer, String> TAG_MAP = new HashMap<>();

    private final List<Integer> FRAGMENT_NAV_ID_LIST = Arrays.asList(
            R.id.nav_news, R.id.nav_owned, R.id.nav_starred, R.id.nav_bookmarks,
            R.id.nav_trace, R.id.nav_public_news, R.id.nav_collections, R.id.nav_topics
    );

    private final List<String> FRAGMENT_TAG_LIST = Arrays.asList(
            EventFragment.class.getSimpleName()
    );

    private final List<Integer> FRAGMENT_TITLE_LIST = Arrays.asList(
            R.string.news, R.string.my_repos, R.string.starred_repos, R.string.bookmarks,
            R.string.trace, R.string.public_news, R.string.repo_collections, R.string.topics
    );

    {
        for(int i = 0; (i < FRAGMENT_NAV_ID_LIST.size()) && (i < FRAGMENT_TAG_LIST.size()); i++){
            TAG_MAP.put(FRAGMENT_NAV_ID_LIST.get(i), FRAGMENT_TAG_LIST.get(i));
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        initView(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected void initView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);

        navView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        selectedPage = R.id.nav_news;
        updateFragmentByNavId(selectedPage);
        updateSelfInfo();
    }

    private void updateFragmentByNavId(int id){
        if(FRAGMENT_NAV_ID_LIST.contains(id)){
            updateTitle(id);
            loadFragment(id);
        }
    }

    private void updateSelfInfo() {

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

    private void updateTitle(int itemId) {
        int titleId = FRAGMENT_TITLE_LIST.get(FRAGMENT_NAV_ID_LIST.indexOf(itemId));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(titleId));
        }
    }

    private void loadFragment(int itemId) {
        selectedPage = itemId;
        String fragmentTag = TAG_MAP.get(itemId);
        Fragment showFragment = getSupportFragmentManager().findFragmentByTag(fragmentTag);
        boolean isExist = true;
        if (showFragment == null) {
            isExist = false;
            showFragment = getFragment(itemId);
        }
        if (showFragment.isVisible()) {
            return;
        }

        Fragment visibleFragment = getVisibleFragment();
        if (isExist) {
            showAndHideFragment(showFragment, visibleFragment);
        } else {
            addAndHideFragment(showFragment, visibleFragment, fragmentTag);
        }
    }

    @NonNull
    private Fragment getFragment(int itemId) {
        switch (itemId) {
            case R.id.nav_news:
                return EventFragment.create();
            case R.id.nav_owned:
                return RepositoriesFragment.create(RepositoriesFragment.RepositoriesType.OWNED, globalInfo.getCurrentUserAccount().getName());
        }
        return null;
    }

    protected Fragment getVisibleFragment(){
        @SuppressLint("RestrictedApi")
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        if(fragmentList != null ){
            for(Fragment fragment : fragmentList){
                if(fragment != null && fragment.isVisible()){
                    return fragment;
                }
            }
        }
        return null;
    }

    private void showAndHideFragment(@NonNull Fragment showFragment, @Nullable Fragment hideFragment) {
        if (hideFragment == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .show(showFragment)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .show(showFragment)
                    .hide(hideFragment)
                    .commit();
        }

    }

    private void addAndHideFragment(@NonNull Fragment showFragment,
                                    @Nullable Fragment hideFragment, @NonNull String addTag) {
        if (hideFragment == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame_layout_content, showFragment, addTag)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame_layout_content, showFragment, addTag)
                    .hide(hideFragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
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
        closeDrawer();
        int id = item.getItemId();

        if(FRAGMENT_NAV_ID_LIST.contains(id)){
            updateFragmentByNavId(id);
            return true;
        }

        switch (id) {
            case R.id.nav_profile:
                Account loginAccount = globalInfo.getCurrentUserAccount();
                ProfileActivity.show(this, loginAccount.getName(),loginAccount.getAvatarUrl());
                break;
            default:
                break;
        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    protected final void openDrawer(boolean isStartDrawer) {
        if (drawerLayout != null) {
            drawerLayout.openDrawer(isStartDrawer ? GravityCompat.START : GravityCompat.END);
        }
    }

    protected final void closeDrawer() {
        if (drawerLayout != null) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            if (drawerLayout.isDrawerOpen(GravityCompat.END))
                drawerLayout.closeDrawer(GravityCompat.END);
        }
    }
}
