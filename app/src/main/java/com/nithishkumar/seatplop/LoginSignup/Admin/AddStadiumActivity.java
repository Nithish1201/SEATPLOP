package com.nithishkumar.seatplop.LoginSignup.Admin;

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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nithishkumar.seatplop.LoginSignup.StartActivity;
import com.nithishkumar.seatplop.Model.CheckInternet;
import com.nithishkumar.seatplop.Model.Stadiums;
import com.nithishkumar.seatplop.R;

import java.util.ArrayList;

public class AddStadiumActivity extends AppCompatActivity {

    TextInputLayout stadiumName;
    TextInputLayout state;
    TextInputLayout city;
    TextInputLayout id;
    TextInputLayout capacity;
    TextInputLayout typeOfSport;
    TextInputLayout surfaceArea;
    TextInputLayout stadiumContact;
    TextInputLayout rating;
    TextInputLayout establishmentYear;

    ProgressBar progressBar;

    ArrayList<String> states;

    String stadiumName_ , state_ , city_ , id_ , capacity_ , typeOfSport_ , surfaceArea_ , stadiumContact_ , rating_ , establishmentYear_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stadium);

        stadiumName = findViewById(R.id.stadium_name);
        state = findViewById(R.id.stadium_state);
        city = findViewById(R.id.stadium_city);
        id = findViewById(R.id.stadium_id);
        capacity = findViewById(R.id.stadium_capacity);
        typeOfSport = findViewById(R.id.stadium_type_of_sport);
        surfaceArea = findViewById(R.id.stadium_surface_area);
        stadiumContact = findViewById(R.id.stadium_contact);
        rating = findViewById(R.id.stadium_rating);
        establishmentYear = findViewById(R.id.stadium_establish_year);

        progressBar = findViewById(R.id.add_stadium_progress_bar);

        progressBar.setVisibility(View.INVISIBLE);

        states = new ArrayList<>();
    }

    public void AddStadiumToDatabase(View view) {

        CheckInternet checkInternet = new CheckInternet();

        if (!checkInternet.isConnected(this)) {
            showCustomDialog();
        }

        if (!ValidateStadiumName() | !ValidateState() | !ValidateCity() | !ValidateId() | !ValidateCapacity() | !ValidateSurfaceArea()
                | !ValidateTypeOfSport() | !ValidateStadiumContact() | !ValidateRating() | !ValidateEstablishmentYear()){
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        getInputs();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Stadiums");
        Stadiums addStadium = new Stadiums(stadiumName_ , state_ , city_ , id_ , capacity_ , typeOfSport_ , surfaceArea_ , stadiumContact_ , rating_ , establishmentYear_);
        ref.child(id_).setValue(addStadium).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(AddStadiumActivity.this, "Database added successfully..", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddStadiumActivity.this,AdminDashboardActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(AddStadiumActivity.this, "Try adding another stadium..", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(AddStadiumActivity.this, "Database not added!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        progressBar.setVisibility(View.INVISIBLE);

    }

    private void getInputs() {
        stadiumName_ = stadiumName.getEditText().getText().toString().trim();
        state_ = state.getEditText().getText().toString().trim();
        city_ = city.getEditText().getText().toString().trim();
        id_ = id.getEditText().getText().toString().trim();
        capacity_ = capacity.getEditText().getText().toString().trim();
        typeOfSport_ = typeOfSport.getEditText().getText().toString().trim();
        surfaceArea_ = surfaceArea.getEditText().getText().toString().trim();
        stadiumContact_ = stadiumContact.getEditText().getText().toString().trim();
        rating_ = rating.getEditText().getText().toString().trim();
        establishmentYear_ = establishmentYear.getEditText().getText().toString().trim();
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddStadiumActivity.this);
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


    public Boolean ValidateStadiumName(){
        String val = stadiumName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            stadiumName.setError("Field cannot be empty");
            return false;
        } else {
            stadiumName.setError(null);
            stadiumName.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateState(){
        addElementsToList();
        Boolean stateThere = false;
        String val = state.getEditText().getText().toString().trim();
        for (int i = 0 ; i < states.size();i++){
            if (val.equals(states.get(i))){
                stateThere = true;
            }
        }
        if (val.isEmpty()) {
            state.setError("Field cannot be empty");
            return false;
        }else if (!stateThere){
            state.setError("Value is not a state!!");
            return false;
        }else {
            state.setError(null);
            state.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateCity(){
        String val = city.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            city.setError("Field cannot be empty");
            return false;
        } else {
            city.setError(null);
            city.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateId(){
        String val = id.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            id.setError("Field cannot be empty");
            return false;
        } else if (!(val.length() == 8)){
            id.setError("Enter a valid id!!");
            return false;
        }else {
            id.setError(null);
            id.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateCapacity(){
        String val = capacity.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            capacity.setError("Field cannot be empty");
            return false;
        } else {
            capacity.setError(null);
            capacity.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateTypeOfSport(){
        String val = typeOfSport.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            typeOfSport.setError("Field cannot be empty");
            return false;
        } else {
            typeOfSport.setError(null);
            typeOfSport.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateSurfaceArea(){
        String val = surfaceArea.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            surfaceArea.setError("Field cannot be empty");
            return false;
        } else {
            surfaceArea.setError(null);
            surfaceArea.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateStadiumContact(){
        String val = stadiumContact.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            stadiumContact.setError("Field cannot be empty");
            return false;
        }else if (val.length() < 12){
            stadiumContact.setError("Enter a valid Phone number!!");
            return false;
        }else {
            stadiumContact.setError(null);
            stadiumContact.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateRating(){
        String val = rating.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            rating.setError("Field cannot be empty");
            return false;
        } else if (Integer.parseInt(val) > 6){
            rating.setError("Give a valid rating Please!!..");
            return false;
        }else {
            rating.setError(null);
            rating.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateEstablishmentYear(){
        String val = establishmentYear.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            establishmentYear.setError("Field cannot be empty");
            return false;
        } else if (!(val.length() == 4)){
            establishmentYear.setError("Give a valid year Please!!..");
            return false;
        } else {
            establishmentYear.setError(null);
            establishmentYear.setEnabled(false);
            return true;
        }
    }

    private void addElementsToList() {
        states.add("Andhra Pradesh");
        states.add("Assam");
        states.add("Bihar");
        states.add("Chandigarh");
        states.add("Chhattisgarh");
        states.add("Delhi NCR");
        states.add("Goa");
        states.add("Gujarat");
        states.add("Haryana");
        states.add("Himachal Pradesh");
        states.add("Jammu and Kashmir");
        states.add("Jharkhand");
        states.add("Karnataka");
        states.add("Kerala");
        states.add("Madhya Pradesh");
        states.add("Maharashtra");
        states.add("Manipur");
        states.add("Nagaland");
        states.add("Odisha");
        states.add("Punjab");
        states.add("Rajasthan");
        states.add("Sikkim");
        states.add("Tamil Nadu");
        states.add("Telangana");
        states.add("Tripura");
        states.add("Uttar Pradesh");
        states.add("West Bengal");
    }

    public void GoToDashboard(View view) {
    }
}