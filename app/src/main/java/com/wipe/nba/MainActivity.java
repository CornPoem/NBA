package com.wipe.nba;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wipe.nba.api.ApiService;
import com.wipe.nba.base.BaseActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class MainActivity extends BaseActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });

    }

    private void getData() {
        mApi.getGameResult(ApiService.KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e("MainActivity", s);
                        tv.setText(s);
                    }
                });

    }
}
