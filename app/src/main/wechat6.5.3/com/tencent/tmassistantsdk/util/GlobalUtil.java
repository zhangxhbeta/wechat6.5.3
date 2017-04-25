package com.tencent.tmassistantsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class GlobalUtil {
    static final int NET_TYPE_WIFI = 4;
    protected static final String SharedPreferencesName = "TMAssistantSDKSharedPreference";
    private static final String TAG = "GlobalUtil";
    protected static GlobalUtil mInstance = null;
    protected static int mMemUUID = 0;
    public final int JCE_CMDID_Empty;
    public final int JCE_CMDID_GetAppSimpleDetail;
    public final int JCE_CMDID_GetAppUpdate;
    public final int JCE_CMDID_GetAuthorized;
    public final int JCE_CMDID_GetSettings;
    public final int JCE_CMDID_ReportLog;
    protected Context mContext;
    public HashMap<Integer, String> mJCECmdIdMap;
    public String mQUA;

    protected GlobalUtil() {
        this.mQUA = "";
        this.JCE_CMDID_Empty = 0;
        this.JCE_CMDID_ReportLog = 1;
        this.JCE_CMDID_GetSettings = 2;
        this.JCE_CMDID_GetAppUpdate = 3;
        this.JCE_CMDID_GetAuthorized = 4;
        this.JCE_CMDID_GetAppSimpleDetail = 5;
        this.mJCECmdIdMap = null;
        this.mJCECmdIdMap = new HashMap();
        this.mJCECmdIdMap.put(Integer.valueOf(1), "ReportLog");
        this.mJCECmdIdMap.put(Integer.valueOf(2), "GetSettings");
        this.mJCECmdIdMap.put(Integer.valueOf(3), "GetAppUpdate");
        this.mJCECmdIdMap.put(Integer.valueOf(4), "GetAuthorized");
        this.mJCECmdIdMap.put(Integer.valueOf(5), "GetAppSimpleDetail");
    }

    public static synchronized GlobalUtil getInstance() {
        GlobalUtil globalUtil;
        synchronized (GlobalUtil.class) {
            if (mInstance == null) {
                mInstance = new GlobalUtil();
            }
            globalUtil = mInstance;
        }
        return globalUtil;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
        this.mQUA = new QUASetting(context).buildQUA();
    }

    public void destroy() {
        this.mContext = null;
        mInstance = null;
    }

    public int getJceCmdIdByClassName(String str) {
        if (str == null) {
            return 0;
        }
        if (this.mJCECmdIdMap != null) {
            for (Entry entry : this.mJCECmdIdMap.entrySet()) {
                if (entry != null) {
                    Integer num = (Integer) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (str2 != null && str2.equals(str)) {
                        return num.intValue();
                    }
                }
            }
        }
        return 0;
    }

    public String getNetworkOperator() {
        if (this.mContext == null) {
            return "";
        }
        return ((TelephonyManager) this.mContext.getSystemService("phone")).getNetworkOperator();
    }

    public int getNetworkType() {
        if (this.mContext == null) {
            return 0;
        }
        return ((TelephonyManager) this.mContext.getSystemService("phone")).getNetworkType();
    }

    public static String getAppPackageName(Context context) {
        if (context != null) {
            return context.getPackageName();
        }
        return "";
    }

    public static int getAppVersionCode(Context context) {
        int i = 0;
        if (context == null) {
            return i;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[i]);
            return i;
        }
    }

    public String getAndroidIdInPhone() {
        if (this.mContext == null) {
            return null;
        }
        return Secure.getString(getContext().getContentResolver(), "android_id");
    }

    public String getPhoneGuid() {
        if (this.mContext == null) {
            return "";
        }
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SharedPreferencesName, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
        }
        return "";
    }

    public void setPhoneGuid(String str) {
        if (this.mContext != null && str != null) {
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SharedPreferencesName, 0);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", str).commit();
            }
        }
    }

    public String getImei() {
        if (this.mContext == null) {
            return null;
        }
        String str = "";
        try {
            return ((TelephonyManager) getContext().getSystemService("phone")).getDeviceId();
        } catch (Throwable e) {
            v.a(TAG, e, "getImei:", new Object[0]);
            return str;
        }
    }

    public String getImsi() {
        if (this.mContext == null) {
            return null;
        }
        String str = "";
        try {
            return ((TelephonyManager) getContext().getSystemService("phone")).getSubscriberId();
        } catch (Throwable e) {
            v.a(TAG, e, "getImsi:", new Object[0]);
            return str;
        }
    }

    public String getMacAddress() {
        if (this.mContext == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) getContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public static String calcMD5AsString(String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes();
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.reset();
                instance.update(bytes, 0, bytes.length);
                byte[] digest = instance.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b : digest) {
                    stringBuffer.append(Integer.toHexString(b & 255));
                }
                str2 = stringBuffer.toString();
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            }
        }
        return str2;
    }

    public static synchronized int getMemUUID() {
        int i;
        synchronized (GlobalUtil.class) {
            i = mMemUUID;
            mMemUUID = i + 1;
        }
        return i;
    }

    public static ArrayList<String> String2List(String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            for (CharSequence charSequence : split) {
                if (!TextUtils.isEmpty(charSequence)) {
                    arrayList.add(charSequence);
                }
            }
        }
        return arrayList;
    }

    public void setNetTypeValue(byte b) {
        if (this.mContext != null) {
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SharedPreferencesName, 0);
            if (sharedPreferences != null && Byte.parseByte(sharedPreferences.getString("TMAssistantSDKNetType", "0")) != b) {
                sharedPreferences.edit().putString("TMAssistantSDKNetType", String.valueOf(b)).commit();
            }
        }
    }

    public boolean canReportValue() {
        return false;
    }

    public int getQQDownloaderAPILevel() {
        int i = 0;
        if (this.mContext != null) {
            try {
                ApplicationInfo applicationInfo = this.mContext.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
                if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                    i = applicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
                }
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            }
        }
        return i;
    }

    public int getQQDownloaderVersionCode() {
        int i = 0;
        if (this.mContext != null) {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager != null) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo("com.tencent.android.qqdownloader", 0);
                    if (packageInfo != null) {
                        i = packageInfo.versionCode;
                    }
                } catch (Throwable e) {
                    v.a(TAG, e, "", new Object[0]);
                }
            }
        }
        return i;
    }

    public static void updateFilePathAuthorized(String str) {
        File file = new File(str);
        String parent = file.getParent();
        String parent2 = new File(parent).getParent();
        String parent3 = new File(parent2).getParent();
        try {
            Runtime.getRuntime().exec("chmod 777 " + file.getAbsolutePath());
            Runtime.getRuntime().exec("chmod 777 " + parent);
            Runtime.getRuntime().exec("chmod 777 " + parent2);
            Runtime.getRuntime().exec("chmod 777" + parent3);
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
        }
    }

    public static int assistantState2SDKState(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 5;
            case 4:
                return 4;
            case 6:
                return 1;
            case 9:
                return 6;
            default:
                return 0;
        }
    }

    public static int assistantErrorCode2SDKErrorCode(int i) {
        switch (i) {
            case -28:
                return 701;
            case -27:
                return 606;
            case -25:
                return 602;
            case -23:
                return 601;
            case -22:
                return 732;
            case -21:
                return 700;
            case -16:
                return 731;
            case -15:
                return 1;
            case -13:
                return 703;
            case -12:
                return 730;
            case -11:
                return 708;
            case -1:
                return 709;
            case 0:
                return 0;
            default:
                return 604;
        }
    }

    public static boolean isDBExist(String str) {
        if (getInstance().getContext() == null || !getInstance().getContext().getDatabasePath(str).exists()) {
            return false;
        }
        return true;
    }

    public static void deleteOldDB(String str) {
        if (getInstance().getContext() != null) {
            File databasePath = getInstance().getContext().getDatabasePath(str);
            if (databasePath.exists()) {
                try {
                    databasePath.delete();
                    TMLog.i(TAG, "deleteDB");
                } catch (Exception e) {
                    TMLog.i(TAG, "deleteDB failed");
                }
            }
        }
    }
}
