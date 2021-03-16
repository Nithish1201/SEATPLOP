package com.nithishkumar.seatplop.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.nithishkumar.seatplop.Adapters.EventAdapter;
import com.nithishkumar.seatplop.Model.Events;
import com.nithishkumar.seatplop.Model.Stadiums;
import com.nithishkumar.seatplop.Model.Users;
import com.nithishkumar.seatplop.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewEvents;
    private EventAdapter eventAdapter;
    private List<Events> eventsList;

    String userLocation;
    private List<String> locatedStadiumList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewEvents = view.findViewById(R.id.recycler_view_events);
        recyclerViewEvents.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerViewEvents.setLayoutManager(linearLayoutManager);
        eventsList = new ArrayList<>();
        locatedStadiumList = new ArrayList<>();
        eventAdapter = new EventAdapter(getContext(),eventsList);
        recyclerViewEvents.setAdapter(eventAdapter);

        getLocatedStadiumList();

        return view;
    }

    private void getLocatedStadiumList() {

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase.getInstance().getReference().child("Users").child(firebaseUser.getPhoneNumber()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Users users = snapshot.getValue(Users.class);
                userLocation = users.getLocation();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //Log.i("userloc",userLocation);


        FirebaseDatabase.getInstance().getReference().child("Stadiums").orderByChild("state").equalTo("Tamilnadu").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                locatedStadiumList.clear();
                if (snapshot.exists()){
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        locatedStadiumList.add(dataSnapshot.getKey());
                    }
                    Log.i("stadium list", locatedStadiumList.get(0));
                    readEvents();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void readEvents() {

        FirebaseDatabase.getInstance().getReference().child("Events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                eventsList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Events events = dataSnapshot.getValue(Events.class);
                    eventsList.add(events);
                    /**
                    for (String id :locatedStadiumList){
                        if (events.getStadium().equals(id));{
                            eventsList.add(events);
                        }
                    }**/
                }
                Log.i("event list", String.valueOf(eventsList.get(0)));
                eventAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}