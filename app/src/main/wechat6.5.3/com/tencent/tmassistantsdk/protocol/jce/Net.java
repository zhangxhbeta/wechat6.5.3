package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class Net extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Net.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final String TAG = "Net";
    public String extNetworkOperator = "";
    public int extNetworkType = 0;
    public byte isWap = (byte) 0;
    public byte netType = (byte) 0;

    public final String className() {
        return "jce.Net";
    }

    public final String fullClassName() {
        return "com.tencent.tmassistantsdk.protocol.jce.Net";
    }

    public final byte getNetType() {
        return this.netType;
    }

    public final void setNetType(byte b) {
        this.netType = b;
    }

    public final String getExtNetworkOperator() {
        return this.extNetworkOperator;
    }

    public final void setExtNetworkOperator(String str) {
        this.extNetworkOperator = str;
    }

    public final int getExtNetworkType() {
        return this.extNetworkType;
    }

    public final void setExtNetworkType(int i) {
        this.extNetworkType = i;
    }

    public final byte getIsWap() {
        return this.isWap;
    }

    public final void setIsWap(byte b) {
        this.isWap = b;
    }

    public Net(byte b, String str, int i, byte b2) {
        this.netType = b;
        this.extNetworkOperator = str;
        this.extNetworkType = i;
        this.isWap = b2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return $assertionsDisabled;
        }
        Net net = (Net) obj;
        if (JceUtil.equals(this.netType, net.netType) && JceUtil.equals(this.extNetworkOperator, net.extNetworkOperator) && JceUtil.equals(this.extNetworkType, net.extNetworkType) && JceUtil.equals(this.isWap, net.isWap)) {
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
        jceOutputStream.write(this.netType, 0);
        if (this.extNetworkOperator != null) {
            jceOutputStream.write(this.extNetworkOperator, 1);
        }
        jceOutputStream.write(this.extNetworkType, 2);
        jceOutputStream.write(this.isWap, 3);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.netType = jceInputStream.read(this.netType, 0, true);
        this.extNetworkOperator = jceInputStream.readString(1, $assertionsDisabled);
        this.extNetworkType = jceInputStream.read(this.extNetworkType, 2, (boolean) $assertionsDisabled);
        this.isWap = jceInputStream.read(this.isWap, 3, (boolean) $assertionsDisabled);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.netType, DownloadInfo.NETTYPE);
        jceDisplayer.display(this.extNetworkOperator, "extNetworkOperator");
        jceDisplayer.display(this.extNetworkType, "extNetworkType");
        jceDisplayer.display(this.isWap, "isWap");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.netType, true);
        jceDisplayer.displaySimple(this.extNetworkOperator, true);
        jceDisplayer.displaySimple(this.extNetworkType, true);
        jceDisplayer.displaySimple(this.isWap, (boolean) $assertionsDisabled);
    }
}
