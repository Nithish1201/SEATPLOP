package com.nithishkumar.seatplop.MainCourse;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.nithishkumar.seatplop.R;

import java.util.ArrayList;

public class SeatStandActivity extends AppCompatActivity {

    String noOfSeats;

    String date;
    String month;
    String year;
    String time;
    String session;
    String eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_stand);

        noOfSeats = getIntent().getStringExtra("noOfSeats");
        date = getIntent().getStringExtra("date");
        month = getIntent().getStringExtra("month");
        year = getIntent().getStringExtra("year");
        time = getIntent().getStringExtra("time");
        session = getIntent().getStringExtra("session");
        eventId = getIntent().getStringExtra("eventId");


    }

    public void Aupper(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in A - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in A - upper for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Alower(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in A - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in A - lower for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Bupper(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in B - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in B - upper for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Blower(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in B - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in B - lower for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Cupper(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in C - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in C - upper for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Clower(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in C - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in C - lower for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Dupper(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in D - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in D - upper for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Dlower(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in D - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in D - lower  for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Eupper(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in E - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in E - upper for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Elower(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in E - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in E - lower for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Fupper(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in F - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in F - upper for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Flower(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in F - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in F - lower for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Gupper(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in G - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in G - upper for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Glower(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in G - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in G - lower for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Hupper(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in H - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in H - upper for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Hlower(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(SeatStandActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in H - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SeatStandActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in H - lower for a event on "+date+"-"+month+"-"+year+" at "+time+", "+session);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}