package com.tencent.tmassistantsdk.downloadservice.taskmanager;

import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.ApkDownloadManager;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.IDownloadManagerListener;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class ServiceDownloadTaskManager implements IDownloadManagerListener {
    protected static final String TAG = "ServiceDownloadTaskManager";
    protected IServiceDownloadTaskManagerListener mListener = null;
    protected ArrayList<ServiceDownloadTask> mServiceTaskList = new ArrayList();

    public ServiceDownloadTaskManager(ArrayList<ServiceDownloadTask> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mServiceTaskList.addAll(arrayList);
        }
    }

    public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String str, String str2) {
        DownloadInfo queryDownloadInfo = ApkDownloadManager.getInstance().queryDownloadInfo(str2);
        if (queryDownloadInfo != null) {
            return new TMAssistantDownloadTaskInfo(queryDownloadInfo.mURL, TMAssistantFile.getSaveFilePath(queryDownloadInfo.mFileName), queryDownloadInfo.mStatus, queryDownloadInfo.mReceivedBytes, queryDownloadInfo.getTotalSize(), queryDownloadInfo.mContentType);
        }
        String str3;
        String generateFileNameFromURL;
        String saveFilePath;
        TMAssistantFile tMAssistantFile;
        if (DownloadHelper.isDownloadFileExisted(str2, "application/vnd.android.package-archive")) {
            str3 = "application/vnd.android.package-archive";
            generateFileNameFromURL = DownloadHelper.generateFileNameFromURL(str2, str3);
            saveFilePath = TMAssistantFile.getSaveFilePath(generateFileNameFromURL);
            tMAssistantFile = new TMAssistantFile(generateFileNameFromURL, generateFileNameFromURL);
            return new TMAssistantDownloadTaskInfo(str2, saveFilePath, 4, tMAssistantFile.length(), tMAssistantFile.length(), str3);
        } else if (DownloadHelper.isDownloadFileExisted(str2, "application/tm.android.apkdiff")) {
            str3 = "application/tm.android.apkdiff";
            generateFileNameFromURL = DownloadHelper.generateFileNameFromURL(str2, str3);
            saveFilePath = TMAssistantFile.getSaveFilePath(generateFileNameFromURL);
            tMAssistantFile = new TMAssistantFile(generateFileNameFromURL, generateFileNameFromURL);
            return new TMAssistantDownloadTaskInfo(str2, saveFilePath, 4, tMAssistantFile.length(), tMAssistantFile.length(), str3);
        } else {
            removeDownloadTask(str2);
            return null;
        }
    }

    public int startDownload(String str, String str2, int i, String str3, String str4, Map<String, String> map) {
        if (str == null || str2 == null) {
            return 3;
        }
        TMLog.i(TAG, "startDownload,clientKey:" + str);
        if (findDownloadTask(str, str2) != null) {
            TMLog.i(TAG, "startDownload,clientKey:" + str + ",taskItem is null");
            return ApkDownloadManager.getInstance().startDownload(str2, i, str3, str4, map);
        }
        ArrayList findDownloadTask = findDownloadTask(str2);
        ServiceDownloadTask serviceDownloadTask = new ServiceDownloadTask(str, str2);
        serviceDownloadTask.mState = 1;
        this.mServiceTaskList.add(serviceDownloadTask);
        TMLog.i(TAG, "startDownload,clientKey:" + str + ",add newTask");
        Iterator it = findDownloadTask.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            ServiceDownloadTask serviceDownloadTask2 = (ServiceDownloadTask) it.next();
            if (serviceDownloadTask2.mState == 2) {
                i2 = 1;
            } else {
                int i4;
                if (serviceDownloadTask2.mState == 1) {
                    i4 = 1;
                } else {
                    i4 = i3;
                }
                i3 = i4;
            }
        }
        if (i2 == 1 || i3 == 1) {
            if (i2 == 1) {
                serviceDownloadTask.mState = 2;
            } else if (i3 == 1) {
                serviceDownloadTask.mState = 1;
            }
            if (this.mListener != null) {
                this.mListener.OnDownloadStateChanged(str, str2, serviceDownloadTask.mState, 0, null);
            }
            TMLog.i(TAG, "startDownload,clientKey:" + str + ",newTask is downloading");
            return 0;
        }
        TMLog.i(TAG, "startDownload,clientKey:" + str + ",start newTask download");
        return ApkDownloadManager.getInstance().startDownload(str2, i, str3, str4, map);
    }

    public void pauseDownload(String str, String str2) {
        if (str != null && str2 != null) {
            TMLog.i(TAG, "pauseDownload,clientKey:" + str);
            ServiceDownloadTask findDownloadTask = findDownloadTask(str, str2);
            if (findDownloadTask != null) {
                findDownloadTask.mState = 3;
                this.mServiceTaskList.remove(findDownloadTask);
                TMLog.i(TAG, "pauseDownload,clientKey:" + str + ",remove taskItem");
                ArrayList findDownloadTask2 = findDownloadTask(str2);
                if (findDownloadTask2 == null || findDownloadTask2.size() == 0) {
                    TMLog.i(TAG, "pauseDownload,clientKey:" + str + ",taskItem is the only on pauseAll");
                    ApkDownloadManager.getInstance().pauseDownload(str2);
                    TMLog.i(TAG, "pauseDownload end,clientKey:" + str + ",taskItem is the only on pauseAll");
                }
                if (this.mListener != null) {
                    this.mListener.OnDownloadStateChanged(str, str2, findDownloadTask.mState, 0, null);
                }
            } else {
                TMLog.w(TAG, "pauseDownload,clientKey:" + str + ",taskItem is null");
            }
            TMLog.i(TAG, "pauseDownload end,clientKey:" + str);
        }
    }

    public void cancelDownload(String str, String str2) {
        if (str != null && str2 != null) {
            TMLog.i(TAG, "cancelDownload,clientKey:" + str);
            ServiceDownloadTask findDownloadTask = findDownloadTask(str, str2);
            if (findDownloadTask != null) {
                this.mServiceTaskList.remove(findDownloadTask);
                TMLog.i(TAG, "cancelDownload,clientKey:" + str + ",remove taskItem");
            } else {
                TMLog.w(TAG, "cancelDownload,clientKey:" + str + ",taskItem is null");
            }
            ArrayList findDownloadTask2 = findDownloadTask(str2);
            if (findDownloadTask2 == null || findDownloadTask2.size() == 0) {
                TMLog.i(TAG, "cancelDownload,clientKey:" + str + ",taskItem is the only on cancelAll");
                ApkDownloadManager.getInstance().cancelDownload(str2);
            }
        }
    }

    public void registerApkDownloadManagerListener() {
        if (this != null) {
            ApkDownloadManager.getInstance().AddDownloadListener(this);
        }
    }

    public void unRegisterApkDownloadManagerListener() {
        if (this != null) {
            ApkDownloadManager.getInstance().RemoveDownloadListener(this);
        }
    }

    protected synchronized ServiceDownloadTask findDownloadTask(String str, String str2) {
        ServiceDownloadTask serviceDownloadTask;
        if (str == null || str2 == null) {
            serviceDownloadTask = null;
        } else {
            Iterator it = this.mServiceTaskList.iterator();
            while (it.hasNext()) {
                serviceDownloadTask = (ServiceDownloadTask) it.next();
                if (serviceDownloadTask.mClientKey != null && serviceDownloadTask.mClientKey.equals(str) && serviceDownloadTask.mUrl.equals(str2)) {
                    break;
                }
            }
            serviceDownloadTask = null;
        }
        return serviceDownloadTask;
    }

    protected synchronized ArrayList<ServiceDownloadTask> findDownloadTask(String str) {
        ArrayList<ServiceDownloadTask> arrayList;
        if (str == null) {
            arrayList = null;
        } else {
            ArrayList<ServiceDownloadTask> arrayList2 = new ArrayList();
            Iterator it = this.mServiceTaskList.iterator();
            while (it.hasNext()) {
                ServiceDownloadTask serviceDownloadTask = (ServiceDownloadTask) it.next();
                if (serviceDownloadTask.mUrl.equals(str)) {
                    arrayList2.add(serviceDownloadTask);
                }
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    protected synchronized void removeDownloadTask(String str) {
        if (str != null) {
            Collection arrayList = new ArrayList();
            Iterator it = this.mServiceTaskList.iterator();
            while (it.hasNext()) {
                ServiceDownloadTask serviceDownloadTask = (ServiceDownloadTask) it.next();
                if (serviceDownloadTask.mUrl.equals(str)) {
                    arrayList.add(serviceDownloadTask);
                }
            }
            if (arrayList.size() > 0) {
                this.mServiceTaskList.removeAll(arrayList);
            }
        }
    }

    public void setListener(IServiceDownloadTaskManagerListener iServiceDownloadTaskManagerListener) {
        this.mListener = iServiceDownloadTaskManagerListener;
    }

    public void OnDownloadStateChanged(String str, int i, int i2, String str2) {
        if (this.mListener != null) {
            ArrayList findDownloadTask = findDownloadTask(str);
            if (findDownloadTask != null && findDownloadTask.size() > 0) {
                Iterator it = findDownloadTask.iterator();
                while (it.hasNext()) {
                    ServiceDownloadTask serviceDownloadTask = (ServiceDownloadTask) it.next();
                    TMLog.i(TAG, "OnDownloadStateChanged,clientKey:" + serviceDownloadTask.mClientKey + ",state:" + i + ",errorcode:" + i2 + ",url:" + str.hashCode());
                    serviceDownloadTask.mState = i;
                    this.mListener.OnDownloadStateChanged(serviceDownloadTask.mClientKey, str, i, i2, str2);
                }
            }
        }
    }

    public void OnDownloadProgressChanged(String str, long j, long j2) {
        if (this.mListener != null) {
            ArrayList findDownloadTask = findDownloadTask(str);
            if (findDownloadTask != null && findDownloadTask.size() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                Iterator it = findDownloadTask.iterator();
                while (it.hasNext()) {
                    ServiceDownloadTask serviceDownloadTask = (ServiceDownloadTask) it.next();
                    if (serviceDownloadTask.checkIsNeedUpdateProgress(j, j2, currentTimeMillis)) {
                        TMLog.i(TAG, "OnDownloadProgressChanged,clientKey:" + serviceDownloadTask.mClientKey + ",receivedLen:" + j + ",url:" + str.hashCode());
                        this.mListener.OnDownloadProgressChanged(serviceDownloadTask.mClientKey, str, j, j2);
                    }
                }
            }
        }
    }
}
