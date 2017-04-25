package ct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import com.tencent.mmdb.database.SQLiteDatabase;
import ct.b.a;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public final class da {
    public static boolean a = false;
    private static long b = 0;
    private static boolean c = false;

    @SuppressLint({"NewApi"})
    public static boolean a(bk bkVar) {
        WifiManager b = bkVar.b();
        boolean z = false;
        if (b != null) {
            z = b.isWifiEnabled();
            if (!z) {
                try {
                    if (VERSION.SDK_INT >= 18) {
                        z = b.isScanAlwaysAvailable();
                    }
                } catch (Exception e) {
                } catch (Error e2) {
                }
            }
        }
        return z;
    }

    public static String a() {
        String str;
        String str2 = SQLiteDatabase.KeyEmpty;
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if (networkInterface != null && networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (!(hardwareAddress == null || hardwareAddress.length == 0)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                        }
                        if (stringBuilder.length() > 0) {
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        }
                        str2 = stringBuilder.toString();
                        a.b("Wifis", "interfaceName=" + networkInterface.getName() + ", mac=" + str2);
                    }
                }
            }
            return str2;
        } catch (Exception e) {
            Exception exception = e;
            str = str2;
            a.b("Wifis", exception.toString());
            return str;
        } catch (Error e2) {
            Error error = e2;
            str = str2;
            a.b("Wifis", error.toString());
            return str;
        }
    }

    public static synchronized boolean a(WifiManager wifiManager) {
        boolean z;
        synchronized (da.class) {
            z = false;
            if (wifiManager != null) {
                try {
                    if (System.currentTimeMillis() - b > 4000) {
                        a.b("wifis", "force scan");
                        z = wifiManager.startScan();
                        c = z;
                        b = System.currentTimeMillis();
                    } else {
                        z = c;
                    }
                } catch (Exception e) {
                    a = true;
                }
            }
        }
        return z;
    }

    public static List<ScanResult> b(WifiManager wifiManager) {
        List<ScanResult> list = null;
        if (wifiManager != null) {
            try {
                list = wifiManager.getScanResults();
                a = false;
            } catch (Exception e) {
                a = true;
            }
        }
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public static String b(bk bkVar) {
        Context context = bkVar.a;
        if (context == null) {
            return "{}";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (wifiManager == null || connectivityManager == null) {
                return "{}";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (connectionInfo == null || networkInfo == null || !networkInfo.isConnected()) {
                return "{}";
            }
            String bssid = connectionInfo.getBSSID();
            if (bssid == null || bssid.equals("000000000000") || bssid.equals("00-00-00-00-00-00") || bssid.equals("00:00:00:00:00:00")) {
                return "{}";
            }
            int rssi = connectionInfo.getRssi();
            if (rssi < -100 || rssi > -20) {
                return "{}";
            }
            String replace = connectionInfo.getSSID().replace("\"", SQLiteDatabase.KeyEmpty).replace("|", SQLiteDatabase.KeyEmpty);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{");
            stringBuilder.append("\"mac\":\"");
            stringBuilder.append(bssid);
            stringBuilder.append("\",\"rssi\":");
            stringBuilder.append(rssi);
            stringBuilder.append(",\"ssid\":\"");
            stringBuilder.append(replace);
            stringBuilder.append("\"}");
            return stringBuilder.toString();
        } catch (Exception e) {
            return "{}";
        }
    }
}
