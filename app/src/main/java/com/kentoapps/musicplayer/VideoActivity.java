package com.kentoapps.musicplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    private static final String VIDEO_URL = "http://fast-uploader.com/transfer/7062287208962.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoView = (VideoView) findViewById(R.id.videoview);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.video_mario;
        videoView.setVideoURI(Uri.parse(path));

        videoView.setMediaController(new MediaController(this));
    }

    // Create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_video, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.music:
                finish();
                startActivity(new Intent(this, MusicActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
