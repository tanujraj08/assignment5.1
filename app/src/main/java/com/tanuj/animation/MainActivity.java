package com.tanuj.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    private Button mStartAnimation;
    private TextView mTextView;
    private Animation mfadeInAnimation;
    private Animation mfadeOutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartAnimation=findViewById(R.id.btnstart);
        mTextView=findViewById(R.id.txtmsg);

        mfadeInAnimation= AnimationUtils.loadAnimation(this,R.anim.fade_in);
        mfadeOutAnimation= AnimationUtils.loadAnimation(this,R.anim.fade_out);
        mfadeInAnimation.setAnimationListener(this);


        mStartAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setVisibility(View.VISIBLE);
                mTextView.startAnimation(mfadeInAnimation);

            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation==mfadeInAnimation){
            mTextView.startAnimation(mfadeOutAnimation);
            mTextView.setVisibility(View.GONE);
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
