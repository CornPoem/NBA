package com.wipe.nba.base;

import android.util.SparseArray;
import android.view.View;
import android.widget.BaseAdapter;

/**
 * Created by Administrator on 2017/2/6.
 */
public abstract class MyBaseAdapter extends BaseAdapter {
    public final String  TAG=getClass().getSimpleName();

    protected View getViewFromViewHolder(View convertView, int id) {
        SparseArray viewHolder = (SparseArray) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray();
            convertView.setTag(viewHolder);
        }
        View childView = (View) viewHolder.get(id);
        if (childView == null) {
            childView = convertView.findViewById(id);
            viewHolder.put(id, childView);
        }
        return childView;
    }
}
