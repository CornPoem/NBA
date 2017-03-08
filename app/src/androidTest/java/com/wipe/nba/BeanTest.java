package com.wipe.nba;

import android.test.InstrumentationTestCase;
import android.util.Log;

import com.wipe.nba.views.NetImageView;

/**
 * Created by Administrator on 2017/2/5.
 */
public class BeanTest extends InstrumentationTestCase {
    public final String TAG = "BeanTest";

    public void testSum() {
     String url = "http://news.youth.cn/jsxw/201506/W020150612484320879723.jpg";
//        int num1 = 10;
//        int num2 = 40;
//        System.out.print("dddddd");
//        Log.e(TAG, "num1:" + num1);
        NetImageView view =new NetImageView(null);
        view.displayImage(url);
    }

    public void test() throws Exception {
        final int expected = 1;
        final int reality = 2;
        assertEquals(expected, reality);
    }
}
