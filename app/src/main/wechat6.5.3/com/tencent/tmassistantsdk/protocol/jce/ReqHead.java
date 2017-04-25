package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.v;

public final class ReqHead extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!ReqHead.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final String TAG = "ReqHead";
    static Net cache_net;
    static Terminal cache_terminal;
    public int assistantAPILevel = 0;
    public int assistantVersionCode = 0;
    public int cmdId = 0;
    public byte encryptWithPack = (byte) 0;
    public Net net = null;
    public String phoneGuid = "";
    public String qua = "";
    public int requestId = 0;
    public Terminal terminal = null;

    public final String className() {
        return "jce.ReqHead";
    }

    public final String fullClassName() {
        return "com.tencent.tmassistantsdk.protocol.jce.ReqHead";
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

    public final String getPhoneGuid() {
        return this.phoneGuid;
    }

    public final void setPhoneGuid(String str) {
        this.phoneGuid = str;
    }

    public final String getQua() {
        return this.qua;
    }

    public final void setQua(String str) {
        this.qua = str;
    }

    public final byte getEncryptWithPack() {
        return this.encryptWithPack;
    }

    public final void setEncryptWithPack(byte b) {
        this.encryptWithPack = b;
    }

    public final Terminal getTerminal() {
        return this.terminal;
    }

    public final void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public final int getAssistantAPILevel() {
        return this.assistantAPILevel;
    }

    public final void setAssistantAPILevel(int i) {
        this.assistantAPILevel = i;
    }

    public final int getAssistantVersionCode() {
        return this.assistantVersionCode;
    }

    public final void setAssistantVersionCode(int i) {
        this.assistantVersionCode = i;
    }

    public final Net getNet() {
        return this.net;
    }

    public final void setNet(Net net) {
        this.net = net;
    }

    public ReqHead(int i, int i2, String str, String str2, byte b, Terminal terminal, int i3, int i4, Net net) {
        this.requestId = i;
        this.cmdId = i2;
        this.phoneGuid = str;
        this.qua = str2;
        this.encryptWithPack = b;
        this.terminal = terminal;
        this.assistantAPILevel = i3;
        this.assistantVersionCode = i4;
        this.net = net;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return $assertionsDisabled;
        }
        ReqHead reqHead = (ReqHead) obj;
        if (JceUtil.equals(this.requestId, reqHead.requestId) && JceUtil.equals(this.cmdId, reqHead.cmdId) && JceUtil.equals(this.phoneGuid, reqHead.phoneGuid) && JceUtil.equals(this.qua, reqHead.qua) && JceUtil.equals(this.encryptWithPack, reqHead.encryptWithPack) && JceUtil.equals(this.terminal, reqHead.terminal) && JceUtil.equals(this.assistantAPILevel, reqHead.assistantAPILevel) && JceUtil.equals(this.assistantVersionCode, reqHead.assistantVersionCode) && JceUtil.equals(this.net, reqHead.net)) {
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
        jceOutputStream.write(this.phoneGuid, 2);
        jceOutputStream.write(this.qua, 3);
        jceOutputStream.write(this.encryptWithPack, 4);
        if (this.terminal != null) {
            jceOutputStream.write(this.terminal, 5);
        }
        jceOutputStream.write(this.assistantAPILevel, 6);
        jceOutputStream.write(this.assistantVersionCode, 7);
        if (this.net != null) {
            jceOutputStream.write(this.net, 8);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.requestId = jceInputStream.read(this.requestId, 0, true);
        this.cmdId = jceInputStream.read(this.cmdId, 1, true);
        this.phoneGuid = jceInputStream.readString(2, true);
        this.qua = jceInputStream.readString(3, true);
        this.encryptWithPack = jceInputStream.read(this.encryptWithPack, 4, (boolean) $assertionsDisabled);
        if (cache_terminal == null) {
            cache_terminal = new Terminal();
        }
        this.terminal = (Terminal) jceInputStream.read(cache_terminal, 5, (boolean) $assertionsDisabled);
        this.assistantAPILevel = jceInputStream.read(this.assistantAPILevel, 6, (boolean) $assertionsDisabled);
        this.assistantVersionCode = jceInputStream.read(this.assistantVersionCode, 7, (boolean) $assertionsDisabled);
        if (cache_net == null) {
            cache_net = new Net();
        }
        this.net = (Net) jceInputStream.read(cache_net, 8, (boolean) $assertionsDisabled);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.requestId, "requestId");
        jceDisplayer.display(this.cmdId, "cmdId");
        jceDisplayer.display(this.phoneGuid, "phoneGuid");
        jceDisplayer.display(this.qua, "qua");
        jceDisplayer.display(this.encryptWithPack, "encryptWithPack");
        jceDisplayer.display(this.terminal, "terminal");
        jceDisplayer.display(this.assistantAPILevel, "assistantAPILevel");
        jceDisplayer.display(this.assistantVersionCode, "assistantVersionCode");
        jceDisplayer.display(this.net, "net");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.requestId, true);
        jceDisplayer.displaySimple(this.cmdId, true);
        jceDisplayer.displaySimple(this.phoneGuid, true);
        jceDisplayer.displaySimple(this.qua, true);
        jceDisplayer.displaySimple(this.encryptWithPack, true);
        jceDisplayer.displaySimple(this.terminal, true);
        jceDisplayer.displaySimple(this.assistantAPILevel, true);
        jceDisplayer.displaySimple(this.assistantVersionCode, true);
        jceDisplayer.displaySimple(this.net, (boolean) $assertionsDisabled);
    }
}
