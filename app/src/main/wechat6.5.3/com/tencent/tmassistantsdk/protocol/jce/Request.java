package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.v;

public final class Request extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Request.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final String TAG = "Request";
    static byte[] cache_body;
    static ReqHead cache_head;
    public byte[] body = null;
    public ReqHead head = null;

    public final String className() {
        return "jce.Request";
    }

    public final String fullClassName() {
        return "com.tencent.tmassistantsdk.protocol.jce.Request";
    }

    public final ReqHead getHead() {
        return this.head;
    }

    public final void setHead(ReqHead reqHead) {
        this.head = reqHead;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final void setBody(byte[] bArr) {
        this.body = bArr;
    }

    public Request(ReqHead reqHead, byte[] bArr) {
        this.head = reqHead;
        this.body = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return $assertionsDisabled;
        }
        Request request = (Request) obj;
        if (JceUtil.equals(this.head, request.head) && JceUtil.equals(this.body, request.body)) {
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
        jceOutputStream.write(this.head, 0);
        if (this.body != null) {
            jceOutputStream.write(this.body, 1);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        if (cache_head == null) {
            cache_head = new ReqHead();
        }
        this.head = (ReqHead) jceInputStream.read(cache_head, 0, true);
        if (cache_body == null) {
            byte[] bArr = new byte[1];
            cache_body = bArr;
            bArr[0] = (byte) 0;
        }
        this.body = jceInputStream.read(cache_body, 1, (boolean) $assertionsDisabled);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.head, "head");
        jceDisplayer.display(this.body, "body");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.head, true);
        jceDisplayer.displaySimple(this.body, (boolean) $assertionsDisabled);
    }
}
