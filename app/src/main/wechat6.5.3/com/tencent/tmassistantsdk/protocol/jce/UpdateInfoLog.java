package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UpdateInfoLog extends JceStruct {
    public int actionCode = 0;
    public long appid = 0;
    public String extra = "";
    public String packageName = "";
    public byte updateType = (byte) 0;
    public byte yybExistFlag = (byte) 0;

    public UpdateInfoLog(byte b, String str, long j, int i, byte b2, String str2) {
        this.updateType = b;
        this.packageName = str;
        this.appid = j;
        this.actionCode = i;
        this.yybExistFlag = b2;
        this.extra = str2;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.updateType, 0);
        jceOutputStream.write(this.packageName, 1);
        jceOutputStream.write(this.appid, 2);
        jceOutputStream.write(this.actionCode, 3);
        jceOutputStream.write(this.yybExistFlag, 4);
        if (this.extra != null) {
            jceOutputStream.write(this.extra, 5);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.updateType = jceInputStream.read(this.updateType, 0, true);
        this.packageName = jceInputStream.readString(1, true);
        this.appid = jceInputStream.read(this.appid, 2, false);
        this.actionCode = jceInputStream.read(this.actionCode, 3, true);
        this.yybExistFlag = jceInputStream.read(this.yybExistFlag, 4, false);
        this.extra = jceInputStream.readString(5, false);
    }
}
