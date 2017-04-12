package test.farhan.cleanarchitecture.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class CheckInternet {
    public static boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
//should check null because in air plan mode it will be null
            return (netInfo != null && netInfo.isConnected());
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
