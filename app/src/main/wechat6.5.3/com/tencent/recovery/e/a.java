package com.tencent.recovery.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import java.security.MessageDigest;
import java.util.UUID;

public final class a {
    public static final int eU(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("recovery-info", 0);
        int i = sharedPreferences.getInt("KeySafeModeUUID", -1);
        if (i != -1) {
            return i;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Secure.getString(context.getContentResolver(), "android_id"));
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
        String macAddress = connectionInfo != null ? connectionInfo.getMacAddress() : null;
        if (macAddress == null) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            macAddress = defaultAdapter != null ? defaultAdapter.getAddress() : null;
        }
        if (macAddress == null) {
            macAddress = UUID.randomUUID().toString();
        }
        stringBuffer.append(macAddress);
        stringBuffer.append(Build.MANUFACTURER + Build.MODEL);
        i = ("A" + m(stringBuffer.toString().getBytes()).substring(0, 15)).hashCode();
        sharedPreferences.edit().putInt("KeySafeModeUUID", i).commit();
        return i;
    }

    private static final String m(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }
}
