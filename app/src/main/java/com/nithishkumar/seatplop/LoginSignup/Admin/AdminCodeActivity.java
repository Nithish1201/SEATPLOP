package com.nithishkumar.seatplop.LoginSignup.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.nithishkumar.seatplop.LoginSignup.LoginActivity;
import com.nithishkumar.seatplop.R;

public class AdminCodeActivity extends AppCompatActivity {

    TextInputLayout adminCode;
    ProgressBar progressBar;

    String phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_code);

        adminCode = findViewById(R.id.admin_code);
        progressBar = findViewById(R.id.admin_code_progress_bar);

        progressBar.setVisibility(View.INVISIBLE);

        phoneNo = getIntent().getStringExtra("phoneNo");

    }

    public void callLoginScreen(View view) {
        Intent intent = new Intent(AdminCodeActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void verifyCode(View view) {
        progressBar.setVisibility(View.VISIBLE);

        if (!validateAdminCode()) {
            return;
        }

        //check internet

        String sysAdminCode = getIntent().getStringExtra("sysAdminCode");
        String adminCodeStr = adminCode.getEditText().getText().toString().trim();

        if (sysAdminCode.equals(adminCodeStr)){

            //check internet

            if (!validateAdminCode()){
                return;
            }

            //admin code is correct
            Toast.makeText(this, "Admin access approved!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AdminCodeActivity.this,AdminDashboardActivity.class);
            startActivity(intent);
        }else{
            //admin code not correct
            Toast.makeText(this, "Admin access not approved!", Toast.LENGTH_SHORT).show();
            adminCode.requestFocus();
            adminCode.setEnabled(true);
        }
        progressBar.setVisibility(View.GONE);

    }

    private boolean validateAdminCode() {
        String val = adminCode.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,40}\\z";     //to limit users a total length of 40 and no numbers
        if (val.isEmpty()) {
            adminCode.setError("Field cannot be empty");
            progressBar.setVisibility(View.GONE);
            return false;
        } else if (val.length() > 6) {
            adminCode.setError("code seems to be invalid!");
            progressBar.setVisibility(View.GONE);
            return false;
        } else if (!val.matches(checkspaces)) {
            adminCode.setError("No white spaces are allowed!");
            progressBar.setVisibility(View.GONE);
            return false;
        } else {
            adminCode.setError(null);
            adminCode.setEnabled(false);
            return true;
        }
    }

}