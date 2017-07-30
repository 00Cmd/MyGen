package com.example.macbookair.mygen.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbookair.mygen.R;

public class IntroActivity extends AppCompatActivity {
    private ImageView fadeImg;
    private TextView startQue,welcomeText,toText,myGenText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        //Firebase if user is regisered, start loginActivity

//        if(mUser != null) {
//            Intent i = new Intent(IntroActivity.this, LoginActivity.class);
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(i);
//        }
        find();
        animateWelcomeImg();
        animateWelcomeQue();
        animateWelcomeText();
    }

    private void animateWelcomeText() {
        //WelcomeText fadeIn
        AlphaAnimation welcomeTextFadeIn = new AlphaAnimation(0.0f,1.0f);
        welcomeTextFadeIn.setDuration(5000);
        welcomeTextFadeIn.setStartOffset(11000);

        //WelcomeText fadeOut
        AlphaAnimation welcomeTextFadeOut = new AlphaAnimation(1.0f, 0.0f);
        welcomeTextFadeOut.setDuration(5000);
        welcomeTextFadeOut.setStartOffset(16000);

        //WelcomeToText fadeIn
        AlphaAnimation welcomeToTextFadeIn = new AlphaAnimation(0.0f,1.0f);
        welcomeToTextFadeIn.setDuration(5000);
        welcomeToTextFadeIn.setStartOffset(14000);

        //WelcomeToText fadeOut
        AlphaAnimation welcomeToTextFadeOut = new AlphaAnimation(1.0f, 0.0f);
        welcomeToTextFadeOut.setDuration(5000);
        welcomeToTextFadeOut.setStartOffset(18000);


        //WelcomeToMyGen fadeIn
        AlphaAnimation welcomeToMyGenFadeIn = new AlphaAnimation(0.0f,1.0f);
        welcomeToMyGenFadeIn.setDuration(5000);
        welcomeToMyGenFadeIn.setStartOffset(17000);

        //WelcomeToMyGen fadeOut
//        AlphaAnimation welcomeToMyGenFadeOut = new AlphaAnimation(1.0f, 0.0f);
//        welcomeToMyGenFadeOut.setDuration(5000);
//        welcomeToMyGenFadeOut.setStartOffset(21000);
        //Animate it so that it moves upword and the login screen apears.


        //Animate all the text's one after another
        AnimationSet set1 = new AnimationSet(true);
        AnimationSet set2 = new AnimationSet(true);
        AnimationSet set3 = new AnimationSet(true);
        set1.addAnimation(welcomeToTextFadeIn);
        set1.addAnimation(welcomeTextFadeOut);
        set2.addAnimation(welcomeToTextFadeIn);
        set2.addAnimation(welcomeToTextFadeOut);
        set3.addAnimation(welcomeToMyGenFadeIn);
//        set3.addAnimation(welcomeToMyGenFadeOut);
        set1.setFillAfter(true);
        set2.setFillAfter(true);
        set3.setFillAfter(true);
        welcomeText.startAnimation(set1);
        toText.startAnimation(set2);
        myGenText.startAnimation(set3);

    }

    private void animateWelcomeQue() {
        //Welcome que fadeIn
        AlphaAnimation queFadeIn = new AlphaAnimation(0.0f, 1.0f);
        queFadeIn.setDuration(10000);

        //Welcome que fadeOut
        AlphaAnimation queFadeOut = new AlphaAnimation(1.0f, 0.0f);
        queFadeOut.setDuration(5000);
        queFadeOut.setStartOffset(9000);

        //Animate WelcomeQue fadeIn and fadeOut
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(queFadeIn);
        set.addAnimation(queFadeOut);
        set.setFillAfter(true);
        startQue.startAnimation(set);
    }

    private void animateWelcomeImg() {
        //Main Image fadeOut
        AlphaAnimation imgAnimation = new AlphaAnimation(1.0f, 0.0f);
        imgAnimation.setDuration(7000);
        imgAnimation.setFillAfter(true);
        fadeImg.startAnimation(imgAnimation);

    }

    private void find() {
        fadeImg = (ImageView) findViewById(R.id.login_fade_img);
        startQue = (TextView) findViewById(R.id.login_que);
        welcomeText = (TextView) findViewById(R.id.login_welcome);
        toText = (TextView) findViewById(R.id.login_welcome2);
        myGenText = (TextView) findViewById(R.id.login_welcome_app_name);
    }
}
