package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface.Stub;

public class TMAssistantDownloadSDKSettingClient extends TMAssistantDownloadSDKClientBase {
    protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService";

    public TMAssistantDownloadSDKSettingClient(Context context, String str) {
        super(context, str, DOWNDLOADSDKSERVICENAME);
    }

    public synchronized int getVersion() {
        int serviceVersion;
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            serviceVersion = iTMAssistantDownloadSDKServiceInterface.getServiceVersion();
        } else {
            super.initTMAssistantDownloadSDK();
            serviceVersion = 0;
        }
        return serviceVersion;
    }

    public synchronized void setDownloadSDKWifiOnly(boolean z) {
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.setServiceSetingIsDownloadWifiOnly(z);
        } else {
            super.initTMAssistantDownloadSDK();
        }
    }

    public synchronized void setDownloadSDKMaxTaskNum(int i) {
        if (i > 0 && i <= 10) {
            ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
            if (iTMAssistantDownloadSDKServiceInterface != null) {
                iTMAssistantDownloadSDKServiceInterface.setServiceSetingMaxTaskNum(i);
            } else {
                super.initTMAssistantDownloadSDK();
            }
        }
    }

    public synchronized boolean isAllDownloadFinished() {
        boolean isAllDownloadFinished;
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            isAllDownloadFinished = iTMAssistantDownloadSDKServiceInterface.isAllDownloadFinished();
        } else {
            super.initTMAssistantDownloadSDK();
            isAllDownloadFinished = false;
        }
        return isAllDownloadFinished;
    }

    protected void onDownloadSDKServiceInvalid() {
    }

    protected void stubAsInterface(IBinder iBinder) {
        this.mServiceInterface = Stub.asInterface(iBinder);
    }

    protected void registerServiceCallback() {
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).registerDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
    }

    protected Intent getBindServiceIntent() {
        return new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
    }

    protected void unRegisterServiceCallback() {
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).unregisterDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
    }
}
