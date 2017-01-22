package com.wipe.nba.ui.main;

import com.wipe.nba.base.BaseMode;
import com.wipe.nba.base.BasePresent;
import com.wipe.nba.base.BaseView;

/**
 * Created by Administrator on 2017/1/22.
 */
public interface Contract {
    interface MainView extends BaseView {
//        void getData();

        void updateData(String s);
    }

    interface MainMode extends BaseMode {
        void getData(CallBack listener);
//        void updateData(String s);
    }

    abstract class MainPresent extends BasePresent {
        public abstract void getData();

//        public abstract void updateData(String s);

        public abstract void setMV(MainMode m, MainView v);

    }

    interface CallBack{
        void sucess(String s);
        void falied(String s);
    }
}
