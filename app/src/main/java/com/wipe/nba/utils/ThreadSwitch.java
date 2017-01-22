package com.wipe.nba.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/1/22.
 */
public class ThreadSwitch implements Observable.Transformer<String, String> {
    @Override
    public Observable<String> call(Observable<String> stringObservable) {

        return stringObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
