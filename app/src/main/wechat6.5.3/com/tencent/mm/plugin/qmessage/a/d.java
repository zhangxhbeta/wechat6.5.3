package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;

public final class d {
    public int bkU = -1;
    int cHX = 0;
    long cIA = 0;
    int cuT = 0;
    int cyA = 0;
    int cyz = 0;
    String extInfo = "";
    public int hZH = 0;
    public long hZI = 0;
    public long hZJ = 0;
    String hZK = "";
    String hZL = "";
    String hZM = "";
    String hZN = "";
    public String username = "";

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bkU & 2) != 0) {
            contentValues.put("qq", Long.valueOf(this.cIA));
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("extinfo", aHj());
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.hZH));
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("extupdateseq", Long.valueOf(this.hZI));
        }
        if ((this.bkU & 32) != 0) {
            contentValues.put("imgupdateseq", Long.valueOf(this.hZJ));
        }
        if ((this.bkU & 64) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.cuT));
        }
        if ((this.bkU & 128) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.cHX));
        }
        if ((this.bkU & 256) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.cyz));
        }
        if ((this.bkU & 512) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.cyA));
        }
        if ((this.bkU & 1024) != 0) {
            contentValues.put("reserved5", this.hZK == null ? "" : this.hZK);
        }
        if ((this.bkU & 2048) != 0) {
            contentValues.put("reserved6", this.hZL == null ? "" : this.hZL);
        }
        if ((this.bkU & 4096) != 0) {
            contentValues.put("reserved7", this.hZM == null ? "" : this.hZM);
        }
        if ((this.bkU & 8192) != 0) {
            contentValues.put("reserved8", this.hZN == null ? "" : this.hZN);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String aHj() {
        return this.extInfo == null ? "" : this.extInfo;
    }
}
