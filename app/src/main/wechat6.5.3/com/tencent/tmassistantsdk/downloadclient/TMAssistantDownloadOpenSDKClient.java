package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.b.a.a.b;
import com.tencent.b.a.a.b.a;
import com.tencent.tmassistantsdk.util.Base64;
import com.tencent.tmassistantsdk.util.Cryptor;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadOpenSDKClient extends TMAssistantDownloadSDKClientBase {
    protected static final String TAG = "TMAssistantDownloadOpenSDKClient";
    ArrayList<IAssistantOnActionListener> mListeners;
    protected boolean retryBindResult;
    protected int retryCount;

    public TMAssistantDownloadOpenSDKClient(Context context, String str, String str2) {
        super(context, str, str2);
        this.retryBindResult = false;
        this.retryCount = 0;
        this.mListeners = new ArrayList();
        this.mServiceCallback = new a() {
            public void onActionResult(byte[] bArr) {
                TMLog.i(TMAssistantDownloadOpenSDKClient.TAG, "onActionResult  callBack data:" + bArr + "  mListeners.size:" + TMAssistantDownloadOpenSDKClient.this.mListeners.size());
                TMAssistantDownloadSDKMessageThread.getInstance().postActionResult(bArr, TMAssistantDownloadOpenSDKClient.this.mListeners);
            }
        };
    }

    public byte[] sendSyncData(byte[] bArr) {
        if (!TextUtils.isEmpty(this.mClientKey)) {
            com.tencent.b.a.a.a aVar = (com.tencent.b.a.a.a) super.getServiceInterface();
            if (aVar != null) {
                return aVar.c(this.mClientKey, bArr);
            }
        }
        return null;
    }

    public void sendAsyncData(byte[] bArr) {
        if (!TextUtils.isEmpty(this.mClientKey)) {
            com.tencent.b.a.a.a aVar = (com.tencent.b.a.a.a) super.getServiceInterface();
            if (aVar != null) {
                aVar.d(this.mClientKey, bArr);
            }
        }
    }

    public void addAssistantOnActionListener(IAssistantOnActionListener iAssistantOnActionListener) {
        TMLog.i(TAG, "addAssistantOnActionListener");
        if (iAssistantOnActionListener != null && !this.mListeners.contains(iAssistantOnActionListener)) {
            this.mListeners.add(iAssistantOnActionListener);
        }
    }

    protected void onDownloadSDKServiceInvalid() {
        if (this.mListeners != null && this.mListeners.size() > 0) {
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                IAssistantOnActionListener iAssistantOnActionListener = (IAssistantOnActionListener) it.next();
                if (iAssistantOnActionListener != null) {
                    iAssistantOnActionListener.onDownloadSDKServiceInvalid();
                }
            }
        }
    }

    protected void stubAsInterface(IBinder iBinder) {
        this.mServiceInterface = com.tencent.b.a.a.a.a.y(iBinder);
    }

    protected void registerServiceCallback() {
        String encodeToString = Base64.encodeToString(new Cryptor().encrypt(String.valueOf(System.currentTimeMillis()).getBytes(), this.mClientKey.getBytes()), 0);
        int a = ((com.tencent.b.a.a.a) this.mServiceInterface).a(this.mClientKey, encodeToString, (b) this.mServiceCallback);
        TMLog.i(TAG, "onServiceConnected,registerActionCallback:" + this.mClientKey + ",tokenString:" + encodeToString + ",threadId:" + Thread.currentThread().getId() + ",mServiceCallback:" + this.mServiceCallback + ",registed result:" + a);
        if (a == 2) {
            onDownloadSDKServiceInvalid();
        }
    }

    protected Intent getBindServiceIntent() {
        Intent intent = new Intent(this.mDwonloadServiceName);
        intent.setPackage("com.tencent.android.qqdownloader");
        return intent;
    }

    protected void unRegisterServiceCallback() {
        if (((com.tencent.b.a.a.a) this.mServiceInterface).a((b) this.mServiceCallback) == 2) {
            onDownloadSDKServiceInvalid();
        }
    }

    public synchronized boolean initTMAssistantDownloadSDK() {
        boolean initTMAssistantDownloadSDK;
        initTMAssistantDownloadSDK = super.initTMAssistantDownloadSDK();
        TMLog.i(TAG, "initTMAssistantDownloadSDK bindResult:" + initTMAssistantDownloadSDK);
        if (!initTMAssistantDownloadSDK) {
            try {
                Intent intent = new Intent();
                intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
                intent.addFlags(268435456);
                this.mContext.startActivity(intent);
            } catch (Exception e) {
                TMLog.w(TAG, "retry bind service startActivity Exception:" + e.toString());
            }
            HandlerThread handlerThread = new HandlerThread("retry_thread");
            handlerThread.start();
            final Handler handler = new Handler(handlerThread.getLooper());
            handler.postDelayed(new Runnable() {
                public void run() {
                    try {
                        Intent bindServiceIntent = TMAssistantDownloadOpenSDKClient.this.getBindServiceIntent();
                        TMAssistantDownloadOpenSDKClient.this.retryBindResult = TMAssistantDownloadOpenSDKClient.this.mContext.bindService(bindServiceIntent, TMAssistantDownloadOpenSDKClient.this, 1);
                    } catch (Exception e) {
                        TMLog.e(TMAssistantDownloadOpenSDKClient.TAG, "retry bind service Exception:" + e.toString());
                    }
                    TMAssistantDownloadOpenSDKClient tMAssistantDownloadOpenSDKClient = TMAssistantDownloadOpenSDKClient.this;
                    tMAssistantDownloadOpenSDKClient.retryCount++;
                    TMLog.i(TMAssistantDownloadOpenSDKClient.TAG, "retry bind service! retryBindResult:" + TMAssistantDownloadOpenSDKClient.this.retryBindResult + ",retryCount:" + TMAssistantDownloadOpenSDKClient.this.retryCount);
                    if (!TMAssistantDownloadOpenSDKClient.this.retryBindResult && TMAssistantDownloadOpenSDKClient.this.retryCount < 3) {
                        handler.postDelayed(this, 1000);
                    }
                }
            }, 1000);
        }
        return initTMAssistantDownloadSDK;
    }

    public static String about() {
        return "TMAssistantDownloadOpenSDKClient_2014_03_06_11_20_release_25634";
    }
}
