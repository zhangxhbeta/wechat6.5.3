package ct;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class be {
    private static String a = SQLiteDatabase.KeyEmpty;
    private static String b = SQLiteDatabase.KeyEmpty;

    public static int a(byte[] bArr) {
        return ((((bArr[0] << 24) & WebView.NIGHT_MODE_COLOR) + ((bArr[1] << 16) & 16711680)) + ((bArr[2] << 8) & 65280)) + (bArr[3] & WebView.NORMAL_MODE_ALPHA);
    }

    public static String a() {
        Object obj = 1;
        try {
            String str = a;
            if (str != null) {
                if (str.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                Context context = p.a;
                if (context != null) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        a = telephonyManager.getDeviceId();
                    }
                }
            }
        } catch (Exception e) {
        }
        return a;
    }

    public static String a(Context context) {
        Object obj = 1;
        if (context == null) {
            return null;
        }
        try {
            String str = a;
            if (str != null) {
                if (str.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    a = telephonyManager.getDeviceId();
                }
            }
        } catch (Exception e) {
        }
        return a;
    }

    public static String a(Exception exception) {
        String stackTraceString = Log.getStackTraceString(exception);
        return stackTraceString != null ? (stackTraceString.indexOf("\n") == -1 || stackTraceString.indexOf("\n") >= 100) ? stackTraceString.length() > 100 ? stackTraceString.substring(0, 100) : stackTraceString : stackTraceString.substring(0, stackTraceString.indexOf("\n")) : SQLiteDatabase.KeyEmpty;
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String b(Context context) {
        Object obj = 1;
        if (context == null) {
            return null;
        }
        try {
            String str = b;
            if (str != null) {
                if (str.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo != null) {
                        b = connectionInfo.getMacAddress();
                    }
                }
            }
        } catch (Exception e) {
        }
        return b;
    }

    public static String b(String str) {
        String str2 = SQLiteDatabase.KeyEmpty;
        Context context = p.a;
        try {
            StringBuilder stringBuilder = new StringBuilder(SQLiteDatabase.KeyEmpty);
            Object a = a(context);
            if (!TextUtils.isEmpty(a)) {
                stringBuilder.append(a);
            }
            Object b = b(context);
            if (!TextUtils.isEmpty(b)) {
                stringBuilder.append(b);
            }
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append(str);
            stringBuilder.append((int) (Math.random() * 2.147483647E9d));
            str2 = d(stringBuilder.toString());
        } catch (Exception e) {
        }
        return str2;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        String str = SQLiteDatabase.KeyEmpty;
        for (int i = 0; i < bArr.length; i++) {
            str = (str + Integer.toHexString((bArr[i] >> 4) & 15)) + Integer.toHexString(bArr[i] & 15);
        }
        return str;
    }

    public static String c(String str) {
        return (str == null || str.length() == 0) ? null : (str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https://")) ? str : "http://" + str;
    }

    private static String d(String str) {
        String str2 = null;
        if (str == null || str.length() == 0) {
            return str2;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            if (digest == null) {
                return SQLiteDatabase.KeyEmpty;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & WebView.NORMAL_MODE_ALPHA);
                if (toHexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(toHexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            return str2;
        }
    }
}
