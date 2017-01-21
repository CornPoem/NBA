package com.wipe.nba.base;

import android.support.v7.app.AppCompatActivity;

import com.wipe.nba.api.ApiService;
import com.wipe.nba.utils.RetrofitUtil;

/**
 * Created by Administrator on 2017/1/21.
 */
public class BaseActivity extends AppCompatActivity {
    protected ApiService mApi= RetrofitUtil.getApi();
}
