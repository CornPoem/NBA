package com.wipe.nba.api;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/21.
 */
public interface ApiService {
    String URL="http://op.juhe.cn/onebox/basketball/";
    String KEY="5db2392656806115177d2449c1222fb0";

    @FormUrlEncoded
    @POST("nba")
    Observable<String> getGameResult(@Field("key")String key);

}
