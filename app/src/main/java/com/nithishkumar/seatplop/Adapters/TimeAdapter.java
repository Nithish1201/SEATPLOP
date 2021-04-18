package com.nithishkumar.seatplop.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nithishkumar.seatplop.Model.Time;
import com.nithishkumar.seatplop.R;

import java.util.List;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.Viewholder>{

    private Context mContext;
    private List<Time> mTimes;

    int index = -1;

    public TimeAdapter(Context mContext, List<Time> mTimes) {
        this.mContext = mContext;
        this.mTimes = mTimes;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.time_item,parent,false);
        return new TimeAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Time time = mTimes.get(position);

        holder.time.setText(time.getTime());
        holder.session.setText(time.getSession());

        holder.clickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = position;
                notifyDataSetChanged();
            }
        });

        if (index == position){
            holder.bgImage.setImageResource(R.drawable.black_border);
            Intent intent = new Intent("timeAdapterValues");
            intent.putExtra("time",time.getTime());
            LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
        } else{
            holder.bgImage.setImageResource(R.drawable.black_border);
        }

    }

    @Override
    public int getItemCount() {
        return mTimes.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        public TextView time;
        public TextView session;

        public ImageView bgImage;
        public Button clickImage;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            time = itemView.findViewById(R.id.time_item_time_txt);
            session = itemView.findViewById(R.id.time_item_session_txt);

            bgImage = itemView.findViewById(R.id.time_item_bg_img);
            clickImage = itemView.findViewById(R.id.time_item_click);

        }
    }

}
