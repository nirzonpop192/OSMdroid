package com.example.faisal.offmap.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;

/**
 * Created by Faisal  on 9/30/2016.
 */

public class NetManager {

/*
   todo: work in later
    @TargetApi(21)
    public static boolean isNetworkAvailable(Context context,int lable) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network[] nets = cm.getAllNetworks();
        for (NetworkInfo net : nets){
            net.equals;
        }


    }*/

    /**
     *
     * @param context invoking activity
     * @return sate of internet available
     */

    public static boolean isNetworkAvailable(Context context) {

        boolean netAvailable=false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();

        for (NetworkInfo net : netInfo){
           if( net.isConnected()){
               netAvailable=true;
               break;
           }
        }
        return netAvailable;
    }
}
