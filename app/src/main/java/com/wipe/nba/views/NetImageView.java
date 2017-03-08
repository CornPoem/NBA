package com.wipe.nba.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.wipe.nba.api.ImageUrl;
import com.wipe.nba.utils.ThreadSwitch;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/2/2.
 */
public class NetImageView {
    private ImageView mImageview;
    private ImageUrl api;


    public NetImageView(ImageView view) {
        mImageview = view;
        initOptions();
    }

    private void initOptions() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://www.baidu.com")
                .build();
        api = mRetrofit.create(ImageUrl.class);

    }

    public void displayImage(String url) {
        Log.e("ggggggg","fafafafaff");
        api.getImgStream(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody response) {
                        InputStream is = response.byteStream();
                        Log.e("stream","tttttt:"+is.toString());
                        if (mImageview != null) {
                            Bitmap bitmap = BitmapFactory.decodeStream(is);
                            Log.e("stream","bitmap.size:"+bitmap.getByteCount());
                            mImageview.setImageBitmap(bitmap);
                        }
                    }
                });
    }

}
