package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QueryDownloadTaskRequest extends JceStruct {
    static IPCBaseParam cache_baseParam;
    public IPCBaseParam baseParam = null;

    public QueryDownloadTaskRequest(IPCBaseParam iPCBaseParam) {
        this.baseParam = iPCBaseParam;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.baseParam, 0);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        if (cache_baseParam == null) {
            cache_baseParam = new IPCBaseParam();
        }
        this.baseParam = (IPCBaseParam) jceInputStream.read(cache_baseParam, 0, true);
    }
}
