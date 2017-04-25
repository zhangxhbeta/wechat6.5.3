package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback.Stub;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface;
import com.tencent.tmassistantsdk.util.TMLog;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class TMAssistantDownloadSDKClient extends TMAssistantDownloadSDKClientBase {
    protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService";
    protected static final String TAG = "TMAssistantDownloadSDKClient";
    protected ReferenceQueue<ITMAssistantDownloadSDKClientListener> mListenerReferenceQueue;
    protected ArrayList<WeakReference<ITMAssistantDownloadSDKClientListener>> mWeakListenerArrayList;

    public TMAssistantDownloadSDKClient(Context context, String str) {
        super(context, str, DOWNDLOADSDKSERVICENAME);
        this.mListenerReferenceQueue = new ReferenceQueue();
        this.mWeakListenerArrayList = new ArrayList();
        this.mServiceCallback = new Stub() {
            public void OnDownloadSDKServiceTaskStateChanged(String str, String str2, int i, int i2, String str3) {
                TMLog.i(TMAssistantDownloadSDKClient.TAG, "OnDownloadStateChanged,clientKey:" + str + ",state:" + i + ", errorcode" + i2 + ",url:" + str2);
                Iterator it = TMAssistantDownloadSDKClient.this.mWeakListenerArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener) weakReference.get();
                    if (iTMAssistantDownloadSDKClientListener == null) {
                        TMLog.i(TMAssistantDownloadSDKClient.TAG, " listener = " + iTMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + weakReference);
                    }
                    TMAssistantDownloadSDKMessageThread.getInstance().postTaskStateChangedMessage(TMAssistantDownloadSDKClient.this, iTMAssistantDownloadSDKClientListener, str2, i, i2, str3);
                }
            }

            public void OnDownloadSDKServiceTaskProgressChanged(String str, String str2, long j, long j2) {
                TMLog.i(TMAssistantDownloadSDKClient.TAG, "OnDownloadProgressChanged,clientKey:" + str + ",receivedLen:" + j + ",totalLen:" + j2 + ",url:" + str2);
                Iterator it = TMAssistantDownloadSDKClient.this.mWeakListenerArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener) weakReference.get();
                    if (iTMAssistantDownloadSDKClientListener == null) {
                        TMLog.i(TMAssistantDownloadSDKClient.TAG, " listener = " + iTMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + weakReference);
                    }
                    TMAssistantDownloadSDKMessageThread.getInstance().postTaskProgressChangedMessage(TMAssistantDownloadSDKClient.this, iTMAssistantDownloadSDKClientListener, str2, j, j2);
                }
            }
        };
    }

    public synchronized TMAssistantDownloadTaskInfo getDownloadTaskState(String str) {
        TMAssistantDownloadTaskInfo downloadTaskInfo;
        TMLog.i(TAG, "getDownloadTaskState,clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            throw new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            downloadTaskInfo = iTMAssistantDownloadSDKServiceInterface.getDownloadTaskInfo(this.mClientKey, str);
        } else {
            super.initTMAssistantDownloadSDK();
            downloadTaskInfo = null;
        }
        return downloadTaskInfo;
    }

    public synchronized int startDownloadTask(String str, String str2) {
        return startDownloadTask(str, 0, str2, null, null);
    }

    public synchronized int startDownloadTask(String str, String str2, Map<String, String> map) {
        return startDownloadTask(str, 0, str2, null, map);
    }

    public synchronized int startDownloadTask(String str, String str2, String str3) {
        return startDownloadTask(str, 0, str2, str3, null);
    }

    public synchronized int startDownloadTask(String str, int i, String str2, String str3, Map<String, String> map) {
        int startDownloadTask;
        TMLog.i(TAG, "startDownloadTask,clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        } else if (str2.equals("resource/tm.android.unknown") && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("if contentType is others, filename shouldn't be null!");
        } else {
            ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
            if (iTMAssistantDownloadSDKServiceInterface != null) {
                startDownloadTask = iTMAssistantDownloadSDKServiceInterface.startDownloadTask(this.mClientKey, str, 0, str2, str3, map);
            } else {
                super.initTMAssistantDownloadSDK();
                startDownloadTask = 0;
            }
        }
        return startDownloadTask;
    }

    public synchronized void pauseDownloadTask(String str) {
        TMLog.i(TAG, "pauseDownloadTask,clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.pauseDownloadTask(this.mClientKey, str);
        } else {
            super.initTMAssistantDownloadSDK();
        }
    }

    public synchronized void cancelDownloadTask(String str) {
        TMLog.i(TAG, "cancelDownloadTask,clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.cancelDownloadTask(this.mClientKey, str);
        } else {
            super.initTMAssistantDownloadSDK();
        }
    }

    public synchronized boolean registerDownloadTaskListener(ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener) {
        boolean z;
        if (iTMAssistantDownloadSDKClientListener == null) {
            z = false;
        } else {
            while (true) {
                Reference poll = this.mListenerReferenceQueue.poll();
                if (poll == null) {
                    break;
                }
                TMLog.i(TAG, "registerDownloadTaskListener removed listener!!!!");
                this.mWeakListenerArrayList.remove(poll);
            }
            Iterator it = this.mWeakListenerArrayList.iterator();
            while (it.hasNext()) {
                if (((ITMAssistantDownloadSDKClientListener) ((WeakReference) it.next()).get()) == iTMAssistantDownloadSDKClientListener) {
                    z = true;
                    break;
                }
            }
            this.mWeakListenerArrayList.add(new WeakReference(iTMAssistantDownloadSDKClientListener, this.mListenerReferenceQueue));
            z = true;
        }
        return z;
    }

    public synchronized boolean unRegisterDownloadTaskListener(ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener) {
        boolean z;
        if (iTMAssistantDownloadSDKClientListener == null) {
            z = false;
        } else {
            Iterator it = this.mWeakListenerArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (((ITMAssistantDownloadSDKClientListener) weakReference.get()) == iTMAssistantDownloadSDKClientListener) {
                    this.mWeakListenerArrayList.remove(weakReference);
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    protected void onDownloadSDKServiceInvalid() {
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            TMAssistantDownloadSDKMessageThread.getInstance().postSDKServiceInvalidMessage(this, (ITMAssistantDownloadSDKClientListener) ((WeakReference) it.next()).get());
        }
    }

    protected void stubAsInterface(IBinder iBinder) {
        this.mServiceInterface = ITMAssistantDownloadSDKServiceInterface.Stub.asInterface(iBinder);
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

    public static String about() {
        return "TMAssistantDownloadSDKClient_2014_03_06_11_20_release_25634";
    }
}
