package com.tencent.tmassistantsdk.logreport;

import com.tencent.tmassistantsdk.protocol.jce.UpdateInfoLog;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable;
import com.tencent.tmassistantsdk.storage.table.UpdateInfoLogTable;
import com.tencent.tmassistantsdk.util.TMLog;

public class UpdateInfoReportManager extends BaseReportManager {
    protected static final String TAG = "UpdateInfoReportManager";
    protected static UpdateInfoReportManager mInstance = null;

    public class UpdateLogConst {
        public static final int ACTION_CHECKYYB_INSTALLED = 100;
        public static final int ACTION_DOWNLOAD_SUCCESS = 102;
        public static final int ACTION_INSTALL_SUCCESS = 103;
        public static final int ACTION_POP_INSTALL_DIALOG = 104;
        public static final int ACTION_START_DOWNLOAD = 101;
        public static final byte UPDATE_TYPE_NORMAL = (byte) 1;
        public static final byte UPDATE_TYPE_SAVE_NETWORK_TRAFFIC = (byte) 2;
        public static final byte UPDATE_TYPE_UNKNOWN = (byte) 0;
        public static final int YYB_IGNORE = 0;
        public static final int YYB_INSTALLED = 1;
        public static final int YYB_NOT_INSTALL = 2;
    }

    private UpdateInfoReportManager() {
    }

    public static synchronized UpdateInfoReportManager getInstance() {
        UpdateInfoReportManager updateInfoReportManager;
        synchronized (UpdateInfoReportManager.class) {
            if (mInstance == null) {
                mInstance = new UpdateInfoReportManager();
            }
            updateInfoReportManager = mInstance;
        }
        return updateInfoReportManager;
    }

    public UpdateInfoLog createUpdateInfoLog(String str, long j) {
        TMLog.i(TAG, "createUpdateInfoLog");
        UpdateInfoLog updateInfoLog = new UpdateInfoLog();
        updateInfoLog.packageName = str;
        updateInfoLog.appid = j;
        return updateInfoLog;
    }

    protected BaseLogTable getLogTable() {
        return UpdateInfoLogTable.getInstance();
    }

    protected byte getReportType() {
        return (byte) 2;
    }
}
