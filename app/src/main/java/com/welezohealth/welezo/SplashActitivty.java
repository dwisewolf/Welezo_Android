package com.welezohealth.welezo;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActitivty extends AppCompatActivity {

    @BindView(R.id.videoView)
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_actitivty);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.logo_animation);
        videoView.setVideoURI(uri);
        videoView.start();

    }
}
//android:theme="@android:style/Theme.NoTitleBar.Fullscreen"