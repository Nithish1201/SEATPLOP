package com.nithishkumar.seatplop.MainCourse;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nithishkumar.seatplop.Adapters.DateAdapter;
import com.nithishkumar.seatplop.Adapters.TimeAdapter;
import com.nithishkumar.seatplop.Model.Date;
import com.nithishkumar.seatplop.Model.Events;
import com.nithishkumar.seatplop.Model.Time;
import com.nithishkumar.seatplop.R;

import java.util.ArrayList;
import java.util.List;

public class DateTimeActivity extends AppCompatActivity {

    private RecyclerView recyclerViewDate;
    private RecyclerView recyclerViewTime;
    private DateAdapter dateAdapter;
    private TimeAdapter timeAdapter;

    private List<Date> dateList;
    private List<Time> timeList;

    String eventId;

    String date;
    String month;
    String year;

    String time;

    int noOfSeats;

    BottomSheetDialog bottomSheetDialog;
    View bottomSheetView;

    TextView seat_1;
    TextView seat_2;
    TextView seat_3;
    TextView seat_4;
    TextView seat_5;
    TextView seat_6;
    TextView seat_7;
    TextView seat_8;
    TextView seat_9;
    TextView seat_10;

    Boolean mIsRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        eventId = getIntent().getStringExtra("eventId");

        recyclerViewDate = findViewById(R.id.recyclerView_date);
        recyclerViewDate.setHasFixedSize(true);
        RecyclerView.LayoutManager gridLayoutManagerDate = new GridLayoutManager(this, 4);
        recyclerViewDate.setLayoutManager(gridLayoutManagerDate);
        dateList = new ArrayList<>();
        dateAdapter = new DateAdapter(DateTimeActivity.this, dateList);
        recyclerViewDate.setAdapter(dateAdapter);

        readDateList();

        recyclerViewTime = findViewById(R.id.recyclerView_time);
        recyclerViewTime.setHasFixedSize(true);
        RecyclerView.LayoutManager gridLayoutManagerTime = new GridLayoutManager(this, 2);
        recyclerViewTime.setLayoutManager(gridLayoutManagerTime);
        timeList = new ArrayList<>();
        timeAdapter = new TimeAdapter(DateTimeActivity.this, timeList);
        recyclerViewTime.setAdapter(timeAdapter);

        readTimeList();

