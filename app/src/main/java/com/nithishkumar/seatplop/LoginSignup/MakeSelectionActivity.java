package com.nithishkumar.seatplop.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nithishkumar.seatplop.R;

public class MakeSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection);
    }

    public void callVerifyOtpScreen(View view) {

        Intent intent = new Intent(MakeSelectionActivity.this,VerifyOtpActivity.class);
        intent.putExtra("phonenumber",getIntent().getStringExtra("phoneNo"));
        intent.putExtra("whatToDo", getIntent().getStringExtra("whatToDo"));
        startActivity(intent);

    }

}