package com.kentoapps.musicplayer;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.kentoapps.musicplayer.views.RecordView;

import java.io.IOException;

public class MusicActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int soundId;

    private MediaPlayer mediaPlayer;
    private RecordView recordView;
    private int[] musicRes = {R.raw.main, R.raw.underground, R.raw.water, R.raw.castle};
    private int current = 0;
    private ImageView imagePlay;

    @Override
    protected void onResume() {
        super.onResume();
        // Initialize SoundPool
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        recordView = (RecordView) findViewById(R.id.recordview);

        // Click Mario image
        recordView.setOnMarioClickListener(new RecordView.MarioClickListener() {
            @Override
            public void onClick() {
            }
        });

        // Initialize MediaPlayer

        // Click Play button
        imagePlay = (ImageView) findViewById(R.id.button_play);
        imagePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        // Click Prev button
        findViewById(R.id.button_prev).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        // Click Next button
        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void pauseMusic() {
        // Pause music

        // Change Pause image to Play image

        // Stop animation

    }

    private void playMusic() {
        // Play music

        // Change Play image to Pause image

        // Start animation

    }

    private void changeSong(int num) {
        try {
            mediaPlayer.reset();
            AssetFileDescriptor afd = getResources().openRawResourceFd(musicRes[num]);
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Pause music
        pauseMusic();
        // Release SoundPool
        soundPool.release();
    }

    // Create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_music, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.video:
                finish();
                startActivity(new Intent(this, VideoActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
