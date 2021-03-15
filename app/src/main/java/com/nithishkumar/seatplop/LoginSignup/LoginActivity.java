package com.nithishkumar.seatplop.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;
import com.nithishkumar.seatplop.Model.CheckInternet;
import com.nithishkumar.seatplop.R;

public class LoginActivity extends AppCompatActivity {

    Button forgotPassword;
    TextInputLayout phoneNo, password;
    CountryCodePicker loginCountryCodePicker;
    ProgressBar progressBar;
    CheckBox rememberMe;

    FirebaseAuth Auth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgotPassword = findViewById(R.id.forgot_password);
        phoneNo = findViewById(R.id.login_phone_number);
        password = findViewById(R.id.login_password);
        progressBar = findViewById(R.id.login_progress_bar);
        loginCountryCodePicker = findViewById(R.id.login_country_code_picker);
        rememberMe = findViewById(R.id.remember_me);

        Auth = FirebaseAuth.getInstance();
        currentUser = Auth.getCurrentUser();

        progressBar.setVisibility(View.INVISIBLE);

    }

    public void VerifyOtp(View view) {

        CheckInternet checkInternet = new CheckInternet();

        if (!checkInternet.isConnected(this)) {
            showCustomDialog();
        }


        if (!validateUserFields()) {
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        //get data
        String phoneNum = phoneNo.getEditText().getText().toString().trim();
        String passWord = password.getEditText().getText().toString().trim();

        if (phoneNum.charAt(0) == '0') {
            phoneNum = phoneNum.substring(1);
        }

        String completePhoneNo = "+" + loginCountryCodePicker.getFullNumber() + phoneNum;

        //Database
        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNo").equalTo(completePhoneNo);
        String finalPhoneNum = phoneNum;
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    phoneNo.setError(null);
                    phoneNo.setErrorEnabled(false);

                    String systemPassword = snapshot.child(completePhoneNo).child("password").getValue(String.class);
                    if (systemPassword.equals(passWord)) {
                        password.setError(null);
                        password.setErrorEnabled(false);

                        Intent intent = new Intent(LoginActivity.this,VerifyOtpActivity.class);
                        intent.putExtra("phonenumber", completePhoneNo);
                        intent.putExtra("whatToDo", "loginUser");
                        startActivity(intent);

                        Toast.makeText(LoginActivity.this, "Both are correct", Toast.LENGTH_SHORT).show();

                    } else {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(LoginActivity.this, "password does not match!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, "No such User Exist!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                Log.i("info", error.getMessage());
                Log.i("info", error.getDetails());
                Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("Please connect to the internet to proceed further")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), StartActivity.class));
                        finish();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    private boolean validateUserFields() {

        String phone = phoneNo.getEditText().getText().toString().trim();
        String pass = password.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,40}\\z";

        if (phone.isEmpty()) {
            phoneNo.setError("this field cannot Be Empty!");
            phoneNo.requestFocus();
            return false;
        } else if (pass.isEmpty()) {
            password.setError("this field cannot Be Empty!");
            password.requestFocus();
            return false;
        } else if (!(pass.length() > 4)) {
            password.setError("Password should contain 4 characters!");
            return false;
        } else if (!(phone.matches(checkspaces))) {
            phoneNo.setError("No special character or whitespaces are allowed");
            return false;
        } else {
            phoneNo.setError(null);
            password.setError(null);
            return true;
        }
    }

    public void callForgotPasswordScreen(View view) {
        Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(forgotPassword, "transition_forgot_password");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    public void callSignupScreen(View view) {
        Intent intent = new Intent(LoginActivity.this, Signup1Activity.class);
        startActivity(intent);
    }
}