package com.laoning.githubaio.ui.fragment;

import android.arch.lifecycle.LiveData;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.laoning.githubaio.R;
import com.laoning.githubaio.base.BundleHelper;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.ui.adapter.RepositoriesAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laoni on 2018-2-9.
 */


public class RepositoriesFragment extends ListFragment<RepositoriesAdapter>{

    public enum RepositoriesType{
        OWNED, PUBLIC, STARRED, TRENDING, SEARCH, FORKS, TRACE, BOOKMARK, COLLECTION, TOPIC
    }

    public static RepositoriesFragment create(@NonNull RepositoriesType type,
                                              @NonNull String user){
        RepositoriesFragment fragment = new RepositoriesFragment();
        fragment.setArguments(BundleHelper.builder().put("type", type)
                .put("user", user).build());
        return fragment;
    }


    public static RepositoriesFragment createForForks(@NonNull String user, @NonNull String repo){
        RepositoriesFragment fragment = new RepositoriesFragment();
        fragment.setArguments(BundleHelper.builder()
                .put("type", RepositoriesType.FORKS)
                .put("user", user)
                .put("repo", repo)
                .build());
        return fragment;
    }


    public static RepositoriesFragment createForTrace(){
        RepositoriesFragment fragment = new RepositoriesFragment();
        fragment.setArguments(BundleHelper.builder().put("type", RepositoriesType.TRACE).build());
        return fragment;
    }

    public static RepositoriesFragment createForBookmark(){
        RepositoriesFragment fragment = new RepositoriesFragment();
        fragment.setArguments(BundleHelper.builder().put("type", RepositoriesType.BOOKMARK).build());
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    protected void onLoadData() {
//        LiveData<Resource<List<Event>>> events =  mainViewModel.loadUserReceivedEvent(globalInfo.getCurrentUserAccount().getName(), 1);
//        events.observe(this, eventsResource -> {
//            if (eventsResource == null || eventsResource.data == null) {
//                return;
//            }
//
//            showEvents(eventsResource.data);
//            hideLoading();
//        });
    }

    public void showRepositories(ArrayList<Repository> repositoryList) {
        adapter.setData(repositoryList);
        postNotifyDataSetChanged();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }


    @Override
    protected void initFragment(Bundle savedInstanceState){
        super.initFragment(savedInstanceState);
//        setLoadMoreEnable(!RepositoriesType.COLLECTION.equals(mPresenter.getType()));
    }

    @Override
    protected void onReLoadData() {
//        mPresenter.loadRepositories(true, 1);
    }

    @Override
    protected String getEmptyTip() {
//        if(RepositoriesType.TRENDING.equals(mPresenter.getType())){
//            return String.format(getString(R.string.no_trending_repos), mPresenter.getLanguage().getName());
//        }
        return getString(R.string.no_repository);
    }

    @Override
    public void onItemClick(int position, @NonNull View view) {
        super.onItemClick(position, view);
//        if(RepositoriesType.TRENDING.equals(mPresenter.getType())
//                || RepositoriesType.TRACE.equals(mPresenter.getType())
//                || RepositoriesType.BOOKMARK.equals(mPresenter.getType())
//                || RepositoriesType.COLLECTION.equals(mPresenter.getType())){
//            RepositoryActivity.show(getActivity(), adapter.getData().get(position).getOwner().getLogin(),
//                    adapter.getData().get(position).getName());
//        } else {
//            RepositoryActivity.show(getActivity(), adapter.getData().get(position));
//        }
    }

    @Override
    protected void onLoadMore(int page) {
        super.onLoadMore(page);
//        mPresenter.loadRepositories(false, page);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
//        if(mPresenter.getType().equals(RepositoriesType.OWNED)){
//            inflater.inflate(R.menu.menu_owned_repo, menu);
//            if(!mPresenter.getUser().equals(AppData.INSTANCE.getLoggedUser().getLogin())){
//                menu.findItem(R.id.action_filter_public).setVisible(false);
//                menu.findItem(R.id.action_filter_private).setVisible(false);
//            }
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentShowed() {
        super.onFragmentShowed();
//        if(mPresenter != null) mPresenter.prepareLoadData();
    }

}
