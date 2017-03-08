package com.wipe.nba.ui.main;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wipe.nba.R;
import com.wipe.nba.base.MyBaseAdapter;
import com.wipe.nba.beans.GameResultBean;
import com.wipe.nba.ui.review.GameReviewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */
public class ListViewAdapter extends MyBaseAdapter {
    private Context mContext;
    private ArrayList data;
    private Picasso mPicasso;

    public ListViewAdapter(Context mContext, ArrayList data) {
        this.mContext = mContext;
        this.data = data;
        mPicasso = Picasso.with(mContext);
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = View.inflate(mContext, R.layout.item_main_activity, null);
        ImageView leftImg = (ImageView) getViewFromViewHolder(convertView, R.id.iv_left);
        ImageView rightImg = (ImageView) getViewFromViewHolder(convertView, R.id.iv_right);
        TextView leftText = (TextView) getViewFromViewHolder(convertView, R.id.tv_left);
        TextView rightText = (TextView) getViewFromViewHolder(convertView, R.id.tv_right);
        TextView leftResText = (TextView) getViewFromViewHolder(convertView, R.id.result_left);
        TextView rightRseText = (TextView) getViewFromViewHolder(convertView, R.id.result_right);
        TextView statusText = (TextView) getViewFromViewHolder(convertView, R.id.tv_game_status);
//        View btnView=getViewFromViewHolder(convertView,R.id.btn_review);
//        btnView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mContext.startActivity(new Intent(mContext, GameReviewActivity.class));
//
//            }
//        });
        GameResultBean bean = (GameResultBean) data.get(position);
        String score=bean.getScore();
        String[] scores = bean.getScore().split("-");
        statusText.setText(bean.getGameStatus()[bean.getStatus()]);
        mPicasso.load(bean.getTeamLogo1()).into(leftImg);
        mPicasso.load(bean.getTeamLogo2()).into(rightImg);
        Log.e(TAG, "score:" + score);
        leftResText.setText(scores[0]);
        rightRseText.setText(scores[1]);
        leftText.setText(bean.getTeamName1());
        rightText.setText(bean.getTeamName2());
        return convertView;
    }

    public void notifyDataSetChanged(List data) {
        this.data = (ArrayList) data;
        super.notifyDataSetChanged();
    }
}
