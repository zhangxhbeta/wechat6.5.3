package com.tencent.wxop.stat.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r {
    private static String a = "";

    public static String a(Context context) {
        try {
            if (k(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(g.b(h.bC(str.getBytes("UTF-8"))), "UTF-8");
        } catch (Throwable th) {
            return str;
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
            }
        }
    }

    public static String b(Context context) {
        if (!k(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            return "";
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(h.bD(g.a(str.getBytes("UTF-8"))), "UTF-8");
        } catch (Throwable th) {
            return str;
        }
    }

    public static String d(Context context) {
        try {
            WifiInfo hq = hq(context);
            if (hq != null) {
                return hq.getBSSID();
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String e(Context context) {
        try {
            WifiInfo hq = hq(context);
            if (hq != null) {
                return hq.getSSID();
            }
        } catch (Throwable th) {
        }
        return null;
    }

    private static WifiInfo hq(Context context) {
        if (k(context, "android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
        }
        return null;
    }

    public static boolean hr(Context context) {
        try {
            if (k(context, "android.permission.INTERNET") && k(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static JSONArray hs(Context context) {
        try {
            if (k(context, "android.permission.INTERNET") && k(context, "android.permission.ACCESS_NETWORK_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null) {
                    List scanResults = wifiManager.getScanResults();
                    if (scanResults != null && scanResults.size() > 0) {
                        Collections.sort(scanResults, new s());
                        JSONArray jSONArray = new JSONArray();
                        int i = 0;
                        while (i < scanResults.size() && i < 10) {
                            ScanResult scanResult = (ScanResult) scanResults.get(i);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bs", scanResult.BSSID);
                            jSONObject.put("ss", scanResult.SSID);
                            jSONArray.put(jSONObject);
                            i++;
                        }
                        return jSONArray;
                    }
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static boolean k(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            return false;
        }
    }
}
