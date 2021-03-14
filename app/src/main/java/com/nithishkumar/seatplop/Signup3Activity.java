package com.nithishkumar.seatplop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class Signup3Activity extends AppCompatActivity {

    //animation variables
    ScrollView scrollView;

    //data variables
    CountryCodePicker countryCodePicker;
    TextInputLayout phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup3);

        //hooks
        scrollView = findViewById(R.id.scroll_view);

        countryCodePicker = findViewById(R.id.country_code_picker);
        phoneNumber = findViewById(R.id.signup_phone_number);
    }

    public void callVerifyOtpScreen(View view) {

        if (!(validatePhoneNumber())){
            return;
        }

        String getPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String phoneNumber = "+"+countryCodePicker.getFullNumber()+getPhoneNumber;

        Intent intent = new Intent(Signup3Activity.this,VerifyOtpActivity.class);

        intent.putExtra("phonenumber",phoneNumber);
        intent.putExtra("gender",getIntent().getStringExtra("gender"));
        intent.putExtra("age",getIntent().getStringExtra("age"));
        intent.putExtra("date",getIntent().getStringExtra("date"));
        intent.putExtra("fullname",getIntent().getStringExtra("fullname"));
        intent.putExtra("username",getIntent().getStringExtra("username"));
        intent.putExtra("email",getIntent().getStringExtra("email"));
        intent.putExtra("password",getIntent().getStringExtra("password"));

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(scrollView,"transition_otp");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signup3Activity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    private  Boolean validatePhoneNumber(){
        String phone = phoneNumber.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,40}\\z";
        String checkNo = "[0-9]";
        if(phone.isEmpty()){
            phoneNumber.setError("This field cannot be empty");
            return false;
        }else if (!(phone.matches(checkspaces))){
            phoneNumber.setError("No special character or whitespaces are allowed");
            return false;
        }else {
            phoneNumber.setError(null);
            phoneNumber.setEnabled(false);
            return true;
        }
    }

    public void callLoginScreen(View view) {
        Intent intent = new Intent(Signup3Activity.this,LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}