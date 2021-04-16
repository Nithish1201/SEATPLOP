package com.nithishkumar.seatplop.MainCourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nithishkumar.seatplop.R;

public class SelectNoOfSeatsActivity extends AppCompatActivity {

    EditText noOfSeats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_no_of_seats);

        noOfSeats = (EditText) findViewById(R.id.no_of_seats_text);
        }

    public void submitnoOfSeats(View view) {
        String noOfSeatsStr = noOfSeats.getText().toString();
        Toast.makeText(this, noOfSeatsStr, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SelectNoOfSeatsActivity.this,StadiumSectorSelectionActivity.class);
        intent.putExtra("noOfSeats",noOfSeatsStr);
        startActivity(intent);
    }
}