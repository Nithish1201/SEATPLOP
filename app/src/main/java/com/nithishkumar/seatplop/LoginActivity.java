package com.nithishkumar.seatplop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgotPassword = findViewById(R.id.forgot_password);
    }

    public void callSignupScreen(View view) {

        Intent intent = new Intent(LoginActivity.this, Signup1Activity.class);
        startActivity(intent);
    }

    public void callForgotPasswordScreen(View view) {
        Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(forgotPassword,"transition_forgot_password");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
            startActivity(intent, options.toBundle());
            finish();
        } else {
            startActivity(intent);
            finish();
        }
    }
}