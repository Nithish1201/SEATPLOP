package com.nithishkumar.seatplop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Signup3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup3);
    }

    public void callNextSignupScreen(View view) {
        Intent intent = new Intent(Signup3Activity.this,VerifyOtpActivity.class);
        startActivity(intent);
    }
}