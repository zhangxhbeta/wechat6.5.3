package com.tencent.tmassistantsdk.openSDK.QQDownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.util.TMLog;

public class QQDownloaderInstalled extends BroadcastReceiver {
    private static final String TAG = "QQDownloaderInstalled";
    protected static QQDownloaderInstalled mInstance = null;
    protected boolean isRegisted = false;
    protected IQQDownloaderInstalled mListener = null;

    public interface IQQDownloaderInstalled {
        void onQQDownloaderInstalled(Context context);
    }

    private QQDownloaderInstalled() {
    }

    public static synchronized QQDownloaderInstalled getInstance() {
        QQDownloaderInstalled qQDownloaderInstalled;
        synchronized (QQDownloaderInstalled.class) {
            if (mInstance == null) {
                mInstance = new QQDownloaderInstalled();
            }
            qQDownloaderInstalled = mInstance;
        }
        return qQDownloaderInstalled;
    }

    public void onReceive(final Context context, Intent intent) {
        TMLog.i(TAG, "onReceive!");
        new Thread() {
            public void run() {
                if (QQDownloaderInstalled.this.mListener != null) {
                    QQDownloaderInstalled.this.mListener.onQQDownloaderInstalled(context);
                }
            }
        }.start();
    }

    public void registeReceiver(Context context) {
        if (!this.isRegisted) {
            TMLog.i(TAG, "registeReceiver   context" + context + "  receiver:" + this);
            try {
                this.isRegisted = true;
            } catch (Throwable th) {
                TMLog.i(TAG, "registeReceiver exception!!!");
                this.isRegisted = false;
                v.a(TAG, th, "", new Object[0]);
            }
        }
    }

    public void unRegisteReceiver(Context context) {
        if (context != null && mInstance != null && this.isRegisted) {
            TMLog.i(TAG, "realy unRegisteReceiver  context:" + context + "  receiver:" + this);
            try {
                this.isRegisted = false;
            } catch (Throwable th) {
                TMLog.i(TAG, "unRegisteReceiver exception!!!");
                this.isRegisted = false;
                v.a(TAG, th, "", new Object[0]);
            }
        }
    }

    public void registeListener(IQQDownloaderInstalled iQQDownloaderInstalled) {
        this.mListener = iQQDownloaderInstalled;
    }

    public void unregisteListener() {
        this.mListener = null;
    }
}
