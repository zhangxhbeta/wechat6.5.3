package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.logreport.DownloadReportManager;
import com.tencent.tmassistantsdk.logreport.GetSettingEngine;
import com.tencent.tmassistantsdk.logreport.LogReportManager;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled.IQQDownloaderInstalled;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class TMQQDownloaderOpenSDK_V2 extends BaseQQDownloaderOpenSDK implements ITMQQDownloaderOpenSDKListener, IQQDownloaderInstalled {
    protected static final String TAG = "QQDownloaderOpenSDK";
    protected static TMQQDownloaderOpenSDK_V2 mInstance = null;
    protected CopyOnWriteArrayList<TMQQDownloaderOpenSDKParam> mTaskList;

    protected TMQQDownloaderOpenSDK_V2() {
        this.mTaskList = null;
        this.mTaskList = new CopyOnWriteArrayList();
    }

    public static synchronized TMQQDownloaderOpenSDK_V2 getInstance() {
        TMQQDownloaderOpenSDK_V2 tMQQDownloaderOpenSDK_V2;
        synchronized (TMQQDownloaderOpenSDK_V2.class) {
            if (mInstance == null) {
                mInstance = new TMQQDownloaderOpenSDK_V2();
            }
            tMQQDownloaderOpenSDK_V2 = mInstance;
        }
        return tMQQDownloaderOpenSDK_V2;
    }

    public void destroyQQDownloaderOpenSDK() {
        NetworkMonitorReceiver.getInstance().unregisterReceiver();
        GetSettingEngine.getInstance().cancleRequest();
        LogReportManager.getInstance().cancleReport();
        LogReportManager.getInstance().destory();
        if (this.mContext != null) {
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).unregisterIQQDownloaderOpenSDKListener();
            QQDownloaderInstalled.getInstance().unregisteListener();
            QQDownloaderInstalled.getInstance().unRegisteReceiver(this.mContext);
        }
        GlobalUtil.getInstance().destroy();
        this.mContext = null;
    }

    public void startToDownloadTaskList(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2, int i) {
        if (context == null) {
            throw new Exception("you must input an application or activity context!");
        } else if (tMQQDownloaderOpenSDKParam != null) {
            String uuid = UUID.randomUUID().toString();
            if (z) {
                JceStruct createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
                createNewChunkLogInfo.UUID = uuid;
                createNewChunkLogInfo.requestUrl = "";
                createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
                createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
                DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
            }
            if (tMQQDownloaderOpenSDKParam != null) {
                int i2;
                String formatOplist = super.formatOplist(z, z2);
                if (1 == i) {
                    i2 = 2;
                } else {
                    i2 = 5;
                }
                addToTaskList(tMQQDownloaderOpenSDKParam);
                TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(tMQQDownloaderOpenSDKParam, i2, formatOplist, tMQQDownloaderOpenSDKParam.actionFlag, null);
            }
        }
    }

    public void startToAppDetail(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2, int i) {
        int i2 = 1;
        if (context == null) {
            throw new Exception("you must input an application or activity context!");
        }
        String uuid = UUID.randomUUID().toString();
        if (z) {
            JceStruct createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
            createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
            createNewChunkLogInfo.UUID = uuid;
            createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
            createNewChunkLogInfo.resultState = 1;
            DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
        }
        if (tMQQDownloaderOpenSDKParam != null) {
            String formatOplist = super.formatOplist(z, z2);
            if (1 != i) {
                i2 = 4;
            }
            addToTaskList(tMQQDownloaderOpenSDKParam);
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(tMQQDownloaderOpenSDKParam, i2, formatOplist, tMQQDownloaderOpenSDKParam.actionFlag, null);
        }
    }

    public void startToAuthorized(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        if (context == null) {
            throw new Exception("you must input an application or activity context!");
        } else if (tMQQDownloaderOpenSDKParam == null) {
            throw new Exception("QQDownloaderParam param cann't be null!");
        } else {
            String uuid = UUID.randomUUID().toString();
            JceStruct createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
            createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
            createNewChunkLogInfo.UUID = uuid;
            createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
            createNewChunkLogInfo.resultState = 1;
            DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
            if (tMQQDownloaderOpenSDKParam != null) {
                addToTaskList(tMQQDownloaderOpenSDKParam);
                TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam2 = tMQQDownloaderOpenSDKParam;
                TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(tMQQDownloaderOpenSDKParam2, 3, super.formatOplist(true, true), tMQQDownloaderOpenSDKParam.actionFlag, str);
            }
        }
    }

    public void startToAuthorized(Context context, String str) {
        String formatEncryptUrl = super.formatEncryptUrl(str);
        if (!TextUtils.isEmpty(str) && this.mContext != null) {
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleUriAction(formatEncryptUrl);
        }
    }

    public void startToWebView(Context context, String str) {
        if (context == null) {
            throw new Exception("you must input an application or activity context!");
        } else if (TextUtils.isEmpty(str)) {
            throw new Exception("param url shouldn't be null!");
        } else {
            Map hashMap = new HashMap();
            hashMap.put("url", str);
            String formatIntentUriPath = super.formatIntentUriPath(5, hashMap);
            TMLog.i(TAG, "startToWebView finalPath:" + formatIntentUriPath);
            if (!TextUtils.isEmpty(str) && this.mContext != null) {
                TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleUriAction(formatIntentUriPath);
            }
        }
    }

    public int startToBatchUpdateOperation(Context context, ArrayList<TMQQDownloaderOpenSDKParam> arrayList, boolean z, int i, String str, String str2, String str3) {
        boolean z2 = true;
        if (context == null) {
            throw new Exception("you must input an application or activity context!");
        }
        int qQDownloadApiLevel = BaseQQDownloaderOpenSDK.getQQDownloadApiLevel(context);
        if (qQDownloadApiLevel <= 0) {
            return 1;
        }
        if (qQDownloadApiLevel < 4) {
            return 2;
        }
        if (!(arrayList == null || arrayList.size() == 0)) {
            z2 = false;
        }
        qQDownloadApiLevel = getBatchRequestType(z2, i);
        if (!TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleBatchRequestAction(qQDownloadApiLevel, arrayList, str, str2, str3)) {
            TMLog.w(TAG, "handleBatchRequestAction return false with batchRequestType=" + qQDownloadApiLevel);
        }
        return 0;
    }

    private int getBatchRequestType(boolean z, int i) {
        if (z) {
            switch (i) {
                case 1:
                    return 1;
                case 2:
                    return 6;
                case 3:
                    return 5;
                default:
                    return 2;
            }
        }
        switch (i) {
            case 0:
            case 1:
                return 4;
            case 2:
                return 8;
            case 3:
                return 7;
            default:
                return 2;
        }
    }

    public ArrayList<TMAssistantDownloadTaskInfo> getBatchTaskState(ArrayList<TMQQDownloaderOpenSDKParam> arrayList, String str, String str2, String str3) {
        if (this.mContext == null) {
            throw new Exception("mContext shouldn't be null !");
        } else if (arrayList == null || arrayList.size() <= 0) {
            throw new Exception("ArrayList<TMQQDownloaderOpenSDKParam> appList cann't be null or empty!");
        } else {
            int qQDownloadApiLevel = BaseQQDownloaderOpenSDK.getQQDownloadApiLevel(this.mContext);
            if (qQDownloadApiLevel <= 1) {
                return null;
            }
            if (qQDownloadApiLevel >= 4) {
                return TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getBatchTaskInfos(arrayList, str, str2, str3);
            }
            TMAssistantDownloadTaskInfo downloadTask = TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getDownloadTask((TMQQDownloaderOpenSDKParam) arrayList.get(0));
            if (downloadTask == null) {
                return null;
            }
            ArrayList<TMAssistantDownloadTaskInfo> arrayList2 = new ArrayList();
            arrayList2.add(downloadTask);
            return arrayList2;
        }
    }

    public long addBatchUpdateOperationToDB(ArrayList<TMQQDownloaderOpenSDKParam> arrayList, boolean z, int i, String str, String str2, String str3) {
        boolean z2 = arrayList == null || arrayList.size() == 0;
        int batchRequestType = getBatchRequestType(z2, i);
        if (!(batchRequestType == 3 || z2)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = (TMQQDownloaderOpenSDKParam) it.next();
                if (tMQQDownloaderOpenSDKParam != null) {
                    addToTaskList(tMQQDownloaderOpenSDKParam);
                }
            }
        }
        JceStruct buildBatchActionRequest = TMQQDownloaderOpenSDKDataProcessor.buildBatchActionRequest(batchRequestType, arrayList, str, str2, str3);
        if (buildBatchActionRequest != null) {
            byte[] buildSendData = TMQQDownloaderOpenSDKDataProcessor.buildSendData(buildBatchActionRequest);
            if (buildSendData != null) {
                return buildAddDBData(buildSendData);
            }
        }
        return -1;
    }

    public TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        if (this.mContext == null) {
            throw new Exception("Context shouldn't be null !");
        } else if (tMQQDownloaderOpenSDKParam != null) {
            return TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getDownloadTask(tMQQDownloaderOpenSDKParam);
        } else {
            throw new Exception("TMQQDownloaderOpenSDKParam param cann't is null!");
        }
    }

    private void onProgressChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, long j, long j2) {
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener) ((WeakReference) it.next()).get();
            if (iTMQQDownloaderOpenSDKListener == null) {
                TMLog.i(TAG, "onDownloadStateChanged listener = null");
            } else {
                iTMQQDownloaderOpenSDKListener.OnDownloadTaskProgressChanged(tMQQDownloaderOpenSDKParam, j, j2);
            }
        }
    }

    private synchronized void addToTaskList(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        if (tMQQDownloaderOpenSDKParam != null) {
            if (this.mTaskList != null) {
                Object obj;
                Iterator it = this.mTaskList.iterator();
                while (it.hasNext()) {
                    TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam2 = (TMQQDownloaderOpenSDKParam) it.next();
                    if (tMQQDownloaderOpenSDKParam2.taskAppId == null) {
                        if (tMQQDownloaderOpenSDKParam2.taskPackageName != null && tMQQDownloaderOpenSDKParam2.taskPackageName.equals(tMQQDownloaderOpenSDKParam.taskPackageName)) {
                            int i = 1;
                            break;
                        }
                    } else if (tMQQDownloaderOpenSDKParam2.taskAppId.equals(tMQQDownloaderOpenSDKParam.taskAppId) && (tMQQDownloaderOpenSDKParam2.taskPackageName == null || tMQQDownloaderOpenSDKParam2.taskPackageName.equals(tMQQDownloaderOpenSDKParam.taskPackageName))) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    this.mTaskList.add(tMQQDownloaderOpenSDKParam);
                }
            }
        }
    }

    public void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, int i, int i2, String str) {
        if (tMQQDownloaderOpenSDKParam != null) {
            onStateChanged(tMQQDownloaderOpenSDKParam, i, i2, str);
        }
    }

    public void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, long j, long j2) {
        if (tMQQDownloaderOpenSDKParam != null) {
            onProgressChanged(tMQQDownloaderOpenSDKParam, j, j2);
        }
    }

    public void OnQQDownloaderInvalid() {
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener) ((WeakReference) it.next()).get();
            if (iTMQQDownloaderOpenSDKListener == null) {
                TMLog.i(TAG, "OnQQDownloaderInvalid listener = null");
            } else {
                iTMQQDownloaderOpenSDKListener.OnQQDownloaderInvalid();
            }
        }
    }

    public synchronized void onQQDownloaderInstalled(Context context) {
        TMLog.i(TAG, "received qqdownload install broadcase!");
        if (this.mTaskList != null) {
            Iterator it = this.mTaskList.iterator();
            while (it.hasNext()) {
                TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = (TMQQDownloaderOpenSDKParam) it.next();
                if (tMQQDownloaderOpenSDKParam != null) {
                    try {
                        getDownloadTaskState(tMQQDownloaderOpenSDKParam);
                    } catch (Throwable e) {
                        v.a(TAG, e, "", new Object[0]);
                    }
                    this.mTaskList.remove(tMQQDownloaderOpenSDKParam);
                }
            }
        }
    }

    public void OnServiceFree() {
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener) ((WeakReference) it.next()).get();
            if (iTMQQDownloaderOpenSDKListener == null) {
                TMLog.i(TAG, "OnQQDownloaderInvalid listener = null");
            } else {
                iTMQQDownloaderOpenSDKListener.OnServiceFree();
            }
        }
    }

    public long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        addToTaskList(tMQQDownloaderOpenSDKParam);
        return super.buildAddDBData(tMQQDownloaderOpenSDKParam, z, z2, tMQQDownloaderOpenSDKParam.actionFlag, null, 2);
    }

    public long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        addToTaskList(tMQQDownloaderOpenSDKParam);
        return super.buildAddDBData(tMQQDownloaderOpenSDKParam, true, true, tMQQDownloaderOpenSDKParam.actionFlag, str, 3);
    }

    public long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        addToTaskList(tMQQDownloaderOpenSDKParam);
        return super.buildAddDBData(tMQQDownloaderOpenSDKParam, z, z2, tMQQDownloaderOpenSDKParam.actionFlag, null, 1);
    }

    public void initQQDownloaderOpenSDK(Context context) {
        this.mContext = context;
        this.hostPackageName = context.getPackageName();
        this.hostVersionCode = GlobalUtil.getAppVersionCode(this.mContext);
        GlobalUtil.getInstance().setContext(this.mContext);
        this.sdkAPILevel = 2;
        if (this.mContext != null) {
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).registerIQQDownloaderOpenSDKListener(this);
            QQDownloaderInstalled.getInstance().registeReceiver(this.mContext);
            QQDownloaderInstalled.getInstance().registeListener(this);
        }
        NetworkMonitorReceiver.getInstance().registerReceiver();
        GetSettingEngine.getInstance().sendRequest();
        LogReportManager.getInstance().reportLog();
    }

    public static String about() {
        return "TMQQDownloaderOpenSDK_2014_05_13_17_36_release_35169";
    }

    public void releaseIPCConnected() {
        if (this.mContext != null) {
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).releaseIPCClient();
        }
    }
}
