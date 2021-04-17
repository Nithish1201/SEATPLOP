package com.nithishkumar.seatplop.MainCourse;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nithishkumar.seatplop.Adapters.DateAdapter;
import com.nithishkumar.seatplop.Adapters.TimeAdapter;
import com.nithishkumar.seatplop.Model.Date;
import com.nithishkumar.seatplop.Model.Events;
import com.nithishkumar.seatplop.R;

import java.util.ArrayList;
import java.util.List;

public class DateTimeActivity extends AppCompatActivity {

    private RecyclerView recyclerViewDate;
    private RecyclerView recyclerViewTime;
    private DateAdapter dateAdapter;
    private TimeAdapter timeAdapter;

    private List<Date> dateList;

    private List<String> timeList;

    String eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        eventId = getIntent().getStringExtra("eventId");

        recyclerViewDate = findViewById(R.id.recyclerView_date);
        recyclerViewDate.setHasFixedSize(true);
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerViewDate.setLayoutManager(gridLayoutManager);
        dateList = new ArrayList<>();
        dateAdapter = new DateAdapter(DateTimeActivity.this,dateList);
        recyclerViewDate.setAdapter(dateAdapter);

        readDateList();

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

                if (start.equals(end)){
                    Date date = new Date(start.substring(0,2),monthStr,yearStr);
                    dateList.add(date);
                }else {
                    int num1 = Integer.parseInt(start.substring(0,2));
                    int num2 = Integer.parseInt(end.substring(0,2));

                    for (int i = num2 ; i >= num1 ; i --){
                        Date date = new Date(String.valueOf(i),monthStr,yearStr);
                        dateList.add(date);
                    }
                }
                if (dateList.isEmpty()){
                    Log.i("info","empty");
                }else {
                    Log.i("info","content");
                }
                dateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}