package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class URIActionRequest extends JceStruct {
    public String uri = "";

    public URIActionRequest(String str) {
        this.uri = str;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uri, 0);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.uri = jceInputStream.readString(0, true);
    }
}
