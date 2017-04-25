package ct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

public final class at {
    private static at a;

    private at(Context context) {
        context.getApplicationContext();
    }

    public static synchronized at a(Context context) {
        at atVar;
        synchronized (at.class) {
            if (a == null && context != null) {
                a = new at(context.getApplicationContext());
            }
            atVar = a;
        }
        return atVar;
    }

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            return "null";
        }
    }

    public static String b() {
        try {
            return VERSION.RELEASE;
        } catch (Throwable th) {
            return "null";
        }
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        String deviceId;
        try {
            deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Throwable th) {
            deviceId = null;
        }
        return deviceId;
    }

    public static String c() {
        try {
            return VERSION.SDK;
        } catch (Throwable th) {
            return "null";
        }
    }

    public static String c(Context context) {
        if (context == null) {
            return null;
        }
        String subscriberId;
        try {
            subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Throwable th) {
            subscriberId = null;
        }
        return subscriberId;
    }

    public static String d() {
        String str = null;
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            return str;
        }
    }

    public static String d(Context context) {
        String str = null;
        if (context != null) {
            try {
                str = Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable th) {
            }
        }
        return str;
    }

    public static String e(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Throwable th) {
            return null;
        }
    }

    public static String f(Context context) {
        String str = "unknown";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return str;
            }
            String str2;
            if (activeNetworkInfo.getType() == 1) {
                str2 = "wifi";
            } else {
                if (activeNetworkInfo.getType() == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        switch (telephonyManager.getNetworkType()) {
                            case 1:
                                str2 = "GPRS";
                                break;
                            case 2:
                                str2 = "EDGE";
                                break;
                            case 3:
                                str2 = "UMTS";
                                break;
                            case 4:
                                str2 = "CDMA";
                                break;
                            case 5:
                                str2 = "EVDO_0";
                                break;
                            case 6:
                                str2 = "EVDO_A";
                                break;
                            case 7:
                                str2 = "1xRTT";
                                break;
                            case 8:
                                str2 = "HSDPA";
                                break;
                            case 9:
                                str2 = "HSUPA";
                                break;
                            case 10:
                                str2 = "HSPA";
                                break;
                            case 11:
                                str2 = "iDen";
                                break;
                            default:
                                str2 = "unknown";
                                break;
                        }
                    }
                }
                str2 = str;
            }
            return str2;
        } catch (Exception e) {
        }
    }
}
