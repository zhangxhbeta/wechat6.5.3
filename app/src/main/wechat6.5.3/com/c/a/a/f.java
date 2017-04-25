package com.c.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    final SensorManager aHA;
    final PackageManager aHB;
    PackageInfo aHC;
    String aHD;
    String aHE;
    String aHF;
    private int aHG = 0;
    private int aHH = 0;
    int aHI = 0;
    int aHJ = 0;
    int aHK = 0;
    int aHL = 0;
    private String aHM = "203";
    private final WifiManager aHy;
    private final LocationManager aHz;
    String imei;
    final Context mContext;
    private String version = "2.0.1";
    String versionName;

    public f(Context context) {
        this.mContext = context;
        this.aHy = (WifiManager) this.mContext.getSystemService("wifi");
        this.aHz = (LocationManager) this.mContext.getSystemService("location");
        this.aHA = (SensorManager) this.mContext.getSystemService("sensor");
        this.aHB = this.mContext.getPackageManager();
        this.aHC = new PackageInfo();
        try {
            this.aHC = this.aHB.getPackageInfo(this.mContext.getPackageName(), 0);
        } catch (NameNotFoundException e) {
        }
    }

    public final String j(byte[] bArr) {
        int i;
        int i2 = 1;
        Object hashMap = new HashMap();
        hashMap.put("version", this.version);
        hashMap.put("app_name", ay(this.versionName));
        if (this.aHD != null) {
            hashMap.put("app_label", ay(Base64.encodeToString(this.aHD.getBytes(), 0)));
        } else {
            hashMap.put("app_label", SQLiteDatabase.KeyEmpty);
        }
        String str = "chips";
        if (nf()) {
            i = 1;
        } else {
            i = 0;
        }
        this.aHH = i;
        i = (this.aHy == null || !this.aHy.isWifiEnabled()) ? 0 : 1;
        if ((i | ng()) == 0) {
            i2 = 0;
        }
        this.aHG = i2;
        hashMap.put(str, Integer.toBinaryString((((((this.aHL | 0) | (this.aHK << 1)) | (this.aHJ << 2)) | (this.aHI << 3)) | (this.aHH << 4)) | (this.aHG << 5)));
        hashMap.put("source", this.aHM);
        hashMap.put("query", new String(bArr));
        try {
            Map hashMap2 = new HashMap();
            hashMap2.put("model", ay(Base64.encodeToString(this.aHE.getBytes(), 0)));
            hashMap2.put("version", ay(this.aHF));
            hashMap2.put("imei", ay(this.imei));
            return new JSONObject(hashMap).put("attribute", new JSONObject(hashMap2)).toString();
        } catch (JSONException e) {
            return null;
        }
    }

    private static String ay(String str) {
        if (str == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        return str;
    }

    private boolean nf() {
        boolean z = false;
        try {
            z = this.aHz.isProviderEnabled("gps");
        } catch (Exception e) {
        }
        return z;
    }

    @SuppressLint({"NewApi"})
    private boolean ng() {
        boolean z = false;
        if (this.aHy != null) {
            z = this.aHy.isWifiEnabled();
            if (!z) {
                try {
                    if (VERSION.SDK_INT >= 18) {
                        z = this.aHy.isScanAlwaysAvailable();
                    }
                } catch (Exception e) {
                } catch (Error e2) {
                }
            }
        }
        return z;
    }
}
