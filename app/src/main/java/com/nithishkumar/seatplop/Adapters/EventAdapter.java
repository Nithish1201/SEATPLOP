package com.nithishkumar.seatplop.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nithishkumar.seatplop.MainCourse.EventActivity;
import com.nithishkumar.seatplop.Model.Events;
import com.nithishkumar.seatplop.Model.Stadiums;
import com.nithishkumar.seatplop.R;

import java.util.List;
import java.util.Random;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.Viewholder> {

    private Context mContext;
    private List<Events> mEvents;

    private FirebaseUser firebaseUser;


    public EventAdapter(Context mContext, List<Events> mEvents) {
        this.mContext = mContext;
        this.mEvents = mEvents;
        this.firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.event_item,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Events events = mEvents.get(position);

        FirebaseDatabase.getInstance().getReference().child("Stadiums").child(events.getStadiumId_()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Stadiums stadiums = snapshot.getValue(Stadiums.class);

                holder.stadiumName.setText(stadiums.getStadiumName_());

                switch (stadiums.getTypeOfSport_()){
                    case "Cricket":
                        holder.typeOfSport.setImageResource(R.drawable.cricket);
                        break;

                    case "Hockey":
                        holder.typeOfSport.setImageResource(R.drawable.hockey);
                        break;

                    case "Football":
                        holder.typeOfSport.setImageResource(R.drawable.football);
                        break;

                    case "Athlete":
                        holder.typeOfSport.setImageResource(R.drawable.running);
                        break;

                    case "Motorsport":
                        holder.typeOfSport.setImageResource(R.drawable.motorcycle);
                        break;

                    case "Horse racing":
                        holder.typeOfSport.setImageResource(R.drawable.racehorse);
                        break;

                    case "Common":
                        holder.typeOfSport.setImageResource(R.drawable.stadium);
                        break;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        holder.eventName.setText(events.getEventName_());

        if (events.getFrom_().equals(events.getTo_())){
            holder.fromDate.setText(events.getFrom_());
            holder.toText.setText("");
            holder.toDate.setText("");
        }else {
            holder.fromDate.setText(events.getFrom_());
            holder.toDate.setText(events.getTo_());
            holder.toText.setText("-");
        }

        final int min = 1;
        final int max = 4;
        final int random = new Random().nextInt((max - min) + 1) + min;
        switch (random){

            case 1:
                holder.cardBackground.setImageResource(R.drawable.bg2_);
                break;

            case 2:
                holder.cardBackground.setImageResource(R.drawable.bg3_);
                break;

            case 3:
                holder.cardBackground.setImageResource(R.drawable.bg4_);
                break;

            case 4:
                holder.cardBackground.setImageResource(R.drawable.bg5_);
                break;

        }

        holder.cardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, EventActivity.class);
                intent.putExtra("eventId",events.getEventId_());
                Log.i("info",events.getEventId_());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        public ImageView typeOfSport;
        public TextView eventName;
        public TextView fromDate;
        public TextView toText;
        public TextView toDate;
        public TextView stadiumName;

        ImageView cardBackground;
        Button cardBtn;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            typeOfSport = itemView.findViewById(R.id.type_of_game_item);
            eventName = itemView.findViewById(R.id.event_name_item);
            fromDate = itemView.findViewById(R.id.from_date_item);
            toDate = itemView.findViewById(R.id.to_date_item);
            toText = itemView.findViewById(R.id.to_text);
            stadiumName = itemView.findViewById(R.id.stadium_name_item);
            cardBtn = itemView.findViewById(R.id.card_btn);
            cardBackground = itemView.findViewById(R.id.card_background);
        }
    }

}
