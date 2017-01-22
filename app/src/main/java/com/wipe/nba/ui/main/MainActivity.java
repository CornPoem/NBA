package com.wipe.nba.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wipe.nba.R;
import com.wipe.nba.base.BaseActivity;


public class MainActivity extends BaseActivity implements Contract.MainView {

    private TextView tv;
    private MainPresenteImpl mPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getData();
                mPresent.getData();
            }
        });

        MainModeImpl mMode = new MainModeImpl();
        mPresent = new MainPresenteImpl();
        mPresent.setMV(mMode, this);
    }

//    @Override
//    public void getData() {
//        mPresent.getData();
//    }

    @Override
    public void updateData(String s) {
        tv.setText(s);
    }

//    private void getData() {
//        mApi.getGameResult(ApiService.KEY)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.e("MainActivity", s);
//                        tv.setText(s);
//                    }
//                });
//
//    }
}
