package com.tencent.c.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s {
    static boolean aM(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }
        return true;
    }

    static boolean aN(String str) {
        if (str == null || str.trim().length() < 40) {
            return false;
        }
        return true;
    }

    static g a(g gVar, g gVar2) {
        if (gVar == null || gVar2 == null) {
            if (gVar != null) {
                return gVar;
            }
            if (gVar2 != null) {
                return gVar2;
            }
            return null;
        } else if (gVar.a(gVar2) >= 0) {
            return gVar;
        } else {
            return gVar2;
        }
    }

    static boolean b(g gVar, g gVar2) {
        if (gVar == null || gVar2 == null) {
            if (gVar == null && gVar2 == null) {
                return true;
            }
            return false;
        } else if (gVar.a(gVar2) == 0) {
            return true;
        } else {
            return false;
        }
    }

    static boolean l(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    static boolean U(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getTypeName() == null || !activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI"))) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    static void b(JSONObject jSONObject, String str, String str2) {
        if (aM(str2)) {
            jSONObject.put(str, str2);
        }
    }

    static String decode(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(l.encrypt(Base64.decode(str.getBytes("UTF-8"), 0), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), "UTF-8").trim().replace("\t", SQLiteDatabase.KeyEmpty).replace("\n", SQLiteDatabase.KeyEmpty).replace("\r", SQLiteDatabase.KeyEmpty);
        } catch (Throwable th) {
            return str;
        }
    }

    static String encode(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(l.encrypt(str.getBytes("UTF-8"), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), 0), "UTF-8").trim().replace("\t", SQLiteDatabase.KeyEmpty).replace("\n", SQLiteDatabase.KeyEmpty).replace("\r", SQLiteDatabase.KeyEmpty);
        } catch (Throwable th) {
            return str;
        }
    }

    static String V(Context context) {
        try {
            if (l(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            }
        } catch (Throwable th) {
        }
        return SQLiteDatabase.KeyEmpty;
    }

    static String W(Context context) {
        if (!l(context, "android.permission.ACCESS_WIFI_STATE")) {
            return SQLiteDatabase.KeyEmpty;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return SQLiteDatabase.KeyEmpty;
            }
            return wifiManager.getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            new StringBuilder("get wifi address error").append(e);
            return SQLiteDatabase.KeyEmpty;
        }
    }

    private static WifiInfo getWifiInfo(Context context) {
        if (l(context, "android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
        }
        return null;
    }

    static String X(Context context) {
        try {
            WifiInfo wifiInfo = getWifiInfo(context);
            if (wifiInfo != null) {
                return wifiInfo.getBSSID();
            }
        } catch (Throwable th) {
        }
        return null;
    }

    static String Y(Context context) {
        try {
            WifiInfo wifiInfo = getWifiInfo(context);
            if (wifiInfo != null) {
                return wifiInfo.getSSID();
            }
        } catch (Throwable th) {
        }
        return null;
    }

    static JSONArray Z(Context context) {
        try {
            if (l(context, "android.permission.INTERNET") && l(context, "android.permission.ACCESS_NETWORK_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null) {
                    List scanResults = wifiManager.getScanResults();
                    if (scanResults != null && scanResults.size() > 0) {
                        Collections.sort(scanResults, new Comparator<ScanResult>() {
                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                ScanResult scanResult = (ScanResult) obj2;
                                int abs = Math.abs(((ScanResult) obj).level);
                                int abs2 = Math.abs(scanResult.level);
                                if (abs > abs2) {
                                    return 1;
                                }
                                return abs == abs2 ? 0 : -1;
                            }
                        });
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

    static String aa(Context context) {
        String str = null;
        try {
            if (l(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    externalStorageState = Environment.getExternalStorageDirectory().getPath();
                    if (externalStorageState != null) {
                        StatFs statFs = new StatFs(externalStorageState);
                        long availableBlocks = (long) statFs.getAvailableBlocks();
                        str = new StringBuilder(String.valueOf(String.valueOf((((long) statFs.getBlockSize()) * availableBlocks) / 1000000))).append("/").append(String.valueOf((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000)).toString();
                    }
                }
            }
        } catch (Throwable th) {
        }
        return str;
    }

    static String nX() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            return new StringBuilder(String.valueOf(String.valueOf((((long) statFs.getAvailableBlocks()) * blockSize) / 1000000))).append("/").append(String.valueOf((((long) statFs.getBlockCount()) * blockSize) / 1000000)).toString();
        } catch (Throwable th) {
            return SQLiteDatabase.KeyEmpty;
        }
    }

    static String ab(Context context) {
        try {
            if (!l(context, "android.permission.INTERNET") || !l(context, "android.permission.ACCESS_NETWORK_STATE")) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (typeName != null) {
                    if (typeName.equalsIgnoreCase("WIFI")) {
                        return "WIFI";
                    }
                    if (typeName.equalsIgnoreCase("MOBILE")) {
                        if (extraInfo == null) {
                            return "MOBILE";
                        }
                        return extraInfo;
                    } else if (extraInfo == null) {
                        return typeName;
                    } else {
                        return extraInfo;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
        }
    }
}
