package com.nithishkumar.seatplop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nithishkumar.seatplop.Model.Events;
import com.nithishkumar.seatplop.Model.Stadiums;
import com.nithishkumar.seatplop.R;

import java.util.List;
import java.util.Random;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.Viewholder> {

    private Context mContext;
    private List<Events> mEvents;

    public EventAdapter(Context mContext, List<Events> mEvents) {
        this.mContext = mContext;
        this.mEvents = mEvents;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.event_item,parent,false);
        return new EventAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final EventAdapter.Viewholder holder, int position) {

        final Events events = mEvents.get(position);

        holder.eventName.setText(events.getName());

        if (events.getFrom().equals(events.getTo())){
            holder.from.setText(events.getFrom());
            holder.toText.setText("");
            holder.to.setText("");
        }else {
            holder.from.setText(events.getFrom());
            holder.to.setText(events.getTo());
        }

        holder.totalTime.setText(events.getTime());

        /**
        FirebaseDatabase.getInstance().getReference().child("Stadiums").child(events.getStadium()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Stadiums stadiums = snapshot.getValue(Stadiums.class);

                holder.stadiumName.setText(stadiums.getName());

                switch (stadiums.getTypeOfSport()){
                    case "Cricket":
                        holder.typeOfSport.setImageResource(R.drawable.cricket);
                        break;
                    case "Football":
                        holder.typeOfSport.setImageResource(R.drawable.football);
                        break;
                    case "Horse racing":
                        holder.typeOfSport.setImageResource(R.drawable.racehorse);
                        break;
                    case "Motorsport":
                        holder.typeOfSport.setImageResource(R.drawable.motorcycle);
                        break;
                    case "Athlete":
                        holder.typeOfSport.setImageResource(R.drawable.running);
                        break;
                    case "Hockey":
                        holder.typeOfSport.setImageResource(R.drawable.hockey);
                        break;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /**
        final int min = 1;
        final int max = 2;
        final int random = new Random().nextInt((max - min) + 1) + min;
        String num = String.valueOf(random);

        switch (num){
            case "1":
                holder.cardBackground.setBackground(R.drawable.round_red);
        }
         **/

    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public  class Viewholder extends RecyclerView.ViewHolder{

        public RelativeLayout cardBackground;
        public ImageView typeOfSport;
        public TextView eventName;
        public TextView from;
        public TextView toText;
        public TextView to;
        public TextView totalTime;
        public TextView stadiumName;
        public Button cardBtn;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            cardBackground = itemView.findViewById(R.id.card_background);
            typeOfSport = itemView.findViewById(R.id.type_of_game);
            eventName = itemView.findViewById(R.id.event_name);
            from = itemView.findViewById(R.id.from);
            toText = itemView.findViewById(R.id.to_text);
            to = itemView.findViewById(R.id.to);
            totalTime = itemView.findViewById(R.id.total_time);
            stadiumName = itemView.findViewById(R.id.stadium_name);
            cardBtn = itemView.findViewById(R.id.card_btn);

        }
    }

}
