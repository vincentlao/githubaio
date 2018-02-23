package com.laoning.githubaio.ui.fragment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
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
import com.laoning.githubaio.base.GlobalInfo;
import com.laoning.githubaio.repository.entity.SearchModel;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.repository.remote.base.Resource;
import com.laoning.githubaio.ui.adapter.EventAdapter;
import com.laoning.githubaio.ui.adapter.RepositoriesAdapter;
import com.laoning.githubaio.viewmodel.MainViewModel;
import com.laoning.githubaio.viewmodel.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by laoni on 2018-2-9.
 */


public class RepositoriesFragment extends ListFragment<RepositoriesAdapter>{
    private MainViewModel mainViewModel;
    private SearchViewModel searchViewModel;
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    GlobalInfo globalInfo;

    private RepositoriesType type;
    private String user;

    public enum RepositoriesType{
        OWNED, PUBLIC, STARRED, TRENDING, SEARCH, FORKS, TRACE, BOOKMARK, COLLECTION, TOPIC
    }

    public static RepositoriesFragment create(@NonNull RepositoriesType type, @NonNull String user){
        RepositoriesFragment fragment = new RepositoriesFragment();
        fragment.setArguments(BundleHelper.builder().put("type", type).put("user", user).build());
        return fragment;
    }

    public static RepositoriesFragment createForSearch(@NonNull SearchModel searchModel){
        RepositoriesFragment fragment = new RepositoriesFragment();
        fragment.setArguments(
                BundleHelper.builder()
                        .put("type", RepositoriesType.SEARCH)
                        .put("searchModel", searchModel)
                        .build()
        );
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

        Bundle bundle = getArguments();
        type =( RepositoriesType)bundle.get("type");
        user = bundle.getString("user");
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }


    @Override
    protected void initFragment(Bundle savedInstanceState){
        adapter = new RepositoriesAdapter(getActivity(), this);
        super.initFragment(savedInstanceState);
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        searchViewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel.class);

        setLoadMoreEnable(true);
        registerForContextMenu(recyclerView);

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
    protected void onLoadMore() {
        super.onLoadMore();
        LoadPage();
    }

    public void showRepositories(List<Repository> repositoryList) {
        adapter.setData(repositoryList);
        postNotifyDataSetChanged();
    }


    private void LoadPage() {
        LiveData<Resource<List<Repository>>> repos =  null;
        if (RepositoriesType.OWNED.equals(type)) {
            repos = mainViewModel.loadMyRepos(getCurPage(), "", "", "");
        } else if (RepositoriesType.STARRED.equals(type)) {
            repos = mainViewModel.loadStarredRepos(user, getCurPage(), "", "");
        } else if (RepositoriesType.SEARCH.equals(type)) {
            Bundle bundle = getArguments();
            SearchModel model = (SearchModel)bundle.get("searchModel");
            repos = searchViewModel.searchRepos(model.getQuery(), model.getSort(), model.getOrder(), getCurPage());
        }

        if (repos == null) {
            return;
        }

        repos.observe(this, reposResource -> {
            if (reposResource == null || reposResource.data == null) {
                return;
            }

            showRepositories(reposResource.data);
            hideLoading();
        });
    }



    @Override
    protected String getEmptyTip() {
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
}
