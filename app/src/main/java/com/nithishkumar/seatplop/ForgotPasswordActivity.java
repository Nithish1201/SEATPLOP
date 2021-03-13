package com.nithishkumar.seatplop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;
import com.nithishkumar.seatplop.Model.CheckInternet;

public class ForgotPasswordActivity extends AppCompatActivity {

    CountryCodePicker countryCodePicker;
    TextInputLayout phoneNumber;
    ProgressBar progressBar;
    String phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        phoneNumber = findViewById(R.id.forgot_password_phone_number);
        countryCodePicker = findViewById(R.id.forget_password_country_code_picker);
        progressBar = findViewById(R.id.forgot_password_progress_bar);

        progressBar.setVisibility(View.INVISIBLE);

    }

    public void callMakeSelectionScreen(View view) {

        CheckInternet checkInternet = new CheckInternet();

        if (!checkInternet.isConnected(this)) {
            showCustomDialog();
        }

        if (!validatePhoneNumber()) {
            return;
        }

        phoneNum = phoneNumber.getEditText().getText().toString().trim();

        progressBar.setVisibility(View.VISIBLE);

        if (phoneNum.charAt(0) == '0') {
            phoneNum = phoneNum.substring(1);
        }

        String countryCode = countryCodePicker.getFullNumber();

        final String completeNum = "+" + countryCode + phoneNum;

        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNo").equalTo(completeNum);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    phoneNumber.setError(null);
                    phoneNumber.setErrorEnabled(false);

                    Intent intent = new Intent(ForgotPasswordActivity.this, MakeSelectionActivity.class);
                    intent.putExtra("phoneNo",completeNum);
                    intent.putExtra("whatToDo", "updateData");
                    startActivity(intent);

                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(ForgotPasswordActivity.this, "No such User exist!", Toast.LENGTH_SHORT).show();
                    phoneNumber.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ForgotPasswordActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });

    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPasswordActivity.this);
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

    private Boolean validatePhoneNumber() {
        String phone = phoneNumber.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,40}\\z";
        if (phone.isEmpty()) {
            phoneNumber.setError("This field cannot be empty");
            return false;
        } else if (!(phone.matches(checkspaces))) {
            phoneNumber.setError("No special character or whitespaces are allowed");
            return false;
        } else {
            phoneNumber.setError(null);
            return true;
        }
    }
}