package com.laoning.githubaio.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.laoning.githubaio.base.PrefUtils;
import com.laoning.githubaio.base.StringUtils;
import com.laoning.githubaio.repository.NotificationRepository;
import com.laoning.githubaio.repository.SearchRepository;
import com.laoning.githubaio.repository.entity.SearchModel;
import com.laoning.githubaio.repository.entity.notification.Notification;
import com.laoning.githubaio.repository.entity.repository.Repository;
import com.laoning.githubaio.repository.entity.user.User;
import com.laoning.githubaio.repository.remote.base.Resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by laoni on 2018-2-5.
 */

public class SearchViewModel extends ViewModel {

    ArrayList<SearchModel> searchModels;

    @Inject
    SearchRepository searchRepository;

    @Inject
    public SearchViewModel() {
        createSearchModels();
    }

    public LiveData<Resource<List<Repository>>> searchRepos(String query, String sort, String order, int page) {
        return searchRepository.searchRepos(query, sort, order, page);
    }

    public LiveData<Resource<List<User>>> searchUsers(String query, String sort, String order, int page) {
        return searchRepository.searchUsers(query, sort, order, page);
    }

    private void createSearchModels() {
        searchModels = new ArrayList<>();
        searchModels.add(new SearchModel(SearchModel.SearchType.Repository));
        searchModels.add(new SearchModel(SearchModel.SearchType.User));
    }

    public ArrayList<SearchModel> getSearchModels() {
        return searchModels;
    }

    public ArrayList<SearchModel> getQueryModels(@NonNull String query) {
        for (SearchModel searchModel : searchModels) {
            searchModel.setQuery(query);
        }
        return searchModels;
    }

    public SearchModel getSortModel(int page, int sortId) {
        return searchModels.get(page).setSortId(sortId);
    }

    @NonNull
    public ArrayList<String> getSearchRecordList() {
        String records = PrefUtils.getSearchRecords();
        ArrayList<String> recordList = new ArrayList<>();
        if (!StringUtils.isBlank(records)) {
            String[] recordArray = records.split("\\$\\$");
            Collections.addAll(recordList, recordArray);
        }
        return recordList;
    }

    public void addSearchRecord(@NonNull String record) {
        if(record.contains("$")){
            return;
        }
        int MAX_SEARCH_RECORD_SIZE = 30;
        ArrayList<String> recordList = getSearchRecordList();
        if(recordList.contains(record)){
            recordList.remove(record);
        }
        if(recordList.size() >= MAX_SEARCH_RECORD_SIZE){
            recordList.remove(recordList.size() - 1);
        }
        recordList.add(0, record);
        StringBuilder recordStr = new StringBuilder("");
        String lastRecord = recordList.get(recordList.size() - 1);
        for(String str : recordList){
            recordStr.append(str);
            if(!str.equals(lastRecord)){
                recordStr.append("$$");
            }
        }
        PrefUtils.set(PrefUtils.SEARCH_RECORDS, recordStr.toString());
    }
}
