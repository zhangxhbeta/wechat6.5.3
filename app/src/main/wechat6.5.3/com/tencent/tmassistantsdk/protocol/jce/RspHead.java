package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.v;

public final class RspHead extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!RspHead.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final String TAG = "RspHead";
    public int cmdId = 0;
    public byte encryptWithPack = (byte) 0;
    public String phoneGuid = "";
    public int requestId = 0;
    public int ret = 0;

    public final String className() {
        return "jce.RspHead";
    }

    public final String fullClassName() {
        return "com.tencent.tmassistantsdk.protocol.jce.RspHead";
    }

    public final int getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(int i) {
        this.requestId = i;
    }

    public final int getCmdId() {
        return this.cmdId;
    }

    public final void setCmdId(int i) {
        this.cmdId = i;
    }

    public final int getRet() {
        return this.ret;
    }

    public final void setRet(int i) {
        this.ret = i;
    }

    public final byte getEncryptWithPack() {
        return this.encryptWithPack;
    }

    public final void setEncryptWithPack(byte b) {
        this.encryptWithPack = b;
    }

    public final String getPhoneGuid() {
        return this.phoneGuid;
    }

    public final void setPhoneGuid(String str) {
        this.phoneGuid = str;
    }

    public RspHead(int i, int i2, int i3, byte b, String str) {
        this.requestId = i;
        this.cmdId = i2;
        this.ret = i3;
        this.encryptWithPack = b;
        this.phoneGuid = str;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return $assertionsDisabled;
        }
        RspHead rspHead = (RspHead) obj;
        if (JceUtil.equals(this.requestId, rspHead.requestId) && JceUtil.equals(this.cmdId, rspHead.cmdId) && JceUtil.equals(this.ret, rspHead.ret) && JceUtil.equals(this.encryptWithPack, rspHead.encryptWithPack) && JceUtil.equals(this.phoneGuid, rspHead.phoneGuid)) {
            return true;
        }
        return $assertionsDisabled;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            return 0;
        }
    }

    public final Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
        }
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.requestId, 0);
        jceOutputStream.write(this.cmdId, 1);
        jceOutputStream.write(this.ret, 2);
        jceOutputStream.write(this.encryptWithPack, 3);
        if (this.phoneGuid != null) {
            jceOutputStream.write(this.phoneGuid, 4);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.requestId = jceInputStream.read(this.requestId, 0, true);
        this.cmdId = jceInputStream.read(this.cmdId, 1, true);
        this.ret = jceInputStream.read(this.ret, 2, true);
        this.encryptWithPack = jceInputStream.read(this.encryptWithPack, 3, (boolean) $assertionsDisabled);
        this.phoneGuid = jceInputStream.readString(4, $assertionsDisabled);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.requestId, "requestId");
        jceDisplayer.display(this.cmdId, "cmdId");
        jceDisplayer.display(this.ret, "ret");
        jceDisplayer.display(this.encryptWithPack, "encryptWithPack");
        jceDisplayer.display(this.phoneGuid, "phoneGuid");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.requestId, true);
        jceDisplayer.displaySimple(this.cmdId, true);
        jceDisplayer.displaySimple(this.ret, true);
        jceDisplayer.displaySimple(this.encryptWithPack, true);
        jceDisplayer.displaySimple(this.phoneGuid, (boolean) $assertionsDisabled);
    }
}
