package com.laoning.githubaio.ui.fragment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import com.laoning.githubaio.R;
import com.laoning.githubaio.base.GlobalInfo;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.repository.remote.base.Resource;
import com.laoning.githubaio.ui.adapter.EventAdapter;
import com.laoning.githubaio.viewmodel.MainViewModel;

import java.util.List;

import javax.inject.Inject;


public class EventFragment extends ListFragment<EventAdapter> {

    private MainViewModel mainViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    GlobalInfo globalInfo;



    public enum ActivityType {
        News, User, Repository, PublicNews
    }

    public static EventFragment create() {
        EventFragment fragment = new EventFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        adapter = new EventAdapter(getActivity(), this);
        super.initFragment(savedInstanceState);

        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);

        setLoadMoreEnable(true);
        registerForContextMenu(recyclerView);

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
        return getString(R.string.no_activity);
    }

    @Override
    public void onItemClick(int position, @NonNull View view) {

    }

    @Override
    public boolean onItemLongClick(int position, @NonNull View view) {
        return super.onItemLongClick(position, view);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getIntent() != null) {
            startActivity(item.getIntent());
        }
        return true;
    }

    @Override
    protected void onLoadMore() {
        super.onLoadMore();
        LoadPage();
    }

    private void LoadPage() {
        LiveData<Resource<List<Event>>> events =  mainViewModel.loadUserReceivedEvent(globalInfo.getCurrentUserAccount().getName(), getCurPage());
        events.observe(this, eventsResource -> {
            if (eventsResource == null || eventsResource.data == null) {
                return;
            }

            showEvents(eventsResource.data);
            hideLoading();
        });
    }

    public void showEvents(List<Event> events) {
        adapter.setData(events);
        postNotifyDataSetChanged();
    }
}
