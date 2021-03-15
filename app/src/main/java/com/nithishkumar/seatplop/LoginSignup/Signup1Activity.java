package com.nithishkumar.seatplop.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.nithishkumar.seatplop.R;

public class Signup1Activity extends AppCompatActivity {

    //variables
    ImageView backBtn;
    Button next, login;
    TextView titleText;

    //get data variables
    TextInputLayout fullName, userName, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);

        //hooks for animation
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);

        //hooks for data variables
        fullName = findViewById(R.id.signup_fullname);
        userName = findViewById(R.id.signup_username);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);

    }

    public void callNextSignupScreen(View view) {

        if(!validateFullname() | !validateUsername() | !validateEmail() | !validatePassword()){     //single or means checks all the functions if double or its only between two
            return;
        }

        Intent intent = new Intent(getApplicationContext(), Signup2Activity.class);

        intent.putExtra("fullname", fullName.getEditText().getText().toString());
        intent.putExtra("username",  userName.getEditText().getText().toString());
        intent.putExtra("email",  email.getEditText().getText().toString());
        intent.putExtra("password",  password.getEditText().getText().toString());

        //add transition
        Pair[] pairs;
        pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signup1Activity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }


    }

    private boolean validateFullname() {
        String val = fullName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            fullName.setError("Field cannot be empty");
            return false;
        } else {
            fullName.setError(null);
            fullName.setEnabled(false);
            return true;
        }
    }

    private boolean validateUsername() {
        String val = userName.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,40}\\z";     //to limit users a total length of 40 and no numbers
        if (val.isEmpty()) {
            userName.setError("Field cannot be empty");
            return false;
        } else if (val.length() > 20) {
            userName.setError("Username is too large");
            return false;
        } else if (!val.matches(checkspaces)) {
            userName.setError("No white spaces are allowed!");
            return false;
        } else {
            userName.setError(null);
            userName.setEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+";     //to have constrains for email id , domain , country
        if (val.isEmpty()) {
            email.setError("Field cannot be empty");
            return false;
        }else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
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

        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        }else if (!(val.length() > 4)) {            //if(!val.matches(checkPassword))
            password.setError("Password should contain 4 characters!");
            return false;
        } else {
            password.setError(null);
            password.setEnabled(false);
            return true;
        }
    }

    public void callLoginScreen(View view) {
        Intent intent = new Intent(Signup1Activity.this,LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}