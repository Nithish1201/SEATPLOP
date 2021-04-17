package com.nithishkumar.seatplop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nithishkumar.seatplop.Model.Date;
import com.nithishkumar.seatplop.Model.Events;
import com.nithishkumar.seatplop.R;

import java.util.List;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.Viewholder> {

    private Context mContext;
    private List<Date> mdates;

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

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date_item_date_txt);
            month = itemView.findViewById(R.id.date_item_month_txt);
            year = itemView.findViewById(R.id.date_item_year_txt);

            bgImage = itemView.findViewById(R.id.date_item_bg_img);

        }
    }

}
