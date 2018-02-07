package com.laoning.githubaio.repository.entity.search;

import java.util.List;

/**
 * Created by laoning on 07/02/2018.
 */

public class SearchResult<T> {

    private String totalCount;
    private boolean incompleteResults;
    private List<T> items;

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
