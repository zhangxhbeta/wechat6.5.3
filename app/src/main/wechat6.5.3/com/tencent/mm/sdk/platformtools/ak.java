package com.tencent.mm.sdk.platformtools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import java.util.LinkedList;
import java.util.List;

public final class ak {
    private static PhoneStateListener njX = null;
    private static int njY = 10000;
    private static int njZ = -1;
    private static int nowStrength = 10000;

    public static class a {
        public String nka;
        public String nkb;
        public String nkc;
        public String nkd;
        public String nke;
        public String nkf;
        public String nkg;
        public String systemId;
        public String type;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            this.nka = str;
            this.nkb = str2;
            this.nkc = str3;
            this.type = str6;
            this.nkd = str4;
            this.nke = str7;
            this.nkf = str8;
            this.systemId = str9;
            this.nkg = str5;
        }
    }

    public static String dN(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            stringBuilder.append("isAvailable " + activeNetworkInfo.isAvailable() + "\r\n");
            stringBuilder.append("isAvailable " + activeNetworkInfo.isAvailable() + "\r\n");
            stringBuilder.append("isConnected " + activeNetworkInfo.isConnected() + "\r\n");
            stringBuilder.append("isRoaming " + activeNetworkInfo.isRoaming() + "\r\n");
            stringBuilder.append("isFailover " + activeNetworkInfo.isFailover() + "\r\n");
            stringBuilder.append("getSubtypeName " + activeNetworkInfo.getSubtypeName() + "\r\n");
            stringBuilder.append("getSubtype " + activeNetworkInfo.getSubtype() + "\r\n");
            stringBuilder.append("getType " + activeNetworkInfo.getType() + "\r\n");
            stringBuilder.append("getExtraInfo " + activeNetworkInfo.getExtraInfo() + "\r\n");
            stringBuilder.append("activeNetInfo " + activeNetworkInfo.toString() + "\r\n");
            stringBuilder.append("is2G " + is2G(context) + "\r\n");
            stringBuilder.append("is3G " + is3G(context) + "\r\n");
            stringBuilder.append("is4G " + is4G(context) + "\r\n");
            stringBuilder.append("isWifi " + isWifi(context) + "\r\n");
            v.i("MicroMsg.NetStatusUtil", "netstatus " + stringBuilder.toString());
        } catch (Throwable e) {
            v.i("MicroMsg.NetStatusUtil", e.getMessage());
            v.a("MicroMsg.NetStatusUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return stringBuilder.toString();
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        boolean isConnected;
        try {
            isConnected = connectivityManager.getActiveNetworkInfo().isConnected();
        } catch (Exception e) {
            isConnected = false;
        }
        return isConnected;
    }

    public static String getNetTypeString(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "NON_NETWORK";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "NON_NETWORK";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            v.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()));
            if (activeNetworkInfo.getExtraInfo() != null) {
                return activeNetworkInfo.getExtraInfo();
            }
            return "MOBILE";
        } catch (Throwable e) {
            v.a("MicroMsg.NetStatusUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return "NON_NETWORK";
        }
    }

    public static String dO(Context context) {
        if (is2G(context)) {
            return "2G";
        }
        if (is3G(context)) {
            return "3G";
        }
        if (is4G(context)) {
            return "4G";
        }
        if (isWifi(context)) {
            return "WIFI";
        }
        return getNetTypeString(context);
    }

    public static int dP(Context context) {
        if (isWifi(context)) {
            return 1;
        }
        if (is4G(context)) {
            return 4;
        }
        if (is3G(context)) {
            return 3;
        }
        if (is2G(context)) {
            return 2;
        }
        return 0;
    }

    public static int dQ(Context context) {
        if (isWifi(context)) {
            return 1;
        }
        if (is4G(context)) {
            return 5;
        }
        if (is3G(context)) {
            return 4;
        }
        if (is2G(context)) {
            return 3;
        }
        if (isWap(getNetType(context))) {
            return 2;
        }
        return 0;
    }

    public static int getNetWorkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType();
            }
        } catch (Throwable e) {
            v.a("MicroMsg.NetStatusUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return -1;
    }

    public static int getNetType(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 0;
        }
        v.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()));
        if (activeNetworkInfo.getExtraInfo() != null) {
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uninet")) {
                return 1;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uniwap")) {
                return 2;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gwap")) {
                return 3;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gnet")) {
                return 4;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmwap")) {
                return 5;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmnet")) {
                return 6;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctwap")) {
                return 7;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctnet")) {
                return 8;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("LTE")) {
                return 10;
            }
        }
        return 9;
    }

    public static int getISPCode(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return 0;
        }
        String simOperator = telephonyManager.getSimOperator();
        if (simOperator == null || simOperator.length() < 5) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int length = simOperator.length();
            if (length > 6) {
                length = 6;
            }
            for (int i = 0; i < length; i++) {
                if (Character.isDigit(simOperator.charAt(i))) {
                    stringBuilder.append(simOperator.charAt(i));
                } else if (stringBuilder.length() <= 0) {
                }
            }
            return Integer.valueOf(stringBuilder.toString()).intValue();
        } catch (Throwable e) {
            v.a("MicroMsg.NetStatusUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return 0;
        }
    }

    public static String getISPName(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return SQLiteDatabase.KeyEmpty;
            }
            v.d("MicroMsg.NetStatusUtil", "getISPName ISPName=%s", telephonyManager.getSimOperatorName());
            if (telephonyManager.getSimOperatorName().length() <= 100) {
                return telephonyManager.getSimOperatorName();
            }
            return telephonyManager.getSimOperatorName().substring(0, 100);
        } catch (Exception e) {
            return SQLiteDatabase.KeyEmpty;
        }
    }

    public static boolean isMobile(Context context) {
        try {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType() == 1) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.NetStatusUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return false;
        }
    }

    public static boolean is2G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return false;
            }
            if (activeNetworkInfo.getSubtype() == 2 || activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 4) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            v.a("MicroMsg.NetStatusUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static boolean is4G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return false;
            }
            if (activeNetworkInfo.getSubtype() >= 13) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            v.a("MicroMsg.NetStatusUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static boolean isWap(Context context) {
        return isWap(getNetType(context));
    }

    public static boolean isWap(int i) {
        if (i == 2 || i == 5 || i == 7 || i == 3) {
            return true;
        }
        return false;
    }

    public static boolean is3G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return false;
            }
            if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            v.a("MicroMsg.NetStatusUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static boolean isWifi(Context context) {
        return getNetType(context) == 0;
    }

    public static boolean isWifi(int i) {
        if (i == 0) {
            return true;
        }
        return false;
    }

    public static WifiInfo getWifiInfo(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return null;
            }
            return wifiManager.getConnectionInfo();
        } catch (Throwable e) {
            v.a("MicroMsg.NetStatusUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    private static Intent searchIntentByClass(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            List installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                v.e("MicroMsg.NetStatusUtil", "package  size" + installedPackages.size());
                for (int i = 0; i < installedPackages.size(); i++) {
                    try {
                        v.e("MicroMsg.NetStatusUtil", "package " + ((PackageInfo) installedPackages.get(i)).packageName);
                        Intent intent = new Intent();
                        intent.setPackage(((PackageInfo) installedPackages.get(i)).packageName);
                        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                        if (size > 0) {
                            try {
                                v.e("MicroMsg.NetStatusUtil", "activityName count " + size);
                                for (int i2 = 0; i2 < size; i2++) {
                                    ActivityInfo activityInfo = ((ResolveInfo) queryIntentActivities.get(i2)).activityInfo;
                                    if (activityInfo.name.contains(str)) {
                                        Intent intent2 = new Intent("/");
                                        intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                        intent2.setAction("android.intent.action.VIEW");
                                        context.startActivity(intent2);
                                        return intent2;
                                    }
                                }
                                continue;
                            } catch (Throwable e) {
                                v.a("MicroMsg.NetStatusUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                        } else {
                            continue;
                        }
                    } catch (Throwable e2) {
                        v.a("MicroMsg.NetStatusUtil", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
            }
        } catch (Throwable e22) {
            v.a("MicroMsg.NetStatusUtil", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return null;
    }

    public static void startSettingItent(Context context, int i) {
        Intent intent;
        switch (i) {
            case 1:
                try {
                    intent = new Intent("/");
                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
                    intent.setAction("android.intent.action.VIEW");
                    context.startActivity(intent);
                    return;
                } catch (Exception e) {
                    searchIntentByClass(context, "DevelopmentSettings");
                    return;
                }
            case 2:
                try {
                    intent = new Intent("/");
                    intent.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
                    intent.setAction("android.intent.action.VIEW");
                    context.startActivity(intent);
                    return;
                } catch (Exception e2) {
                    try {
                        intent = new Intent("/");
                        intent.setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
                        intent.setAction("android.intent.action.VIEW");
                        context.startActivity(intent);
                        return;
                    } catch (Exception e3) {
                        searchIntentByClass(context, "ManageAccountsSettings");
                        return;
                    }
                }
            case 3:
                try {
                    intent = new Intent();
                    intent.setAction("android.settings.WIFI_IP_SETTINGS");
                    context.startActivity(intent);
                    return;
                } catch (Exception e4) {
                    searchIntentByClass(context, "AdvancedSettings");
                    return;
                }
            default:
                return;
        }
    }

    public static boolean isLimited(int i) {
        if (i == 2 || i == 1 || i == 3) {
            return true;
        }
        return false;
    }

    public static int getBackgroundLimitType(Context context) {
        if (VERSION.SDK_INT >= 14) {
            try {
                Class cls = Class.forName("android.app.ActivityManagerNative");
                Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                if (((Integer) invoke.getClass().getMethod("getProcessLimit", new Class[0]).invoke(invoke, new Object[0])).intValue() == 0) {
                    return 1;
                }
            } catch (Throwable e) {
                v.a("MicroMsg.NetStatusUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        try {
            int i = System.getInt(context.getContentResolver(), "wifi_sleep_policy", 2);
            if (i == 2 || getNetType(context) != 0) {
                return 0;
            }
            if (i == 1 || i == 0) {
                return 3;
            }
            return 0;
        } catch (Throwable e2) {
            v.a("MicroMsg.NetStatusUtil", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        if (activeNetworkInfo.getState() != State.CONNECTED) {
            return false;
        }
        return true;
    }

    public static int getNetTypeForStat(Context context) {
        if (context == null) {
            return TbsLog.TBSLOG_CODE_SDK_INIT;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return TbsLog.TBSLOG_CODE_SDK_INIT;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return TbsLog.TBSLOG_CODE_SDK_INIT;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            int subtype = activeNetworkInfo.getSubtype();
            return subtype == 0 ? TbsLog.TBSLOG_CODE_SDK_INIT : subtype * 1000;
        } catch (Throwable e) {
            v.a("MicroMsg.NetStatusUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return TbsLog.TBSLOG_CODE_SDK_INIT;
        }
    }

    public static boolean dR(Context context) {
        int netType = getNetType(context);
        if (netType == 0 || netType == 10) {
            v.d("MicroMsg.NetStatusUtil", "[cpan] is wifi or 4g network");
            return true;
        }
        v.d("MicroMsg.NetStatusUtil", "[cpan] is mobile network");
        return false;
    }

    public static synchronized void dS(Context context) {
        synchronized (ak.class) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            njZ = telephonyManager.getPhoneType();
            if (njX == null) {
                njX = new PhoneStateListener() {
                    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                        super.onSignalStrengthsChanged(signalStrength);
                        if (ak.njZ == 2) {
                            ak.nowStrength = signalStrength.getCdmaDbm();
                        }
                        if (ak.njZ == 1) {
                            ak.nowStrength = (signalStrength.getGsmSignalStrength() * 2) - 113;
                        }
                        v.i("MicroMsg.NetStatusUtil", "PhoneStateListener  type:%d  strength:%d", Integer.valueOf(ak.njZ), Integer.valueOf(ak.nowStrength));
                    }
                };
                telephonyManager.listen(njX, FileUtils.S_IRUSR);
            }
        }
    }

    public static synchronized int getStrength(Context context) {
        int i;
        synchronized (ak.class) {
            if (context == null) {
                i = 0;
            } else {
                try {
                    if (getNetTypeForStat(context) == 1) {
                        i = Math.abs(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getRssi());
                    } else {
                        if (njX == null) {
                            v.e("MicroMsg.NetStatusUtil", "getStrength phone Listener has not been inited");
                        }
                        i = Math.abs(nowStrength);
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.NetStatusUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    i = 0;
                }
            }
        }
        return i;
    }

    public static synchronized List<a> dT(Context context) {
        List<a> list;
        List<NeighboringCellInfo> neighboringCellInfo;
        synchronized (ak.class) {
            if (njX == null) {
                v.e("MicroMsg.NetStatusUtil", "getStrength phone Listener has not been inited");
                list = null;
            } else {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                List<a> linkedList = new LinkedList();
                String str = "460";
                String str2 = SQLiteDatabase.KeyEmpty;
                try {
                    String networkOperator = telephonyManager.getNetworkOperator();
                    if (networkOperator == null || networkOperator.equals(SQLiteDatabase.KeyEmpty)) {
                        networkOperator = telephonyManager.getSimOperator();
                        if (!(networkOperator == null || networkOperator.equals(SQLiteDatabase.KeyEmpty))) {
                            str = networkOperator.substring(0, 3);
                            str2 = networkOperator.substring(3, 5);
                        }
                        networkOperator = str2;
                    } else {
                        str = networkOperator.substring(0, 3);
                        networkOperator = networkOperator.substring(3, 5);
                    }
                    String str3;
                    GsmCellLocation gsmCellLocation;
                    int cid;
                    int lac;
                    if (telephonyManager.getPhoneType() == 2) {
                        try {
                            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                            if (cdmaCellLocation != null) {
                                str3 = nowStrength == njY ? SQLiteDatabase.KeyEmpty : nowStrength;
                                if (!(cdmaCellLocation.getBaseStationId() == -1 || cdmaCellLocation.getNetworkId() == -1 || cdmaCellLocation.getSystemId() == -1)) {
                                    linkedList.add(new a(str, networkOperator, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, str3, "cdma", cdmaCellLocation.getBaseStationId(), cdmaCellLocation.getNetworkId(), cdmaCellLocation.getSystemId()));
                                }
                            }
                        } catch (Exception e) {
                            try {
                                gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                                if (gsmCellLocation != null) {
                                    cid = gsmCellLocation.getCid();
                                    lac = gsmCellLocation.getLac();
                                    if (!(lac >= 65535 || lac == -1 || cid == -1)) {
                                        linkedList.add(new a(str, networkOperator, String.valueOf(lac), String.valueOf(cid), SQLiteDatabase.KeyEmpty, "gsm", SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
                                    }
                                }
                            } catch (Throwable e2) {
                                v.a("MicroMsg.NetStatusUtil", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                            neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
                            if (neighboringCellInfo != null && neighboringCellInfo.size() > 0) {
                                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                                    if (!(neighboringCellInfo2.getCid() == -1 || neighboringCellInfo2.getLac() > 65535 || neighboringCellInfo2.getLac() == -1)) {
                                        linkedList.add(new a(str, networkOperator, neighboringCellInfo2.getLac(), neighboringCellInfo2.getCid(), ((neighboringCellInfo2.getRssi() * 2) - 113), "gsm", SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
                                    }
                                }
                            }
                        }
                    } else {
                        try {
                            gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                            if (gsmCellLocation != null) {
                                cid = gsmCellLocation.getCid();
                                lac = gsmCellLocation.getLac();
                                if (!(lac >= 65535 || lac == -1 || cid == -1)) {
                                    linkedList.add(new a(str, networkOperator, String.valueOf(lac), String.valueOf(cid), nowStrength == njY ? SQLiteDatabase.KeyEmpty : nowStrength, "gsm", SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
                                }
                            }
                        } catch (Throwable e22) {
                            v.a("MicroMsg.NetStatusUtil", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                        neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
                        if (neighboringCellInfo != null && neighboringCellInfo.size() > 0) {
                            for (NeighboringCellInfo neighboringCellInfo22 : neighboringCellInfo) {
                                if (neighboringCellInfo22.getCid() != -1 && neighboringCellInfo22.getLac() <= 65535) {
                                    str3 = ((neighboringCellInfo22.getRssi() * 2) - 113);
                                    v.v("checked", "lac:" + neighboringCellInfo22.getLac() + "  cid:" + neighboringCellInfo22.getCid() + " dbm:" + str3);
                                    linkedList.add(new a(str, networkOperator, neighboringCellInfo22.getLac(), neighboringCellInfo22.getCid(), str3, "gsm", SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
                                }
                            }
                        }
                    }
                    list = linkedList;
                } catch (Throwable e222) {
                    v.a("MicroMsg.NetStatusUtil", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                    list = linkedList;
                }
            }
        }
        return list;
    }
}
