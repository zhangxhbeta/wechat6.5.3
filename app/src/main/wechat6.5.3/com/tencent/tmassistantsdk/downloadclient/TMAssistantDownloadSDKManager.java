package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadSDKManager {
    protected static TMAssistantDownloadSDKManager mInstance = null;
    protected static ArrayList<TMAssistantDownloadOpenSDKClient> mOpenSDKClientList = new ArrayList();
    protected static ArrayList<TMAssistantDownloadSDKClient> mSDKClientList = new ArrayList();
    protected static TMAssistantDownloadSDKSettingClient mSDKSettingClient = null;
    protected Context mContext = null;

    protected TMAssistantDownloadSDKManager(Context context) {
        this.mContext = context;
    }

    public static synchronized TMAssistantDownloadSDKManager getInstance(Context context) {
        TMAssistantDownloadSDKManager tMAssistantDownloadSDKManager;
        synchronized (TMAssistantDownloadSDKManager.class) {
            if (mInstance == null) {
                mInstance = new TMAssistantDownloadSDKManager(context);
            }
            tMAssistantDownloadSDKManager = mInstance;
        }
        return tMAssistantDownloadSDKManager;
    }

    public synchronized TMAssistantDownloadSDKClient getDownloadSDKClient(String str) {
        TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient;
        if (str != null) {
            if (str.length() > 0) {
                Iterator it = mSDKClientList.iterator();
                while (it.hasNext()) {
                    tMAssistantDownloadSDKClient = (TMAssistantDownloadSDKClient) it.next();
                    if (tMAssistantDownloadSDKClient.mClientKey.equals(str)) {
                        break;
                    }
                }
                tMAssistantDownloadSDKClient = new TMAssistantDownloadSDKClient(this.mContext, str);
                tMAssistantDownloadSDKClient.initTMAssistantDownloadSDK();
                mSDKClientList.add(tMAssistantDownloadSDKClient);
            }
        }
        tMAssistantDownloadSDKClient = null;
        return tMAssistantDownloadSDKClient;
    }

    public synchronized TMAssistantDownloadSDKSettingClient getDownloadSDKSettingClient() {
        if (mSDKSettingClient == null) {
            TMAssistantDownloadSDKSettingClient tMAssistantDownloadSDKSettingClient = new TMAssistantDownloadSDKSettingClient(this.mContext, "TMAssistantDownloadSDKManager");
            mSDKSettingClient = tMAssistantDownloadSDKSettingClient;
            tMAssistantDownloadSDKSettingClient.initTMAssistantDownloadSDK();
        }
        return mSDKSettingClient;
    }

    public synchronized TMAssistantDownloadOpenSDKClient getDownloadOpenSDKClient(String str) {
        TMAssistantDownloadOpenSDKClient tMAssistantDownloadOpenSDKClient;
        Iterator it = mOpenSDKClientList.iterator();
        while (it.hasNext()) {
            tMAssistantDownloadOpenSDKClient = (TMAssistantDownloadOpenSDKClient) it.next();
            if (tMAssistantDownloadOpenSDKClient.mClientKey.equals(str)) {
                break;
            }
        }
        tMAssistantDownloadOpenSDKClient = new TMAssistantDownloadOpenSDKClient(this.mContext, str, "com.tencent.android.qqdownloader.SDKService");
        if (tMAssistantDownloadOpenSDKClient.initTMAssistantDownloadSDK()) {
            mOpenSDKClientList.add(tMAssistantDownloadOpenSDKClient);
        } else {
            tMAssistantDownloadOpenSDKClient = null;
        }
        return tMAssistantDownloadOpenSDKClient;
    }

    public synchronized boolean releaseDownloadSDKClient(String str) {
        boolean z;
        Iterator it = mSDKClientList.iterator();
        while (it.hasNext()) {
            TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient = (TMAssistantDownloadSDKClient) it.next();
            if (tMAssistantDownloadSDKClient != null && tMAssistantDownloadSDKClient.mClientKey.equals(str)) {
                tMAssistantDownloadSDKClient.unInitTMAssistantDownloadSDK();
                it.remove();
                z = true;
                break;
            }
        }
        if (mSDKSettingClient == null || !mSDKSettingClient.mClientKey.equals(str)) {
            z = false;
        } else {
            mSDKSettingClient.unInitTMAssistantDownloadSDK();
            mSDKSettingClient = null;
            z = true;
        }
        return z;
    }

    public static synchronized void closeAllService(Context context) {
        synchronized (TMAssistantDownloadSDKManager.class) {
            TMLog.i("TMAssistantDownloadSDKManager", "closeAllService method!");
            if (mInstance == null) {
                TMLog.i("TMAssistantDownloadSDKManager", "manager minstance == null");
            } else {
                if (mSDKClientList != null && mSDKClientList.size() > 0) {
                    Iterator it = mSDKClientList.iterator();
                    while (it.hasNext()) {
                        TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient = (TMAssistantDownloadSDKClient) it.next();
                        if (tMAssistantDownloadSDKClient != null) {
                            tMAssistantDownloadSDKClient.unInitTMAssistantDownloadSDK();
                        }
                    }
                    mSDKClientList.clear();
                }
                if (mSDKSettingClient != null) {
                    mSDKSettingClient.unInitTMAssistantDownloadSDK();
                    mSDKSettingClient = null;
                }
                mInstance = null;
            }
        }
    }

    public static String about() {
        return "TMAssistantDownloadSDKManager_2014_03_04_17_55_release_25406";
    }
}
