package com.nithishkumar.seatplop.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nithishkumar.seatplop.MainActivity;
import com.nithishkumar.seatplop.Model.Users;
import com.nithishkumar.seatplop.R;

import java.util.concurrent.TimeUnit;

public class VerifyOtpActivity extends AppCompatActivity {

    PinView pinView;
    FirebaseAuth mAuth;
    String codeBySystem;
    TextView topText;

    String phoneNo,fullName,userName,email,password,date,age,gender,whatToDo,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        pinView = findViewById(R.id.pin_view);
        mAuth = FirebaseAuth.getInstance();
        topText = findViewById(R.id.code_verify_text);

         phoneNo = getIntent().getStringExtra("phonenumber");
         fullName = getIntent().getStringExtra("fullname");
         userName = getIntent().getStringExtra("username");
         email = getIntent().getStringExtra("email");
         password = getIntent().getStringExtra("password");
         date = getIntent().getStringExtra("date");
         age = getIntent().getStringExtra("age");
         gender = getIntent().getStringExtra("gender");
         location = "Tamilnadu";

         whatToDo = getIntent().getStringExtra("whatToDo");

        topText.setText("ENTER ONE TIME PASSWORD SENT TO "+phoneNo);

        sendVerificationCodeToUser(phoneNo);

    }

    private  void  sendVerificationCodeToUser(String phoneNo){
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNo)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }

    private final PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeBySystem = s;
        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code!=null){
                pinView.setText(code);
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(VerifyOtpActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            Log.i("info",e.getMessage());

        }
    };

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeBySystem,code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            if (whatToDo != null && whatToDo.equals("updateData")){
                                Intent intent = new Intent(VerifyOtpActivity.this,SetNewPasswordActivity.class);
                                intent.putExtra("phoneNo",phoneNo);
                                startActivity(intent);
                                finish();
                            } else if (whatToDo != null && whatToDo.equals("loginUser")){
                                Intent intent = new Intent(VerifyOtpActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            } else {
                                storeNewUsersData();
                            }
                            Toast.makeText(VerifyOtpActivity.this, "Verification completed", Toast.LENGTH_SHORT).show();

                        } else {
                            // Sign in failed, display a message and update the UI
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
                        }
                    }
                });
    }

    private void storeNewUsersData() {

        /**

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("info","createUserWithEmail:success");
                            Toast.makeText(VerifyOtpActivity.this, "Authentication success.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("info", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(VerifyOtpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
         **/

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        Users addNewUser = new Users(phoneNo,fullName,userName,email,password,date,age,gender,location);
        reference.child("Users").child(phoneNo).setValue(addNewUser);

        Intent intent = new Intent(VerifyOtpActivity.this,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(whatToDo.equals("updateData")){
            Intent intent = new Intent(VerifyOtpActivity.this,LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        else  if (whatToDo.equals("loginUser")){
            Intent intent = new Intent(VerifyOtpActivity.this,LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }else {
            Intent intent = new Intent(VerifyOtpActivity.this,Signup1Activity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }

    public void callNextScreenFromOtp(View view) {
        String code = pinView.getText().toString();
        if(!code.isEmpty()){
            verifyCode(code);
        }
    }
}