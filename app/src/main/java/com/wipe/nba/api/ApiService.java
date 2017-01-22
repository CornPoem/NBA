package com.wipe.nba.api;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/21.
 */
public interface ApiService {
    String URL = "http://op.juhe.cn/onebox/basketball/";
    String KEY = "5db2392656806115177d2449c1222fb0";


    @POST("nba")
    Observable<String> getGameResult();

    @FormUrlEncoded
    @POST("team")
    Observable<String> getTeam( @Field("team") String team);

    @FormUrlEncoded
    @POST("combat")
    Observable<String> getCombat( @Field("hteam") String hteam, @Field("vteam") String vteam);

}
