package com.kentoapps.musicplayer.views;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kentoapps.musicplayer.R;

/**
 * Created by kento on 2017/09/29.
 */

public class RecordView extends RelativeLayout {

    private View view;
    private ImageView imageRecord;
    private ImageView imageMario;
    private Animation rotateAnim;
    private AnimationDrawable marioAnim;
    private MarioClickListener listner;

    public RecordView(Context context) {
        this(context, null);
    }

    public RecordView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecordView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        view = View.inflate(getContext(), R.layout.view_record, this);
        imageRecord = (ImageView)view.findViewById(R.id.image_record);

        imageMario = (ImageView)findViewById(R.id.image_mario);
        imageMario.setBackgroundResource(R.drawable.anim_walk);
        marioAnim = (AnimationDrawable) imageMario.getBackground();


        rotateAnim = AnimationUtils.loadAnimation(getContext(), R.anim.rotation);


        imageMario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listner != null) listner.onClick();
            }
        });
    }

    public void start() {
        imageRecord.startAnimation(rotateAnim);
        marioAnim.start();
    }

    public void stop() {
        imageRecord.clearAnimation();
        marioAnim.stop();
    }

    public void setOnMarioClickListener(MarioClickListener listener) {
        this.listner = listener;
    }

    public interface MarioClickListener {
        void onClick();
    }
}
