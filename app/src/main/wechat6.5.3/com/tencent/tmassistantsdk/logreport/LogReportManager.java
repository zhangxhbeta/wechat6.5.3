package com.tencent.tmassistantsdk.logreport;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver.INetworkChangedObserver;
import com.tencent.tmassistantsdk.util.TMLog;

public class LogReportManager {
    private static final Class<?>[] REPORT_MANAGERS = new Class[]{DownloadReportManager.class, TipsInfoReportManager.class, UpdateInfoReportManager.class};
    private static final String TAG = "LogReportManager";
    private static LogReportManager mInstance = null;
    private final INetworkChangedObserver mNetworkChangedObserver = new INetworkChangedObserver() {
        public void onNetworkChanged() {
            TMLog.i(LogReportManager.TAG, "onNetworkChanged,netState:" + DownloadHelper.getNetStatus());
            for (Object obj : LogReportManager.REPORT_MANAGERS) {
                try {
                    if (obj.equals(DownloadReportManager.class)) {
                        DownloadReportManager.getInstance().resetMaxReportCount();
                    } else if (obj.equals(TipsInfoReportManager.class)) {
                        TipsInfoReportManager.getInstance().resetMaxReportCount();
                    }
                } catch (Throwable e) {
                    v.a(LogReportManager.TAG, e, "", new Object[0]);
                }
            }
            if (DownloadHelper.isNetworkConncted() && DownloadHelper.getNetStatus().equalsIgnoreCase("wifi")) {
                LogReportManager.this.reportLog();
            }
        }
    };

    public static synchronized LogReportManager getInstance() {
        LogReportManager logReportManager;
        synchronized (LogReportManager.class) {
            if (mInstance == null) {
                mInstance = new LogReportManager();
            }
            logReportManager = mInstance;
        }
        return logReportManager;
    }

    private LogReportManager() {
        NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this.mNetworkChangedObserver);
    }

    public void destory() {
        for (Object obj : REPORT_MANAGERS) {
            try {
                if (obj.equals(DownloadReportManager.class)) {
                    DownloadReportManager.getInstance().destroy();
                } else if (obj.equals(TipsInfoReportManager.class)) {
                    TipsInfoReportManager.getInstance().destroy();
                }
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            }
        }
        NetworkMonitorReceiver.getInstance().removeNetworkChangedObserver(this.mNetworkChangedObserver);
    }

    public void reportLog() {
        for (Object obj : REPORT_MANAGERS) {
            try {
                if (obj.equals(DownloadReportManager.class)) {
                    DownloadReportManager.getInstance().reportLogData();
                } else if (obj.equals(TipsInfoReportManager.class)) {
                    TipsInfoReportManager.getInstance().reportLogData();
                } else if (obj.equals(UpdateInfoReportManager.class)) {
                    UpdateInfoReportManager.getInstance().reportLogData();
                }
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            }
        }
    }

    public void cancleReport() {
        for (Object obj : REPORT_MANAGERS) {
            try {
                if (obj.equals(DownloadReportManager.class)) {
                    DownloadReportManager.getInstance().cancleRequest();
                } else if (obj.equals(TipsInfoReportManager.class)) {
                    TipsInfoReportManager.getInstance().cancleRequest();
                }
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            }
        }
    }
}
