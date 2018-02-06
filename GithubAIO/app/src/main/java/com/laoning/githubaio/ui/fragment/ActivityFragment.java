package com.laoning.githubaio.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.laoning.githubaio.R;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.ui.adapter.ActivityAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ActivityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ActivityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivityFragment extends ListFragment<ActivityAdapter> {

    public enum ActivityType {
        News, User, Repository, PublicNews
    }

    public static ActivityFragment create() {
        ActivityFragment fragment = new ActivityFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        super.initFragment(savedInstanceState);
        setLoadMoreEnable(true);
        registerForContextMenu(recyclerView);
    }

    @Override
    protected void onReLoadData() {
//        mPresenter.loadEvents(true, 1);
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
    protected void onLoadMore(int page) {
        super.onLoadMore(page);
//        mPresenter.loadEvents(false, page);
    }

    public void showEvents(ArrayList<Event> events) {
        adapter.setData(events);
        postNotifyDataSetChanged();
//        if(getCurPage() == 2 && PrefUtils.isActivityLongClickTipAble()){
//            showOperationTip(R.string.activity_click_tip);
//            PrefUtils.set(PrefUtils.ACTIVITY_LONG_CLICK_TIP_ABLE, false);
//        }
    }

    @Override
    public void onFragmentShowed() {
        super.onFragmentShowed();
//        if (mPresenter != null) mPresenter.prepareLoadData();
    }

}
