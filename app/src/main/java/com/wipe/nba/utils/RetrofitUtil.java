package com.wipe.nba.utils;

import com.wipe.nba.api.ApiService;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
                    //自定义网络请求服务端
                    OkHttpClient mClient = new OkHttpClient.Builder()
                            .addInterceptor(new Interceptor() {
                                @Override
                                public Response intercept(Chain chain) throws IOException {
                                    Request request = chain.request();
                                    HttpUrl originUrl = request.url();
                                    HttpUrl newUrl = originUrl.newBuilder().addQueryParameter("key", ApiService.KEY).build();
                                    Request newRequest = request.newBuilder().url(newUrl).build();
                                    return chain.proceed(newRequest);
                                }
                            })
                            .build();
                    //构造retrofit工厂
                    if (mRetrofit == null) {
                        mRetrofit = new Retrofit.Builder()
                                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                .addConverterFactory(ScalarsConverterFactory.create())
                                .client(mClient)
                                .baseUrl(ApiService.URL).build();
                    }
                }
            }
            mApiService = mRetrofit.create(ApiService.class);
        }
        return mApiService;
    }


}
