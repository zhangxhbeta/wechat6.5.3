package com.tencent.tmassistantsdk.downloadservice;

import android.os.PowerManager.WakeLock;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class DownloadThreadPool {
    public static final String TAG = "DownloadThreadPool";
    protected static DownloadThreadPool mDownloadThreadPool = null;
    final ArrayList<TaskThread> mDownloadThreadList = new ArrayList();
    final ArrayList<DownloadTask> mExecList = new ArrayList();
    protected final Comparator<DownloadTask> mPriorityQueueComparator = new Comparator<DownloadTask>() {
        public int compare(DownloadTask downloadTask, DownloadTask downloadTask2) {
            if (downloadTask.getPriority() > downloadTask2.getPriority()) {
                return 1;
            }
            if (downloadTask.getPriority() == downloadTask2.getPriority()) {
                return 0;
            }
            return -1;
        }
    };
    final Object mTaskLock = new Object();
    final Object mThreadlock = new Object();
    final PriorityQueue<DownloadTask> mWaitingList = new PriorityQueue(16, this.mPriorityQueueComparator);

    class TaskThread extends Thread {
        private int mIndex = 0;

        public TaskThread(int i) {
            this.mIndex = i;
            setName("download_thread_" + this.mIndex);
            start();
        }

        public void run() {
            TMLog.i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " starts running...");
            while (true) {
                synchronized (DownloadThreadPool.this.mThreadlock) {
                    try {
                        TMLog.i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " is waitting...");
                        DownloadThreadPool.this.mThreadlock.wait();
                    } catch (Throwable e) {
                        TMLog.i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " is interrupted...");
                        v.a(DownloadThreadPool.TAG, e, "", new Object[0]);
                        return;
                    }
                }
                if (Thread.currentThread().isInterrupted()) {
                    TMLog.i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " is interrupted...");
                    return;
                }
                while (DownloadThreadPool.this.hasWaitingTask()) {
                    DownloadTask downloadTask = null;
                    synchronized (DownloadThreadPool.this.mTaskLock) {
                        if (DownloadThreadPool.this.mWaitingList.size() > 0) {
                            downloadTask = (DownloadTask) DownloadThreadPool.this.mWaitingList.remove();
                            DownloadThreadPool.this.mExecList.add(downloadTask);
                        }
                    }
                    if (Thread.currentThread().isInterrupted()) {
                        TMLog.i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " is interrupted...");
                        return;
                    }
                    if (downloadTask != null) {
                        TMLog.i(DownloadThreadPool.TAG, "TaskThread::Run ThreadName: " + getName() + " url: " + downloadTask.getDownloadURI());
                        WakeLock wakeLock = DownloadHelper.getWakeLock();
                        downloadTask.exec(getName());
                        if (wakeLock != null) {
                            wakeLock.release();
                        }
                    }
                    synchronized (DownloadThreadPool.this.mTaskLock) {
                        if (downloadTask != null) {
                            DownloadThreadPool.this.mExecList.remove(downloadTask);
                        }
                    }
                }
            }
        }
    }

    public static DownloadThreadPool getInstance() {
        if (mDownloadThreadPool == null) {
            mDownloadThreadPool = new DownloadThreadPool();
        }
        return mDownloadThreadPool;
    }

    private DownloadThreadPool() {
        int maxTaskNum = DownloadSetting.getInstance().getMaxTaskNum();
        for (int i = 0; i < maxTaskNum; i++) {
            this.mDownloadThreadList.add(new TaskThread(i));
        }
    }

    int addDownloadTask(DownloadTask downloadTask) {
        int taskId;
        synchronized (this.mTaskLock) {
            this.mWaitingList.add(downloadTask);
            synchronized (this.mThreadlock) {
                this.mThreadlock.notifyAll();
            }
            taskId = downloadTask.getTaskId();
        }
        return taskId;
    }

    void cancelDownloadTask(int i) {
        synchronized (this.mTaskLock) {
            Iterator it = this.mExecList.iterator();
            while (it.hasNext()) {
                DownloadTask downloadTask = (DownloadTask) it.next();
                if (downloadTask.getTaskId() == i) {
                    downloadTask.cancel();
                    this.mExecList.remove(downloadTask);
                    return;
                }
            }
            it = this.mWaitingList.iterator();
            while (it.hasNext()) {
                downloadTask = (DownloadTask) it.next();
                if (downloadTask.getTaskId() == i) {
                    downloadTask.cancel();
                    this.mWaitingList.remove(downloadTask);
                    return;
                }
            }
        }
    }

    boolean hasWaitingTask() {
        boolean z;
        synchronized (this.mTaskLock) {
            z = this.mWaitingList.size() > 0;
        }
        return z;
    }

    public DownloadTask getDownloadTask(String str) {
        synchronized (this.mTaskLock) {
            Iterator it = this.mExecList.iterator();
            while (it.hasNext()) {
                DownloadTask downloadTask = (DownloadTask) it.next();
                if (downloadTask.getDownloadURI().equals(str)) {
                    return downloadTask;
                }
            }
            it = this.mWaitingList.iterator();
            while (it.hasNext()) {
                downloadTask = (DownloadTask) it.next();
                if (downloadTask.getDownloadURI().equals(str)) {
                    return downloadTask;
                }
            }
            return null;
        }
    }
}
