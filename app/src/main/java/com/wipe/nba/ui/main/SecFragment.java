package com.wipe.nba.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wipe.nba.R;

import java.util.List;

/**
 * Created by Administrator on 2017/2/9.
 */
public class SecFragment extends Fragment implements Contract.MainView, SwipeRefreshLayout.OnRefreshListener {
    private Context mContext;

    private ListView mListView;
    private ListViewAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        mContext=getActivity();
        View view =inflater.inflate(R.layout.item_viewpager_main_acitivity,null);
        mListView = (ListView)view.findViewById(R.id.lv_main);
        mAdapter = new ListViewAdapter(mContext,null);
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
    public void onRefresh() {

    }
}
