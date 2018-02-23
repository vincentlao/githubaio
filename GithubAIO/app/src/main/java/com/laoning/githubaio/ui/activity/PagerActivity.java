

package com.laoning.githubaio.ui.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import com.laoning.githubaio.R;
import com.laoning.githubaio.ui.adapter.FragmentViewPagerAdapter;
import com.laoning.githubaio.ui.fragment.BaseFragment;

import java.util.ArrayList;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class PagerActivity extends BaseActivity implements ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener{

    protected FragmentViewPagerAdapter pagerAdapter;
    Unbinder unbinder;

    @BindView(R.id.view_pager) protected ViewPager viewPager;
    @BindView(R.id.tab_layout) protected TabLayout tabLayout;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.toolbar_layout) @Nullable CollapsingToolbarLayout toolbarLayout;

    private ArrayList<Fragment> fragments ;

    private int prePosition = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        unbinder = ButterKnife.bind(this);
        initView(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected void initView(Bundle savedInstanceState) {
        pagerAdapter =  new FragmentViewPagerAdapter(getSupportFragmentManager());
        viewPager.addOnPageChangeListener(this);
        tabLayout.addOnTabSelectedListener(this);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    @Deprecated
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Fragment fragment = pagerAdapter.getCurFragment();
        if(fragment != null
                && fragment instanceof IFragmentKeyListener
                && ((IFragmentKeyListener)fragment).onKeyDown(keyCode, event)){
            return true;
        }
        return onMainKeyDown(keyCode, event);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        scrollToTop();
    }

    private void scrollToTop(){
        Fragment fragment = pagerAdapter.getCurFragment();
        if(fragment != null && fragment instanceof BaseFragment){
            ((BaseFragment)fragment).scrollToTop();
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    protected abstract int getContentView();



    protected boolean onMainKeyDown(int keyCode, KeyEvent event){
        return super.onKeyDown(keyCode, event);
    }

    public interface IFragmentKeyListener {
        boolean onKeyDown(int keyCode, KeyEvent event);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(final int position) {
        postNotifyFragmentStatus(prePosition, false, 100);
        postNotifyFragmentStatus(position, true, 500);
        prePosition = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * Notify first pager selected, only for first launch
     */
    protected void showFirstPager(){
        prePosition = 0;
        postNotifyFragmentStatus(0, true, 100);

    }

    private void postNotifyFragmentStatus(final int position, final boolean isShow, long delay){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isShow){
                    pagerAdapter.getPagerList().get(position).getFragment().onFragmentShowed();
                }else{
                    pagerAdapter.getPagerList().get(position).getFragment().onFragmentHided();
                }
            }
        }, delay);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        int fragmentPosition = getFragmentPosition(fragment);
        if(fragmentPosition != -1) {
            getFragments().set(fragmentPosition, fragment);
        }
    }

    @NonNull
    public ArrayList<Fragment> getFragments() {
        if(fragments == null){
            fragments = new ArrayList<>();
            for(int i = 0; i < getPagerSize(); i++){
                fragments.add(null);
            }
        }
        return fragments;
    }

    public abstract int getPagerSize();

    protected abstract int getFragmentPosition(Fragment fragment);


    protected void setToolbarScrollAble(boolean scrollAble) {
        if(toolbar == null) return;
        int flags = scrollAble ? (AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
                | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP) : 0;
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        layoutParams.setScrollFlags(flags);
        toolbar.setLayoutParams(layoutParams);
    }

    protected void setTransparentStatusBar(){
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    protected void setToolbarBackEnable() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void setToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
        if(toolbarLayout != null){
            toolbarLayout.setTitle(title);
        }
    }

    protected void setToolbarTitle(String title, String subTitle) {
        setToolbarTitle(title);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setSubtitle(subTitle);
        }
    }

    protected void setToolbarSubTitle(String subTitle) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setSubtitle(subTitle);
        }
    }

}
