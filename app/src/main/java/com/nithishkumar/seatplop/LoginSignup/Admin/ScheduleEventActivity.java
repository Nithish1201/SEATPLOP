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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nithishkumar.seatplop.LoginSignup.StartActivity;
import com.nithishkumar.seatplop.Model.CheckInternet;
import com.nithishkumar.seatplop.Model.Events;
import com.nithishkumar.seatplop.R;

import java.util.ArrayList;

public class ScheduleEventActivity extends AppCompatActivity {

    TextInputLayout eventName;
    TextInputLayout from;
    TextInputLayout to;
    TextInputLayout stadiumId;
    TextInputLayout time;
    TextInputLayout session;
    TextInputLayout bookFrom;
    TextInputLayout eventContact;
    TextInputLayout bookedSeats;
    TextInputLayout ticketStartingPrice;

    ProgressBar progressBar;

    ArrayList<String> sessions;

    String eventName_, from_, to_, stadiumId_, time_, session_, bookFrom_, eventContact_, bookedSeats_, ticketStartingPrice_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_event);

        eventName = findViewById(R.id.event_name);
        from = findViewById(R.id.event_from);
        to = findViewById(R.id.event_to);
        stadiumId = findViewById(R.id.stadium_id);
        time = findViewById(R.id.event_time);
        session = findViewById(R.id.event_session);
        bookFrom = findViewById(R.id.booking_start_date);
        eventContact = findViewById(R.id.event_contact);
        bookedSeats = findViewById(R.id.booked_seats);
        ticketStartingPrice = findViewById(R.id.ticket_starting_price);

        progressBar = findViewById(R.id.schedule_event_progress_bar);
        progressBar.setVisibility(View.INVISIBLE);

        sessions = new ArrayList<>();

    }

    public void AddEventToDatabase(View view) {

        CheckInternet checkInternet = new CheckInternet();

        if (!checkInternet.isConnected(this)) {
            showCustomDialog();
        }

        if (!ValidateEventName() | !ValidateFrom() | !ValidateTo() | !ValidateStadiumId() | !ValidateTime()
                | !ValidateSession() | !ValidateBookFrom() | !ValidateEventContact() | !ValidateBookedSeats() | !ValidateTicketStartingPrice()) {
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        getInputs();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Events");
        String referenceId = reference.push().getKey();
        Events addEvents = new Events(eventName_, from_, to_, stadiumId_, time_, session_, bookFrom_, eventContact_, bookedSeats_, ticketStartingPrice_, referenceId);
        reference.child(referenceId).setValue(addEvents).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ScheduleEventActivity.this, "Database added successfully", Toast.LENGTH_SHORT).show();
                    //add events to stadiums
                    FirebaseDatabase.getInstance().getReference("Stadiums").child(stadiumId_).child("events_").child(referenceId).setValue(true);
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(ScheduleEventActivity.this,AdminDashboardActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(ScheduleEventActivity.this, "Try Scheduling another event", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ScheduleEventActivity.this, "Database not added", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    private void getInputs() {
        eventName_ = eventName.getEditText().getText().toString().trim();
        from_ = from.getEditText().getText().toString().trim();
        to_ = to.getEditText().getText().toString().trim();
        stadiumId_ = stadiumId.getEditText().getText().toString().trim();
        time_ = time.getEditText().getText().toString().trim();
        session_ = session.getEditText().getText().toString().trim();
        bookFrom_ = bookFrom.getEditText().getText().toString().trim();
        eventContact_ = eventContact.getEditText().getText().toString().trim();
        bookedSeats_ = bookedSeats.getEditText().getText().toString().trim();
        ticketStartingPrice_ = ticketStartingPrice.getEditText().getText().toString().trim();
    }

    public Boolean ValidateEventName() {
        String val = eventName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            eventName.setError("Field cannot be empty");
            return false;
        } else {
            eventName.setError(null);
            eventName.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateFrom() {
        String val = from.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            from.setError("Field cannot be empty");
            return false;
        } else if (!(val.length() == 10)) {
            from.setError("Enter a valid date");
            return false;
        } else {
            from.setError(null);
            from.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateTo() {
        String val = to.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            to.setError("Field cannot be empty");
            return false;
        } else if (!(val.length() == 10)) {
            to.setError("Enter a valid date");
            return false;
        } else {
            to.setError(null);
            to.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateStadiumId() {
        String val = stadiumId.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            stadiumId.setError("Field cannot be empty");
            return false;
        } else if (!(val.length() == 8)) {
            stadiumId.setError("Enter a valid id!!");
            return false;
        } else {
            stadiumId.setError(null);
            stadiumId.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateTime() {
        String val = time.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            time.setError("Field cannot be empty");
            return false;
        } else {
            time.setError(null);
            time.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateSession() {
        addElementsToList();
        Boolean stateThere = false;
        String val = session.getEditText().getText().toString().trim();
        for (int i = 0; i < sessions.size(); i++) {
            if (val.equals(sessions.get(i))) {
                stateThere = true;
            }
        }
        if (val.isEmpty()) {
            session.setError("Field cannot be empty");
            return false;
        } else if (!stateThere) {
            session.setError("Enter a valid session!!");
            return false;
        } else {
            session.setError(null);
            session.setEnabled(false);
            return true;
        }
    }

    private void addElementsToList() {

        sessions.add("Morning");
        sessions.add("Afternoon");
        sessions.add("Evening");
        sessions.add("Night");
        sessions.add("Late Night");
        sessions.add("Mid Night");
        sessions.add("Early Morning");
        sessions.add("Whole Day");
        sessions.add("Whole Night");

    }

    public Boolean ValidateBookFrom() {
        String val = bookFrom.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            bookFrom.setError("Field cannot be empty");
            return false;
        } else if (!(val.length() == 10)) {
            bookFrom.setError("Enter a valid date");
            return false;
        } else {
            bookFrom.setError(null);
            bookFrom.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateEventContact() {
        String val = eventContact.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            eventContact.setError("Field cannot be empty");
            return false;
        } else if (val.length() < 12) {
            eventContact.setError("Enter a valid Phone number!!");
            return false;
        } else {
            eventContact.setError(null);
            eventContact.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateBookedSeats() {
        String val = bookedSeats.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            bookedSeats.setError("Field cannot be empty");
            return false;
        } else {
            bookedSeats.setError(null);
            bookedSeats.setEnabled(false);
            return true;
        }
    }

    public Boolean ValidateTicketStartingPrice() {
        String val = ticketStartingPrice.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            ticketStartingPrice.setError("Field cannot be empty");
            return false;
        } else {
            ticketStartingPrice.setError(null);
            ticketStartingPrice.setEnabled(false);
            return true;
        }
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ScheduleEventActivity.this);
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

    public void GoToDashboard(View view) {
    }
}