package com.tencent.tmassistantsdk.openSDK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannelDataItem;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.logreport.DownloadReportManager;
import com.tencent.tmassistantsdk.logreport.GetSettingEngine;
import com.tencent.tmassistantsdk.logreport.LogReportManager;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TMQQDownloaderOpenSDK extends BaseQQDownloaderOpenSDK implements IDownloadStateChangedListener {
    public static final String AUTHORITY = "com.tencent.android.qqdownloader.provider";
    public static final Uri CONTENT_URI = DownloadInfos.CONTENT_URI;
    protected static final String TAG = "QQDownloaderOpenSDK";
    protected static TMQQDownloaderOpenSDK mInstance = null;
    Map<String, TMQQDownloaderOpenSDKParam> mDownloadParams;
    protected int sdkAPILevel;

    private TMQQDownloaderOpenSDK() {
        this.sdkAPILevel = 1;
        this.mDownloadParams = null;
        this.mDownloadParams = new ConcurrentHashMap();
    }

    public static synchronized TMQQDownloaderOpenSDK getInstance() {
        TMQQDownloaderOpenSDK tMQQDownloaderOpenSDK;
        synchronized (TMQQDownloaderOpenSDK.class) {
            if (mInstance == null) {
                mInstance = new TMQQDownloaderOpenSDK();
            }
            tMQQDownloaderOpenSDK = mInstance;
        }
        return tMQQDownloaderOpenSDK;
    }

    public void destroyQQDownloaderOpenSDK() {
        NetworkMonitorReceiver.getInstance().unregisterReceiver();
        GetSettingEngine.getInstance().cancleRequest();
        LogReportManager.getInstance().cancleReport();
        LogReportManager.getInstance().destory();
        if (this.mContext != null) {
            DownloadStateChangedReceiver.getInstance().unRegisteReceiver(this.mContext);
            DownloadStateChangedReceiver.getInstance().removeDownloadStateChangedListener(this);
        }
        GlobalUtil.getInstance().destroy();
        this.mContext = null;
    }

    public static boolean isExistActoin(long j) {
        if (j < 0) {
            return false;
        }
        ArrayList channelDataItemList = new TMAssistantSDKChannel().getChannelDataItemList();
        if (channelDataItemList != null && channelDataItemList.size() > 0) {
            Iterator it = channelDataItemList.iterator();
            while (it.hasNext()) {
                TMAssistantSDKChannelDataItem tMAssistantSDKChannelDataItem = (TMAssistantSDKChannelDataItem) it.next();
                if (((long) tMAssistantSDKChannelDataItem.mDBIdentity) == j && tMAssistantSDKChannelDataItem.mDataItemEndTime - tMAssistantSDKChannelDataItem.mDataItemStartTime <= 300000) {
                    return true;
                }
            }
        }
        return false;
    }

    public int checkQQDownloaderInstalled(int i) {
        if (this.mContext == null) {
            throw new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
        }
        String str = "com.tencent.android.qqdownloader";
        PackageManager packageManager = this.mContext.getPackageManager();
        if (packageManager != null) {
            try {
                if (packageManager.getPackageInfo(str, 0) == null) {
                    return 1;
                }
                int qQDownloaderVersionCode = GlobalUtil.getInstance().getQQDownloaderVersionCode();
                if (this.sdkAPILevel <= GlobalUtil.getInstance().getQQDownloaderAPILevel() && i <= qQDownloaderVersionCode) {
                    return 0;
                }
                return 2;
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            }
        }
        return 1;
    }

    public void startQQDownloader(Context context) {
        if (context != null) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.android.qqdownloader");
            if (context instanceof Application) {
                launchIntentForPackage.addFlags(268435456);
            }
            context.startActivity(launchIntentForPackage);
        }
    }

    public void startToDownloadTaskList(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        if (context == null) {
            throw new Exception("you must input an application or activity context!");
        } else if (tMQQDownloaderOpenSDKParam != null) {
            String uuid = UUID.randomUUID().toString();
            if (this.mDownloadParams != null) {
                this.mDownloadParams.put(uuid, tMQQDownloaderOpenSDKParam);
            }
            if (z) {
                JceStruct createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
                createNewChunkLogInfo.UUID = uuid;
                createNewChunkLogInfo.requestUrl = "";
                createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
                createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
                DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
            }
            Map formatMapParams = super.formatMapParams(tMQQDownloaderOpenSDKParam, z, z2);
            formatMapParams.put("taskid", uuid);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(1, formatMapParams)));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        if (!(this.mDownloadParams == null || tMQQDownloaderOpenSDKParam == null)) {
            this.mDownloadParams.put(UUID.randomUUID().toString(), tMQQDownloaderOpenSDKParam);
        }
        return super.buildAddDBData(tMQQDownloaderOpenSDKParam, z, z2, tMQQDownloaderOpenSDKParam.actionFlag, null, 1);
    }

    public void startToAppDetail(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        if (context == null) {
            throw new Exception("you must input an application or activity context!");
        }
        String uuid = UUID.randomUUID().toString();
        if (this.mDownloadParams != null) {
            this.mDownloadParams.put(uuid, tMQQDownloaderOpenSDKParam);
        }
        if (z) {
            JceStruct createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
            createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
            createNewChunkLogInfo.UUID = uuid;
            createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
            createNewChunkLogInfo.resultState = 1;
            DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
        }
        Map formatMapParams = super.formatMapParams(tMQQDownloaderOpenSDKParam, z, z2);
        formatMapParams.put("taskid", uuid);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(2, formatMapParams)));
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        if (!(this.mDownloadParams == null || tMQQDownloaderOpenSDKParam == null)) {
            this.mDownloadParams.put(UUID.randomUUID().toString(), tMQQDownloaderOpenSDKParam);
        }
        return super.buildAddDBData(tMQQDownloaderOpenSDKParam, z, z2, tMQQDownloaderOpenSDKParam.actionFlag, null, 2);
    }

    public void startToAuthorized(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        if (context == null) {
            throw new Exception("you must input an application or activity context!");
        } else if (tMQQDownloaderOpenSDKParam == null) {
            throw new Exception("QQDownloaderParam param cann't be null!");
        } else {
            String uuid = UUID.randomUUID().toString();
            if (this.mDownloadParams != null) {
                this.mDownloadParams.put(uuid, tMQQDownloaderOpenSDKParam);
            }
            JceStruct createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
            createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
            createNewChunkLogInfo.UUID = uuid;
            createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
            createNewChunkLogInfo.resultState = 1;
            DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
            Map formatMapParams = super.formatMapParams(tMQQDownloaderOpenSDKParam, true, true);
            formatMapParams.put("verifytype", str);
            formatMapParams.put("taskid", uuid);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(3, formatMapParams)));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public void startToAuthorized(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(formatEncryptUrl(str)));
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        if (!(this.mDownloadParams == null || tMQQDownloaderOpenSDKParam == null)) {
            this.mDownloadParams.put(UUID.randomUUID().toString(), tMQQDownloaderOpenSDKParam);
        }
        return super.buildAddDBData(tMQQDownloaderOpenSDKParam, true, true, tMQQDownloaderOpenSDKParam.actionFlag, str, 3);
    }

    public long addDownloadTaskFromAuthorize(String str) {
        String formatEncryptUrl = super.formatEncryptUrl(str);
        long currentTimeMillis = System.currentTimeMillis();
        return this.sdkChannel.AddDataItem(this.hostPackageName, this.hostVersionCode, "", 0, formatEncryptUrl, currentTimeMillis, currentTimeMillis + 300000, 0, null);
    }

    public TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
        Throwable e;
        Cursor cursor;
        Throwable th;
        if (this.mContext == null) {
            throw new Exception("Context shouldn't be null !");
        } else if (tMQQDownloaderOpenSDKParam == null) {
            throw new Exception("QQDownloaderParam param cann't is null!");
        } else {
            Cursor query;
            try {
                query = this.mContext.getContentResolver().query(CONTENT_URI, null, "packageName=? and versionCode=? and channelId=?", new String[]{tMQQDownloaderOpenSDKParam.taskPackageName, String.valueOf(tMQQDownloaderOpenSDKParam.taskVersion), tMQQDownloaderOpenSDKParam.channelId}, null);
                try {
                    TMLog.d(TAG, "getDownloadTaskState from qqdownloader , taskPackageName = " + tMQQDownloaderOpenSDKParam.taskPackageName + ", taskVersion=" + String.valueOf(tMQQDownloaderOpenSDKParam.taskVersion) + ", channelId=" + tMQQDownloaderOpenSDKParam.channelId);
                    if (query == null || !query.moveToFirst()) {
                        tMAssistantDownloadTaskInfo = null;
                    } else {
                        TMLog.i(TAG, "relate to qqdownloader , packageName = " + tMQQDownloaderOpenSDKParam.taskPackageName);
                        long j = query.getLong(query.getColumnIndex(DownloadInfoColumns.APKID));
                        String str = (String) GlobalUtil.String2List(query.getString(query.getColumnIndex(DownloadInfoColumns.APPURLS))).get(0);
                        String string = query.getString(query.getColumnIndex(DownloadInfoColumns.FILEPATH));
                        long j2 = query.getLong(query.getColumnIndex(DownloadInfoColumns.RECEIVEDLENGTH));
                        long j3 = query.getLong(query.getColumnIndex(DownloadInfoColumns.TOTALLENGTH));
                        String str2 = "application/vnd.android.package-archive";
                        int assistantState2SDKState = GlobalUtil.assistantState2SDKState(query.getInt(query.getColumnIndex("state")));
                        TMLog.i(TAG, "getDownloadTaskState state = " + assistantState2SDKState);
                        if (4 != assistantState2SDKState || isFileExist(string)) {
                            try {
                                tMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(str, string, assistantState2SDKState, j2, j3, str2);
                                if (assistantState2SDKState == 5 || assistantState2SDKState == 4 || assistantState2SDKState == 3) {
                                    JceStruct createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
                                    createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
                                    createNewChunkLogInfo.appId = String.valueOf(j);
                                    createNewChunkLogInfo.resultState = assistantState2SDKState;
                                    createNewChunkLogInfo.requestUrl = str;
                                    DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
                                }
                                if (this.mDownloadParams != null) {
                                    Object obj;
                                    for (Entry value : this.mDownloadParams.entrySet()) {
                                        TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam2 = (TMQQDownloaderOpenSDKParam) value.getValue();
                                        if (tMQQDownloaderOpenSDKParam2 != null && tMQQDownloaderOpenSDKParam2.taskPackageName.equals(tMQQDownloaderOpenSDKParam.taskPackageName) && tMQQDownloaderOpenSDKParam2.taskVersion == tMQQDownloaderOpenSDKParam.taskVersion) {
                                            obj = 1;
                                            break;
                                        }
                                    }
                                    obj = null;
                                    if (obj == null) {
                                        TMLog.i(TAG, "relate to qqdownloader , packageName = " + tMQQDownloaderOpenSDKParam.taskPackageName);
                                        str = UUID.randomUUID().toString();
                                        tMQQDownloaderOpenSDKParam.taskApkId = String.valueOf(j);
                                        this.mDownloadParams.put(str, tMQQDownloaderOpenSDKParam);
                                        relateToQQDownloader(this.mContext, tMQQDownloaderOpenSDKParam, str);
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                cursor = query;
                                try {
                                    v.a(TAG, e, "", new Object[0]);
                                    if (cursor != null) {
                                        return tMAssistantDownloadTaskInfo;
                                    }
                                    cursor.close();
                                    return tMAssistantDownloadTaskInfo;
                                } catch (Throwable th2) {
                                    th = th2;
                                    query = cursor;
                                    if (query != null) {
                                        query.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (query != null) {
                                    query.close();
                                }
                                throw th;
                            }
                        }
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                    if (query == null) {
                        return tMAssistantDownloadTaskInfo;
                    }
                    query.close();
                    return tMAssistantDownloadTaskInfo;
                } catch (Throwable th4) {
                    e = th4;
                    cursor = query;
                    tMAssistantDownloadTaskInfo = null;
                    v.a(TAG, e, "", new Object[0]);
                    if (cursor != null) {
                        return tMAssistantDownloadTaskInfo;
                    }
                    cursor.close();
                    return tMAssistantDownloadTaskInfo;
                } catch (Throwable th32) {
                    th4 = th32;
                    if (query != null) {
                        query.close();
                    }
                    throw th4;
                }
            } catch (Throwable th42) {
                e = th42;
                cursor = null;
                tMAssistantDownloadTaskInfo = null;
                v.a(TAG, e, "", new Object[0]);
                if (cursor != null) {
                    return tMAssistantDownloadTaskInfo;
                }
                cursor.close();
                return tMAssistantDownloadTaskInfo;
            } catch (Throwable th5) {
                th42 = th5;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th42;
            }
        }
    }

    private void relateToQQDownloader(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        Map formatMapParams = super.formatMapParams(tMQQDownloaderOpenSDKParam, false, false);
        formatMapParams.put("taskid", str);
        String formatIntentUriPath = super.formatIntentUriPath(4, formatMapParams);
        Intent intent = new Intent("com.tencent.android.qqdownloader.action.RELATED");
        intent.setPackage("com.tencent.android.qqdownloader");
        intent.putExtra("command", "cmd_updatedownload");
        intent.putExtra("relatedurl", formatIntentUriPath);
        context.sendBroadcast(intent);
    }

    private boolean isFileExist(String str) {
        if (new File(str).exists()) {
            return true;
        }
        return false;
    }

    public void onDownloadStateChanged(TMQQDownloaderStateChangeParam tMQQDownloaderStateChangeParam) {
        TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = tMQQDownloaderStateChangeParam.param;
        int assistantState2SDKState = GlobalUtil.assistantState2SDKState(tMQQDownloaderStateChangeParam.state);
        int assistantErrorCode2SDKErrorCode = GlobalUtil.assistantErrorCode2SDKErrorCode(tMQQDownloaderStateChangeParam.errorCode);
        String str = tMQQDownloaderStateChangeParam.errorMsg;
        String str2 = tMQQDownloaderStateChangeParam.taskId;
        TMLog.i(TAG, "onDownloadStateChanged state = " + assistantState2SDKState);
        TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam2 = null;
        if (str2 != null && str2.trim().length() > 0) {
            tMQQDownloaderOpenSDKParam2 = (TMQQDownloaderOpenSDKParam) this.mDownloadParams.get(str2);
        }
        if (tMQQDownloaderOpenSDKParam2 != null) {
            onStateChanged(tMQQDownloaderOpenSDKParam2, assistantState2SDKState, assistantErrorCode2SDKErrorCode, str);
        } else {
            TMLog.i(TAG, "onDownloadStateChanged storeParam = null");
        }
        if (6 == assistantState2SDKState) {
            ArrayList arrayList = new ArrayList();
            for (Entry entry : this.mDownloadParams.entrySet()) {
                TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam3 = (TMQQDownloaderOpenSDKParam) entry.getValue();
                String str3 = (String) entry.getKey();
                if (tMQQDownloaderOpenSDKParam3 != null && !TextUtils.isEmpty(tMQQDownloaderOpenSDKParam.taskPackageName) && tMQQDownloaderOpenSDKParam3.taskPackageName.equals(tMQQDownloaderOpenSDKParam.taskPackageName) && tMQQDownloaderOpenSDKParam3.taskVersion == tMQQDownloaderOpenSDKParam.taskVersion) {
                    arrayList.add(str3);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.mDownloadParams.remove((String) it.next());
            }
        }
    }

    public void initQQDownloaderOpenSDK(Context context) {
        this.mContext = context;
        this.hostPackageName = context.getPackageName();
        this.hostVersionCode = GlobalUtil.getAppVersionCode(this.mContext);
        GlobalUtil.getInstance().setContext(this.mContext);
        this.sdkAPILevel = 1;
        DownloadStateChangedReceiver.getInstance().registeReceiver(this.mContext);
        DownloadStateChangedReceiver.getInstance().addDownloadStateChangedListener(this);
        NetworkMonitorReceiver.getInstance().registerReceiver();
        GetSettingEngine.getInstance().sendRequest();
        LogReportManager.getInstance().reportLog();
    }

    public static String about() {
        return "TMQQDownloaderOpenSDK_2014_05_13_17_36_release_35169";
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
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(formatIntentUriPath));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }
}
