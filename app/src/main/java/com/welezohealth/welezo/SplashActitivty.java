package com.welezohealth.welezo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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
        assert actionBar != null;
        actionBar.hide();

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.logo_animation);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnCompletionListener(mp -> startActivity(new Intent(this,SignUp_Activity.class)));

        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActitivty.this,SignUp_Activity.class));
            }
        });
    }

}

//android:theme="@android:style/Theme.NoTitleBar.Fullscreen"wwwwwwwww
