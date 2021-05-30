package com.nithishkumar.seatplop.MainCourse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.nithishkumar.seatplop.R;

import java.util.ArrayList;

public class SeatStandActivity extends AppCompatActivity {

    ListView standListView;
    ArrayList<String> stands;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_stand);

        standListView = findViewById(R.id.stand_list_view);
        stands = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_2,android.R.id.text1,stands) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                text1.setText(stands.get(position));
                text2.setText("40");
                return view;
            }
        };
        standListView.setAdapter(arrayAdapter);

        addElementsToList();

    }

    private void addElementsToList() {

    }
}