package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade;
import com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary;

public class PlayManagerImp implements IPlayManager {
    private static String TAG = "TV_Httpproxy";
    private static boolean mbSoLoadSuccess = false;
    private ConfigStorage mConfigStorageInstance;
    private HttpproxyFacade proxy;

    public PlayManagerImp() {
        this.proxy = null;
        this.mConfigStorageInstance = new ConfigStorage();
        this.proxy = HttpproxyFacade.instance();
    }

    private static boolean isWifiOn(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        if (activeNetworkInfo.getType() == 1) {
            return true;
        }
        return false;
    }

    public synchronized int init(Context context, String str) {
        int i = -1;
        synchronized (this) {
            if (context != null) {
                if (this.proxy != null) {
                    HttpproxyFacade.setContext(context);
                }
                if (!mbSoLoadSuccess) {
                    try {
                        TVHttpProxyLoadLibrary.load("wxhttpproxy", PlayManagerImp.class.getClassLoader(), context);
                        TVHttpProxyLoadLibrary.setupBrokenLibraryHandler();
                        mbSoLoadSuccess = true;
                    } catch (Throwable th) {
                        mbSoLoadSuccess = false;
                    }
                }
                try {
                    String downProxyConfig = ConfigStorage.getDownProxyConfig(context);
                    this.mConfigStorageInstance.synGetServerConfig(context);
                    if (str == null) {
                        str = "";
                    }
                    int init = this.proxy.init(str, downProxyConfig);
                    if (!isWifiOn(context)) {
                        this.proxy.setNetWorkState(2);
                    }
                    i = init;
                } catch (Throwable th2) {
                }
            }
        }
        return i;
    }

    public synchronized void deinit() {
        try {
            this.mConfigStorageInstance.stopGetServerConfig();
            this.proxy.deinit();
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,deinit native not found");
        }
    }

    public synchronized String buildPlayURLMp4(int i) {
        String buildPlayURL;
        try {
            buildPlayURL = this.proxy.buildPlayURL(i);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,buildPlayURL native not found");
            buildPlayURL = "";
        }
        return buildPlayURL;
    }

    public synchronized void stopPlay(int i) {
        try {
            this.proxy.stopPlay(i);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,stopPlay native not found");
        }
    }

    public synchronized void setUtilsObject(IUtils iUtils) {
        try {
            this.proxy.setUtils(iUtils);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,setUtilsObject native not found");
        }
    }

    public synchronized void setCookie(String str) {
        try {
            this.proxy.setCookie(str);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,setCookie native not found");
        }
    }

    public synchronized void appToFront() {
        try {
            this.proxy.pushEvent(3);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,appToFront native not found");
        }
    }

    public synchronized void appToBack() {
        try {
            this.proxy.pushEvent(4);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,appToBack native not found");
        }
    }

    public synchronized String getProxyVersion() {
        String version;
        try {
            version = this.proxy.getVersion();
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,getProxyVersion native not found");
            version = "TVHttpproxy.1.0.0.0000";
        }
        return version;
    }

    public synchronized void setNetWorkState(int i) {
        try {
            this.proxy.setNetWorkState(i);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,setNetWorkStatus native not found");
        }
    }

    public synchronized void setPlayerState(int i) {
        try {
            this.proxy.setPlayerState(i);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,setPlayState native not found");
        }
    }

    public synchronized int startPlay(String str, int i, String str2, long j, int i2) {
        int startPlay;
        try {
            startPlay = this.proxy.startPlay(str, i, str2, j, i2);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,startPlay native not found");
            startPlay = -1;
        }
        return startPlay;
    }

    public synchronized int preLoad(int i, int i2) {
        int preLoad;
        try {
            preLoad = this.proxy.preLoad(i, i2);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,preLoad native not found");
            preLoad = -1;
        }
        return preLoad;
    }

    public synchronized int getCurrentOffset(int i) {
        int currentOffset;
        try {
            currentOffset = this.proxy.getCurrentOffset(i);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,getCurrentOffset native not found");
            currentOffset = 0;
        }
        return currentOffset;
    }

    public synchronized int getTotalOffset(int i) {
        int totalOffset;
        try {
            totalOffset = this.proxy.getTotalOffset(i);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,getTotalOffset native not found");
            totalOffset = 0;
        }
        return totalOffset;
    }

    public synchronized void setRemainTime(int i, int i2) {
        try {
            this.proxy.setRemainTime(i, i2);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,getTotalOffset native not found");
        }
    }

    public synchronized int getLocalServerPort() {
        int localServerPort;
        try {
            localServerPort = this.proxy.getLocalServerPort();
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,getLocalServerPort native not found");
            localServerPort = -1;
        }
        return localServerPort;
    }

    public synchronized int setMaxStorageSize(long j) {
        int maxStorageSize;
        try {
            maxStorageSize = this.proxy.setMaxStorageSize(j);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,setMaxStorageSize native not found");
            maxStorageSize = -1;
        }
        return maxStorageSize;
    }

    public synchronized int cleanStorage() {
        int cleanStorage;
        try {
            cleanStorage = this.proxy.cleanStorage();
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,cleanStorage native not found");
            cleanStorage = -1;
        }
        return cleanStorage;
    }
}
