package com.wipe.nba.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wipe.nba.R;

import java.util.List;

/**
 * Created by Administrator on 2017/2/9.
 */
public class FirstFragment extends Fragment implements Contract.MainView, View.OnTouchListener {
    private Context mContext;

    private ListView mListView;
    private ListViewAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        View view = inflater.inflate(R.layout.item_viewpager_main_acitivity, null);
        mListView = (ListView) view.findViewById(R.id.lv_main);
        mListView.setOnTouchListener(this);
        mAdapter = new ListViewAdapter(mContext, null);
        mListView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void updateData(List data) {
        mAdapter.notifyDataSetChanged(data);
    }

    @Override
    public void updateDataFail(String msg) {
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        float mLastY = 0;
        if (action == MotionEvent.ACTION_DOWN) {
            // 记录点击到ViewPager时候，手指的X坐标
            mLastY = event.getY();
        }
        if (action == MotionEvent.ACTION_MOVE) {
            // 超过阈值
            int top = mListView.getChildAt(0).getTop();
            float nowY = event.getY();
            if (top != 0 ) {
                ((MainActivity) mContext).mRefreshLayout.setEnabled(false);
//                mScrollView.requestDisallowInterceptTouchEvent(true);
            } else {

                ((MainActivity) mContext).mRefreshLayout.setEnabled(true);

            }
        }
        return false;
    }
}
