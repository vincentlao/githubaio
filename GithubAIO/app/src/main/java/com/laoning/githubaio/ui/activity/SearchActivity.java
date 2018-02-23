package com.laoning.githubaio.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.laoning.githubaio.R;
import com.laoning.githubaio.base.StringUtils;
import com.laoning.githubaio.base.ViewUtils;
import com.laoning.githubaio.repository.entity.SearchModel;
import com.laoning.githubaio.ui.adapter.FragmentPagerModel;
import com.laoning.githubaio.ui.fragment.RepositoriesFragment;
import com.laoning.githubaio.ui.fragment.UserListFragment;
import com.laoning.githubaio.viewmodel.NotificationViewModel;
import com.laoning.githubaio.viewmodel.SearchViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by laoni on 2018-2-20.
 */

public class SearchActivity extends PagerActivity implements MenuItemCompat.OnActionExpandListener, SearchView.OnQueryTextListener {

    public static void show(@NonNull Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        context.startActivity(intent);
    }

    private final Map<Integer, List<Integer>> MENU_ID_MAP = new HashMap<>();

    boolean isInputMode = true;
    String[] sortInfos;

    private SearchViewModel searchViewModel;

    public void SearchActivity() {
        MENU_ID_MAP.put(0, SearchModel.REPO_SORT_ID_LIST);
        MENU_ID_MAP.put(1, SearchModel.USER_SORT_ID_LIST);
    }


    @Nullable
    @Override
    protected int getContentView() {
        return R.layout.activity_view_pager;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        searchViewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel.class);

        setToolbarScrollAble(true);
        setToolbarBackEnable();
        setToolbarTitle(getString(R.string.search));
        if(sortInfos == null) {
            sortInfos = new String[]{
                    getString(R.string.best_match), getString(R.string.best_match)
            };
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        searchView.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
//        searchView.setQuery(mPresenter.getSearchModels().get(0).getQuery(), false);
        if (isInputMode) {
            MenuItemCompat.expandActionView(searchItem);
        } else {
            MenuItemCompat.collapseActionView(searchItem);
        }
        MenuItemCompat.setOnActionExpandListener(searchItem, this);

        AutoCompleteTextView autoCompleteTextView = searchView
                .findViewById(android.support.v7.appcompat.R.id.search_src_text);
        autoCompleteTextView.setThreshold(0);
//        autoCompleteTextView.setAdapter(new ArrayAdapter<>(this, R.layout.layout_item_simple_list, mPresenter.getSearchRecordList()));
        autoCompleteTextView.setDropDownBackgroundDrawable(new ColorDrawable(ViewUtils.getWindowBackground(this)));
        autoCompleteTextView.setOnItemClickListener((parent, view, position, id) -> {
            onQueryTextSubmit(parent.getAdapter().getItem(position).toString());
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_sort) {
            filterSortMenu(item);
        } else if (SearchModel.SORT_ID_LIST.contains(item.getItemId())) {
            int page = viewPager.getCurrentItem();
//            postSearchEvent(mPresenter.getSortModel(page, item.getItemId()));
            sortInfos[page] = item.getTitle().toString();
            setSubTitle(page);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (isInputMode) {
            menu.findItem(R.id.action_info).setVisible(false);
            menu.findItem(R.id.action_sort).setVisible(false);
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
//            searchView.setQuery(mPresenter.getSearchModels().get(0).getQuery(), false);
        } else {
            menu.findItem(R.id.action_info).setVisible(false);
            menu.findItem(R.id.action_sort).setVisible(pagerAdapter.getCount() != 0);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        isInputMode = true;
        invalidateOptionsMenu();
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        isInputMode = false;
        invalidateOptionsMenu();
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if (StringUtils.isBlank(query)) {
//            showWarningToast(getString(R.string.invalid_query));
            return true;
        }
        isInputMode = false;
        invalidateOptionsMenu();
        search(query);
        setSubTitle(viewPager.getCurrentItem());
//        mPresenter.addSearchRecord(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    private void filterSortMenu(MenuItem item) {
        int index = viewPager.getCurrentItem();
        List<Integer> idList = MENU_ID_MAP.get(index);
        for (Integer id : SearchModel.SORT_ID_LIST) {
            item.getSubMenu().findItem(id).setVisible(idList.contains(id));
        }
    }

    private void search(String query) {
        if (pagerAdapter.getCount() == 0) {
            pagerAdapter.setPagerList(FragmentPagerModel.createSearchPagerList(this, searchViewModel.getQueryModels(query), getFragments()));
            tabLayout.setVisibility(View.VISIBLE);
            tabLayout.setupWithViewPager(viewPager);
            viewPager.setAdapter(pagerAdapter);
            showFirstPager();
        } else {
//            for (SearchModel searchModel : mPresenter.getQueryModels(query)) {
//                postSearchEvent(searchModel);
//            }
        }
    }

//    private void postSearchEvent(SearchModel searchModel) {
//        AppEventBus.INSTANCE.getEventBus().post(new Event.SearchEvent(searchModel));
//    }

    private void setSubTitle(int page) {
//        setToolbarSubTitle(mPresenter.getSearchModels().get(0).getQuery() + "/" + sortInfos[page]);
    }

    @Override
    public void onPageSelected(int position) {
        super.onPageSelected(position);
        setSubTitle(position);
    }

    @Override
    public int getPagerSize() {
        return 2;
    }

    public void showSearches(ArrayList<SearchModel> searchModels) {
        search(searchModels.get(0).getQuery());
        setSubTitle(0);
    }

    @Override
    protected int getFragmentPosition(Fragment fragment) {
        if(fragment instanceof RepositoriesFragment){
            return 0;
        }else if(fragment instanceof UserListFragment){
            return 1;
        }else
            return -1;
    }

}