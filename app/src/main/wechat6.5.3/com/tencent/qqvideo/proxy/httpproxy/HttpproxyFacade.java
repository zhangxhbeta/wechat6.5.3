package com.tencent.qqvideo.proxy.httpproxy;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.qqvideo.proxy.common.ConfigStorage;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import org.json.JSONObject;

public class HttpproxyFacade {
    private static String TAG = "TV_Httpproxy";
    private static final String dev_type = "2";
    private static Context mContext = null;
    private static HttpproxyFacade mInstance = null;
    private static boolean mbHttpProxyExist = false;
    private IUtils mUtils = null;

    public native String buildPlayURL(int i);

    public native int cleanStorage();

    public native void deinit();

    public native int getCurrentOffset(int i);

    public native int getLocalServerPort();

    public native int getTotalOffset(int i);

    public native String getVersion();

    public native int init(String str, String str2);

    public native int preLoad(int i, int i2);

    public native void pushEvent(int i);

    public native void setCookie(String str);

    public native int setMaxStorageSize(long j);

    public native void setNetWorkState(int i);

    public native void setPlayerState(int i);

    public native void setRemainTime(int i, int i2);

    public native int startPlay(String str, int i, String str2, long j, int i2);

    public native void stopPlay(int i);

    private HttpproxyFacade() {
    }

    public static synchronized HttpproxyFacade instance() {
        HttpproxyFacade httpproxyFacade;
        synchronized (HttpproxyFacade.class) {
            if (mInstance == null) {
                mInstance = new HttpproxyFacade();
            }
            httpproxyFacade = mInstance;
        }
        return httpproxyFacade;
    }

    public static boolean isLoadSuccess() {
        return mbHttpProxyExist;
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    public void setUtils(IUtils iUtils) {
        this.mUtils = iUtils;
    }

    public static synchronized void javaUtilLog(String str) {
        synchronized (HttpproxyFacade.class) {
            HttpproxyFacade instance = instance();
            if (instance.mUtils != null) {
                instance.mUtils.javaUtilLog(4, TAG, str);
            }
        }
    }

    public static void print(int i, String str, String str2) {
        HttpproxyFacade instance = instance();
        if (instance.mUtils != null) {
            instance.mUtils.javaUtilLog(i, str, str2);
        }
    }

    public static void jsonReport(String str) {
        try {
            Object valueOf;
            String str2;
            String deviceID = VcSystemInfo.getDeviceID(mContext);
            String osVersion = VcSystemInfo.getOsVersion();
            int netWorkType = VcSystemInfo.getNetWorkType(mContext);
            String str3 = "";
            WifiInfo connectionInfo = ((WifiManager) mContext.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo.getBSSID() != null) {
                valueOf = String.valueOf(WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 5));
            } else {
                str2 = str3;
            }
            str3 = ConfigStorage.getHttpProxyVersion();
            String configVersion = ConfigStorage.getConfigVersion();
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("dev_id", deviceID);
            jSONObject.put("dev_type", dev_type);
            jSONObject.put("os_ver", osVersion);
            jSONObject.put("net_type", netWorkType);
            jSONObject.put("net_stren", valueOf);
            jSONObject.put("config_ver", configVersion);
            jSONObject.put("proxy_ver", str3);
            str3 = jSONObject.toString().replace(",", ";");
            if (!TextUtils.isEmpty(str3)) {
                HttpproxyFacade instance = instance();
                if (instance.mUtils == null) {
                    return;
                }
                if (str3.length() <= BaseReportManager.MAX_READ_COUNT) {
                    instance.mUtils.httpproxyReport(str3);
                    return;
                }
                int length = str3.length();
                if (length > 2000) {
                    length = 2000;
                }
                String substring = str3.substring(0, BaseReportManager.MAX_READ_COUNT);
                str2 = str3.substring(BaseReportManager.MAX_READ_COUNT, length);
                instance.mUtils.httpproxyReport(substring, str2);
            }
        } catch (Throwable th) {
            print(6, TAG, "reportMTA exception");
        }
    }

    public static void idKeyReport(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                HttpproxyFacade instance = instance();
                if (instance.mUtils != null) {
                    new StringBuilder("idKeyReport:id=").append(str).append(",key=").append(str2).append(",value=").append(str3);
                    instance.mUtils.idKeyReport(str, str2, str3);
                }
            }
        } catch (Throwable th) {
            print(6, TAG, "idKeyReport exception");
        }
    }

    public static void kvReport(String str) {
        try {
            String httpProxyVersionCode = ConfigStorage.getHttpProxyVersionCode();
            String configVersion = ConfigStorage.getConfigVersion();
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("DownloadResult");
            String optString2 = jSONObject.optString("OptimalCDN");
            String optString3 = jSONObject.optString("VideoRate");
            String optString4 = jSONObject.optString("VideoTotalFileLength");
            String optString5 = jSONObject.optString("VideoContentLength");
            String optString6 = jSONObject.optString("DownloadTotalFlow");
            String optString7 = jSONObject.optString("DownloadCostTime");
            String optString8 = jSONObject.optString("DownloadAverageSpeed");
            String optString9 = jSONObject.optString("DownloadMaxSpeed");
            String optString10 = jSONObject.optString("DownloadMinSpeed");
            HttpproxyFacade instance = instance();
            if (instance.mUtils != null) {
                instance.mUtils.kvReport(optString, optString2, httpProxyVersionCode, configVersion, optString3, optString4, optString5, optString6, optString7, optString8, optString9, optString10);
            }
        } catch (Throwable th) {
            print(6, TAG, "kvReport exception");
        }
    }
}
