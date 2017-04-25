package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.v;

public final class ReportLogRequest extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!ReportLogRequest.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final String TAG = "ReportLogRequest";
    static byte[] cache_logData;
    public String hostAppPackageName = "";
    public int hostAppVersion = 0;
    public String hostUserId = "";
    public byte[] logData = null;
    public int logType = 0;

    public final String className() {
        return "jce.ReportLogRequest";
    }

    public final String fullClassName() {
        return "com.tencent.tmassistantsdk.protocol.jce.ReportLogRequest";
    }

    public final int getLogType() {
        return this.logType;
    }

    public final void setLogType(int i) {
        this.logType = i;
    }

    public final byte[] getLogData() {
        return this.logData;
    }

    public final void setLogData(byte[] bArr) {
        this.logData = bArr;
    }

    public final String getHostUserId() {
        return this.hostUserId;
    }

    public final void setHostUserId(String str) {
        this.hostUserId = str;
    }

    public final String getHostAppPackageName() {
        return this.hostAppPackageName;
    }

    public final void setHostAppPackageName(String str) {
        this.hostAppPackageName = str;
    }

    public final int getHostAppVersion() {
        return this.hostAppVersion;
    }

    public final void setHostAppVersion(int i) {
        this.hostAppVersion = i;
    }

    public ReportLogRequest(int i, byte[] bArr, String str, String str2, int i2) {
        this.logType = i;
        this.logData = bArr;
        this.hostUserId = str;
        this.hostAppPackageName = str2;
        this.hostAppVersion = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return $assertionsDisabled;
        }
        ReportLogRequest reportLogRequest = (ReportLogRequest) obj;
        if (JceUtil.equals(this.logType, reportLogRequest.logType) && JceUtil.equals(this.logData, reportLogRequest.logData) && JceUtil.equals(this.hostUserId, reportLogRequest.hostUserId) && JceUtil.equals(this.hostAppPackageName, reportLogRequest.hostAppPackageName) && JceUtil.equals(this.hostAppVersion, reportLogRequest.hostAppVersion)) {
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
        jceOutputStream.write(this.logType, 0);
        if (this.logData != null) {
            jceOutputStream.write(this.logData, 1);
        }
        if (this.hostUserId != null) {
            jceOutputStream.write(this.hostUserId, 2);
        }
        if (this.hostAppPackageName != null) {
            jceOutputStream.write(this.hostAppPackageName, 3);
        }
        jceOutputStream.write(this.hostAppVersion, 4);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.logType = jceInputStream.read(this.logType, 0, (boolean) $assertionsDisabled);
        if (cache_logData == null) {
            byte[] bArr = new byte[1];
            cache_logData = bArr;
            bArr[0] = (byte) 0;
        }
        this.logData = jceInputStream.read(cache_logData, 1, (boolean) $assertionsDisabled);
        this.hostUserId = jceInputStream.readString(2, $assertionsDisabled);
        this.hostAppPackageName = jceInputStream.readString(3, $assertionsDisabled);
        this.hostAppVersion = jceInputStream.read(this.hostAppVersion, 4, (boolean) $assertionsDisabled);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.logType, "logType");
        jceDisplayer.display(this.logData, "logData");
        jceDisplayer.display(this.hostUserId, "hostUserId");
        jceDisplayer.display(this.hostAppPackageName, "hostAppPackageName");
        jceDisplayer.display(this.hostAppVersion, "hostAppVersion");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.logType, true);
        jceDisplayer.displaySimple(this.logData, true);
        jceDisplayer.displaySimple(this.hostUserId, true);
        jceDisplayer.displaySimple(this.hostAppPackageName, true);
        jceDisplayer.displaySimple(this.hostAppVersion, (boolean) $assertionsDisabled);
    }
}
