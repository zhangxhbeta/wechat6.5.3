package com.tencent.tmassistantsdk.logreport;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.network.PostHttpRequest;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogRequest;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogResponse;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable.DataWrapper;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;

public class LogReportHttpRequest extends PostHttpRequest {
    protected ILogReportHttpListener mListener = null;

    public boolean sendLogDataToServer(byte b, DataWrapper dataWrapper) {
        if (dataWrapper == null) {
            return false;
        }
        return super.sendRequest((ReportLogRequest) ProtocolPackage.buildReportRequest(b, dataWrapper.dataList, GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext()), GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext()), ""));
    }

    public void setmListener(ILogReportHttpListener iLogReportHttpListener) {
        this.mListener = iLogReportHttpListener;
    }

    protected void onFinished(JceStruct jceStruct, JceStruct jceStruct2, int i) {
        if (jceStruct2 != null) {
            if (this.mListener == null || i != 0) {
                TMLog.i("LogReportHttpRequest", "mListener is null !");
            } else if (!(jceStruct2 instanceof ReportLogResponse)) {
                TMLog.i("LogReportHttpRequest", "response isn't instanceof ReportLogResponse !");
            } else if (((ReportLogResponse) jceStruct2).ret == 0) {
                this.mListener.onLogReprotHttpRequestFinish(this, true);
            } else {
                this.mListener.onLogReprotHttpRequestFinish(this, false);
            }
        }
    }
}
