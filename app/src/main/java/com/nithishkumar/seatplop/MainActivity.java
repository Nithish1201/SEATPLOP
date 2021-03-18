package com.nithishkumar.seatplop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.nithishkumar.seatplop.LoginSignup.StartActivity;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Auth = FirebaseAuth.getInstance();
    }
    public void signOut(View view) {
        Auth.signOut();
        Intent intent = new Intent(MainActivity.this, StartActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}