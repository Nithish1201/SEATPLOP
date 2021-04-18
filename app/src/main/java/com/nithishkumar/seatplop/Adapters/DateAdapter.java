package com.nithishkumar.seatplop.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;
import com.nithishkumar.seatplop.MainCourse.DateTimeActivity;
import com.nithishkumar.seatplop.Model.Date;
import com.nithishkumar.seatplop.Model.Events;
import com.nithishkumar.seatplop.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.Viewholder> {

    private Context mContext;
    private List<Date> mdates;

    int index = 0;
    SharedPreferences sharedPreferences;

    public DateAdapter(Context mContext, List<Date> mdates) {
        this.mContext = mContext;
        this.mdates = mdates;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.date_item,parent,false);
        return new DateAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        final Date date = mdates.get(position);

        holder.date.setText(date.getDate());
        holder.month.setText(date.getMonth());
        holder.year.setText(date.getYear());


        holder.clickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = position;
                notifyDataSetChanged();
            }
        });

        if (index == position){
            holder.bgImage.setImageResource(R.drawable.color_primary_with_border);
            Intent intent = new Intent("dateAdapterValues");
            intent.putExtra("date",date.getDate());
            intent.putExtra("month",date.getMonth());
            intent.putExtra("year",date.getYear());
            LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
        } else{
            holder.bgImage.setImageResource(R.drawable.black_border);
        }
    }


    @Override
    public int getItemCount() {
        return mdates.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        public TextView date;
        public TextView month;
        public TextView year;

        public ImageView bgImage;
        public Button clickImage;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date_item_date_txt);
            month = itemView.findViewById(R.id.date_item_month_txt);
            year = itemView.findViewById(R.id.date_item_year_txt);

            bgImage = itemView.findViewById(R.id.date_item_bg_img);
            clickImage = itemView.findViewById(R.id.date_item_click);
        }
    }

}
