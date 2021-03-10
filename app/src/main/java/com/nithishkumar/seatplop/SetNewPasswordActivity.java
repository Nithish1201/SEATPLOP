package com.nithishkumar.seatplop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SetNewPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);
    }

    public void callForgotPasswordMessageScreen(View view) {
        Intent intent = new Intent(SetNewPasswordActivity.this, ForgotPasswordMessageActivity.class);
        startActivity(intent);
    }
}