package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public final class StatCfg extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!StatCfg.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final String TAG = "StatCfg";
    public int internal = 0;
    public short lineNum = (short) 0;
    public byte netType = (byte) 0;
    public byte type = (byte) 0;

    public final String className() {
        return "jce.StatCfg";
    }

    public final String fullClassName() {
        return "com.tencent.tmassistantsdk.protocol.jce.StatCfg";
    }

    public final byte getType() {
        return this.type;
    }

    public final void setType(byte b) {
        this.type = b;
    }

    public final byte getNetType() {
        return this.netType;
    }

    public final void setNetType(byte b) {
        this.netType = b;
    }

    public final short getLineNum() {
        return this.lineNum;
    }

    public final void setLineNum(short s) {
        this.lineNum = s;
    }

    public final int getInternal() {
        return this.internal;
    }

    public final void setInternal(int i) {
        this.internal = i;
    }

    public StatCfg(byte b, byte b2, short s, int i) {
        this.type = b;
        this.netType = b2;
        this.lineNum = s;
        this.internal = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return $assertionsDisabled;
        }
        StatCfg statCfg = (StatCfg) obj;
        if (JceUtil.equals(this.type, statCfg.type) && JceUtil.equals(this.netType, statCfg.netType) && JceUtil.equals(this.lineNum, statCfg.lineNum) && JceUtil.equals(this.internal, statCfg.internal)) {
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
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.netType, 1);
        jceOutputStream.write(this.lineNum, 2);
        jceOutputStream.write(this.internal, 3);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.netType = jceInputStream.read(this.netType, 1, true);
        this.lineNum = jceInputStream.read(this.lineNum, 2, (boolean) $assertionsDisabled);
        this.internal = jceInputStream.read(this.internal, 3, (boolean) $assertionsDisabled);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.type, Columns.TYPE);
        jceDisplayer.display(this.netType, DownloadInfo.NETTYPE);
        jceDisplayer.display(this.lineNum, "lineNum");
        jceDisplayer.display(this.internal, "internal");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.netType, true);
        jceDisplayer.displaySimple(this.lineNum, true);
        jceDisplayer.displaySimple(this.internal, (boolean) $assertionsDisabled);
    }
}
