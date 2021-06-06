package com.nithishkumar.seatplop.MainCourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nithishkumar.seatplop.R;

import java.util.ArrayList;

public class TicketActivity extends AppCompatActivity {

    ListView ticketListView;
    ArrayList<String> tickets;
    ArrayAdapter arrayAdapter;

    String content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        content = getIntent().getStringExtra("listViewContent");

        ticketListView = findViewById(R.id.list_view_ticket);
        tickets = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tickets);
        ticketListView.setAdapter(arrayAdapter);

        tickets.add(content);

        tickets.add("booked 1 seats in H - lower for a event on 10-MAY-2021 at 09:30 AM, Morning");
        //tickets.add("booked 6 seats in G - upper for a event on 28-MAY-2021 at 01:30 PM, Afternoon");
        tickets.add("booked 3 seats in B - lower for a event on 09-MAY-2021 at 12:00 AM, Late Night");
        //tickets.add("booked 9 seats in E - upper for a event on 12-MAY-2021 at 07:30 AM, Morning");

    }
}