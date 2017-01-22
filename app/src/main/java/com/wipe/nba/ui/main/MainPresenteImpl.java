package com.wipe.nba.ui.main;

/**
 * Created by Administrator on 2017/1/22.
 */
public class MainPresenteImpl extends Contract.MainPresent implements Contract.CallBack {
    private Contract.MainMode mMode;
    private Contract.MainView mView;

    @Override
    public void getData() {
        mMode.getData(this);
    }

//    @Override
//    public void updateData(String s) {
//        mView.updateData(s);
//    }

    @Override
    public void setMV(Contract.MainMode m, Contract.MainView v) {
        mMode = m;
        mView = v;
    }

    @Override
    public void sucess(String s) {
        mView.updateData(s);
    }

    @Override
    public void falied(String s) {

    }
}
