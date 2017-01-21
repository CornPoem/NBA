package com.wipe.nba.utils;

import com.wipe.nba.api.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2017/1/21.
 */
public class RetrofitUtil {
    private static Retrofit mRetrofit = null;
    private static ApiService mApiService;

    private RetrofitUtil() {
    }

//    public static Retrofit getRetrofit() {
//
//
//        return mRetrofit;
//    }

    public synchronized static ApiService getApi() {
        mApiService = null;
        if (mApiService == null) {
            if (mRetrofit == null) {
                synchronized (RetrofitUtil.class) {
                    if (mRetrofit == null) {
                        mRetrofit = new Retrofit.Builder()
                                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                .addConverterFactory(ScalarsConverterFactory.create())
                                .baseUrl(ApiService.URL).build();
                    }
                }
            }
            mApiService = mRetrofit.create(ApiService.class);
        }
        return mApiService;
    }
}
