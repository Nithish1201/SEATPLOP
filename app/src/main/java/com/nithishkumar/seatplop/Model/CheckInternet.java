package com.nithishkumar.seatplop.Model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class CheckInternet {

    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiCon = connectivityManager.getNetworkInfo(connectivityManager.TYPE_WIFI);
        NetworkInfo mobileCon = connectivityManager.getNetworkInfo(connectivityManager.TYPE_MOBILE);

        if ((wifiCon != null && wifiCon.isConnected() || (mobileCon != null && mobileCon.isConnected()))){
            return true;
        }else {
            return false;
        }
    }
}
