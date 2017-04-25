package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;

public final class a {
    public int aPV = 0;
    int bkU = -1;
    String cuV = "";
    String cuW = "";
    String dac = "";
    int dhF = 0;
    public long dhH = 0;
    long dhI = 0;
    public String filename = "";
    String hjp = "";
    public String hjq = "";
    public int hjr = 0;
    public int hjs = 0;
    int hjt = 0;
    int hju = 0;
    public int hjv = 0;
    public int hjw = 0;
    public int msgType = 0;
    int status = 0;

    public final void b(Cursor cursor) {
        this.dac = cursor.getString(0);
        this.status = cursor.getInt(1);
        this.dhH = cursor.getLong(2);
        this.dhI = cursor.getLong(3);
        this.filename = cursor.getString(4);
        this.hjp = cursor.getString(5);
        this.hjq = cursor.getString(6);
        this.hjr = cursor.getInt(7);
        this.msgType = cursor.getInt(8);
        this.hjs = cursor.getInt(9);
        this.hjt = cursor.getInt(10);
        this.aPV = cursor.getInt(11);
        this.dhF = cursor.getInt(12);
        this.hju = cursor.getInt(13);
        this.hjv = cursor.getInt(14);
        this.hjw = cursor.getInt(15);
        this.cuV = cursor.getString(16);
        this.cuW = cursor.getString(17);
    }

    public final String ayX() {
        return this.dac == null ? "" : this.dac;
    }

    public final String ayY() {
        return this.filename == null ? "" : this.filename;
    }

    public final String ayZ() {
        return this.hjp == null ? "" : this.hjp;
    }

    public final String aza() {
        return this.hjq == null ? "" : this.hjq;
    }
}
