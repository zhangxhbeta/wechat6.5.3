package com.tencent.tmassistantsdk.downloadservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.recovery.b;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface.Stub;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.IServiceDownloadTaskManagerListener;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTaskManager;
import com.tencent.tmassistantsdk.logreport.GetSettingEngine;
import com.tencent.tmassistantsdk.logreport.LogReportManager;
import com.tencent.tmassistantsdk.storage.DBManager;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.HashMap;
import java.util.Map;

public class TMAssistantDownloadSDKService extends Service implements IServiceDownloadTaskManagerListener {
    protected static final String TAG = "TMAssistantDownloadSDKService";
    protected final TMAssistantDownloadSDKServiceImpl downloadSDKServiceImpl = new TMAssistantDownloadSDKServiceImpl();
    protected final HashMap<ITMAssistantDownloadSDKServiceCallback, String> mCallbackHashMap = new HashMap();
    protected final RemoteCallbackList<ITMAssistantDownloadSDKServiceCallback> mCallbacks = new RemoteCallbackList();
    ServiceDownloadTaskManager mServiceDownloadTaskManager = null;

    protected class TMAssistantDownloadSDKServiceImpl extends Stub {
        protected TMAssistantDownloadSDKServiceImpl() {
        }

        public int getServiceVersion() {
            return 1;
        }

        public void setServiceSetingIsTaskAutoResume(boolean z) {
            DownloadSetting.getInstance().setIsTaskAutoResume(z);
        }

        public void setServiceSetingIsDownloadWifiOnly(boolean z) {
            DownloadSetting.getInstance().setIsDownloadWifiOnly(z);
        }

        public void setServiceSetingMaxTaskNum(int i) {
            DownloadSetting.getInstance().setMaxTaskNum(i);
        }

        public boolean isAllDownloadFinished() {
            return ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
        }

