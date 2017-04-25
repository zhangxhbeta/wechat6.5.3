package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.pb.common.c.d;
import java.io.BufferedOutputStream;

public final class k {
    public static boolean kzO = false;
    static BufferedOutputStream kzP = null;

    public static int gB(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 4;
            }
            if (activeNetworkInfo.getSubtype() == 3) {
                return 3;
            }
            if (activeNetworkInfo.getSubtype() > 0 && activeNetworkInfo.getSubtype() < 5) {
                return 1;
            }
            if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                return 3;
            }
            if (activeNetworkInfo.getSubtype() >= 13) {
                return 3;
            }
            return 2;
        } catch (Exception e) {
            return 2;
        }
    }

    private static int getNetType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 4;
            }
            if (activeNetworkInfo.getSubtype() == 3) {
                return 3;
            }
            if (activeNetworkInfo.getSubtype() > 0 && activeNetworkInfo.getSubtype() < 5) {
                return 1;
            }
            if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                return 3;
            }
            if (activeNetworkInfo.getSubtype() >= 13) {
                return 5;
            }
            return 2;
        } catch (Exception e) {
            return 2;
        }
    }

    public static boolean bPS() {
        return getNetType(d.kzS) == 4;
    }
}
