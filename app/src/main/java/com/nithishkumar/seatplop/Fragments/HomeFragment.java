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
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.nithishkumar.seatplop.Adapters.EventAdapter;
import com.nithishkumar.seatplop.Model.Events;
import com.nithishkumar.seatplop.Model.Users;
import com.nithishkumar.seatplop.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private RecyclerView recyclerViewEvents;
    private EventAdapter eventAdapter;
    private List<Events> eventsList;

    private List<String> locatedStadiumList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewEvents = view.findViewById(R.id.events_recyclerview);
        recyclerViewEvents.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewEvents.setLayoutManager(linearLayoutManager);
        eventsList = new ArrayList<>();
        eventAdapter = new EventAdapter(getContext(),eventsList);
        recyclerViewEvents.setAdapter(eventAdapter);

        locatedStadiumList = new ArrayList<>();

        getUserLocation();

        return view;
    }

    private void getUserLocation() {

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getPhoneNumber()).child("location").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    String userLocation = String.valueOf(task.getResult().getValue());
                    Log.i("info",userLocation);
                    getLocatedStadiumList(userLocation);
                }
            }
        });


    }

    private void getLocatedStadiumList(String userLocation) {

        Query checkStadiums = FirebaseDatabase.getInstance().getReference("Stadiums").orderByChild("state_").equalTo(userLocation);
        checkStadiums.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                locatedStadiumList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    locatedStadiumList.add(dataSnapshot.getKey());
                }
                Log.i("info",String.valueOf(locatedStadiumList.get(0)));
                getEventList();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void getEventList() {

        FirebaseDatabase.getInstance().getReference("Events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                eventsList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Events events = dataSnapshot.getValue(Events.class);
                    for (String stadiumId : locatedStadiumList){
                        if (events.getStadiumId_().equals(stadiumId)){
                            eventsList.add(events);
                        }
                    }
                }
                if (eventsList.isEmpty()){
                    Log.i("info","true");
                }else{
                    Log.i("info","false");
                }
                eventAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}