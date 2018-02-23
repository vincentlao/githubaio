package com.laoning.githubaio.ui.fragment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.laoning.githubaio.R;
import com.laoning.githubaio.base.BundleHelper;
import com.laoning.githubaio.base.GlobalInfo;
import com.laoning.githubaio.repository.entity.SearchModel;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.remote.base.Resource;
import com.laoning.githubaio.ui.activity.ProfileActivity;
import com.laoning.githubaio.ui.adapter.NotificationsAdapter;
import com.laoning.githubaio.ui.adapter.UsersAdapter;
import com.laoning.githubaio.viewmodel.MainViewModel;
import com.laoning.githubaio.viewmodel.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by laoni on 2018-2-20.
 */

public class UserListFragment extends ListFragment<UsersAdapter>{

    private MainViewModel mainViewModel;
    private SearchViewModel searchViewModel;
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    GlobalInfo globalInfo;

    public enum UserListType{
        STARGAZERS, WATCHERS, FOLLOWERS, FOLLOWING, SEARCH, ORG_MEMBERS, TRACE, BOOKMARK
    }

    public static UserListFragment create(@NonNull UserListType type, @NonNull String user,
                                          @NonNull String repo){
        UserListFragment fragment = new UserListFragment();
        fragment.setArguments(
                BundleHelper.builder()
                        .put("type", type)
                        .put("user", user)
                        .put("repo", repo)
                        .build()
        );
        return fragment;
    }

    public static UserListFragment createForSearch(@NonNull SearchModel searchModel){
        UserListFragment fragment = new UserListFragment();
        fragment.setArguments(
                BundleHelper.builder()
                        .put("type", UserListType.SEARCH)
                        .put("searchModel", searchModel)
                        .build()
        );
        return fragment;
    }

    public static UserListFragment createForTrace(){
        UserListFragment fragment = new UserListFragment();
        fragment.setArguments(BundleHelper.builder().put("type", UserListType.TRACE).build());
        return fragment;
    }

    public static UserListFragment createForBookmark(){
        UserListFragment fragment = new UserListFragment();
        fragment.setArguments(BundleHelper.builder().put("type", UserListType.BOOKMARK).build());
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        adapter = new UsersAdapter(getActivity(), this);

        super.initFragment(savedInstanceState);

        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        searchViewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel.class);


        setLoadMoreEnable(true);
    }

    @Override
    public void onFragmentShowed() {
        super.onFragmentShowed();
        onLoadData();
    }

    @Override
    protected void onLoadData() {
        LoadPage();
    }

    @Override
    protected void onReLoadData() {
        LoadPage();
    }

    @Override
    protected String getEmptyTip() {
        return getString(R.string.no_user);
    }

    public void showUsers(List<User> users) {
        adapter.setData(users);
        postNotifyDataSetChanged();
    }

    protected void onLoadMore() {
        super.onLoadMore();
        LoadPage();
    }

    private void LoadPage() {
        Bundle bundle = getArguments();
        SearchModel model = (SearchModel)bundle.get("searchModel");

        LiveData<Resource<List<User>>> repos = searchViewModel.searchUsers(model.getQuery(), model.getSort(), model.getOrder(), getCurPage());


        if (repos == null) {
            return;
        }

        repos.observe(this, reposResource -> {
            if (reposResource == null || reposResource.data == null) {
                return;
            }

            showUsers(reposResource.data);
            hideLoading();
        });
    }

    @Override
    public void onItemClick(int position, @NonNull View view) {
        super.onItemClick(position, view);
        View userAvatar = view.findViewById(R.id.avatar);
//        ProfileActivity.show(getActivity(), userAvatar, adapter.getData().get(position).getLogin(), adapter.getData().get(position).getAvatarUrl());
    }
}