        public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String str, String str2) {
            TMLog.i(TMAssistantDownloadSDKService.TAG, "getDownloadTaskInfo");
            if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
                return TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.getDownloadTaskInfo(str, str2);
            }
            return null;
        }

        public int startDownloadTask(String str, String str2, int i, String str3, String str4, Map map) {
            TMLog.i(TMAssistantDownloadSDKService.TAG, "startDownloadTask，clientkey:" + str + ",url:" + str2 + ",manager:" + TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager + ",fileName:" + str4);
            if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager == null) {
                return 3;
            }
            DBManager.getInstance().saveClientInfo(str, str2);
            return TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.startDownload(str, str2, i, str3, str4, map);
        }

        public void pauseDownloadTask(String str, String str2) {
            TMLog.i(TMAssistantDownloadSDKService.TAG, "pauseDownloadTask");
            try {
                if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
                    TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.pauseDownload(str, str2);
                }
            } catch (Throwable e) {
                v.a(TMAssistantDownloadSDKService.TAG, e, "", new Object[0]);
            }
            TMLog.i(TMAssistantDownloadSDKService.TAG, "pauseDownloadTask end");
        }

        public void cancelDownloadTask(String str, String str2) {
            if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
                TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.cancelDownload(str, str2);
            }
        }

        public void registerDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
            TMLog.i(TMAssistantDownloadSDKService.TAG, "registerDownloadTaskCallback,clientKey:" + str);
            if (str != null && iTMAssistantDownloadSDKServiceCallback != null) {
                TMAssistantDownloadSDKService.this.mCallbacks.register(iTMAssistantDownloadSDKServiceCallback);
                synchronized (this) {
                    TMAssistantDownloadSDKService.this.mCallbackHashMap.put(iTMAssistantDownloadSDKServiceCallback, str);
                }
            }
        }

        public void unregisterDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
            TMLog.i(TMAssistantDownloadSDKService.TAG, "unregisterDownloadTaskCallback,clientKey:" + str);
            if (str != null && iTMAssistantDownloadSDKServiceCallback != null) {
                TMAssistantDownloadSDKService.this.mCallbacks.unregister(iTMAssistantDownloadSDKServiceCallback);
                synchronized (this) {
                    TMAssistantDownloadSDKService.this.mCallbackHashMap.remove(iTMAssistantDownloadSDKServiceCallback);
                }
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        GlobalUtil.getInstance().setContext(this);
        NetworkMonitorReceiver.getInstance().registerReceiver();
        this.mServiceDownloadTaskManager = new ServiceDownloadTaskManager(DBManager.getInstance().queryWaitingAndDownloadingTaskList());
        this.mServiceDownloadTaskManager.setListener(this);
        this.mServiceDownloadTaskManager.registerApkDownloadManagerListener();
        ApkDownloadManager.getInstance().init();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (Throwable e) {
                    v.a(TMAssistantDownloadSDKService.TAG, e, "", new Object[0]);
                }
                GetSettingEngine.getInstance().sendRequest();
                LogReportManager.getInstance().reportLog();
            }
        }).start();
        TMLog.i(TAG, "onCreate");
    }

    public IBinder onBind(Intent intent) {
        TMLog.i(TAG, "onBind ,intent:" + intent);
        return this.downloadSDKServiceImpl;
    }

    public boolean onUnbind(Intent intent) {
        TMLog.i(TAG, "onUnbind ,intent:" + intent);
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        TMLog.i(TAG, "onDestroy");
        super.onDestroy();
        ApkDownloadManager.getInstance().uninit();
        GetSettingEngine.getInstance().cancleRequest();
        LogReportManager.getInstance().cancleReport();
        LogReportManager.getInstance().destory();
        this.mServiceDownloadTaskManager.unRegisterApkDownloadManagerListener();
        this.mServiceDownloadTaskManager.setListener(null);
        this.mServiceDownloadTaskManager = null;
        NetworkMonitorReceiver.getInstance().unregisterReceiver();
        GlobalUtil.getInstance().destroy();
        SystemClock.sleep(300);
        int myPid = Process.myPid();
        b.yH(13);
        Process.killProcess(myPid);
    }

    public void OnDownloadStateChanged(String str, String str2, int i, int i2, String str3) {
        try {
            int beginBroadcast = this.mCallbacks.beginBroadcast();
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                try {
                    ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback = (ITMAssistantDownloadSDKServiceCallback) this.mCallbacks.getBroadcastItem(i3);
                    String str4 = (String) this.mCallbackHashMap.get(iTMAssistantDownloadSDKServiceCallback);
                    if (str4 != null && str4.equals(str)) {
                        TMLog.i(TAG, "OnDownloadStateChanged,clientKey:" + str + ",state:" + i + ",url:" + str2);
                        iTMAssistantDownloadSDKServiceCallback.OnDownloadSDKServiceTaskStateChanged(str, str2, i, i2, str3);
                        break;
                    }
                } catch (RemoteException e) {
                }
            }
            this.mCallbacks.finishBroadcast();
        } catch (Throwable th) {
        }
    }

    public void OnDownloadProgressChanged(String str, String str2, long j, long j2) {
        try {
            int beginBroadcast = this.mCallbacks.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback = (ITMAssistantDownloadSDKServiceCallback) this.mCallbacks.getBroadcastItem(i);
                    String str3 = (String) this.mCallbackHashMap.get(iTMAssistantDownloadSDKServiceCallback);
                    if (str3 != null && str3.equals(str)) {
                        TMLog.i(TAG, "OnDownloadProgressChanged,clientKey:" + str + ",receivedLen:" + j + ",url:" + str2);
                        iTMAssistantDownloadSDKServiceCallback.OnDownloadSDKServiceTaskProgressChanged(str, str2, j, j2);
                        break;
                    }
                } catch (RemoteException e) {
                }
            }
            this.mCallbacks.finishBroadcast();
        } catch (Throwable th) {
        }
    }
}
