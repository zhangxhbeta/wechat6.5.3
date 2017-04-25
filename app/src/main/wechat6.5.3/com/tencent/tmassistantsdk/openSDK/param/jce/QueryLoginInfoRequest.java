package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QueryLoginInfoRequest extends JceStruct {
    public String addtion = "";

    public QueryLoginInfoRequest(String str) {
        this.addtion = str;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.addtion != null) {
            jceOutputStream.write(this.addtion, 0);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.addtion = jceInputStream.readString(0, false);
    }
}
