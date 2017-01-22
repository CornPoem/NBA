package com.wipe.nba.base;

import com.wipe.nba.api.ApiService;
import com.wipe.nba.utils.RetrofitUtil;

/**
 * Created by Administrator on 2017/1/22.
 */
public interface BaseMode {
   ApiService mApi= RetrofitUtil.getApi();
}
