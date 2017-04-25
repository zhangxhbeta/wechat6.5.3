package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public final class SettingsCfg extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!SettingsCfg.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final String TAG = "SettingsCfg";
    static byte[] cache_cfg;
    public byte[] cfg = null;
    public long revision = 0;
    public byte type = (byte) 0;

    public final String className() {
        return "jce.SettingsCfg";
    }

    public final String fullClassName() {
        return "com.tencent.tmassistantsdk.protocol.jce.SettingsCfg";
    }

    public final byte getType() {
        return this.type;
    }

    public final void setType(byte b) {
        this.type = b;
    }

    public final byte[] getCfg() {
        return this.cfg;
    }

    public final void setCfg(byte[] bArr) {
        this.cfg = bArr;
    }

    public final long getRevision() {
        return this.revision;
    }

    public final void setRevision(long j) {
        this.revision = j;
    }

    public SettingsCfg(byte b, byte[] bArr, long j) {
        this.type = b;
        this.cfg = bArr;
        this.revision = j;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return $assertionsDisabled;
        }
        SettingsCfg settingsCfg = (SettingsCfg) obj;
        if (JceUtil.equals(this.type, settingsCfg.type) && JceUtil.equals(this.cfg, settingsCfg.cfg) && JceUtil.equals(this.revision, settingsCfg.revision)) {
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
        jceOutputStream.write(this.cfg, 1);
        jceOutputStream.write(this.revision, 2);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        if (cache_cfg == null) {
            byte[] bArr = new byte[1];
            cache_cfg = bArr;
            bArr[0] = (byte) 0;
        }
        this.cfg = jceInputStream.read(cache_cfg, 1, true);
        this.revision = jceInputStream.read(this.revision, 2, (boolean) $assertionsDisabled);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.type, Columns.TYPE);
        jceDisplayer.display(this.cfg, "cfg");
        jceDisplayer.display(this.revision, "revision");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.cfg, true);
        jceDisplayer.displaySimple(this.revision, (boolean) $assertionsDisabled);
    }
}