        bottomSheetDialog = new BottomSheetDialog(DateTimeActivity.this, R.style.BottomSheetDialogTheme);
        bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_bottom_sheet_noofseats, (LinearLayout) findViewById(R.id.bottomSheetContainer));

        bottomSheetInitialising();

        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver1,new IntentFilter("dateAdapterValues"));
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver2,new IntentFilter("timeAdapterValues"));

    }

    public BroadcastReceiver mMessageReceiver1 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            date = intent.getStringExtra("date");
            month = intent.getStringExtra("month");
            year = intent.getStringExtra("year");
            //Toast.makeText(context, date+month+year, Toast.LENGTH_SHORT).show();
        }
    };

    public BroadcastReceiver mMessageReceiver2 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
           time =  intent.getStringExtra("time");
           //Toast.makeText(context, time, Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(DateTimeActivity.this);
            builder.setTitle("CONFIRMATION")
                    .setMessage("You have booked "+noOfSeats+" seats on "+date+" "+month+" "+year+" at "+time+" \n\nDo you want to proceed?")
                    .setCancelable(false)
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //next activity
                            //pass intent
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            bottomSheetDialog.setContentView(bottomSheetView);
                            bottomSheetDialog.show();
                        }
                    });


            AlertDialog alertDialog = builder.create();

            if (mIsRunning.equals(true)){
                alertDialog.show();
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        mIsRunning = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsRunning = false;
    }

    private void readTimeList() {
        FirebaseDatabase.getInstance().getReference().child("Events").child(eventId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                timeList.clear();
                Events events = snapshot.getValue(Events.class);

                String sessionStr = events.getSession_();
                sessionSwitch(sessionStr);

                timeAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void readDateList() {

        FirebaseDatabase.getInstance().getReference().child("Events").child(eventId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dateList.clear();
                Events events = snapshot.getValue(Events.class);

                String start = events.getFrom_();
                String end = events.getTo_();

                String monthStr = events.getFrom_().substring(3,5);
                String yearStr = events.getFrom_().substring(6,10);

                monthStr = monthSwitch(monthStr);

                if (start.equals(end)){
                    Date date = new Date(start.substring(0,2),monthStr,yearStr);
                    dateList.add(date);
                }else {
                    int num1 = Integer.parseInt(start.substring(0,2));
                    int num2 = Integer.parseInt(end.substring(0,2));

                    for (int i = num1 ; i <= num2 ; i ++){
                        Date date = new Date(String.valueOf(i),monthStr,yearStr);
                        dateList.add(date);
                    }
                }
                dateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



    @Override
    protected void onStart() {
        super.onStart();
        bottomSheetDialog.setContentView(bottomSheetView);

        bottomSheetDialog.setCancelable(false);

        ImageView noOfSeatImage = bottomSheetView.findViewById(R.id.no_of_seats_image);
        Button confirmBtn = bottomSheetView.findViewById(R.id.lay_bottom_sheet_confirm_btn);

        seat_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noOfSeatImage.setImageResource(R.drawable.bicycle);
                clearBorder();
                seat_1.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.color_primary_border));
                confirmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        noOfSeats = Integer.parseInt(seat_1.getTag().toString());
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        seat_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noOfSeatImage.setImageResource(R.drawable.scooter);
                clearBorder();
                seat_2.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.color_primary_border));
                confirmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        noOfSeats = Integer.parseInt(seat_2.getTag().toString());
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        seat_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noOfSeatImage.setImageResource(R.drawable.rickshaw);
                clearBorder();
                seat_3.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.color_primary_border));
                confirmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        noOfSeats = Integer.parseInt(seat_3.getTag().toString());
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        seat_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noOfSeatImage.setImageResource(R.drawable.car1);
                clearBorder();
                seat_4.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.color_primary_border));
                confirmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        noOfSeats = Integer.parseInt(seat_4.getTag().toString());
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        seat_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noOfSeatImage.setImageResource(R.drawable.car2);
                clearBorder();
                seat_5.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.color_primary_border));
                confirmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        noOfSeats = Integer.parseInt(seat_5.getTag().toString());
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        seat_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noOfSeatImage.setImageResource(R.drawable.minivan);
                clearBorder();
                seat_6.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.color_primary_border));
                confirmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        noOfSeats = Integer.parseInt(seat_6.getTag().toString());
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        seat_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noOfSeatImage.setImageResource(R.drawable.minivan);
                clearBorder();
                seat_7.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.color_primary_border));
                confirmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        noOfSeats = Integer.parseInt(seat_7.getTag().toString());
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        seat_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noOfSeatImage.setImageResource(R.drawable.bus2);
                clearBorder();
                seat_8.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.color_primary_border));
                confirmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        noOfSeats = Integer.parseInt(seat_8.getTag().toString());
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        seat_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noOfSeatImage.setImageResource(R.drawable.bus1);
                clearBorder();
                seat_9.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.color_primary_border));
                confirmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        noOfSeats = Integer.parseInt(seat_9.getTag().toString());
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        seat_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noOfSeatImage.setImageResource(R.drawable.bus1);
                clearBorder();
                seat_10.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.color_primary_border));
                confirmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        noOfSeats = Integer.parseInt(seat_10.getTag().toString());
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noOfSeats = Integer.parseInt(seat_2.getTag().toString());
                bottomSheetDialog.dismiss();
            }
        });

        bottomSheetDialog.show();
    }

    void sessionSwitch(String string) {
        switch (string) {
            case "Early Morning":
                Time time1 = new Time("04:30 AM", "Early Morning");
                timeList.add(time1);
                break;

            case "Morning":
                Time time2 = new Time("08:30 AM", "Morning");
                timeList.add(time2);
                break;

            case "Afternoon":
                Time time3 = new Time("12:00 PM", "Afternoon");
                timeList.add(time3);
                break;

            case "Evening":
                Time time4 = new Time("04:00 PM", "Evening");
                timeList.add(time4);
                break;

            case "Night":
                Time time5 = new Time("07:30 PM", "Night");
                timeList.add(time5);
                break;

            case "Late Night":
                Time time6 = new Time("10:30 PM", "Late Night");
                timeList.add(time6);
                break;

            case "Mid Night":
                Time time7 = new Time("01:00 AM", "Mid Night");
                timeList.add(time7);
                break;

            case "Whole Day":
                Time time11 = new Time("04:30 AM", "Early Morning");
                timeList.add(time11);
                Time time22 = new Time("08:30 AM", "Morning");
                timeList.add(time22);
                Time time33 = new Time("12:00 PM", "Afternoon");
                timeList.add(time33);
                Time time44 = new Time("04:00 PM", "Evening");
                timeList.add(time44);
                break;

            case "Whole Night":
                Time time55 = new Time("07:30 PM", "Night");
                timeList.add(time55);
                Time time66 = new Time("10:30 PM", "Late Night");
                timeList.add(time66);
                Time time77 = new Time("01:00 AM", "Mid Night");
                timeList.add(time77);
                break;
        }
    }

    String monthSwitch(String monthStr)
    {
        switch (monthStr)
        {
            case "01":
                monthStr = "JAN";
                break;

            case "02":
                monthStr = "FEB";
                break;

            case "03":
                monthStr = "MAR";
                break;

            case "04":
                monthStr = "APR";
                break;

            case "05":
                monthStr = "MAY";
                break;

            case "06":
                monthStr = "JUN";
                break;

            case "07":
                monthStr = "JLY";
                break;

            case "08":
                monthStr = "AUG";
                break;

            case "09":
                monthStr = "SEP";
                break;

            case "10":
                monthStr = "OCT";
                break;

            case "11":
                monthStr = "NOV";
                break;

            case "12":
                monthStr = "DEC";
                break;
        }
        return monthStr;
    }

    void bottomSheetInitialising(){
        seat_1 = bottomSheetView.findViewById(R.id.no_of_seat_1);
        seat_2 = bottomSheetView.findViewById(R.id.no_of_seat_2);
        seat_3 = bottomSheetView.findViewById(R.id.no_of_seat_3);
        seat_4 = bottomSheetView.findViewById(R.id.no_of_seat_4);
        seat_5 = bottomSheetView.findViewById(R.id.no_of_seat_5);
        seat_6 = bottomSheetView.findViewById(R.id.no_of_seat_6);
        seat_7 = bottomSheetView.findViewById(R.id.no_of_seat_7);
        seat_8 = bottomSheetView.findViewById(R.id.no_of_seat_8);
        seat_9 = bottomSheetView.findViewById(R.id.no_of_seat_9);
        seat_10 = bottomSheetView.findViewById(R.id.no_of_seat_10);
    }

    void clearBorder(){
        seat_1.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.flag_transparent));
        seat_2.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.flag_transparent));
        seat_3.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.flag_transparent));
        seat_4.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.flag_transparent));
        seat_5.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.flag_transparent));
        seat_6.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.flag_transparent));
        seat_7.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.flag_transparent));
        seat_8.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.flag_transparent));
        seat_9.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.flag_transparent));
        seat_10.setBackground(ContextCompat.getDrawable(DateTimeActivity.this,R.drawable.flag_transparent));
    }

}