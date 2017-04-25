package com.tencent.tmassistantsdk.util;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;

public class TMLog {
    protected static boolean mDebugFlagForSDK = false;
    protected static String mDebugFlagForSDKTag = "";
    protected static boolean mHardDebugFlag = false;
    protected static HashMap<String, ArrayList<Long>> mUseTimeLongList = new HashMap();
    protected static HashMap<String, ArrayList<String>> mUseTimeStringList = new HashMap();

    public static void setDebugLog(boolean z, String str) {
        mDebugFlagForSDK = z;
        mDebugFlagForSDKTag = str;
    }

    public static void debugV(String str) {
        if (mDebugFlagForSDK && !TextUtils.isEmpty(mDebugFlagForSDKTag)) {
            v.v(mDebugFlagForSDKTag, str);
        }
    }

    public static void debugE(String str) {
        if (mDebugFlagForSDK && !TextUtils.isEmpty(mDebugFlagForSDKTag)) {
            v.e(mDebugFlagForSDKTag, str);
        }
    }

    public static boolean isForDebug() {
        return mHardDebugFlag;
    }

    public static void v(String str, String str2) {
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            v.v(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            v.i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            v.d(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            v.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            v.e(str, str2);
        }
    }

    public static void time(String str) {
        time("UseTime", str, false);
    }

    public static void time(String str, boolean z) {
        time("UseTime", str, z);
    }

    public static void time(String str, String str2) {
        time(str, str2, false);
    }

    public static void time(String str, String str2, boolean z) {
        int i = 0;
        if (isForDebug()) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3 = (ArrayList) mUseTimeStringList.get(str);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                mUseTimeStringList.put(str, arrayList3);
                arrayList = arrayList3;
            } else {
                arrayList = arrayList3;
            }
            arrayList.add(str2);
            arrayList3 = (ArrayList) mUseTimeLongList.get(str);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                mUseTimeLongList.put(str, arrayList3);
                arrayList2 = arrayList3;
            } else {
                arrayList2 = arrayList3;
            }
            arrayList2.add(Long.valueOf(System.currentTimeMillis()));
            if (z) {
                StringBuffer stringBuffer = new StringBuffer();
                long longValue = ((Long) arrayList2.get(0)).longValue();
                stringBuffer.append("total time:");
                stringBuffer.append(((Long) arrayList2.get(arrayList2.size() - 1)).longValue() - longValue);
                stringBuffer.append(" ");
                while (i < arrayList.size()) {
                    stringBuffer.append(((Long) arrayList2.get(i)).longValue() - longValue);
                    longValue = ((Long) arrayList2.get(i)).longValue();
                    stringBuffer.append(" ");
                    stringBuffer.append((String) arrayList.get(i));
                    stringBuffer.append(" ");
                    i++;
                }
                v.v(str, stringBuffer.toString());
                arrayList.clear();
                arrayList2.clear();
            }
        }
    }
}
