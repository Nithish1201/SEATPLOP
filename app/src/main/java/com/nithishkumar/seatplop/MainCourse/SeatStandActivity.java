package com.nithishkumar.seatplop.MainCourse;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.nithishkumar.seatplop.R;

import java.util.ArrayList;

public class SeatStandActivity extends AppCompatActivity {

    ListView seatStandListView;
    //ArrayList<String> stands;
    String[] stands = {"fdgdffg","sgg","faf"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_stand);

        seatStandListView = findViewById(R.id.stand_list_view_seatstandactivity);
        //stands = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stands);

        /**stands.add("content");
        stands.add("C Upper");
        stands.add("C Lower");
        stands.add("D Upper");
        stands.add("D Lower");
        stands.add("E Upper");
        stands.add("E Lower");
        stands.add("F Upper");
        stands.add("F Lower");
        stands.add("G Upper");
        stands.add("G Lower");
        stands.add("H Upper");
        stands.add("H Lower");

        stands.add("P.T Special Box");
        stands.add("Terrace Bay");
        stands.add("MCC Terrace");
        stands.add("MCC Pavilion");
        stands.add("Anna Pavilion");**/

        seatStandListView.setAdapter(arrayAdapter);

    }
}