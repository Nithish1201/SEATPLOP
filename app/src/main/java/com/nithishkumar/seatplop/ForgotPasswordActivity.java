package com.nithishkumar.seatplop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void callMakeSelectionScreen(View view) {
        Intent intent = new Intent(ForgotPasswordActivity.this,MakeSelectionActivity.class);
        startActivity(intent);
    }
}