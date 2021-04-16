package com.nithishkumar.seatplop.MainCourse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.nithishkumar.seatplop.R;
import com.nithishkumar.seatplop.TicketActivity;

public class StadiumSectorSelectionActivity extends AppCompatActivity {

    String noOfSeats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium_sector_selection);

        noOfSeats = getIntent().getStringExtra("noOfSeats");

    }

    public void Aupper(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in A - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in A - upper");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in A - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in A - lower");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in B - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in B - upper");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in B - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in B - lower");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in C - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in C - upper");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in C - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in C - lower");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in D - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in D - upper");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in D - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in D - lower");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in E - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in E - upper");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in E - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in E - lower");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in F - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in F - upper");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in F - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in F - lower");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in G - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in G - upper");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in G - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in G - lower");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in H - upper sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in H - upper");
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
        AlertDialog.Builder builder= new AlertDialog.Builder(StadiumSectorSelectionActivity.this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure that you want to book " + noOfSeats + " seats in H - lower sector")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(StadiumSectorSelectionActivity.this, TicketActivity.class);
                        intent.putExtra("listViewContent","Booked "+noOfSeats+" seats in H - lower");
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