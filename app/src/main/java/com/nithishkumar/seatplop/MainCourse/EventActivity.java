package com.nithishkumar.seatplop.MainCourse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nithishkumar.seatplop.Model.Events;
import com.nithishkumar.seatplop.Model.Stadiums;
import com.nithishkumar.seatplop.R;

public class EventActivity extends AppCompatActivity {

    String eventId;

    int totalNoSeats;
    int noOfSeatsBooked;

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
        Log.i("info",eventId);

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
        //eventImg = findViewById(R.id.event_image);

        //saveImg= findViewById(R.id.save_image_event);
        //likeImg = findViewById(R.id.like_image_event);

        FirebaseDatabase.getInstance().getReference("Events").child(eventId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Events events = snapshot.getValue(Events.class);

                eventName.setText(events.getEventName_());
                fromDate.setText(events.getFrom_());

                if (events.getFrom_().equals(events.getTo_())){
                    toDate.setText("");
                    toTxt.setText("");
                }else {
                    toDate.setText(events.getTo_());
                    toTxt.setText("to");
                }
                session.setText(events.getSession_());
                time.setText(events.getTime_());
                bookingStartsFrom.setText(events.getBookFrom_());
                ticketStartingPrice.setText(events.getTicketStartingPrice_());
                eventContact.setText(events.getEventContact_());

                String stadiumId = String.valueOf(events.getStadiumId_());
                Log.i("info",stadiumId);

                FirebaseDatabase.getInstance().getReference("Stadiums").child(stadiumId).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        Stadiums stadiums = snapshot.getValue(Stadiums.class);

                        stadiumName.setText(stadiums.getStadiumName_());
                        typeOfSportTxt.setText(stadiums.getTypeOfSport_());
                        switch (stadiums.getTypeOfSport_()){
                            case "Cricket":
                                typeOfSportImg.setImageResource(R.drawable.cricket);
                                break;

                            case "Hockey":
                                typeOfSportImg.setImageResource(R.drawable.hockey);
                                break;

                            case "Football":
                                typeOfSportImg.setImageResource(R.drawable.football);
                                break;

                            case "Athlete":
                                typeOfSportImg.setImageResource(R.drawable.running);
                                break;

                            case "Motorsport":
                                typeOfSportImg.setImageResource(R.drawable.motorcycle);
                                break;

                            case "Horse racing":
                                typeOfSportImg.setImageResource(R.drawable.racehorse);
                                break;

                            case "Common":
                                typeOfSportImg.setImageResource(R.drawable.stadium);
                                break;
                        }

                        totalNoSeats = Integer.parseInt(stadiums.getCapacity_());
                        leftOutSeats.setText(String.valueOf(totalNoSeats-noOfSeatsBooked));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                noOfSeatsBooked = Integer.parseInt(events.getBookedSeats_());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void BookTicketBtn(View view) {
        Intent intent = new Intent(EventActivity.this,DateTimeActivity.class);
        intent.putExtra("eventId",eventId);
        startActivity(intent);
    }
}