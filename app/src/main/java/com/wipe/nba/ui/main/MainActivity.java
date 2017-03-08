package com.wipe.nba.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import com.wipe.nba.R;
import com.wipe.nba.base.BaseActivity;
import com.wipe.nba.ui.review.GameReviewActivity;

import java.util.List;


public class MainActivity extends BaseActivity implements Contract.MainView, SwipeRefreshLayout.OnRefreshListener, View.OnTouchListener {

    private ViewPager mPager;
    private MainPresenteImpl mPresent;
    public SwipeRefreshLayout mRefreshLayout;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPager = (ViewPager) findViewById(R.id.vp);
        fm = getSupportFragmentManager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(fm);
        mPager.setAdapter(adapter);
        mPager.setOnTouchListener(this);
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl_refresh);
        mRefreshLayout.setOnRefreshListener(this);
        mPresent = new MainPresenteImpl(this);

    }


    @Override
    public void updateData(List data) {
        List<Fragment> fragments = fm.getFragments();
        for (Fragment fragment : fragments) {
            ((Contract.MainView) fragment).updateData(data);
        }
    }

    @Override
    public void onRefresh() {
        mPresent.getData();
    }

    @Override
    public void updateDataFail(String msg) {
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        float mLastX = 0;
        if (action == MotionEvent.ACTION_DOWN) {
            // 记录点击到ViewPager时候，手指的X坐标
            mLastX = event.getX();
        }
        if (action == MotionEvent.ACTION_MOVE) {
            // 超过阈值
            if (Math.abs(event.getX() - mLastX) > 60f) {
                mRefreshLayout.setEnabled(false);
//                mScrollView.requestDisallowInterceptTouchEvent(true);
            }
        }
        if (action == MotionEvent.ACTION_UP) {
            // 用户抬起手指，恢复父布局状态
//            mScrollView.requestDisallowInterceptTouchEvent(false);
            mRefreshLayout.setEnabled(true);
        }
        return false;
    }
}
