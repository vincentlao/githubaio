package com.laoning.githubaio.ui.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.laoning.githubaio.ui.activity.LoginActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by laoning on 06/02/2018.
 */

public abstract class BaseFragment extends Fragment {
    private final String TAG = BaseFragment.class.getSimpleName();

    @Inject
    ProgressDialog mProgressDialog;
    Unbinder unbinder;

    /**
     * fragment for viewpager
     */
    private boolean isPagerFragment = false;
    private boolean isFragmentShowed = false;

    public BaseFragment() {

    }

    @LayoutRes
    protected abstract int getLayoutId();


    protected abstract void initFragment(Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //some page contain WebView will make default language changed
        View fragmentView = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        initFragment(savedInstanceState);
        return fragmentView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.with(this).onLowMemory();
    }

    public void onFragmentShowed() {
        isFragmentShowed = true;
    }

    public void onFragmentHided() {
        isFragmentShowed = false;
    }

    public boolean isPagerFragment() {
        return isPagerFragment;
    }

    public BaseFragment setPagerFragment(boolean flag) {
        isPagerFragment = flag;
        return this;
    }

    public boolean isFragmentShowed() {
        return isFragmentShowed;
    }


    public void scrollToTop() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
