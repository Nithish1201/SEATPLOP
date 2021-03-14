package com.nithishkumar.seatplop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nithishkumar.seatplop.Model.CheckInternet;

public class SetNewPasswordActivity extends AppCompatActivity {

    TextInputLayout newPassword,confirmNewPassword;
    ProgressBar progressBar;
    String phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);

        newPassword = findViewById(R.id.new_password);
        confirmNewPassword = findViewById(R.id.confirm_new_password);
        progressBar = findViewById(R.id.set_new_password_progress_bar);

        progressBar.setVisibility(View.INVISIBLE);

        phoneNum = getIntent().getStringExtra("phoneNo");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SetNewPasswordActivity.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void callForgotPasswordMessageScreen(View view) {

        CheckInternet checkInternet = new CheckInternet();
        if (!checkInternet.isConnected(this)){
            showCustomDialog();
        }

        if(!validatePassword()){
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        String password = newPassword.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

        reference.child(phoneNum).child("password").setValue(password);

        Intent intent = new Intent(SetNewPasswordActivity.this, ForgotPasswordMessageActivity.class);
        startActivity(intent);
        finish();
        progressBar.setVisibility(View.GONE);
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SetNewPasswordActivity.this);
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

    private boolean validatePassword() {
        String pass1 = newPassword.getEditText().getText().toString().trim();
        String pass2 = confirmNewPassword.getEditText().getText().toString().trim();
        /**
         String checkPassword = "^" +
         //"(?=.*[0-9])" +         //at least 1 digit
         //"(?=.*[a-z])" +         //at least 1 lower case letter
         //"(?=.*[A-Z])" +         //at least 1 upper case letter
         "(?=.*[a-zA-Z])" +      //any letter
         //"(?=.*[@#$%^&+=])" +    //at least 1 special character
         "(?=S+$)" +           //no white spaces
         ".{4,}" +               //at least 4 characters
         "$";
         **/

        if (pass1.isEmpty()) {
            newPassword.setError("Field cannot be empty");
            return false;
        }else  if (pass2.isEmpty()){
            confirmNewPassword.setError("Field cannot be empty");
            return false;
        }else if (!(pass1.length() > 4)) {            //if(!val.matches(checkPassword))
            newPassword.setError("Password should contain 4 characters!");
            return false;
        }else if (!(pass2.length() > 4)) {            //if(!val.matches(checkPassword))
            confirmNewPassword.setError("Password should contain 4 characters!");
            return false;
        }else if(!(pass1.equals(pass2))){
            newPassword.setError("your password does not match!");
            confirmNewPassword.setError("your password does not match!");
            return false;
        } else {
        newPassword.setError(null);
        newPassword.setEnabled(false);
        confirmNewPassword.setError(null);
        confirmNewPassword.setEnabled(false);
        return true;
        }
    }
}