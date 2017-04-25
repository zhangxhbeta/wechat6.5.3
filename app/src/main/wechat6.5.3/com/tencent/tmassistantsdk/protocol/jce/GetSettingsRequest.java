package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.v;

public final class GetSettingsRequest extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!GetSettingsRequest.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final String TAG = "GetSettingsRequest";
    public String reserve = "";

    public final String className() {
        return "jce.GetSettingsRequest";
    }

    public final String fullClassName() {
        return "com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest";
    }

    public final String getReserve() {
        return this.reserve;
    }

    public final void setReserve(String str) {
        this.reserve = str;
    }

    public GetSettingsRequest(String str) {
        this.reserve = str;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return $assertionsDisabled;
        }
        return JceUtil.equals(this.reserve, ((GetSettingsRequest) obj).reserve);
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
        if (this.reserve != null) {
            jceOutputStream.write(this.reserve, 0);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.reserve = jceInputStream.readString(0, $assertionsDisabled);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        new JceDisplayer(stringBuilder, i).display(this.reserve, "reserve");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        new JceDisplayer(stringBuilder, i).displaySimple(this.reserve, (boolean) $assertionsDisabled);
    }
}
