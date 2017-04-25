package com.tencent.tmassistantsdk.downloadservice;

import android.text.TextUtils;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.HashMap;

public class DownloadSetting {
    public static final String ISDOWNLOADWIFIONLY = "isDownloadWifiOnly";
    public static final String ISTASKAUTORESUME = "isTaskAutoResume";
    public static final String MAXTASKNUM = "maxTaskNum";
    private static final String TAG = "DownloadSetting";
    public static final String TYPE_BOOLEAN = "boolean";
    public static final String TYPE_INTEGER = "Integer";
    protected static DownloadSetting mInstance = null;
    protected boolean isDownloadWifiOnly = false;
    protected boolean isTaskAutoResume = true;
    protected int maxTaskNum = 5;

    public DownloadSetting() {
        loadFromDB();
    }

    public static synchronized DownloadSetting getInstance() {
        DownloadSetting downloadSetting;
        synchronized (DownloadSetting.class) {
            if (mInstance == null) {
                mInstance = new DownloadSetting();
            }
            downloadSetting = mInstance;
        }
        return downloadSetting;
    }

    static int getSplitSizeInBytes(String str) {
        if (str.equalsIgnoreCase("WIFI")) {
            throw new UnsupportedOperationException("Split is not allowed in current version. netType: " + str);
        } else if (!str.contains("net") && str.contains("wap")) {
            return 409600;
        } else {
            return 921600;
        }
    }

    public void setIsTaskAutoResume(boolean z) {
        if (mInstance.isTaskAutoResume != z) {
            mInstance.isTaskAutoResume = z;
            DownloadSettingTable.save(ISTASKAUTORESUME, String.valueOf(z), TYPE_BOOLEAN);
        }
    }

    public void setIsDownloadWifiOnly(boolean z) {
        if (mInstance.isDownloadWifiOnly != z) {
            mInstance.isDownloadWifiOnly = z;
            DownloadSettingTable.save(ISDOWNLOADWIFIONLY, String.valueOf(z), TYPE_BOOLEAN);
        }
    }

    public void setMaxTaskNum(int i) {
        if (mInstance.maxTaskNum != i) {
            mInstance.maxTaskNum = i;
            DownloadSettingTable.save(MAXTASKNUM, String.valueOf(i), TYPE_INTEGER);
        }
    }

    private void loadFromDB() {
        boolean z = false;
        HashMap query = DownloadSettingTable.query();
        String str = (String) query.get(ISTASKAUTORESUME);
        if (str != null && str.length() > 0) {
            this.isTaskAutoResume = !str.equals("false");
        }
        str = (String) query.get(ISDOWNLOADWIFIONLY);
        if (str != null && str.length() > 0) {
            if (!str.equals("false")) {
                z = true;
            }
            this.isDownloadWifiOnly = z;
        }
        str = (String) query.get(MAXTASKNUM);
        if (str != null && str.length() > 0) {
            this.maxTaskNum = Integer.valueOf(str).intValue();
        }
    }

    public boolean getIsTaskAutoResume() {
        return this.isTaskAutoResume;
    }

    public boolean getIsDownloadWifiOnly() {
        return this.isDownloadWifiOnly;
    }

    public int getMaxTaskNum() {
        return this.maxTaskNum;
    }

    public boolean isAutoDownload() {
        if (this.isTaskAutoResume) {
            String netStatus = DownloadHelper.getNetStatus();
            if (netStatus.contains("wifi") || netStatus.contains("net")) {
                return true;
            }
        }
        return false;
    }

    public boolean isAutoDownload(String str, String str2) {
        TMLog.i(TAG, "downloadInfoNetType = " + str);
        TMLog.i(TAG, "currentNetType = " + str2);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str2.equalsIgnoreCase("WIFI")) {
            return true;
        }
        if (!str2.contains("net") || str.equalsIgnoreCase("WIFI")) {
            return false;
        }
        return true;
    }
}
