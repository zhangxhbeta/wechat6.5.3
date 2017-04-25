package com.tencent.mm.modelstat;

import android.database.Cursor;

public final class j {
    private static final String ddc;
    int bkU = -2;
    public int dcA = 0;
    public int dcB = 0;
    public int dcC = 0;
    public int dcD = 0;
    public int dcE = 0;
    public int dcF = 0;
    public int dcG = 0;
    public int dcH = 0;
    public int dcI = 0;
    public int dcJ = 0;
    public int dcK = 0;
    public int dcL = 0;
    public int dcM = 0;
    public int dcN = 0;
    public int dcO = 0;
    public int dcP = 0;
    public int dcQ = 0;
    public int dcR = 0;
    public int dcS = 0;
    public int dcT = 0;
    public int dcU = 0;
    public int dcV = 0;
    public int dcW = 0;
    public int dcX = 0;
    public int dcY = 0;
    public int dcZ = 0;
    public int dcz = 0;
    public int dda = 0;
    public int ddb = 0;
    public int id = 0;

    public final void b(Cursor cursor) {
        this.id = cursor.getInt(0);
        this.dcz = cursor.getInt(1);
        this.dcA = cursor.getInt(2);
        this.dcB = cursor.getInt(3);
        this.dcC = cursor.getInt(4);
        this.dcD = cursor.getInt(5);
        this.dcE = cursor.getInt(6);
        this.dcF = cursor.getInt(7);
        this.dcG = cursor.getInt(8);
        this.dcH = cursor.getInt(9);
        this.dcI = cursor.getInt(10);
        this.dcJ = cursor.getInt(11);
        this.dcK = cursor.getInt(12);
        this.dcL = cursor.getInt(13);
        this.dcM = cursor.getInt(14);
        this.dcN = cursor.getInt(15);
        this.dcO = cursor.getInt(16);
        this.dcP = cursor.getInt(17);
        this.dcQ = cursor.getInt(18);
        this.dcR = cursor.getInt(19);
        this.dcS = cursor.getInt(20);
        this.dcT = cursor.getInt(21);
        this.dcU = cursor.getInt(22);
        this.dcV = cursor.getInt(23);
        this.dcW = cursor.getInt(24);
        this.dcX = cursor.getInt(25);
        this.dcY = cursor.getInt(26);
        this.dcZ = cursor.getInt(27);
        this.dda = cursor.getInt(28);
        this.ddb = cursor.getInt(29);
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NetStatInfo:");
        stringBuilder.append("[mobile in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
        stringBuilder.append("[wifi in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
        stringBuilder.append("[text in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[image in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[voice in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[video in=%d/%dB, out=%d/%dB]");
        ddc = stringBuilder.toString();
    }

    public final String toString() {
        return String.format(ddc, new Object[]{Integer.valueOf(this.dcI), Integer.valueOf(this.dcY), Integer.valueOf(this.dcK), Integer.valueOf(this.dcU), Integer.valueOf(this.dda), Integer.valueOf(this.dcW), Integer.valueOf(this.dcJ), Integer.valueOf(this.dcZ), Integer.valueOf(this.dcL), Integer.valueOf(this.dcV), Integer.valueOf(this.ddb), Integer.valueOf(this.dcX), Integer.valueOf(this.dcA), Integer.valueOf(this.dcB), Integer.valueOf(this.dcM), Integer.valueOf(this.dcN), Integer.valueOf(this.dcC), Integer.valueOf(this.dcD), Integer.valueOf(this.dcO), Integer.valueOf(this.dcP), Integer.valueOf(this.dcE), Integer.valueOf(this.dcF), Integer.valueOf(this.dcQ), Integer.valueOf(this.dcR), Integer.valueOf(this.dcG), Integer.valueOf(this.dcH), Integer.valueOf(this.dcS), Integer.valueOf(this.dcT)});
    }
}
