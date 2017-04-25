package com.tencent.tmassistantsdk.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;

public class QUASetting {
    protected static final String APP_VERSION = "100";
    protected static final String BUILD_NO = "100";
    public static final int ROOT_STATUS_UNKNOWN = 0;
    protected static final String UN_DEFINED = "NA";
    protected static String mChannelId = UN_DEFINED;
    protected Context mContext = null;

    public QUASetting(Context context) {
        this.mContext = context;
    }

    public String buildQUA() {
        QUABuilder qUABuilder = new QUABuilder();
        qUABuilder.mBuildNo = getBuildNo();
        qUABuilder.mChannel = "";
        qUABuilder.mChannelId = mChannelId;
        qUABuilder.mAdrRelease = getAndroidVersion();
        qUABuilder.mDeviceHeight = getDeviceHeight();
        qUABuilder.mDeviceWidth = getDeviceWidth();
        qUABuilder.mRootStatus = getRootStatus();
        qUABuilder.mUA = getUA();
        qUABuilder.mVersionName = "100";
        return qUABuilder.get();
    }

    private int getDeviceWidth() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels;
    }

    private int getDeviceHeight() {
        return this.mContext.getResources().getDisplayMetrics().heightPixels;
    }

    public static String getBuildNo() {
        if ("100".contains("BuildNo")) {
            return "0000";
        }
        return "100";
    }

    private int getRootStatus() {
        return 0;
    }

    private String getUA() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(filter(Build.BRAND));
        stringBuffer.append("_");
        stringBuffer.append(filter(Build.MODEL));
        return stringBuffer.toString();
    }

    private String getAndroidVersion() {
        StringBuffer stringBuffer = new StringBuffer();
        Object obj = VERSION.RELEASE;
        if (TextUtils.isEmpty(obj)) {
            stringBuffer.append(UN_DEFINED);
        } else {
            stringBuffer.append(obj);
        }
        stringBuffer.append("_");
        stringBuffer.append(VERSION.SDK_INT);
        return stringBuffer.toString();
    }

    private StringBuffer filter(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.isEmpty(str)) {
            stringBuffer.append(UN_DEFINED);
            return stringBuffer;
        }
        char[] toCharArray = str.toCharArray();
        int i = 0;
        while (i < toCharArray.length) {
            if (!(toCharArray[i] <= ' ' || toCharArray[i] == '/' || toCharArray[i] == '_' || toCharArray[i] == '&' || toCharArray[i] == '|' || toCharArray[i] == '-')) {
                stringBuffer.append(toCharArray[i]);
            }
            i++;
        }
        return stringBuffer;
    }
}
