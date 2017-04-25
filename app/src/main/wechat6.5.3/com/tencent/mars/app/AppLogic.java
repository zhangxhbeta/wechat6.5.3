package com.tencent.mars.app;

import com.tencent.mmdb.database.SQLiteDatabase;

public class AppLogic {
    private static final String TAG = "mars.app.NativeAppJni$C2Java";
    private static ICallBack callBack = null;

    public static class AccountInfo {
        public long uin = 0;
        public String userName = SQLiteDatabase.KeyEmpty;

        public AccountInfo(long j, String str) {
            this.uin = j;
            this.userName = str;
        }
    }

    public static class DeviceInfo {
        public String devicename = SQLiteDatabase.KeyEmpty;
        public String devicetype = SQLiteDatabase.KeyEmpty;

        public DeviceInfo(String str, String str2) {
            this.devicename = str;
            this.devicetype = str2;
        }
    }

    public interface ICallBack {
        AccountInfo getAccountInfo();

        String getAppFilePath();

        int getClientVersion();

        String getCurLanguage();

        DeviceInfo getDeviceType();
    }

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    public static String getAppFilePath() {
        if (callBack == null) {
            return null;
        }
        return callBack.getAppFilePath();
    }

    private static AccountInfo getAccountInfo() {
        if (callBack == null) {
            return null;
        }
        return callBack.getAccountInfo();
    }

    private static int getClientVersion() {
        if (callBack == null) {
            return 0;
        }
        return callBack.getClientVersion();
    }

    private static DeviceInfo getDeviceType() {
        if (callBack == null) {
            return null;
        }
        return callBack.getDeviceType();
    }

    private static String getCurLanguage() {
        if (callBack == null) {
            return null;
        }
        return callBack.getCurLanguage();
    }
}
