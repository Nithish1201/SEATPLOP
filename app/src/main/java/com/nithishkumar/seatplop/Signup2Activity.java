package com.nithishkumar.seatplop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Signup2Activity extends AppCompatActivity {

    //variables
    ImageView backBtn;
    Button next, login;
    TextView titleText;

    //data variables initialisation
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;
    String age;
    String gender;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        //hooks
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);

        //data hooks
        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);

    }

    public void callNextSignupScreen(View view) {

        if (!validateGender() | !validateAge()) {
            return;
        }

        selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
        gender = (String) selectedGender.getText();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        date = day+"/"+month+"/"+year;

        Intent intent = new Intent(getApplicationContext(),Signup3Activity.class);

        intent.putExtra("gender",gender);
        intent.putExtra("age",age);
        intent.putExtra("date",date);
        intent.putExtra("fullname",getIntent().getStringExtra("fullname"));
        intent.putExtra("username",getIntent().getStringExtra("username"));
        intent.putExtra("email",getIntent().getStringExtra("email"));
        intent.putExtra("password",getIntent().getStringExtra("password"));

        /**Log.i("info",getIntent().getStringExtra("fullname"));
        Log.i("info",getIntent().getStringExtra("username"));
        Log.i("info",getIntent().getStringExtra("email"));
        Log.i("info",getIntent().getStringExtra("password"));
        Log.i("info",getIntent().getStringExtra("gender"));
        Log.i("info",getIntent().getStringExtra("age"));
        Log.i("info",getIntent().getStringExtra("date"));**/


        //add transition
        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View,String>(backBtn,"transition_back_arrow_btn");
        pairs[1] = new Pair<View,String>(next,"transition_next_btn");
        pairs[2] = new Pair<View,String>(login,"transition_login_btn");
        pairs[3] = new Pair<View,String>(titleText,"transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signup2Activity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }

    }

    private  Boolean validateGender(){
        if (radioGroup.getCheckedRadioButtonId() == -1){     //if any gender is not selected
            Toast.makeText(this, "Please select the gender", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    private  Boolean validateAge(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;
        if(isAgeValid < 14){
            Toast.makeText(this, "You are not eligible to apply!", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            age = String.valueOf(isAgeValid);
            return true;
        }
    }

}