package com.wipe.nba.http;

import android.util.Log;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.functions.Action1;

/**
 * Created by Administrator on 2017/2/1.
 */
public class FailAction implements Action1<Throwable> {
    @Override
    public void call(Throwable throwable) {
        if (throwable instanceof IOException){
//            HttpException e= (HttpException) throwable;
//            int code=throwable.
            Log.e("FailAction","网络错误！");
        }else {

            String msg=throwable.getMessage();
            Throwable casuse=throwable.getCause();
            Log.e("throwable.getMessage()","msg:"+msg);
            Log.e("throwable.getCause()","casuse:"+casuse);
        }
    }
}
