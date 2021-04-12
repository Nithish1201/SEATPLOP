package com.nithishkumar.seatplop.MainCourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nithishkumar.seatplop.R;

public class EventActivity extends AppCompatActivity {

    String eventId;

    ImageView typeOfSportImg;
    ImageView eventImg;

    ImageView saveImg;
    ImageView likeImg;

    TextView eventName;
    TextView fromDate;
    TextView toTxt;
    TextView toDate;
    TextView session;
    TextView time;
    TextView typeOfSportTxt;
    TextView stadiumName;
    TextView bookingStartsFrom;
    TextView ticketStartingPrice;
    TextView eventContact;
    TextView leftOutSeats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        eventId = getIntent().getStringExtra("eventId");

        eventName = findViewById(R.id.event_name_event);
        fromDate = findViewById(R.id.from_date_event);
        toTxt = findViewById(R.id.to_txt_event);
        toDate = findViewById(R.id.to_date_event);
        session = findViewById(R.id.session_event);
        time = findViewById(R.id.time_event);
        typeOfSportTxt = findViewById(R.id.type_of_sport_txt_event);
        stadiumName = findViewById(R.id.stadium_name_event);
        bookingStartsFrom = findViewById(R.id.booking_start_from_event);
        ticketStartingPrice = findViewById(R.id.starting_price_event);
        eventContact = findViewById(R.id.event_contact_event);
        leftOutSeats = findViewById(R.id.no_of_seats_left_event);

        typeOfSportImg = findViewById(R.id.type_of_sport_image_event);
        eventImg = findViewById(R.id.event_image);

        saveImg= findViewById(R.id.save_image_event);
        likeImg = findViewById(R.id.like_image_event);

    }

    public void BookTicketBtn(View view) {
    }
}