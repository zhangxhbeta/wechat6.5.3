package com.c.a.a;

import android.net.wifi.ScanResult;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.math.BigInteger;
import java.util.List;

final class v {
    private static String aD(String str) {
        if (str == null) {
            throw new NullPointerException("trying to manipulate null string");
        }
        String str2 = SQLiteDatabase.KeyEmpty;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ':') {
                str2 = new StringBuilder(String.valueOf(str2)).append(str.charAt(i)).toString();
            }
        }
        return str2;
    }

    static String a(List<ScanResult> list, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null) {
            for (ScanResult scanResult : list) {
                if (!(scanResult.capabilities == null || scanResult.capabilities.contains("IBSS"))) {
                    try {
                        String bigInteger = new BigInteger(aD(scanResult.BSSID), 16).toString();
                        String valueOf = String.valueOf(scanResult.level);
                        String str = SQLiteDatabase.KeyEmpty;
                        stringBuilder.append(z ? "&WD[]=" : "|WD,");
                        stringBuilder.append(bigInteger);
                        stringBuilder.append(',');
                        stringBuilder.append(valueOf);
                        stringBuilder.append(',');
                        stringBuilder.append(valueOf);
                        stringBuilder.append(',');
                        stringBuilder.append(valueOf);
                        stringBuilder.append(',');
                        stringBuilder.append(1);
                        stringBuilder.append(',');
                        stringBuilder.append(1);
                        stringBuilder.append(',');
                        stringBuilder.append(0);
                        stringBuilder.append(',');
                        stringBuilder.append(str);
                    } catch (NullPointerException e) {
                    } catch (NumberFormatException e2) {
                    } catch (Error e3) {
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    static boolean c(double d, double d2) {
        return Math.abs(d) <= 90.0d && Math.abs(d2) <= 180.0d;
    }

    static String aE(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("&SD=", "|SD,");
    }

    static String aF(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("&GD=", "|GD,");
    }

    static String a(String str, long j, String str2) {
        if (str == null || !str.startsWith("|")) {
            return null;
        }
        return "&OD[]=ST," + String.valueOf(j) + ',' + str2 + str;
    }
}
