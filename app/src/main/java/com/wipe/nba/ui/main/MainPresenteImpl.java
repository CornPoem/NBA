package com.wipe.nba.ui.main;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class MainPresenteImpl extends Contract.MainPresent implements Contract.CallBack {
    private Contract.MainMode mMode;
    private Contract.MainView mView;

    public MainPresenteImpl(Contract.MainView mView) {
        this.mView = mView;
        mMode=new MainModeImpl();
    }

    @Override
    public void getData() {
        mMode.getData(this);
    }

//    @Override
//    public void updateData(String s) {
//        mView.updateData(s);
//    }


    @Override
    public void sucess(List data) {
        mView.updateData(data);
    }

    @Override
    public void falied(String s) {
            mView.updateDataFail(s);
    }
}
