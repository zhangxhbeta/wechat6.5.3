package ct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public class bc {
    public static String a = "nonetwork";
    public static String b = SQLiteDatabase.KeyEmpty;
    public static String c = SQLiteDatabase.KeyEmpty;
    public static volatile boolean d = false;
    private static final String e = bc.class.getSimpleName();
    private static String f = "cmwap";
    private static String g = "3gwap";
    private static String h = "uniwap";
    private static String i = "ctwap";
    private static String j = "wifi";
    private static Context k;
    private static volatile boolean l = true;
    private static String m = SQLiteDatabase.KeyEmpty;
    private static volatile int n = 0;
    private static int o = 0;
    private static String p = SQLiteDatabase.KeyEmpty;

    public static synchronized String a() {
        String str;
        synchronized (bc.class) {
            switch (n) {
                case 1:
                    str = "ssid_" + m + c;
                    break;
                case 2:
                case 3:
                    str = "apn_" + b;
                    break;
                case 4:
                    str = "4Gapn_" + b;
                    break;
                default:
                    str = "unknown";
                    break;
            }
        }
        return str;
    }

    public static void a(Context context) {
        try {
            k = context;
            b();
            h();
        } catch (Throwable th) {
        }
    }

    public static synchronized boolean a(Integer num) {
        boolean z = true;
        synchronized (bc.class) {
            if (!(num.intValue() == 1 || num.intValue() == 2 || num.intValue() == 3)) {
                z = false;
            }
        }
        return z;
    }

    public static synchronized void b() {
        synchronized (bc.class) {
            try {
                bd.b();
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) k.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    b = SQLiteDatabase.KeyEmpty;
                    n = 0;
                    d = false;
                    p = SQLiteDatabase.KeyEmpty;
                    l = false;
                    b = a;
                } else {
                    if (activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                        l = true;
                    } else {
                        l = false;
                        b = a;
                    }
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        n = 1;
                        d = false;
                        p = SQLiteDatabase.KeyEmpty;
                        WifiInfo connectionInfo = ((WifiManager) k.getSystemService("wifi")).getConnectionInfo();
                        m = connectionInfo.getSSID();
                        c = connectionInfo.getBSSID();
                        b = j;
                    } else {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        if (extraInfo == null) {
                            b = SQLiteDatabase.KeyEmpty;
                            n = 0;
                            d = false;
                            p = SQLiteDatabase.KeyEmpty;
                        } else {
                            b = extraInfo.trim().toLowerCase();
                            if (type == 0) {
                                int subtype = activeNetworkInfo.getSubtype();
                                if (subtype == 1 || subtype == 2 || subtype == 4) {
                                    n = 2;
                                } else if (subtype == 13) {
                                    n = 4;
                                } else {
                                    n = 3;
                                }
                            }
                            o = i().intValue();
                            if (b.contains(g)) {
                                d = true;
                                p = "10.0.0.172";
                            } else if (b.contains(f)) {
                                d = true;
                                p = "10.0.0.172";
                            } else if (b.contains(h)) {
                                d = true;
                                p = "10.0.0.172";
                            } else if (b.contains(i)) {
                                d = true;
                                p = "10.0.0.200";
                            } else {
                                d = false;
                                p = SQLiteDatabase.KeyEmpty;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public static synchronized int c() {
        int i;
        synchronized (bc.class) {
            i = n;
        }
        return i;
    }

    public static synchronized int d() {
        int i;
        synchronized (bc.class) {
            i = o;
        }
        return i;
    }

    public static boolean e() {
        return l;
    }

    public static boolean f() {
        return n == 1;
    }

    public static Proxy g() {
        return (!d || TextUtils.isEmpty(p)) ? null : new Proxy(Type.HTTP, new InetSocketAddress(p, 80));
    }

    private static synchronized void h() {
        synchronized (bc.class) {
            new StringBuilder("showApnInfo... Apn:").append(b).append(",sIsNetworkOk:").append(l).append(",sNetType:").append(n).append(",sIsProxy:").append(d).append(",sProxyAddress:").append(p);
            bd.b();
        }
    }

    private static synchronized Integer i() {
        Integer valueOf;
        int i = 3;
        int i2 = 2;
        int i3 = 1;
        synchronized (bc.class) {
            if (n == 1) {
                String str = m;
                if (str == null || str.length() <= 0) {
                    valueOf = Integer.valueOf(0);
                } else {
                    str = str.toLowerCase();
                    if (!str.contains("cmcc")) {
                        i3 = 0;
                    }
                    if (!str.contains("chinanet")) {
                        i = i3;
                    }
                    if (!str.contains("chinaunicom")) {
                        i2 = i;
                    }
                    valueOf = Integer.valueOf(i2);
                }
                o = valueOf.intValue();
            } else if (n == 2 || n == 3) {
                String simOperator;
                Context context = k;
                String str2 = b;
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                    simOperator = telephonyManager.getSimOperator();
                    if (simOperator.length() > 0) {
                        if (simOperator.equals("46000") || simOperator.equals("46002")) {
                            valueOf = Integer.valueOf(1);
                            o = valueOf.intValue();
                        } else {
                            if (simOperator.equals("46001")) {
                                valueOf = Integer.valueOf(2);
                            } else if (simOperator.equals("46003")) {
                                valueOf = Integer.valueOf(3);
                            }
                            o = valueOf.intValue();
                        }
                    }
                }
                if (str2 != null) {
                    simOperator = str2.toLowerCase();
                    if (simOperator.contains("cmnet") || simOperator.contains("cmwap")) {
                        valueOf = Integer.valueOf(1);
                        o = valueOf.intValue();
                    } else if (simOperator.contains("uninet") || simOperator.contains("uniwap") || simOperator.contains("3gnet") || simOperator.contains("3gwap")) {
                        valueOf = Integer.valueOf(2);
                        o = valueOf.intValue();
                    } else if (simOperator.contains("ctnet") || simOperator.contains("ctwap")) {
                        valueOf = Integer.valueOf(3);
                        o = valueOf.intValue();
                    }
                }
                valueOf = Integer.valueOf(0);
                o = valueOf.intValue();
            } else {
                o = 0;
            }
            valueOf = Integer.valueOf(o);
        }
        return valueOf;
    }
}
