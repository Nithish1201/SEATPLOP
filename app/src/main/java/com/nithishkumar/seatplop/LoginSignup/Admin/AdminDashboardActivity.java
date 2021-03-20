package com.nithishkumar.seatplop.LoginSignup.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nithishkumar.seatplop.LoginSignup.LoginActivity;
import com.nithishkumar.seatplop.R;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
    }

    public void AddStadium(View view) {
        Intent intent = new Intent(AdminDashboardActivity.this,AddStadiumActivity.class);
        startActivity(intent);
        finish();
    }

    public void ScheduleEvent(View view) {
        Intent intent = new Intent(AdminDashboardActivity.this,ScheduleEventActivity.class);
        startActivity(intent);
    }

    public void EditAdminDetails(View view) {
        Intent intent = new Intent(AdminDashboardActivity.this,EditAdminDetalisActivity.class);
        startActivity(intent);
    }

    public void VerifyStadiumId(View view) {
        Intent intent = new Intent(AdminDashboardActivity.this,VerifyStadiumIdActivity.class);
        startActivity(intent);
    }

    public void callLoginScreen(View view) {
        Intent intent = new Intent(AdminDashboardActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}