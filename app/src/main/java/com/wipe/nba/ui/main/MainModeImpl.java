package com.wipe.nba.ui.main;

import android.util.Log;

import com.wipe.nba.api.ApiService;
import com.wipe.nba.utils.ThreadSwitch;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/1/22.
 */
public class MainModeImpl implements Contract.MainMode {

    @Override
    public void getData(final Contract.CallBack listener) {
        mApi.getGameResult()
                .compose(new ThreadSwitch())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e("MainActivity", s);
                        listener.sucess(s);
                    }
                });
    }
}
