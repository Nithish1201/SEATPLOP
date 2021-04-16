package com.nithishkumar.seatplop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        tickets.add("booked 1 seats in H - lower");
        tickets.add("booked 6 seats in G - upper");
        tickets.add("booked 3 seats in B - lower");
        tickets.add("booked 9 seats in E - upper");

    }
}