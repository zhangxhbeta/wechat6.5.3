package com.tencent.pb.common.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;

public final class h {
    public static boolean ppF = true;
    private static long ppG = -1;
    public static int ppH = a.ppJ;
    private static int ppI = a.ppJ;

    public enum a {
        ;

        static {
            ppJ = 1;
            ppK = 2;
            ppL = 3;
            ppM = new int[]{ppJ, ppK, ppL};
        }
    }

    private static NetworkInfo getNetworkInfo() {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) d.kzS.getSystemService("connectivity");
        } catch (Exception e) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            c.i("getSystemService(Context.CONNECTIVITY_SERVICE) null", new Object[0]);
            return null;
        }
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th) {
            c.i("getActiveNetworkInfo exception:", th);
            activeNetworkInfo = null;
        }
        return activeNetworkInfo;
    }

    public static boolean isNetworkConnected() {
        try {
            NetworkInfo networkInfo = getNetworkInfo();
            if (networkInfo == null) {
                return false;
            }
            return networkInfo.isConnected();
        } catch (Exception e) {
            return true;
        }
    }
}
