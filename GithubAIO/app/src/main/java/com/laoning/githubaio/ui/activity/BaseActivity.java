package com.laoning.githubaio.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.laoning.githubaio.R;

/**
 * Created by laoning on 01/02/2018.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void delayFinish() {
        delayFinish(1000);
    }

    protected void delayFinish(int mills) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, mills);
    }
}
