package com.nithishkumar.seatplop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {

    //variables
    Animation topAnim;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.start_activity_top_animation);
        image = findViewById(R.id.imageView2);

        image.setAnimation(topAnim);
    }
}