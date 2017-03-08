package com.wipe.nba.ui.review;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.wipe.nba.R;
import com.wipe.nba.base.BaseActivity;

import java.net.URISyntaxException;

/**
 * Created by Administrator on 2017/2/9.
 */
public class GameReviewActivity extends BaseActivity {

    private VideoView mPlayer;
    private String path = "http://sports.qq.com/kbsweb/game.htm?mid=100000:1468994";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_game_review);
        mPlayer = (VideoView) findViewById(R.id.vv_palyer);
        mPlayer.setMediaController(new MediaController(this));

        Uri uri = Uri.parse(path);
        mPlayer.setVideoURI(uri);
        mPlayer.start();

    }
}
