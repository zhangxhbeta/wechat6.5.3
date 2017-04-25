package com.tencent.tmassistantsdk.storage;

import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTask;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadInfoTable;
import java.util.ArrayList;

public class DBManager {
    protected static DBManager mInstance = null;

    public static synchronized DBManager getInstance() {
        DBManager dBManager;
        synchronized (DBManager.class) {
            if (mInstance == null) {
                mInstance = new DBManager();
            }
            dBManager = mInstance;
        }
        return dBManager;
    }

    public ArrayList<DownloadInfo> queryDownloadInfoList() {
        return DownloadInfoTable.load();
    }

    public void saveDownloadInfoList(ArrayList<DownloadInfo> arrayList) {
        DownloadInfoTable.save(arrayList);
    }

    public void addDownloadInfo(DownloadInfo downloadInfo) {
        DownloadInfoTable.add(downloadInfo);
    }

    public void deleteDownloadInfo(String str) {
        DownloadInfoTable.del(str);
        ClientInfoTable.deleteItemsByURL(str);
    }

    public DownloadInfo queryDownloadInfoByUrl(String str) {
        return DownloadInfoTable.query(str);
    }

    public ArrayList<ServiceDownloadTask> queryWaitingAndDownloadingTaskList() {
        return DownloadInfoTable.query();
    }

    public void saveClientInfo(String str, String str2) {
        ClientInfoTable.save(str, str2);
    }
}
