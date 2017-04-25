package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.v;

public final class ReportLogResponse extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!ReportLogResponse.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final String TAG = "ReportLogResponse";
    public int ret = 0;

    public final String className() {
        return "jce.ReportLogResponse";
    }

    public final String fullClassName() {
        return "com.tencent.tmassistantsdk.protocol.jce.ReportLogResponse";
    }

    public final int getRet() {
        return this.ret;
    }

    public final void setRet(int i) {
        this.ret = i;
    }

    public ReportLogResponse(int i) {
        this.ret = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return $assertionsDisabled;
        }
        return JceUtil.equals(this.ret, ((ReportLogResponse) obj).ret);
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
        jceOutputStream.write(this.ret, 0);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        new JceDisplayer(stringBuilder, i).display(this.ret, "ret");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        new JceDisplayer(stringBuilder, i).displaySimple(this.ret, (boolean) $assertionsDisabled);
    }
}
