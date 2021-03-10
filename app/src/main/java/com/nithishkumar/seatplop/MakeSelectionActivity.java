package com.nithishkumar.seatplop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MakeSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection);
    }

    public void callVerifyOtpScreen(View view) {
    }

    public void sample(View view) {
        Intent intent = new Intent(MakeSelectionActivity.this, SetNewPasswordActivity.class);
        startActivity(intent);
    }
}