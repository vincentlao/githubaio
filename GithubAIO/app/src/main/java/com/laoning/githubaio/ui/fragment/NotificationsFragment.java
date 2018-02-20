package com.laoning.githubaio.ui.fragment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.laoning.githubaio.R;
import com.laoning.githubaio.base.BundleHelper;
import com.laoning.githubaio.base.GlobalInfo;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.entity.notification.Notification;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.repository.remote.base.Resource;
import com.laoning.githubaio.ui.adapter.EventAdapter;
import com.laoning.githubaio.ui.adapter.NotificationsAdapter;
import com.laoning.githubaio.ui.adapter.base.DoubleTypesModel;
import com.laoning.githubaio.viewmodel.MainViewModel;
import com.laoning.githubaio.viewmodel.NotificationViewModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by laoni on 2018-2-20.
 */


public class NotificationsFragment extends ListFragment<NotificationsAdapter> implements NotificationsAdapter.NotificationAdapterListener {

    public enum NotificationsType{
        Unread, Participating, All
    }

    private NotificationViewModel notificationViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    GlobalInfo globalInfo;

    public static Fragment create(NotificationsType type){
        NotificationsFragment fragment = new NotificationsFragment();
        fragment.setArguments(BundleHelper.builder().put("type", type).build());
        return fragment;
    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {

        adapter = new NotificationsAdapter(getActivity(), this);


        super.initFragment(savedInstanceState);

        notificationViewModel = ViewModelProviders.of(this, viewModelFactory).get(NotificationViewModel.class);

        setLoadMoreEnable(true);
//        setHasOptionsMenu(NotificationsType.Unread.equals(mPresenter.getType()));
        adapter.setListener(this);

        loadNotification();
    }

    public void showNotifications(ArrayList<DoubleTypesModel<Repository, Notification>> notifications) {
        adapter.setData(notifications);
        postNotifyDataSetChanged();
        getActivity().invalidateOptionsMenu();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void onLoadData() {
        loadNotification();
    }

    @Override
    protected void onReLoadData() {
        loadNotification();
    }

    @Override
    protected String getEmptyTip() {
        return getString(R.string.no_notifications_tip);
    }

    @Override
    public void onItemClick(int position, @NonNull View view) {
        super.onItemClick(position, view);
//        Notification notification = adapter.getData().get(position).getM2();
//        Repository repository = adapter.getData().get(position).getM1();
//        if(adapter.getItemViewType(position) == 0){
//            RepositoryActivity.show(getActivity(), repository.getOwner().getLogin(), repository.getName());
//        }else{
//            String url = notification.getSubject().getUrl();
//            switch (notification.getSubject().getType()){
//                case Issue:
//                    IssueDetailActivity.show(getActivity(), url);
//                    break;
//                case Commit:
//                    CommitDetailActivity.show(getActivity(), url);
//                    break;
//                case PullRequest:
//                    showInfoToast(getString(R.string.developing));
//                    break;
//            }
//
//            if(notification.isUnread() &&
//                    !notification.getSubject().getType().equals(NotificationSubject.Type.PullRequest)){
//                mPresenter.markNotificationAsRead(notification.getId());
//                notification.setUnread(false);
//                adapter.notifyItemChanged(position);
//                getActivity().invalidateOptionsMenu();
//            }
//
//        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
//        if(!mPresenter.isNotificationsAllRead()){
//            inflater.inflate(R.menu.menu_notifications, menu);
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId() == R.id.action_mark_all_as_read){
//            mPresenter.markAllNotificationsAsRead();
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRepoMarkAsReadClicked(@NonNull Repository repository) {
//        mPresenter.markRepoNotificationsAsRead(repository);
    }


    private void loadNotification() {
        LiveData<Resource<List<Notification>>> notifications =  notificationViewModel.loadMyNotifications(true, false);
        notifications.observe(this, notificaitonsResource -> {
            if (notificaitonsResource == null || notificaitonsResource.data == null) {
                return;
            }

            showNotifications(notificaitonsResource.data);
            hideLoading();
        });
    }

    public void showNotifications(List<Notification> notifications) {
        List<DoubleTypesModel<Repository, Notification>> sortedNotification = sortNotifications(notifications);
        adapter.setData(sortedNotification);
        postNotifyDataSetChanged();
    }


    private List<DoubleTypesModel<Repository, Notification>> sortNotifications(List<Notification> notifications) {

        ArrayList<DoubleTypesModel<Repository, Notification>> sortedList = new ArrayList<>();
        Map<String, ArrayList<Notification>> sortedMap = new LinkedHashMap<>();
        for (Notification notification : notifications) {
            ArrayList<Notification> list = sortedMap.get(notification.getRepository().getFullName());
            if (list == null) {
                list = new ArrayList<>();
                sortedMap.put(notification.getRepository().getFullName(), list);
            }
            list.add(notification);
        }

        Iterator<String> iterator = sortedMap.keySet().iterator();
        for (; iterator.hasNext(); ) {
            String key = iterator.next();
            ArrayList<Notification> list = sortedMap.get(key);
            sortedList.add(new DoubleTypesModel<Repository, Notification>(list.get(0).getRepository(), null));
            for(Notification notification : list){
                sortedList.add(new DoubleTypesModel<Repository, Notification>(null, notification));
            }
        }
        return sortedList;
    }
}
