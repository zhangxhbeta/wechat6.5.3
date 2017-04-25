package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public class VcSystemInfo {
    public static final int CHIP_ARM_LATER = 50;
    public static final int CHIP_ARM_V5 = 3;
    public static final int CHIP_ARM_V6 = 4;
    public static final int CHIP_ARM_V7_NENO = 6;
    public static final int CHIP_ARM_V7_NO_NENO = 5;
    public static final int CHIP_MIPS = 2;
    public static final int CHIP_UNKNOW = 0;
    public static final int CHIP_X86 = 1;
    public static final int NETWORK_AP_3G = 2;
    public static final int NETWORK_AP_GPRS = 3;
    public static final int NETWORK_AP_LINE = 4;
    public static final int NETWORK_AP_WIFI = 1;
    public static final int NETWORK_CLASS_2_G = 2;
    public static final int NETWORK_CLASS_3_G = 3;
    public static final int NETWORK_CLASS_4_G = 4;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_NONE = 0;
    private static final int NETWORK_TYPE_1xRTT = 7;
    private static final int NETWORK_TYPE_CDMA = 4;
    private static final int NETWORK_TYPE_EDGE = 2;
    private static final int NETWORK_TYPE_EHRPD = 14;
    private static final int NETWORK_TYPE_EVDO_0 = 5;
    private static final int NETWORK_TYPE_EVDO_A = 6;
    private static final int NETWORK_TYPE_EVDO_B = 12;
    private static final int NETWORK_TYPE_GPRS = 1;
    private static final int NETWORK_TYPE_HSDPA = 8;
    private static final int NETWORK_TYPE_HSPA = 10;
    private static final int NETWORK_TYPE_HSPAP = 15;
    private static final int NETWORK_TYPE_HSUPA = 9;
    private static final int NETWORK_TYPE_IDEN = 11;
    private static final int NETWORK_TYPE_LTE = 13;
    private static final int NETWORK_TYPE_UMTS = 3;
    public static final int PLAYER_LEVEL_1 = 1;
    public static final int PLAYER_LEVEL_11 = 11;
    public static final int PLAYER_LEVEL_16 = 16;
    public static final int PLAYER_LEVEL_21 = 21;
    public static final int PLAYER_LEVEL_26 = 26;
    public static final int PLAYER_LEVEL_6 = 6;
    private static final String TAG = "VcSystemInfo";
    public static final int TYPE_CMNET = 2;
    public static final int TYPE_CMWAP = 3;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_OTHER = 4;
    public static final int TYPE_WIFI = 1;
    private static int appVersionCode = 0;
    private static String appVersionName;
    private static String deviceID = "";
    private static String deviceIMEI;
    private static String deviceIMSI;
    private static String deviceMacAddr;
    public static int mCpuArchitecture = 0;
    public static String mCpuHardware = "";
    private static int mDeviceLevel = 0;
    public static String mFeature = "";
    private static int mMCC = 0;
    private static int mMNC = 0;
    public static String mProcessorName = "N/A";
    public static int mScreenHeight;
    public static int mScreenWidth;
    public int mCoreNumber = 1;
    public long mCurrCpuFreq = 0;
    private long mLastCpu;
    private long mLastIdle;
    public long mMaxCpuFreq = 0;
    public int mdispHeight;
    public int mdispWidth;

    public VcSystemInfo() {
        mScreenWidth = 320;
        mScreenHeight = 480;
        this.mdispWidth = 320;
        this.mdispHeight = 240;
        this.mLastCpu = 0;
        this.mLastIdle = 0;
    }

    public static String getDeviceIMEI(Context context) {
        if (!TextUtils.isEmpty(deviceIMEI)) {
            return deviceIMEI;
        }
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String deviceId = telephonyManager.getDeviceId();
                deviceIMEI = deviceId;
                if (deviceId == null) {
                    deviceIMEI = "";
                }
                return deviceIMEI;
            }
        } catch (Throwable th) {
        }
        return "";
    }

    public static String getDeviceIMSI(Context context) {
        if (!TextUtils.isEmpty(deviceIMSI)) {
            return deviceIMSI;
        }
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String subscriberId = telephonyManager.getSubscriberId();
                deviceIMSI = subscriberId;
                if (subscriberId == null) {
                    deviceIMSI = "";
                }
                return deviceIMSI;
            }
        } catch (Throwable th) {
        }
        return "";
    }

    public static String getDeviceID(Context context) {
        if (!TextUtils.isEmpty(deviceID)) {
            return deviceID;
        }
        if (context == null) {
            return "";
        }
        try {
            String string = System.getString(context.getContentResolver(), "android_id");
            deviceID = string;
            if (string == null) {
                deviceID = "";
            }
        } catch (Throwable th) {
            deviceID = "";
        }
        return deviceID;
    }

    public static String getDeviceMacAddr(Context context) {
        if (!TextUtils.isEmpty(deviceMacAddr)) {
            return deviceMacAddr;
        }
        if (context == null) {
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    String macAddress = connectionInfo.getMacAddress();
                    deviceMacAddr = macAddress;
                    if (macAddress == null) {
                        deviceMacAddr = "";
                    }
                    return deviceMacAddr;
                }
            }
        } catch (Throwable th) {
        }
        return "";
    }

    public static String getOsVersion() {
        return VERSION.RELEASE;
    }

    public static int getOsVerIntFromVerStr() {
        String osVersion = getOsVersion();
        int osVerInt = getOsVerInt();
        if (osVersion.length() < 3) {
            return osVerInt;
        }
        try {
            int parseInt = Integer.parseInt(osVersion.substring(0, 1));
            int parseInt2 = Integer.parseInt(osVersion.substring(2, 3));
            if (parseInt == 2) {
                if (parseInt2 == 3) {
                    return 9;
                }
                return osVerInt;
            } else if (parseInt != 4) {
                return osVerInt;
            } else {
                switch (parseInt2) {
                    case 0:
                        return 14;
                    case 1:
                        return 16;
                    case 2:
                        return 17;
                    case 3:
                        return 18;
                    case 4:
                        return 19;
                    default:
                        return osVerInt;
                }
            }
        } catch (Exception e) {
            return osVerInt;
        }
    }

    public static int getOsVerInt() {
        switch (VERSION.SDK_INT) {
            case 9:
            case 10:
                return 9;
            case 14:
            case 15:
                return 14;
            case 16:
                return 16;
            case 17:
                return 17;
            case 18:
                return 18;
            case 19:
            case 20:
                return 19;
            default:
                return 0;
        }
    }

    public static String getRomInfo() {
        return VERSION.INCREMENTAL;
    }

    public static int GetNetAP(Context context) {
        if (context == null) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 0;
        }
        if ("wifi".equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
            return 1;
        }
        return 2;
    }

    public static String getAppName(Context context, String str) {
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0)).toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public static String getAppVersionName(Context context) {
        if (!TextUtils.isEmpty(appVersionName)) {
            return appVersionName;
        }
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            appVersionName = str2;
            if (str2 != null) {
                return str2;
            }
            try {
                return "";
            } catch (Throwable th) {
                return str2;
            }
        } catch (Throwable th2) {
            return str;
        }
    }

    public static int getAppVersionCode(Context context, String str) {
        if (appVersionCode != 0) {
            return appVersionCode;
        }
        if (context == null) {
            return 0;
        }
        try {
            int i = context.getPackageManager().getPackageInfo(str, 0).versionCode;
            appVersionCode = i;
            return i;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return activeNetworkInfo.getState() == State.CONNECTED;
    }

    public static int getNetWorkType(Context context) {
        if (context == null) {
            return 0;
        }
        int i;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    switch (activeNetworkInfo.getType()) {
                        case 0:
                            i = 2;
                            try {
                                if (!(activeNetworkInfo.getExtraInfo() == null || "cmnet".equalsIgnoreCase(activeNetworkInfo.getExtraInfo()))) {
                                    i = 3;
                                    break;
                                }
                            } catch (Exception e) {
                                break;
                            }
                        case 1:
                            i = 1;
                            break;
                        default:
                            i = 4;
                            break;
                    }
                    return i;
                }
            }
            i = 0;
        } catch (Exception e2) {
            i = 0;
        }
        return i;
    }

    public static int getWifiNetStrength(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null) {
                return 0;
            }
            int rssi = connectionInfo.getRssi();
            if (VERSION.SDK_INT >= 14) {
                return WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 101);
            }
            if (rssi <= -100) {
                return 0;
            }
            if (rssi >= -55) {
                return 100;
            }
            return (int) ((((float) (rssi + 100)) * 100.0f) / 45.0f);
        } catch (Throwable th) {
            return 0;
        }
    }

    public static long getRxBytesFromNetwork(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            context.getClassLoader().loadClass("android.net.TrafficStats");
            if (-1 == -1) {
                return TrafficStats.getTotalRxBytes();
            }
            return -1;
        } catch (ClassNotFoundException e) {
            return 0;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static long getAppInstallTime(Context context) {
        long j = 0;
        if (context != null) {
            try {
                j = new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).lastModified() / 1000;
            } catch (NameNotFoundException e) {
            } catch (Throwable th) {
            }
        }
        return j;
    }

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        if (mScreenWidth != 0) {
            return mScreenWidth;
        }
        try {
            mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable th) {
        }
        return mScreenWidth;
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        if (mScreenHeight != 0) {
            return mScreenHeight;
        }
        try {
            mScreenHeight = context.getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable th) {
        }
        return mScreenHeight;
    }

    public static boolean isNetworkTypeMobile(Context context) {
        if (context == null) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                switch (activeNetworkInfo.getType()) {
                    case 0:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return true;
                    default:
                        return false;
                }
            }
        }
        return true;
    }

    public static int getMarketId(Context context) {
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream = null;
        int i = -1;
        if (context != null) {
            InputStream open;
            try {
                open = context.getApplicationContext().getAssets().open("channel.ini");
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(open));
                    try {
                        String readLine = bufferedReader.readLine();
                        if (!TextUtils.isEmpty(readLine) && readLine.contains("CHANNEL=")) {
                            Object substring = readLine.substring(readLine.indexOf("=") + 1);
                            if (!TextUtils.isEmpty(substring)) {
                                i = Integer.parseInt(substring.trim());
                            }
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th2) {
                            }
                        }
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        th = th3;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th4) {
                                throw th;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                    if (open != null) {
                        open.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
                open = null;
                if (open != null) {
                    open.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        }
        return i;
    }

    public static int getMCC(Context context) {
        if (mMCC != 0) {
            return mMCC;
        }
        if (context == null) {
            return 0;
        }
        try {
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration != null) {
                mMCC = configuration.mcc;
            }
            return mMCC;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static int getMNC(Context context) {
        if (mMNC != 0) {
            return mMNC;
        }
        if (context == null) {
            return 0;
        }
        try {
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration != null) {
                mMNC = configuration.mnc;
            }
            return mMNC;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static String PrintStack(Throwable th) {
        if (th == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            byteArrayOutputStream.close();
        } catch (IOException e) {
        } catch (Throwable th2) {
            byteArrayOutputStream.close();
        }
        return byteArrayOutputStream.toString();
    }

    public static String readSystemStat() {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String str = null;
        try {
            randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            try {
                str = randomAccessFile.readLine();
                try {
                    randomAccessFile.close();
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                th = th3;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            Throwable th6 = th5;
            randomAccessFile = str;
            th = th6;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
        return str;
    }

    public static int getSystemCpuUsage(String str, String str2) {
        float f = -1.0f;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        try {
            String[] split = str.trim().split("\\s+");
            long systemIdleTime = getSystemIdleTime(split);
            long systemUptime = getSystemUptime(split);
            split = str2.trim().split("\\s+");
            long systemIdleTime2 = getSystemIdleTime(split);
            long systemUptime2 = getSystemUptime(split);
            if (systemIdleTime >= 0 && systemUptime >= 0 && systemIdleTime2 >= 0 && systemUptime2 >= 0 && systemUptime2 + systemIdleTime2 > systemUptime + systemIdleTime && systemUptime2 >= systemUptime) {
                f = (((float) (systemUptime2 - systemUptime)) / ((float) ((systemIdleTime2 + systemUptime2) - (systemIdleTime + systemUptime)))) * 100.0f;
            }
        } catch (Throwable th) {
        }
        return (int) f;
    }

    public static long getSystemUptime(String[] strArr) {
        long j = 0;
        for (int i = 1; i < strArr.length; i++) {
            if (4 != i) {
                try {
                    j += Long.parseLong(strArr[i]);
                } catch (Throwable th) {
                    return -1;
                }
            }
        }
        return j;
    }

    public static long getSystemIdleTime(String[] strArr) {
        try {
            return Long.parseLong(strArr[4]);
        } catch (Throwable th) {
            return -1;
        }
    }

    public static int getNetworkClass(Context context) {
        if (context == null) {
            return 0;
        }
        int networkClass;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                switch (activeNetworkInfo.getType()) {
                    case 0:
                        networkClass = getNetworkClass(activeNetworkInfo.getSubtype());
                        break;
                    default:
                        networkClass = 0;
                        break;
                }
                return networkClass;
            }
        }
        networkClass = 0;
        return networkClass;
    }

    private static int getNetworkClass(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    public static String getWiFiMacAddress(Context context) {
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Throwable th) {
            return "";
        }
    }
}
