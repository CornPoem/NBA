package com.wipe.nba.api;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Administrator on 2017/2/2.
 */
public interface ImageUrl {
    @GET
    Observable<ResponseBody> getImgStream(@Url String url);
}
