package com.laoning.githubaio.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.laoning.githubaio.R;
import com.laoning.githubaio.ui.adapter.BaseAdapter;
import com.laoning.githubaio.ui.adapter.BaseViewHolder;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by laoning on 06/02/2018.
 */

public abstract  class ListFragment<A extends BaseAdapter> extends BaseFragment implements BaseViewHolder.OnItemClickListener, BaseViewHolder.OnItemLongClickListener, SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.refresh_layout) protected SwipeRefreshLayout refreshLayout;
    @BindView(R.id.recycler_view) protected RecyclerView recyclerView;
    @Inject
    protected A adapter;
    private RecyclerView.AdapterDataObserver observer;

    @BindView(R.id.lay_tip)
    LinearLayout layTip;
    @BindView(R.id.tv_tip)
    TextView tvTip;
    @BindView(R.id.error_image)
    AppCompatImageView errorImage;

    private int curPage = 1;

    private boolean refreshEnable = true;
    private boolean loadMoreEnable = false;
    private boolean canLoadMore = false;
    private boolean autoJudgeCanLoadMoreEnable = true;
    private boolean isLoading = false;
    private final int DEFAULT_PAGE_SIZE = 30;
}
