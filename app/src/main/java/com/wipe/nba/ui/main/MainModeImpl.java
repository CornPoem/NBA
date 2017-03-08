package com.wipe.nba.ui.main;

import android.util.Log;

import com.wipe.nba.beans.GameResultBean;
import com.wipe.nba.http.FailAction;
import com.wipe.nba.utils.Logutil;
import com.wipe.nba.utils.ThreadSwitch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import rx.functions.Action1;

/**
 * Created by Administrator on 2017/1/22.
 */
public class MainModeImpl implements Contract.MainMode {
    public String TAG=this.getClass().getSimpleName();

    @Override
    public void getData(final Contract.CallBack listener) {
        mApi.getGameResult()
                .compose(new ThreadSwitch())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e("MainActivity", s);
                        try {
                            JSONObject obj1 = new JSONObject(s);
                            String retCode = obj1.getString("error_code");
                            String msg = obj1.getString("reason");
                            if (!"0".equals(retCode)) {
                                listener.falied(msg);
                            }
                            ArrayList data=new ArrayList();
                            JSONObject obj2=obj1.getJSONObject("result");
                            JSONObject obj3=obj2.getJSONObject("statuslist");
                            String[] statusText=new String[3];
                            for (int i = 0; i < 3; i++) {
                                statusText[i]=obj3.getString("st"+i);
                            }
                            JSONArray jsonArray=obj2.getJSONArray("list");
                            for (int i = 0; i < jsonArray.length()-1; i++) {
                                JSONObject obj4=jsonArray.getJSONObject(i);
                                String date=obj4.getString("title");
                                JSONArray jsonArray1=obj4.getJSONArray("tr");
                                GameResultBean bean=null;
                                for (int x = 0; x < jsonArray1.length(); x++) {
                                    JSONObject obj5=jsonArray1.getJSONObject(x);
                                    String p1=obj5.getString("player1");
                                    String l1=obj5.getString("player1logobig");
                                    String p2=obj5.getString("player2");
                                    String l2=obj5.getString("player2logobig");
                                    String score=obj5.getString("score");
                                    int status=obj5.getInt("status");
                                    Logutil.e(TAG,"score:"+score);
                                    bean=new GameResultBean(statusText,score,p1,p2,l1,l2,status);
                                    data.add(bean);
                                }

                            }

                            listener.sucess(data);

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }finally {
                            Logutil.e(TAG,"finally 执行！");
                            listener.falied("刷新结束！");
                        }
                    }
                }, new FailAction());
    }
}
