package com.tencent.tmassistantsdk.downloadservice;

import java.util.ArrayList;
import java.util.Iterator;

public class DownloadListenerManager {
    protected static DownloadListenerManager mDownloadListenerManager = null;
    protected final ArrayList<IDownloadManagerListener> mListeners = new ArrayList();

    public static DownloadListenerManager getInstance() {
        if (mDownloadListenerManager == null) {
            mDownloadListenerManager = new DownloadListenerManager();
        }
        return mDownloadListenerManager;
    }

    protected DownloadListenerManager() {
    }

    public synchronized void Add(IDownloadManagerListener iDownloadManagerListener) {
        if (!this.mListeners.contains(iDownloadManagerListener)) {
            this.mListeners.add(iDownloadManagerListener);
        }
    }

    public synchronized void Remove(IDownloadManagerListener iDownloadManagerListener) {
        this.mListeners.remove(iDownloadManagerListener);
    }

    public synchronized void OnDownloadStateChanged(String str, int i, int i2, String str2) {
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((IDownloadManagerListener) it.next()).OnDownloadStateChanged(str, i, i2, str2);
        }
    }

    public synchronized void OnDownloadProgressChanged(String str, long j, long j2) {
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((IDownloadManagerListener) it.next()).OnDownloadProgressChanged(str, j, j2);
        }
    }
}
