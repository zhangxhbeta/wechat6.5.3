package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ServiceFreeActionResponse extends JceStruct {
    static byte[] cache_revertField;
    public byte[] revertField = null;

    public ServiceFreeActionResponse(byte[] bArr) {
        this.revertField = bArr;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.revertField != null) {
            jceOutputStream.write(this.revertField, 0);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        if (cache_revertField == null) {
            byte[] bArr = new byte[1];
            cache_revertField = bArr;
            bArr[0] = (byte) 0;
        }
        this.revertField = jceInputStream.read(cache_revertField, 0, false);
    }
}
