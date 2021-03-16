package com.nithishkumar.seatplop.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.nithishkumar.seatplop.MainActivity;
import com.nithishkumar.seatplop.R;

public class StartActivity extends AppCompatActivity {

    //private static int SPLASH_SCREEN = 5000;
    //variables
    Animation topAnim , botmAnim;
    ImageView image1;
    Button loginBtn,registerBtn;
    TextView sloganText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.start_activity_top_animation);
        botmAnim = AnimationUtils.loadAnimation(this,R.anim.start_activity_bottom_animation);

        image1 = findViewById(R.id.imageView1);
        loginBtn = findViewById(R.id.login_btn);
        registerBtn = findViewById(R.id.register_btn);
        sloganText = findViewById(R.id.slogan_txt);

        image1.setAnimation(topAnim);

        loginBtn.setAnimation(botmAnim);
        registerBtn.setAnimation(botmAnim);
        sloganText.setAnimation(botmAnim);

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);*/
    }

    public void callLoginScreen(View view) {
        Intent intent = new Intent(StartActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();

        /**
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(loginBtn,"transition_login");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(StartActivity.this, pairs);
            startActivity(intent, options.toBundle());
            finish();
        } else {
            startActivity(intent);
            finish();
        }
         **/
    }

    public void callSignupScreen(View view) {
        Intent intent = new Intent(StartActivity.this, Signup1Activity.class);
        startActivity(intent);
        finish();

        /**
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(registerBtn,"transition_login");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(StartActivity.this, pairs);
            startActivity(intent, options.toBundle());
            finish();
        } else {
            startActivity(intent);
            finish();
        }
         **/
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            FirebaseAuth.getInstance().signOut();
            //Intent intent = new Intent(StartActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            //startActivity(intent);
            //finish();
        }
    }
}